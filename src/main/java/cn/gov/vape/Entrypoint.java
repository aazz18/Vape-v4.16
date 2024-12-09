package cn.gov.vape;

import cn.gov.vape.handlers.ApiHandler;
import cn.gov.vape.implemention.Core;
import cn.gov.vape.implemention.Forge;
import cn.gov.vape.implemention.Reflections;
import cn.gov.vape.reflect.Mapping;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.net.httpserver.HttpServer;
import lombok.Getter;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.Display;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;
import java.util.concurrent.Executors;

public class Entrypoint {
    public static final Entrypoint INSTANCE = new Entrypoint();
    private static final int SERVER_PORT = 8964;

    private final Logger logger = LogManager.getLogger("vape.bootstrap");

    @Getter
    private final Core core = new Core();
    @Getter
    private final Reflections reflections = new Reflections();
    @Getter
    private final Forge forge = new Forge();
    @Getter
    private Mapping mapper;

    public boolean vanilla = false;
    public final int mcVersion = getVersion();

    public static void main() {
        INSTANCE.init();
    }

    private void init(){

        mapper = new Mapping(String.valueOf(mcVersion));

        try (InputStream inputStream = Entrypoint.class.getResourceAsStream("/data/strings.json")) {
            if (inputStream != null) {
                String dat = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
                JsonObject strings = new JsonParser().parse(dat).getAsJsonObject();
                for (Map.Entry<String, JsonElement> stringJsonElementEntry : strings.entrySet()) {
                    core.loadStrings(Integer.parseInt(stringJsonElementEntry.getKey()), new String(Base64.getDecoder().decode(stringJsonElementEntry.getValue().getAsString()),StandardCharsets.UTF_8));
                }
            } else {
                logger.error("strings.json resource not found");
            }
        } catch (IOException e) {
            logger.error("Error reading strings.json", e);
        }

        try {
            Class.forName("net.minecraftforge.common.ForgeVersion");
            vanilla = false;
        } catch (ClassNotFoundException e) {
            vanilla = true;
        }

        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(SERVER_PORT), 0);
            server.createContext("/api/v1", new ApiHandler());
            server.setExecutor(Executors.newCachedThreadPool());

            new Thread(() -> {
                server.start();
                logger.info("Server started on port {}", SERVER_PORT);
            }, "Virtual Server Thread").start();

            a.a.start();
        } catch (IOException e) {
            logger.error("Server startup failed", e);
        }
    }

    private int getVersion() {
        String title = Display.getTitle().toLowerCase();

        if (title.contains("1.7.10")) {
            return 13;
        } else if (title.contains("1.8.8") || title.contains("1.8.9")) {
            return 15;
        } else if (title.contains("1.12.2")) {
            return 23;
        } else if (title.contains("1.16")) {
            return 35;
        }

        return 15;
    }
}

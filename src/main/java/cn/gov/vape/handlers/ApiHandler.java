package cn.gov.vape.handlers;

import cn.gov.vape.handlers.endpoint.BaseHandler;
import cn.gov.vape.handlers.endpoint.handlers.AuthenticatedHandler;
import cn.gov.vape.handlers.endpoint.handlers.ProfileTagsHandler;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import lombok.var;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ApiHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String method = exchange.getRequestMethod();
        String path = exchange.getRequestURI().getPath();

        BaseHandler handler = getHandlerForPath(path);
        JsonObject response = handler != null ? handler.handleRequest(method, IOUtils.toString(exchange.getRequestBody())) : createDefaultResponse();

        sendResponse(exchange, response.toString());
    }

    private BaseHandler getHandlerForPath(String path) {
        if (path.contains("authenticated")) {
            return new AuthenticatedHandler();
        } else if (path.contains("profile/public/tags")) {
            return new ProfileTagsHandler();
        }
        return null;
    }


    public void sendResponse(HttpExchange exchange, String response) throws IOException {
        exchange.getResponseHeaders().set("Content-Type", "application/json");
        exchange.sendResponseHeaders(200, response.getBytes(StandardCharsets.UTF_8).length);
        try (var os = exchange.getResponseBody()) {
            os.write(response.getBytes(StandardCharsets.UTF_8));
        }
    }

    public JsonObject createDefaultResponse() {
        JsonObject root = new JsonObject();
        root.add("data", JsonNull.INSTANCE);
        root.add("error", JsonNull.INSTANCE);
        root.addProperty("successful", false);
        return root;
    }
}

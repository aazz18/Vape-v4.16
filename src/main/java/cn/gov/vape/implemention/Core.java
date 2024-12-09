package cn.gov.vape.implemention;

import java.io.IOException;
import java.io.InputStream;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

import cn.gov.vape.Entrypoint;
import cn.gov.vape.Proxy;
import cn.gov.vape.reflect.Type;

public class Core {
    private final Logger logger = LogManager.getLogger("vape.core");
    private boolean flag;

    private final Map<Integer,String> strings = new ConcurrentHashMap<>();

    public void loadStrings(int key,String value){
        strings.put(key,value);
    }

    /**
     * a.gfb, added in 4.11, replaced gt (getTexture).
     */
    public byte[] getFileBytes(String fileName) {
        try (InputStream inputStream = Entrypoint.class.getResourceAsStream("/files/" + fileName)) {
            if (inputStream == null) {
                logger.warn("Resource file not found: {}", fileName);
                return new byte[0];
            }
            return IOUtils.toByteArray(inputStream);
        } catch (IOException e) {
            logger.error("Error reading resource file: {}", fileName, e);
            return new byte[0];
        }
    }

    public void setRenderState(int state, double displayWidth, double displayHeight) {
        GL11.glClear(GL11.GL_DEPTH_BUFFER_BIT);
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0D, displayWidth, displayHeight, 0.0D, 1000.0D, 3000.0D);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0F, 0.0F, -2000.0F);
        if(state>0) {
            if(flag) {
                GL11.glEnable(GL11.GL_ALPHA_TEST);
            }
        }else{
            flag = GL11.glIsEnabled(GL11.GL_ALPHA_TEST);
            if(flag) {
                GL11.glDisable(GL11.GL_ALPHA_TEST);
            }
        }
    }

    /**
     *
     */
    public double[] worldToScreen(double x, double y, double z) {
        FloatBuffer modelViewMatrix = BufferUtils.createFloatBuffer(16);
        FloatBuffer projectionMatrix = BufferUtils.createFloatBuffer(16);
        IntBuffer viewportMatrix = BufferUtils.createIntBuffer(16);

        GL11.glGetFloat(GL11.GL_MODELVIEW_MATRIX, modelViewMatrix);
        GL11.glGetFloat(GL11.GL_PROJECTION_MATRIX, projectionMatrix);
        GL11.glGetInteger(GL11.GL_VIEWPORT, viewportMatrix);

        FloatBuffer winCoords = BufferUtils.createFloatBuffer(3);
        GLU.gluProject((float) x, (float) y, (float) z, modelViewMatrix, projectionMatrix, viewportMatrix, winCoords);

        double[] ret = new double[3];
        ret[0] = winCoords.get(0);
        ret[1] = winCoords.get(1);
        ret[2] = winCoords.get(2);

        return ret;
    }

    public Class<?> getJavaClass(String name) {
        try {
            return name.startsWith("[") ? Class.forName(name.substring(2, name.length() - 1).replace("/",".")) : Class.forName(Type.getType(name.substring(1, name.length() - 1)).getClassName());
        }catch (Exception e){
            logger.catching(e);
            return null;
        }
    }
    
    /* 
     * Click mouse button via PostMessage to LWJGL window.
    */
    public void sendMouseClick(int buttonNumber, int statusCode) {
        Proxy.click(buttonNumber,statusCode);
    }

    public String getClassString(Class<?> clazz) {
        if(clazz == null){
            return "";
        }
        return "L" + clazz.getName().replaceAll("\\.","/") + ";";
    }

    public String copyString(int index) {
        if(strings.containsKey(index)){
            return strings.get(index);
        }else {
            logger.warn("String {} is not present.",index);
            return "Unknown string " + index;
        }
    }

    public void updateDiscord(String title, String status) {
        // Not Implemented yet.
    }

    
    /* 
     * Get key name from scan code via GetAsyncKeyState.
    */
    public String getKeyName(long scanCode) {
        return Proxy.getKeyName(scanCode);
    }

    public short getKeyState(int code) {
        return Proxy.getKeyState(code);
    }

    public int mapVirtualKey(int var0, int var1) {
        return Proxy.mapVirtualKey(var0,var1);
    }

    public Class<?> getClass(String clazzName) {
        try {
            return Class.forName(clazzName.replace("/", "."));
        }
        catch (Throwable e) {
            logger.catching(e);
            return null;
        }
    }

    public void copy(String string) {
        // Not Implemented yet.
    }

    public int setClassBytes(Class<?> clazz, byte[] bytes) {
        // Not Implemented yet.
        return 0;
    }

    public byte[] getClassBytes(Class<?> clazz) {
        // Not Implemented yet.
        return new byte[0];
    }
}

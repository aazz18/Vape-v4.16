package cn.gov.vape;


public class Proxy {

    
    public static native int loadKeyHook();
    public static native int mapVirtualKey(int keyCode, int mappingType);
    public static native String getKeyName(long keyHandle);
    public static native void click(int buttonNumber, int clickCode);
    public static native short getKeyState(int keyCode);
    public static boolean onNotification(int message,long keyStatus,long mouseXY) {
        return a.d.onNotification(message,keyStatus,mouseXY);
    }

}

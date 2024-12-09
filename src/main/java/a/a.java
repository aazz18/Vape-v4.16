package a;

import cn.gov.vape.Entrypoint;
import cn.gov.vape.Proxy;
import lombok.SneakyThrows;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;

public class a {
    private static JWindow splashWindow;
    public static void mb(int var0){
    }

    @SneakyThrows
    public static byte[] gfb(String var0) {
        return Entrypoint.INSTANCE.getCore().getFileBytes(var0);
    }

    public static String[] gcm(Class var0) {
        return new String[0];
    }

    //GetClassString
    public static String gcs(Class var0) {
        return Entrypoint.INSTANCE.getCore().getClassString(var0);
    }

    public static void scm(String var0, String var1) {
    }

    public static void updc(String var0, String var1) {
        Entrypoint.INSTANCE.getCore().updateDiscord(var0,var1);
    }

    // isVanilla
    public static boolean iv() {
        return Entrypoint.INSTANCE.vanilla;
    }

    public static String gkn(long var0) {
        return Entrypoint.INSTANCE.getCore().getKeyName(var0);
    }

    public static int mvk(int var0, int var1) {
        return Entrypoint.INSTANCE.getCore().mapVirtualKey(var0,var1);
    }

    public static void b(String[] var0) {
    }

    public static boolean ib() {
        return EG.O;
    }

    public static void test() {
        System.out.println("test");
    }

    public static boolean gtcf(Object var0, int var1, int var2) {
        return false;
    }

    public static byte[] gt(String var0) {
        return new byte[0];
    }

    public static Class gc(String var0) {
        return Entrypoint.INSTANCE.getCore().getClass(var0);
    }

    @Deprecated
    public static void ss(String var0) {
    }

    public static Class gvc(String var0) {
        try {
            return Class.forName(var0.replace("/", "."));
        }
        catch (Throwable e) {
            //System.out.println("Failed to allocate class: " + var0);
            //e.printStackTrace();
            return null;
        }
    }

    public static void cpy(String var0) {
        Entrypoint.INSTANCE.getCore().copy(var0);
    }


    // GetMinecraftVersion
    public static int gmv() {
        return Entrypoint.INSTANCE.mcVersion;
    }

    public static int mfv2(int var0, int var1, String var2) {
        return 0;
    }

    public static void rs(int state, double displayWidth, double displayHeight) {
        Entrypoint.INSTANCE.getCore().setRenderState(state,displayWidth,displayHeight);
    }

    public static void start() {

        splashWindow = new JWindow();

        ImageIcon splashImage = null;
        try {
            URL imageUrl = Entrypoint.class.getResource("/data/banner.png");
            if (imageUrl != null) {
                splashImage = new ImageIcon(ImageIO.read(imageUrl));
            } else {
                System.exit(1);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        JLabel imageLabel = new JLabel(splashImage);
        splashWindow.getContentPane().add(imageLabel, BorderLayout.CENTER);

        splashWindow.setSize(splashImage.getIconWidth(), splashImage.getIconHeight());
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        splashWindow.setLocation((screenSize.width - splashWindow.getSize().width) / 2,
                (screenSize.height - splashWindow.getSize().height) / 2);
        splashWindow.setAlwaysOnTop(true);
        splashWindow.setVisible(true);
        String[] var0 = new String[]{};
        long var10000 = 1000L;

        try {
            Thread.sleep(var10000);
            EG var1 = new EG();
            EG var3 = var1;
            if (!var1.d()) {
                return;
            }

            var1.j();
            var1.a();
            var3 = var1;

            var3.c(true);
        } catch (Throwable var2) {
            var2.printStackTrace();
        }
    }

    public static double gshv2(int var0, String var1) {
        return 0.0;
    }

    public static int sts() {
        return 1;
    }

    public static void dc() {
    }

    @SneakyThrows
    public static int scb(Class var0, byte[] var1) {
       return Entrypoint.INSTANCE.getCore().setClassBytes(var0,var1);
    }

    public static void reload() {
        String[] var0 = new String[]{};
        if (!r5.P().c()) {
            // r5.a(null);
            r5.q();
        }

        Iterator var2 = EG.R.g().k().iterator();

        while(true) {
            if (var2.hasNext()) {
                lF var3 = (lF)var2.next();
                if (var0 == null) {
                    break;
                }

                label34: {
                    lF var10000 = var3;
                    if (var0 != null) {
                        if (!var3.p()) {
                            break label34;
                        }

                        var10000 = var3;
                    }

                    var10000.b(false);
                }

                if (var0 != null) {
                    continue;
                }

                int var1 = QM.I();
                QM.b(++var1);
            }

            long var6 = 500L;

            try {
                Thread.sleep(var6);
            } catch (InterruptedException var4) {
            }
            break;
        }

        EG.R.Q = true;
        rl();
    }

    public static int ss_2(String var0) {
        return 0;
    }

    public static double gswv2(int var0, String var1) {
        return 0.0;
    }

    public static Object[] gco(Class var0) {
        return new Object[0];
    }

    private static Throwable a(Throwable var0) {
        return var0;
    }

    public static String gs() {
        return "";
    }

    public static void smd(int var0, int var1) {
        Entrypoint.INSTANCE.getCore().sendMouseClick(var0,var1);
    }

    // CopyString
    public static String cs(int var0) {
        return Entrypoint.INSTANCE.getCore().copyString(var0);
    }

    public static double[] trn(double x, double y, double z) {
        return Entrypoint.INSTANCE.getCore().worldToScreen(x,y,z);
    }

    public static void su(String var0) {
        System.out.println(var0);
    }

    public static int ss_3(String var0) {
        return 0;
    }

    public static void p(String var0) {
        System.out.println(var0);
    }

    public static void rl() {
    }

    public static double gsh(int var0, String var1) {
        return 0.0;
    }

    // Transaction inject progress
    public static void trs(int progress) {
        if(progress == 23){
            Proxy.loadKeyHook();
        }
        if(progress == 28){
            splashWindow.setVisible(false);
            splashWindow.dispose();
        }
    }

    public static int dsv2(int var0, String var1, double var2, double var4, int var6, float var7) {
        return 0;
    }

    public static String sp(String var0, String var1) {
        return null;
    }

    public static double gsw(int var0, String var1) {
        return 0.0;
    }

    public static void exit(boolean var0) {
    }

    public static String gp(String var0) {
        return "";
    }

    public static int gk() {
        return 0;
    }

    public static String[] gcf(Class var0) {
        return new String[0];
    }

    public static boolean[] gls() {
        return new boolean[0];
    }

    public static int mf(int var0, int var1, String var2) {
        return 0;
    }

    public static void sb() {
        if (!EG.O) {
            EG.R.r();
        }
    }

    public static int gts() {
        return 1;
    }

    public static void fs() {
    }


    // GetAuthToken
    public static String gat() {
        return "0";
    }

    public static void rsc() {
    }

    public static short gks(int code){
        return Entrypoint.INSTANCE.getCore().getKeyState(code);
    }

    public static Object grh() {
        return null;
    }

    //GetClassJava
    public static Class gcj(String name) {
        return Entrypoint.INSTANCE.getCore().getJavaClass(name);
    }

    public static int ds(int var0, String var1, double var2, double var4, int var6) {
        return 0;
    }

    public static byte[] gcb(Class var0) {
        return Entrypoint.INSTANCE.getCore().getClassBytes(var0);
    }
}

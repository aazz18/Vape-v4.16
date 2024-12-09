package a;

import cn.gov.vape.Entrypoint;

public class i {
    public static final int f = 513;
    public static final int b = 2;
    public static final int c = 514;
    public static final int e = 516;
    public static final int a = 517;
    public static final int h = 1;
    public static final int g = 1;
    public static final int d = 2;

    public static boolean e() {
        return (Entrypoint.INSTANCE.getCore().getKeyState(1)) != 0;
    }

    public static void b(int var0) {
        if (var0 == 0) {
            c();
        }

        if (var0 == 1) {
            d();
        }
    }

    public static void d() {
        Entrypoint.INSTANCE.getCore().sendMouseClick(2, 516);
    }

    public static void c() {
        Entrypoint.INSTANCE.getCore().sendMouseClick(1, 513);
    }

    public static void f() {
        Entrypoint.INSTANCE.getCore().sendMouseClick(2, 517);
    }

    public static void b() {
        Entrypoint.INSTANCE.getCore().sendMouseClick(1, 514);
    }

    public static boolean a() {
        return (Entrypoint.INSTANCE.getCore().getKeyState(2)) != 0;
    }

    public static void a(int var0) {
        if (var0 == 0) {
            b();
        }

        if (var0 == 1) {
            f();
        }
    }

    private static M4 a(M4 var0) {
        return var0;
    }
}

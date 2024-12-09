package a;

import cn.gov.vape.implemention.Reflections;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static cn.gov.vape.implemention.Reflections.*;

public class b {
    public static Object ccc(int id, Class<?> cls, Object... params) throws Exception {
        return invokeConstructor(id, params);
    }


    public static void ggg(int var0, Object var1, byte var2) {
    }

    public static String gfn(int var0) {
        return ((Field)fieldMap.get(var0)).getName();
    }

    public static boolean d(int var0, Object var1, Object... var2) {
        return invokeMethod(var0, var1, Boolean.TYPE, var2);
    }


    public static float[] q(int id, Object instance, Object... params) throws Exception {
        return invokeMethod(id, instance, float[].class, params);
    }

    public static long h(int id, Object instance, Object... params) throws Exception {
        return invokeMethod(id, instance, Long.TYPE, params);
    }


    public static Object[] kk(int var0, Object var1) {
        return Reflections.getField(var0,var1);
    }


    public static void qq(int id, Object instance, float value) throws Exception {
        ((Field)fieldMap.get(id)).setFloat(instance, value);
    }

    public static void zz(int id, Object instance, double[] value) throws Exception {
        setObjectField(id, instance, value);
    }

    public static short[] ff(int id, Object instance) throws Exception {
        return getField(id, instance);
    }


    public static int[] o(int id, Object instance, Object... params) throws Exception {
        return invokeMethod(id, instance, int[].class, params);
    }
    public static String gmn(int var0) {
        return ((Method)methodMap.get(var0)).getName();
    }

    public static Object cc(int var0, Object var1) {
        return Reflections.getField(var0,var1);
    }


    public static char e(int id, Object instance, Object... params) throws Exception {
        return invokeMethod(id, instance, Character.TYPE, params);
    }


    public static void iii(int var0, Object var1, byte[] var2) {

    }

    public static byte[] hhh(int var0, Object var1) {
        return invokeMethod(var0, var1,byte[].class );

    }


    public static void mm(int id, Object instance, char value) throws Exception {
        ((Field)fieldMap.get(id)).setChar(instance, value);
    }

    public static void oo(int id, Object instance, int value) throws Exception {
        ((Field)fieldMap.get(id)).setInt(instance, value);
    }

    public static void aaa(int id, Object instance, Object[] value) throws Exception {
        setObjectField(id, instance, value);
    }

    public static byte ddd(int id, Object instance, Object... params) throws Exception {
        return invokeMethod(id, instance, Byte.TYPE, params);
    }


    public static void uu(int id, Object instance, char[] value) throws Exception {
        setObjectField(id, instance, value);
    }
    public static int g(int var0, Object var1, Object... var2) {
        return invokeMethod(var0, var1, Integer.TYPE, var2);
    }


    public static long z(int id, Object instance) throws Exception {
        return ((Field)fieldMap.get(id)).getLong(instance);
    }


    public static char[] m(int id, Object instance, Object... params) throws Exception {
        return invokeMethod(id, instance, char[].class, params);
    }

    public static void ll(int id, Object instance, boolean value) throws Exception {
        ((Field)fieldMap.get(id)).setBoolean(instance, value);
    }

    public static void tt(int id, Object instance, boolean[] value) throws Exception {
        setObjectField(id, instance, value);
    }

    public static void pp(int id, Object instance, long value) throws Exception {
        ((Field)fieldMap.get(id)).setLong(instance, value);
    }


    public static short f(int id, Object instance, Object... params) throws Exception {
        return invokeMethod(id, instance, Short.TYPE, params);
    }
    public static byte fff(int var0, Object var1) {
        return 0;
    }

    public static byte[] eee(int var0, Object var1, Object... var2) {
        return new byte[0];
    }

    public static long[] p(int id, Object instance, Object... params) throws Exception {
        return invokeMethod(id, instance, long[].class, params);
    }

    public static Object jjj(int var0, Object var1, Object... var2) {
        return invokeMethod(var0,var1,Object.class,var2);
    }

    public static void bbb(int var0, Object var1, Object... var2) {
        invokeMethod(var0,var1,Void.class,var2);
    }

    public static Object[] s(int var0, Object var1, Object... var2) {
        return invokeMethod(var0, var1, Object[].class, var2);
    }

    public static void xx(int var0, Object var1, long[] var2) {
    }

    public static double j(int var0, Object var1, Object... var2) {
        return invokeMethod(var0, var1, Double.TYPE, var2);
    }

    public static char w(int var0, Object var1) {
        return '\0';
    }

    public static void b(int var0, Class var1, String var2, String var3, boolean var4) throws Exception {
        Reflections.getMethod(var0,var1,var2,var3,var4,true);
    }

    public static char[] ee(int var0, Object var1) {
       return getField(var0,var1);
    }

    public static void t(int var0, Class var1, String var2, String var3, boolean var4) throws Exception {
        Reflections.getField(var0,var1,var2,var3,var4);
    }

    public static void c(int var0, Object var1, Object... var2) {
        invokeMethod(var0, var1, Void.TYPE, var2);
    }


    public static long[] hh(int id, Object instance) throws Exception {
        return getField(id, instance);
    }
    @SneakyThrows
    public static int y(int var0, Object var1) {
        return ((Field)fieldMap.get(var0)).getInt(var1);
    }

    public static void nn(int id, Object instance, short value) throws Exception {
        ((Field)fieldMap.get(id)).setShort(instance, value);
    }

    public static Object k(int var0, Object var1, Object... var2) {
        return invokeMethod(var0, var1, Object.class, var2);
    }


    public static void yy(int id, Object instance, float[] value) throws Exception {
        setObjectField(id, instance, value);
    }

    public static void a(int var0, Class var1, String var2, String var3, boolean var4) throws Exception {
        Reflections.getMethod(var0,var1,var2,var3,var4,false);
    }


    public static void vv(int id, Object instance, short[] value) throws Exception {
        setObjectField(id, instance, value);
    }
    public static boolean[] l(int id, Object instance, Object... params) throws Exception {
        return invokeMethod(id, instance, boolean[].class, params);
    }

    @SneakyThrows
    public static void rr(int var0, Object var1, double var2) {
        ((Field)fieldMap.get(var0)).setDouble(var1, var2);
    }

    public static double[] r(int id, Object instance, Object... params) throws Exception {
        return invokeMethod(id, instance, double[].class, params);
    }

    public static double bb(int id, Object instance) throws Exception {
        return ((Field)fieldMap.get(id)).getDouble(instance);
    }


    public static boolean v(int id, Object instance) throws Exception {
        return ((Field)fieldMap.get(id)).getBoolean(instance);
    }


    public static float[] ii(int id, Object instance) throws Exception {
        return getField(id, instance);
    }


    public static void ss(int id, Object instance, Object value) throws Exception {
        setObjectField(id, instance, value);
    }

    public static float i(int var0, Object var1, Object... var2) {
        return invokeMethod(var0, var1, Float.TYPE, var2);
    }

    public static float aa(int id, Object instance) throws Exception {
        Field field = (Field)fieldMap.get(id);
        return field.getType() == Float.TYPE ? field.getFloat(instance) : (float)field.getDouble(instance);
    }
    public static boolean[] dd(int id, Object instance) throws Exception {
        return getField(id, instance);
    }
    public static short[] n(int id, Object instance, Object... params) throws Exception {
        return invokeMethod(id, instance, short[].class, params);
    }

    public static short x(int id, Object instance) throws Exception {
        return ((Field)fieldMap.get(id)).getShort(instance);
    }

    public static void ww(int id, Object instance, int[] value) throws Exception {
        setObjectField(id, instance, value);
    }

    public static int[] gg(int id, Object instance) throws Exception {
        return getField(id, instance);
    }

    public static void u(int var0, Class var1, String var2, String var3, boolean var4) throws Exception {
        Reflections.getField(var0,var1,var2,var3,var4,true);
    }

    public static double[] jj(int id, Object instance) throws Exception {
        return getField(id, instance);
    }


}
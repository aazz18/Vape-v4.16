package cn.gov.vape.implemention;

import cn.gov.vape.Entrypoint;
import cn.gov.vape.reflect.Mapping;
import cn.gov.vape.reflect.Parameters;
import lombok.SneakyThrows;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@SuppressWarnings("all")
public class Reflections {

    public static final Map<Integer, Method> methodMap = new ConcurrentHashMap<>();
    public static final Map<Integer, Field> fieldMap = new ConcurrentHashMap<>();
    public static final Map<Integer, Constructor<?>> constructorMap = new ConcurrentHashMap<>();

    // Get minecraft method
    public static void getMinecraftMethod(int id, Class<?> cls, String name, String desc, boolean remap) throws NoSuchMethodException {
        Reflections.getMethod(id, cls, name, desc, remap, false);
    }

    // Get method
    public static void getMethod(int id, Class<?> cls, String name, String desc, boolean remap) throws NoSuchMethodException {
        Reflections.getMethod(id, cls, name, desc, remap, true);
    }

    public static void getMethod(int id, Class<?> cls, String name, String desc, boolean remap, boolean isStatic) throws NoSuchMethodException {
        if (name.equals("<init>")) {
            Reflections.getConstructor(id, cls, desc);
        } else {
            if (!name.equals("ordinal") && !name.equals("values")) {
                boolean skipParamCheck = name.equals("getEnchantmentModifierDamage");
                for (Method method : cls.getDeclaredMethods()) {
                    if (!Entrypoint.INSTANCE.getMapper().match(method, name) || !Parameters.checkParameterTypes(method.getParameterTypes(), method.getReturnType(), desc) && !skipParamCheck) continue;
                    method.setAccessible(true);
                    methodMap.put(id, method);
                    return;
                }
                throw new NoSuchMethodException();
            }
            for (Method declaredMethod : getAllMethods(cls)) {
                if(declaredMethod.getName().equals(name)){
                    methodMap.put(id, declaredMethod);
                }
            }
        }
    }

    public static Method[] getAllMethods(Class<?> clazz) {
        ArrayList<Method> methods = new ArrayList<>();
        ArrayList<Class<?>> classes = new ArrayList<>();
        do {
            classes.add(clazz);
            clazz = clazz.getSuperclass();
        } while(clazz != Object.class && clazz != null);
        for(int i=classes.size()-1;i>=0;i--) for(Method m : classes.get(i).getDeclaredMethods()) methods.add(m);
        return methods.toArray(new Method[0]);
    }

    public static void getConstructor(int id, Class<?> cls, String desc) {
        Constructor<?>[] constructors;
        for (Constructor<?> constructor : constructors = cls.getDeclaredConstructors()) {
            if (!Parameters.checkParameterTypes(constructor.getParameterTypes(), Void.TYPE, desc)) continue;
            constructor.setAccessible(true);
            constructorMap.put(id, constructor);
            return;
        }
    }
    // invoke
    public static void invoke(int id, Object instance, Object ... params) {
        Reflections.invokeMethod(id, instance, Void.TYPE, params);
    }
    // invokeMethodBoolean
    public static boolean invokeMethodBoolean(int id, Object instance, Object ... params) {
        return Reflections.invokeMethod(id, instance, Boolean.TYPE, params);
    }
    // invokeMethodChar
    public static char invokeMethodChar(int id, Object instance, Object ... params) {
        return Reflections.invokeMethod(id, instance, Character.TYPE, params).charValue();
    }
    // invokeMethodShort
    public static short invokeMethodShort(int id, Object instance, Object ... params) {
        return Reflections.invokeMethod(id, instance, Short.TYPE, params);
    }
    // invokeMethodInt
    public static int invokeMethodInt(int id, Object instance, Object ... params) {
        return Reflections.invokeMethod(id, instance, Integer.TYPE, params);
    }
    // invokeMethodLong
    public static long invokeMethodLong(int id, Object instance, Object ... params) {
        return Reflections.invokeMethod(id, instance, Long.TYPE, params);
    }
    // invokeMethodFloat
    public static float invokeMethodFloat(int id, Object instance, Object ... params) {
        return Reflections.invokeMethod(id, instance, Float.TYPE, params).floatValue();
    }
    // invokeMethodDouble
    public static double invokeMethodDouble(int id, Object instance, Object ... params) {
        return Reflections.invokeMethod(id, instance, Double.TYPE, params);
    }
    // invokeMethodObject
    public static Object invokeMethodObject(int id, Object instance, Object ... params) {
        return Reflections.invokeMethod(id, instance, Object.class, params);
    }
    // invokeMethodBooleanArray
    public static boolean[] invokeMethodBooleanArray(int id, Object instance, Object ... params) {
        return Reflections.invokeMethod(id, instance, boolean[].class, params);
    }
    // invokeMethodCharArray
    public static char[] invokeMethodCharArray(int id, Object instance, Object ... params) {
        return Reflections.invokeMethod(id, instance, char[].class, params);
    }
    // invokeMethodShortArray
    public static short[] invokeMethodShortArray(int id, Object instance, Object ... params) {
        return Reflections.invokeMethod(id, instance, short[].class, params);
    }
    // invokeMethodIntArray
    public static int[] invokeMethodIntArray(int id, Object instance, Object ... params) {
        return Reflections.invokeMethod(id, instance, int[].class, params);
    }
    // invokeMethodLongArray
    public static long[] invokeMethodLongArray(int id, Object instance, Object ... params) {
        return Reflections.invokeMethod(id, instance, long[].class, params);
    }
    // invokeMethodFloatArray
    public static float[] invokeMethodFloatArray(int id, Object instance, Object ... params) {
        return Reflections.invokeMethod(id, instance, float[].class, params);
    }
    // invokeMethodDoubleArray
    public static double[] invokeMethodDoubleArray(int id, Object instance, Object ... params) {
        return Reflections.invokeMethod(id, instance, double[].class, params);
    }
    // invokeMethodObjectArray
    public static Object[] invokeMethodObjectArray(int id, Object instance, Object ... params) {
        return Reflections.invokeMethod(id, instance, Object[].class, params);
    }

    public static <T> T invokeMethod(int id, Object instance, Class<T> type, Object... params) {
        try {
            return (T)(methodMap.get(id)).invoke(instance, params);
        } catch (Throwable e) {
            return null;
        }
    }
    // getMinecraftField
    public static void getMinecraftField(int id, Class<?> cls, String name, String type, boolean remap) throws NoSuchFieldException {
        Reflections.getField(id, cls, name, type, remap, false);
    }
    // getField
    public static void getField(int id, Class<?> cls, String name, String type, boolean remap) throws NoSuchFieldException {
        Reflections.getField(id, cls, name, type, remap, true);
    }

    public static void getField(int id, Class<?> cls, String name, String type, boolean remap, boolean isStatic) throws NoSuchFieldException {
        for (Field field : cls.getDeclaredFields()) {
            if (!Entrypoint.INSTANCE.getMapper().match(field, name)) continue;
            field.setAccessible(true);
            fieldMap.put(id, field);
            return;
        }
        throw new NoSuchFieldException();
    }

    @SneakyThrows // getFieldBoolean
    public static boolean getFieldBoolean(int id, Object instance) {
        return (fieldMap.get(id)).getBoolean(instance);
    }
    @SneakyThrows // getFieldChar
    public static char getFieldChar(int id, Object instance) {
        return (fieldMap.get(id)).getChar(instance);
    }
    @SneakyThrows // getFieldShort
    public static short getFieldShort(int id, Object instance) {
        return (fieldMap.get(id)).getShort(instance);
    }
    @SneakyThrows // getFieldInt
    public static int getFieldInt(int id, Object instance) {
        return (fieldMap.get(id)).getInt(instance);
    }
    @SneakyThrows // getFieldLong
    public static long getFieldLong(int id, Object instance) {
        return (fieldMap.get(id)).getLong(instance);
    }
    @SneakyThrows // getFieldFloat
    public static float getFieldFloat(int id, Object instance) {
        Field field = fieldMap.get(id);
        return field.getType() == Float.TYPE ? field.getFloat(instance) : (float)field.getDouble(instance);
    }
    @SneakyThrows // getFieldDouble
    public static double getFieldDouble(int id, Object instance) {
        return (fieldMap.get(id)).getDouble(instance);
    }

    // getFieldObject
    public static Object getFieldObject(int id, Object instance) {
        return Reflections.getField(id, instance);
    }

    // getFieldBooleanArray
    public static boolean[] getFieldBooleanArray(int id, Object instance) {
        return Reflections.getField(id, instance);
    }

    // getFieldCharArray
    public static char[] getFieldCharArray(int id, Object instance) {
        return Reflections.getField(id, instance);
    }

    // getFieldShortArray
    public static short[] getFieldShortArray(int id, Object instance) {
        return Reflections.getField(id, instance);
    }

    // getFieldIntArray
    public static int[] getFieldIntArray(int id, Object instance) {
        return Reflections.getField(id, instance);
    }

    // getFieldLongArray
    public static long[] getFieldLongArray(int id, Object instance) {
        return Reflections.getField(id, instance);
    }

    // getFieldFloatArray
    public static float[] getFieldFloatArray(int id, Object instance) {
        return Reflections.getField(id, instance);
    }

    // getFieldDoubleArray
    public static double[] getFieldDoubleArray(int id, Object instance) {
        return Reflections.getField(id, instance);
    }

    // getFieldObjectArray
    public static Object[] getFieldObjectArray(int id, Object instance) {
        return Reflections.getField(id, instance);
    }
    @SneakyThrows
    public static <T> T getField(int id, Object instance) {
        try {
            return (T) fieldMap.get(id).get(instance);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    @SneakyThrows // setFieldBoolean
    public static void setFieldBoolean(int id, Object instance, boolean value) {
        fieldMap.get(id).setBoolean(instance, value);
    }
    @SneakyThrows // setFieldChar
    public static void setFieldChar(int id, Object instance, char value) {
        fieldMap.get(id).setChar(instance, value);
    }
    @SneakyThrows // setFieldShort
    public static void setFieldShort(int id, Object instance, short value) {
        fieldMap.get(id).setShort(instance, value);
    }
    @SneakyThrows // setFieldInt
    public static void setFieldInt(int id, Object instance, int value) {
        fieldMap.get(id).setInt(instance, value);
    }
    @SneakyThrows // setFieldLong
    public static void setFieldLong(int id, Object instance, long value) {
        fieldMap.get(id).setLong(instance, value);
    }
    @SneakyThrows // setFieldFloat
    public static void setFieldFloat(int id, Object instance, float value) {
        fieldMap.get(id).setFloat(instance, value);
    }
    @SneakyThrows // setFieldDouble
    public static void setFieldDouble(int id, Object instance, double value) {
        (fieldMap.get(id)).setDouble(instance, value);
    }

    // setFieldObject
    public static void setFieldObject(int id, Object instance, Object value) {
        Reflections.setObjectField(id, instance, value);
    }

    // setFieldBooleanArray
    public static void setFieldBooleanArray(int id, Object instance, boolean[] value) {
        Reflections.setObjectField(id, instance, value);
    }

    // setFieldCharArray
    public static void setFieldCharArray(int id, Object instance, char[] value) {
        Reflections.setObjectField(id, instance, value);
    }

    // setFieldShortArray
    public static void setFieldShortArray(int id, Object instance, short[] value) {
        Reflections.setObjectField(id, instance, value);
    }

    // setFieldIntArray
    public static void setFieldIntArray(int id, Object instance, int[] value) {
        Reflections.setObjectField(id, instance, value);
    }

    // setFieldLongArray
    public static void setFieldLongArray(int id, Object instance, long[] value) {
        Reflections.setObjectField(id, instance, value);
    }

    // setFieldFloatArray
    public static void setFieldFloatArray(int id, Object instance, float[] value) {
        Reflections.setObjectField(id, instance, value);
    }

    // setFieldDoubleArray
    public static void setFieldDoubleArray(int id, Object instance, double[] value) {
        Reflections.setObjectField(id, instance, value);
    }

    // setFieldObjetcArray
    public static void setFieldObjetcArray(int id, Object instance, Object[] value) {
        Reflections.setObjectField(id, instance, value);
    }
    @SneakyThrows
    public static void setObjectField(int id, Object instance, Object value) {
        fieldMap.get(id).set(instance, value);
    }

    // invokeMethodVoid
    public static void invokeMethodVoid(int id, Object instance, Object ... params) {
        Reflections.invokeMethod(id, instance, Void.TYPE, params);
    }

    // create
    public static Object create(int id, Class<?> cls, Object ... params) {
        return Reflections.invokeConstructor(id, params);
    }
    @SneakyThrows
    public static <T> T invokeConstructor(int id, Object ... params) {
        return (T) ((Constructor) constructorMap.get(id)).newInstance(params);
    }

    // invokeMethodByte
    public static byte invokeMethodByte(int id, Object instance, Object ... params) {
        return Reflections.invokeMethod(id, instance, Byte.TYPE, params);
    }

    // getFieldName
    public static String getFieldName(int id) {
        return fieldMap.get(id).getName();
    }

    // getMethodName
    public static String getMethodName(int id) {
        return methodMap.get(id).getName();
    }

    // invokeMethodObject
    public static Object invokeMethodObjects(int id, Object instance, Object ... params) {
        return Reflections.invokeMethod(id, instance, Object.class, params);
    }

}
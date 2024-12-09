package cn.gov.vape.implemention;

import cn.gov.vape.Entrypoint;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Forge {
    @SneakyThrows
    public void register(Class<?> clazz, int busID){
        Map<Object, Object> map = new HashMap<>();

        Class<?> clsMap = Map.class;
        try {
            Class<?> clsEvent;
            Class<?> clsListenerList;
            Class<?> clsEventPriority;

            java.lang.reflect.Method getListenerListMethod;
            java.lang.reflect.Method registerMethod;

            int version = Entrypoint.INSTANCE.mcVersion;

            if (version < 14) { // 1.7.10
                // Classes:
                // Lcpw/mods/fml/common/eventhandler/Event;
                // Lcpw/mods/fml/common/eventhandler/ListenerList;
                // Lcpw/mods/fml/common/eventhandler/EventPriority;
                // MethodIDs:
                // ()Lcpw/mods/fml/common/eventhandler/ListenerList;
                // (ILcpw/mods/fml/common/eventhandler/EventPriority;Lcpw/mods/fml/common/eventhandler/IEventListener;)V
                clsEvent = Class.forName("cpw.mods.fml.common.eventhandler.Event");
                clsListenerList = Class.forName("cpw.mods.fml.common.eventhandler.ListenerList");
                clsEventPriority = Class.forName("cpw.mods.fml.common.eventhandler.EventPriority");
                getListenerListMethod = clsEvent.getMethod("getListenerList");
                registerMethod = clsListenerList.getMethod("register", int.class, clsEventPriority, Class.forName("cpw.mods.fml.common.eventhandler.IEventListener"));
            } else if (version < 26) { // 1.12.2
                // Classes:
                // Lnet/minecraftforge/fml/common/eventhandler/Event;
                // Lnet/minecraftforge/fml/common/eventhandler/ListenerList;
                // Lnet/minecraftforge/fml/common/eventhandler/EventPriority;
                // MethodIDs:
                // ()Lnet/minecraftforge/fml/common/eventhandler/ListenerList;
                // (ILnet/minecraftforge/fml/common/eventhandler/EventPriority;Lnet/minecraftforge/fml/common/eventhandler/IEventListener;)V

                clsEvent = Class.forName("net.minecraftforge.fml.common.eventhandler.Event");
                clsListenerList = Class.forName("net.minecraftforge.fml.common.eventhandler.ListenerList");
                clsEventPriority = Class.forName("net.minecraftforge.fml.common.eventhandler.EventPriority");

                getListenerListMethod = clsEvent.getMethod("getListenerList");
                registerMethod = clsListenerList.getMethod("register", int.class, clsEventPriority, Class.forName("net.minecraftforge.fml.common.eventhandler.IEventListener"));
            } else { // 1.8.9
                // Classes:
                // Lnet/minecraftforge/eventbus/api/Event;
                // Lnet/minecraftforge/eventbus/ListenerList;
                // Lnet/minecraftforge/eventbus/api/EventPriority;
                // MethodIDs:
                // ()Lnet/minecraftforge/eventbus/ListenerList;
                // (ILnet/minecraftforge/eventbus/api/EventPriority;Lnet/minecraftforge/eventbus/api/IEventListener;)V

                clsEvent = Class.forName("net.minecraftforge.eventbus.api.Event");
                clsListenerList = Class.forName("net.minecraftforge.eventbus.ListenerList");
                clsEventPriority = Class.forName("net.minecraftforge.eventbus.api.EventPriority");

                getListenerListMethod = clsEvent.getMethod("getListenerList");
                registerMethod = clsListenerList.getMethod("register", int.class, clsEventPriority, Class.forName("net.minecraftforge.eventbus.api.IEventListener"));
            }
            Field f = clsEvent.getDeclaredField("listeners");
            f.setAccessible(true);
            Object listenerList = f.get(null);
            registerMethod.invoke(listenerList,busID,clsEventPriority.getDeclaredField("NORMAL"),clazz);
            registerMethod.invoke(listenerList,busID,clsEventPriority.getDeclaredField("NORMAL"),this);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            System.out.println("Failed to register: " + clazz.getName());
            e.printStackTrace();
        }
    }
}

package cn.gov.vape.reflect;

import cn.gov.vape.Entrypoint;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;

public class Mapping {
    private final Logger logger = LogManager.getLogger("vape.mappings");
    public final Multimap<String, String> methods = HashMultimap.create();
    public final Multimap<String, String> methodsReversed = HashMultimap.create();
    public final Multimap<String, String> fields = HashMultimap.create();
    public final Multimap<String, String> fieldsReversed = HashMultimap.create();

    public Mapping(String version){
        try {
            parse(Entrypoint.class.getResourceAsStream("/data/v"+version+"/methods.csv"), methods, methodsReversed);
            parse(Entrypoint.class.getResourceAsStream("/data/v"+version+"/fields.csv"), fields, fieldsReversed);
        }
        catch (IOException e) {
            logger.catching(e);
        }
    }

    public void parse(InputStream stream, Multimap<String, String> map, Multimap<String, String> mapReverse) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream))){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String srg = parts[0];
                String name = parts[1];
                map.put(name, srg);
                mapReverse.put(srg, name);
            }
        }
    }

    public boolean match(Method method, String name) {
        String methodName = method.getName();
        if (!methodName.equals(name)) {
            String s;
            Iterator<String> iterator = methods.get(name).iterator();
            do {
                if (iterator.hasNext()) continue;
                iterator = methodsReversed.get(name).iterator();
                do {
                    if (iterator.hasNext()) continue;
                    return false;
                } while (!methodName.equals(s = iterator.next()));
                return true;
            } while (!methodName.equals(s = iterator.next()));
        }
        return true;
    }

    public boolean match(Field field, String name) {
        String fieldName = field.getName();
        if (!fieldName.equals(name)) {
            String s;
            Iterator<String> iterator = fields.get(name).iterator();
            do {
                if (iterator.hasNext()) continue;
                iterator = fieldsReversed.get(name).iterator();
                do {
                    if (iterator.hasNext()) continue;
                    return false;
                } while (!fieldName.equals(s = iterator.next()));
                return true;
            } while (!fieldName.equals(s = iterator.next()));
        }
        return true;
    }
}
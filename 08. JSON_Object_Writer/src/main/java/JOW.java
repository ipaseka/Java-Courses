import org.json.simple.JSONObject;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class JOW {
    public static String getJsonStringByObject(Object obj) {
        Class clazz = obj.getClass();
        Map<String, Object> objectMap = new HashMap<>();
        for (Field field: clazz.getDeclaredFields())
        {
            System.out.println(field.getName() + " : " + field.getType().getSimpleName());

            boolean fieldAccessible = field.isAccessible();
            Object val = "";
            field.setAccessible(true);

            try {
                val = field.get(obj);
                if(field.getType().getSimpleName().endsWith("[]"))//arr
                {
                    Object[] objectArr = new Object[Array.getLength(val)];
                    for (int i = 0; i < Array.getLength(val); i++) {
                        objectArr[i] = Array.get(val, i);
                    }
                    val = Arrays.asList(objectArr);
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            finally {
                field.setAccessible(fieldAccessible);
            }
            objectMap.put(field.getName(), val);
        }
        return JSONObject.toJSONString(objectMap);
    }
}

package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionHelper {
    private ReflectionHelper(){}

    public static <T> T getInstanceOf(Class <T> type, Object... args) {
        try {
            if (args.length == 0)
                return type.getDeclaredConstructor().newInstance();
            else
                return type.getDeclaredConstructor(getClassList(args)).newInstance(args);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static Object callMethod (Object obj, String methodName, Object... methodArgs) {
        Boolean isAccessible = false;
        Method method = null;
        try {
            method = obj.getClass().getMethod(methodName, getClassList(methodArgs));
            isAccessible = method.isAccessible();
            method.setAccessible(true);
            return method.invoke(obj, methodArgs);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
           throw new RuntimeException(e);
        } finally {
            if (method != null)
                method.setAccessible(isAccessible);
        }
    }
    private static Class<?>[] getClassList (Object... args) {
        Class<?> [] classArr = new Class<?>[args.length];
        for (int i = 0; i < args.length; i++) {
            classArr[i] = args[i].getClass();
        }
        return classArr;
    }
}

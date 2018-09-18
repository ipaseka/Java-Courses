import annotations.After;
import annotations.Before;
import annotations.Test;
import org.reflections.Reflections;
import reflection.ReflectionHelper;
import java.lang.reflect.Method;
import java.util.*;

public class CustomTest {
    private CustomTest () {

    }
    public static void testClass (Class<?> type) {
        Object instance = ReflectionHelper.getInstanceOf(type);
        List <Method> beforeMethodList = new ArrayList<>();
        List <Method> testMethodList = new ArrayList<>();
        List <Method> afterMethodList = new ArrayList<>();
        for (Method method : type.getDeclaredMethods())
        {
            if (method.isAnnotationPresent(Before.class))
                beforeMethodList.add(method);
            if (method.isAnnotationPresent(Test.class))
                testMethodList.add(method);
            if (method.isAnnotationPresent(After.class))
                afterMethodList.add(method);
        }
        beforeMethodList.forEach(item -> ReflectionHelper.callMethod(instance, item.getName()));
        testMethodList.forEach(item -> ReflectionHelper.callMethod(instance, item.getName()));
        afterMethodList.forEach(item -> ReflectionHelper.callMethod(instance, item.getName()));

    }
    public static void testPackage (String packageName) {
        Reflections ref = new Reflections(packageName);
        Set<Class<? extends Object>> classSet = ref.getSubTypesOf(Object.class);

        classSet.forEach((input) -> testClass(input));
    }

}

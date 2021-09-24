package annotation;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicInvocationHandler implements InvocationHandler {

    private Object target;

    DynamicInvocationHandler(Object target) {
        this.target = target;

//        for(Method method: target.getClass().getDeclaredMethods()) {
//            this.methods.put(method.getName(), method);
//        }
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(42);
        Object result = method.invoke(target, args);
        return result;
    }
}

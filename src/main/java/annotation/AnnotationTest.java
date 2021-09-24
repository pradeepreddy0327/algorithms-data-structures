package annotation;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class AnnotationTest {

    public static void main(String[] args) {
        //repoTest();
        Map proxyInstance = (Map) Proxy.newProxyInstance(AnnotationTest.class.getClassLoader(), new Class[] {Map.class }, new DynamicInvocationHandler(new HashMap<>()));
        proxyInstance.put("hello", "world");
        System.out.println(proxyInstance.get("hello"));
    }

    private static void repoTest() {
        SampleRepository repo = new SampleRepository();
        for(Method method: repo.getClass().getMethods()){
            Transaction annotation = method.getAnnotation(Transaction.class);
            if(annotation != null){
                //method.
//                TransactionDecorator decorator = new TransactionDecorator();
//                method.invoke(repo, )
            }
        }
    }
}

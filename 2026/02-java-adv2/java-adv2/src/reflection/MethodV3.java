package reflection;

import reflection.data.Calculator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 14.
 * @fileName : MethodV3
 */
public class MethodV3 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Call Method Name : ");
        String methodName = scanner.nextLine();
        System.out.print("Number 1 press : ");
        int num1 = scanner.nextInt();
        System.out.print("Number 2 press : ");
        int num2 = scanner.nextInt();

        Calculator calculator = new Calculator();

        // 호출할 메서드를 변수 이름으로 동적으로 선택한다.

        Class<Calculator> aClass = Calculator.class;
        Method method = aClass.getMethod(methodName, int.class, int.class);

        Object returnValue = method.invoke(calculator, num1, num2);
        System.out.println("returnValue = " + returnValue);
    }
}

package 面试题目.java基础题;

/**
 * @author: shade
 * @date: 2022/4/25 18:36
 * @description:
 */
public class 浮点除法 {
    public static void main(String[] args) {
        System.out.println(1.0 / 0.0); // Infinity
        System.out.println(0.0 / 0.0); // NaN
    }
    //Infinity 的中文意思是无穷大，NaN 的中文意思是这不是一个数字（Not a Number）。
    //当整数除以 0 的时候（10 / 0），会抛出异常：
    //Exception in thread "main" java.lang.ArithmeticException: / by zero
    // at com.itwanger.eleven.ArithmeticOperator.main(ArithmeticOperator.java:32)
    //通常，我们在进行整数的除法运算时，需要先判断除数是否为 0，以免程序抛出异常。
}

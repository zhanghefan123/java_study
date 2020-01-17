package 静态绑定以及动态绑定以及重载;
/*
* 1.发生在同一个类之中签名不同的方法
* 称之为重载。，遵循编译器绑定，看参数/引用的类型来绑定方法
* */

/*
 * 方法的重写：重新写，覆盖
 * 1.发生在父子类之中，方法名称相同，参数列表相同，方法体不同
 * 2.重写方法被调用式，看对象的类型
 * 3.重写遵循"两同两小一大"
 * 4.1.方法名称相同
 *   2.参数列表相同
 *   3.派生类方法返回值类型小于或等于超类方法的返回值类型,当为void或者基本数据类型时必须相等，引用类型时小于或者等于
 *   4.派生类的访问权限大于或者等于超类方法的访问权限
 *   5.派生类抛出异常的异常小于或者等于超类的方法
 *   6.超类大，子类小
 * */

import org.junit.Test;
/*
* 总结下来就是重载看引用的类型
* 但是重写的话就是看对象的类型
*
* */


/*
* 静态绑定
* 静态绑定以及隐藏
修饰符限定使之称为静态绑定：
A. 对于private的方法，首先一点它不能被继承，既然不能被继承那么就没办法通过它子类的对象来调用，
* 而只能通过这个类自身的对象来调用。因此就可以说private方法和定义这个方法的类绑定在了一起。
B.final方法虽然可以被继承，但不能被重写（覆盖），虽然子类对象可以调用，但是调用的都是父类中所定义的那个final方法，（
* 由此我们可以知道将方法声明为final类型，一是为了防止方法被覆盖，二是为了有效地关闭java中的动态绑定)。
C.static方法的话可以被继承，如果满足重写的规则则不是被重写，而是被隐藏，
* 根据引用的类型来进行调用。如果不满足重写的规则，比如说形参列表不一致，那么就根据形参列表来进行判断调用哪一个。
*
*
*
*
* */
public class OverrideDemo {
    public static void main(String[] args) {
        //重写的演示，show是实例方法
        Father son = new Son();
        son.show();
        //静态绑定的演示,sayHi是静态方法
        Father son1 = new Son();
        son1.sayHi();
        //私有方法是静态绑定的演示
        /*
        * 因为私有方法根本无法被继承所以不能通过子类对象来进行
        * 调用。所以其和这个类进行了绑定。
        * */

        //final方法是静态绑定的演示
        /*
        * final修饰的方法，final虽然可以进行继承
        * 但是不能被重写，虽然子类可以调用但是都是调用的是父类之中的
        * 那个方法。
        * */
    }
}
class Father{
    String name;
    int age;
    public void show()
    {
      System.out.println("I am your father");
    }
    public static void sayHi()
    {
        System.out.println("FATHER");
    }

}
class Son extends Father
{
    double salary;
    public static void sayHi()
    {
        System.out.println("SON");
    }
    public void show()
    {
        System.out.println("I am your Son");
    }
}
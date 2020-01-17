package 静态STATIC学习;
//static 静态的
/*
* 1.静态变量
* 由static进行修饰
* 属于类，存在方法区，只有一份(类也是对象，并且是唯一的)
* 常常通过类名来访问静态变量，
* 什么时候用：所有对象所共享的数据，(图片，音频，视频)

* 2.静态方法：
* A.由static进行修饰
* B.属于类，存储在方法区之中,只有一份
* C.通过类名来进行访问
* D.静态方法没有隐式的this传递
* E.静态犯法之中不能直接访问成员变量，实例变量
* F.方法的操作仅与参数相关与对象无关

* 3.静态代码块：
* 属于类，在类被加载期间自动执行
* 因类只被加载以此，所以静态块只执行以此，
* 什么时候用:加载/初始化资源(图片/音频/视频)等
*
* 注意在静态方法和静态代码块之中，不允许去调用非静态成员变量。
* 可以通过对象来调用静态帆帆发，但是不建议。

* 静态代码块先于构造方法执行
*
* 4.debug
* 1.先打断点，看你想看的那一行代码
* 2.F5 下一步代码的执行
* 3.F6 会执行完当前的这一行代码，无论是否有方法
* 4.F7 跳出当前方法，并且默认当前方法已经执行完毕
* 5.F8是跳到下一个断点，如果没有断点程序就进行正常的执行。
*
* 5.静态常量的学习
* static final 常量：应用率非常的高
* 1.必须在声明的同时进行初始化的操作
* 2.通过类名进行改变，不能被改变
* 3.建议：所有常量名所有字母都必须进行大写，多个单词之间采用_进行隔开
* 4.编译器在编译的时候将常量直接替换成为具体的只，效率高
* 5.什么时候用：数据永远不变，并且经常进行使用。
* */

import org.junit.Test;

public class StaticDemo {
    public static void main(String[] args)
    {
        Noo noo1 = new Noo();
        Noo noo2 = new Noo();
        /*输出的结果是a为1 b为2*/

        /*
        * 1.加载Boo.class到方法区之中
        * 2.静态变量num也存储到方法区之中
        * 3.到方法区之中获取num的值并且进行输出
        * */
        System.out.println(Boo.num);
        /*
        * 1.编译器在进行编译的时候将常量直接替换
        * 成为具体的值，效率高。
        * 相当于System.out.println(5);
        * */
        System.out.println(Boo.COUNT);
    }

    public static void test()
    {

    }
}
class Loo{

    int a;
    static int b;
    Loo()
    {
        a++;
        b++;
    }
    void show()
    {
        System.out.println(a+","+b);
    }
}
class Noo
{
    static
    {
        System.out.println("静态块");
    }
    Noo()
    {
        System.out.println("构造方法");
    }

}

class Boo
{
    public static int num =5;//静态变量
    public static final int COUNT =5;//常量

}


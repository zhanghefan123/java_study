package 基本数据类型的学习;

//C++的int以及long数据类型是与平台是相关的，但是JAVA的数据类型
//则是与平台是无关的，增强了程序的可移植性，不会造成转移平台时溢出的情况的
//发生

/*
* byte   1字节
* char   2字节  存储UNICODE字符，所以说它是可以进行中文字符的存储的
* short  2字节
* int    4字节
* long   8字节
* float  4字节
* double 8字节
* */

/*
整数类型可以进行赋值的常量如下
* 12 -12 +12 0b12 012 0x12
* 有十进制整数，二进制整数，八进制整数，十六进制整数
* */

/*
* JAVA之中没有任何的无符号
* 整数类型
* */

/*C++可以使用数值，字符串，甚至指针都可以进行布尔值的替代
* 但是JAVA是不可以的，就可以避免x=1这种永真式放在循环之中
* 发生死循环的事件*/

public class Basic {

}
class Start
{
    public static void main(String[]args)
    {
        System.out.println(Double.POSITIVE_INFINITY);
        System.out.println(Double.NEGATIVE_INFINITY);
        System.out.println(Double.NaN);
        double nan = Double.NaN;
        double finit = Double.POSITIVE_INFINITY;
        double infinit = Double.NEGATIVE_INFINITY;
        if(Double.isNaN(nan))
        {
            System.out.println("不是一个数");
        }
        if(Double.isFinite(finit))
        {
            System.out.println("正无穷大");
        }
        if(Double.isInfinite(infinit))
        {
            System.out.println("负无穷大");
        }
    }
}
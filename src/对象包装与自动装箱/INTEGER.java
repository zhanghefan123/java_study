package 对象包装与自动装箱;
/*
* 出现的目的是让基本类型转换成为对象，所有基本类型都有一个
* 预期对应的类，这些对象包装器类拥有很明显的名字：Float Long
* Double Short Byte Character Void Boolean,对象包装类是不可
* 变的，即一旦构造了包装器，就不允许更改包装在其中的值，对象包装器类
* 是final因此不能够定义它的子类
*/

/*
*
①使类中所有的成员变量被final修饰
②类中没有修改成员变量的方法,例如setXXX,可以提供一个带参的构造函数来初始化这些成员变量
③确保类中的方法不会被重写.可以将类或者类中的方法定义为final的来实现
④如果一个类的成员不是不可变量,那么在成员初始化或者使用get方法获取该成员变量时,需要使用clone方法来确保类的不可变性
* */

/*
创建包装类对象：
使用valueOf而不是new进行创建。
可以在valueOf之中放基本类型，以及基本类型的字符串形式，
字符串要符合数字格式。
* */

/*
包装类字段：
MIN_VALUE 最小值
MAX_VALUE 最大值
BYTES 字节数
SIZE 位数
TYPE 基本类型
* */

/*
* 自动装箱操作
* 如果将一个Integer赋值给一个int值时，将会自动地进行拆箱的操作。
* 甚至在算术表达式之中也能够进行自动的拆箱以及装箱。
* */

/*
* 举出Integer类来作为调用的方法
* INTEGER类以及类对象的方法：
《1》转换成基本数据类型的函数
     int intValue()
     double doubleValue()
     long longValue()
《2》static String toString(int i)返回指定十进制数的字符串表示.
《3》static int parseInt(String s)将字符串转换成为整数
《4》static int parseInt(String s,int radix)我们给定的字符串s是radix进制的。

*
* */
public class INTEGER {
    public static void main(String[] args) {
        //1.创建的包装类对象的方法
        Integer integer = 1;
        Integer integer2 = Integer.valueOf(1);
        //2.将字符串转换成为整数,不需要写上0X 或者 0 来代表十六进制或者是八进制
        int age = Integer.parseInt("12",16);
        System.out.println(age);
        //3.返回指定十进制数的字符串表示
        String str = Integer.toString(1);
        //4.返回数值
        System.out.println(integer.intValue());
        //5.字段问题
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.BYTES);
        System.out.println(Integer.TYPE);
    }
}

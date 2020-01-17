package JAVA变量常量;
/*
* 1.JAVA变量分为局部变量(在方法之中进行声明)
* 和成员变量(在类之中进行声明的)，就是实例域
* 注意成员变量如果在构造函数和初始化块之中没有进行赋值的
* 操作的话它也有默认的值，这个默认的值在自主学习的构造对象的
* 学习上进行了讲解
*
* 2.在JAVA之中使用常量来进行常量标识，其实final还有其它的用法，
* A.final修饰类的时候代表类不能够进行继承的操作
* B.final修饰方法的时候代表方法不能够进行重写
* C.final修饰变量的时候代表变量不能够进行重新的赋值
*
* 3.静态方法只能够进行静态变量的访问，实例方法可以访问静态变量以及实例变量
* 在JAVA之中使用关键字final来进行常量的标识，常量只能够在初始化的时候接受赋值
* 在java之中经常希望某个变量可以在一个之中的多个方法之中进行使用，通常我们将这些
* 常量称之为静态常量
* */
public class Start {
    public static void main(String[] args)
    {
        System.out.println("熊可铭");
    }
}
class Test{
    String name;
    int age;
    static String address;
    public void Test(String name,int age,String address)
    {
        this.name = name;
        this.age =age;
        this.address = address;
    }
    public void show()
    {
        System.out.println("my name is "+name);
    }
    static void show2()
    {
        System.out.println("my name is "+address);
    }
}

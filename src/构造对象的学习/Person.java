package 构造对象的学习;

class Start
{
    public static void main(String[] args) {
        Person person = new Person(12);
        System.out.println(person.unregister);
        System.out.println(person.address);
        System.out.println(person.id);

    }
}
public class Person {
    String name = "张贺凡";
    int unregister;
    int age;
    String address;
    final String id = "123456";//必须要在这里或者构造函数之中进行初始化,就是必须在对象创建的时候进行初始化的操作
    public Person(int age,String address)
    {
        this.age = age;
        this.address = address;
    }
    public Person(int unregister)
    {
        this(12,"武威路");
    }
}
/*
* 成员变量或者说类的实例域都是存在默认值的
* 实例域默认值：
  成员变量即实例域如果没有初始化则编译器会进行默认的初始化，即存在一个默认的构造函数对这些进行初始化。
  整数类型默认为0
  浮点类型默认为0.0
  字符类型默认为空格
  布尔类型默认为false
  字符串类型默认为null
  若在属性之中有对象的化在构造的时候没有对他进行初始化的话，会进行报错出现空指针异常，因为这个对象变量也是赋值为默认值null，所以引用它的话会导致空指针异常。
* */

/*
* 显示域初始化：可以在类定义之中，直接将一个值赋值给任何域。
* 在执行构造器之前，先执行赋值的操作，
* 在C++之中不能够直接的进行初始化，但是JAVA之中是可以的。
* */

/*
* 调用另一个构造器：如果构造器的第一个语句形如this(…)
* 这个构造器将调用同一个类之中的另一个构造器
* */

/*
* 初始化块
* 在一个类的声明之中，可以包含多个代码块，只要构造类的对象，
* 这些代码块就会被执行。
* 格式就是用大括号将一系列的初始化语句包括在内即可。
* */

/*成员变量初始化的过程如下所示
调用构造器进行初始化的具体步骤：
《1》将所有数据域（静态域实例域）初始化为默认值
《2》按照在类之中声明的次序，依次执行所有域初始化语句以及初始化块。
《3》如果这个构造器的内部调用了另一个构造器则执行另一个构造器之中的内容
《4》执行本构造器的内容。
* */
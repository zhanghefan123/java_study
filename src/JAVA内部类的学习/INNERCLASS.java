package JAVA内部类的学习;
//简单叙述:
/*
* 人体是由大脑器官以及各个部分组成的生命体，组成我们人体的这些器官也拥有自身的属性
* 以及他们的行为，并且他们要依靠外部的人体才能够存在，类似的一个类之中我们也可以包
* 括另一个类，并且里面的类要依靠外面的类才能够存在，这就演化出了我们的内部类，
* 内部类是定义在另一个类之中的类
*
*
* */

//优点：
/*
* A.内部类可以访问该类定义的所在作用域之中的数据。
* B.内部类很成功的对同包之中的类隐藏了起来。
* C.减少了编译之后字节码文件的大小。
*
* */

//分类：
/*
* 1.局部内部类
* 2.成员内部类
* 3.静态内部类
* 4.实例内部类
* 5.匿名内部类
* 如果想要创建一个类(派生类)的对象，并且对象只被创建一次
* 此时该类不必进行命名，成为匿名内部类。匿名内部类之中如果
* 想要访问外面的变量，这个变量必须是final，即为从外面捕获
* 的变量必须是不可变的常量。
* 匿名内部类访问外部局部变量，该变量必须所示final
* 1.7之后编译器会默认给你加上final
        * */

//成员内部类的特点/包括静态成员内部类
/*
* 1.内部类仍然是一个独立的类，在编译之后还是会生成独立的.class文件
* 2.内部类不能够使用普通的方式进行访问，内部类为外部类的一个成员，因此
* 内部类可以自由访问外部类成员甚至是private修饰的成员
* 3.内部类如果声明为静态的即如果是静态内部类的话，只能够访问外部类的静态成员
* 4.嵌套是一种类与类之间的关系，而不是对象之间的嵌套，嵌套类增加了命名控制以及访问控制
* 我们可以将内部类放在外部类的私有部分，这样就可以将内部类的数据设置为公有的，
* 它只能被外部类的方法所访问，以及被自身的方法所访问。
* 5.内部类还有一个隐式的引用类似于this，我们也可以通过外部类名.this访问外部数据域，
* 通过this.访问内部数据域。
*
* */

//局部内部类是在一个方法之中定义的内部类
/*
* A.局部内部类与局部变量相同不能够使用访问控制修饰符
* B.局部内部类只能在当前方法之中生效
* C.局部内部类之中不能够定义static成员
* D.局部内部类之中可以访问外部类之中的所有成员
* E.局部内部类之中可以访问当前方法之中final类型的参数与变量
*
*
* */

import java.util.Comparator;
import java.util.function.Consumer;

//6.静态内部类的语法规则
/*
* A.在外围创建静态内部类的实例的时候不需要实现创建外部类的实例
* Outer.Inner a = new Outer.Inner();
* B.静态内部类之中是哪个可以 定义静态成员以及实例成员
* C.静态内部类之中可以访问外部类的静态成员，但是如果如果想要访问
* 外部的实例成员，则需要创建外部类的对象。
*
*
*
*
*
*
//7.方法引用的写法
方法引用：方法引用可以看作LAMBDA表达式深层次的表达，它也是
函数式接口的实例。

使用的情景：当要传递给LAMBDA体的操作已经存在有实现的方法的情况之下
我们可以使用方法引用。

方法引用使用的要求：
要求接口之中的抽象方法的形参列表和返回值类型与方法引用的方法的
形参列表和返回值类型相同，只是针对于对象::非静态方法以及类::静态方法

举例：
比如说我们Consumer这个函数式的接口，它其中的唯一的一个抽象方法
是没有返回值但是存在一个参数，所以只要存在一个没有返回值，并且
传递一个参数的方法的话我们就可以直接将他引用过来把他当作函数式接口的
一个实例，在这里我们既可以使用lambda表达式也可以使用方法引用
比如：Consumer<String> con = System.out::println()

格式：
类(或者对象)::方法名

方法引用具体分为以下的三种情况
* */
//A.对象::非静态方法，完全匹配
class Employee
{
    String name;
    Employee()
    {
        name = "zhanghefan";
    }
    public void getName(String name)
    {
        this.name = name;
    }
    public void show()
    {
        System.out.println(name);
    }
}
//

public class INNERCLASS {
    public static void main(String [] args)
    {
        //Baby baby = new Mama.Baby() 编译错误 内部类只能够在外部类之中进行使用
        Mama m = new Mama();
        Mama.Baby b  = m.new Baby();//通过外部类对象创建内部类对象，所以我们一定要存在外部类对象才能够在
                                    //外部类的外部创建内部类对象
        //使用匿名内部类，为该派生类创建一个对象，大括号之中为派生类的类体
        Aoo o1 = new Aoo()//相当于省去了一个类。
        {

        };

        //创建一个Boo的派生类但是同样也没有名字
        Boo o2 = new Boo()
        {
          void show()
          {
              System.out.println("show");
          }
        };
        o2.show();
        System.out.println(Integer.compare(1,2));

        //A.引用对象之中的非静态方法，完全匹配
        Employee employee = new Employee();
        Consumer<String> con1 = employee::getName;
        con1.accept("zhuzeguo");
        employee.show();

        //B.引用类之中的静态方法(需要完全匹配)
        Comparator<Integer> com1 = Integer::compareTo;
        System.out.println(com1.compare(1,2));

        //C.类:非静态方法(不需要完全匹配)
        /*
        * String之中的compareTo方法不是静态方法而是一个实例方法
        * Comparator之中的抽象方法是需要两个参数的，但是这里不需要
        * 完全比配，就是将第一个参数作为调用者，第二个作为参数
        * 等于说外部先是将两个参数接下来，内部之中一个参数当成
        * 调用者一个当成参数
        * */
        Comparator<String> com2 = String::compareTo;


    }
}
abstract class Boo
{
    abstract void show();
}
abstract class Aoo
{

}

class Mama
{
    private String name;
    //成员内部类
    class Baby
    {
        public void showMamaName()
        {
            System.out.println(name);
            System.out.println(Mama.this.name);
            //System.out.println(this.name);//会发生报错
        }
    }
    void createBaby()
    {
        Baby b = new Baby();//内部类对象是可以在外部类之中被创建的。
    }
}

class Outer
{
    String self_introduction;
    public void show()
    {
        class Inner
        {
            String name;
            int age;
            public Inner(){
            this.name =  "张贺凡";
            this.age = 12;
            }
            public void show_inner()
            {
                System.out.println(Outer.this.self_introduction);
                System.out.println(name);
                System.out.println(age);
            }
        }
        Inner inner = new Inner();

    }
}
package 单例模式;
//分为饿汉式以及懒汉式
/*
* 要求:
* 1.----------创建一个私有的构造方法
* 2.----------创建一个获取单例的静态方法
* 3.----------创建几个获取属性的方法
* */

/*
* 饿汉式和懒汉式的区别，饿汉式就是类一旦加载的时候就把单例初始化完成，
* 保证getInstance的时候单例就已经是存在的了。懒汉式是比较懒的只有在
* getInstance即获取其中的实例的时候才回去对这个单例进行初始化的操作。
* */
public class Single {
    String name;
    int age;
    private static final Single t = new Single();
    private Single()
    {
        this.name = "张三";
        this.age = 12;
    }
    public static Single getSingle()
    {
        return t;
    }
    public String getName()
    {
        return name;
    }
    public int getAge()
    {
        return age;
    }
}
class Single2{
    String name;
    int age;
    private static Single2 single2;
    private Single2()
    {
        this.name = "李四";
        this.age = 12;
    }
    //在获取实例的时候才进行创建所以说它是懒汉
    public static Single2 getSingle2()
    {
        if(single2 == null)
        {
            single2 = new Single2();
        }
        return single2;
    }
    public String getName()
    {
        return name;
    }
    public int getAge()
    {
        return age;
    }
}
class Start
{
    public static void main(String[] args)
    {
        Single single = Single.getSingle();
        System.out.println(single.getName());
        System.out.println(single.age);
        Single2 single2 = Single2.getSingle2();
        System.out.println(single2.getAge());
        System.out.println(single2.getName());
    }
}

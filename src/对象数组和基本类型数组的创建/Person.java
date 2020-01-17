package 对象数组和基本类型数组的创建;
/*
* 需要了解的是数组是如何进行创建的。
* 使用大括号进行构造的时候我们需要使用new
* Doctor[] doctors = new Doctor[]{new Doctor("张贺凡","五维路滨江庄园",12,12000)};
*
* */

//1.-----------------创建数组的四种方式
/*
A.int [ ] a;
B.int [ ] a = new int[100]; 100个元素将会被全部初始化为0
C.int [ ] a = new int[ ]{1,2,3};
D.int [ ] a = {1，2，3}
* */

//2.-----------------数组的拷贝
/*
A.在JAVA之中允许将一个数组变量拷贝给另一个数组变量，但是这样与我们的常规想法
是不一样的，他们实际上是让两个引用指向了同一个对象
B.如果想要进行浅拷贝，即如果数组之中都是基本类型的话则可以将所有的值进行一份
拷贝，并让另一个数组变量来指向这个堆内存之中的对象，这里通过Arrays之中的copyOf
方法来进行实现，其中第一个参数是要进行拷贝的原数组，然后第二个参数是新数组的数组
长度。多余的元素将被赋值为默认值，类似于我们成员变量所拥有的默认值。
C.数组的扩容(倍扩)
数组名A = Arrays.copyOf(数组名A，2*数组名.length)
D.数组的排序：
数组之中拥有静态的sort方法，参数为数组名对数组进行排序，这个排序不是返回一个数组
而是进行就地排序。
E.Arrays之中的静态方法static void fill(type[] a,type v )
这个使用来对数组之中的所有的元素进行赋值的操作。
F.将一维数组转换成为字符串使用Arrays.toString将二维数组 转换成为字符串使用Arrays.deepToString
*
*
*
*
* */
public class Person {
    String name;
    String address;
    int age;
    public Person(String name,String address,int age)
    {
        this.name = name;
        this.address = address;
        this.age= age;
    }
}
class Doctor extends Person
{
    double salary;
    public Doctor(String name,String address,int age,double salary)
    {
        super(name,address,age);
        this.salary = salary;
    }
}
class Start
{
    public static void main(String[] args) {
        Doctor[] doctors = new Doctor[]{new Doctor("张贺凡","五维路滨江庄园",12,12000)};
        double[] array = new double[3];
        double[] array1 = new double[]{1,2,3};
        double[] array2 = {};
        double[][] array_double = new double[3][];//相当于创建三行多列的二维数组，他可能是一个列不等长数组。
    }
}
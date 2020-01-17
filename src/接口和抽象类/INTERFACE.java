package 接口和抽象类;
//1.接口的定义
/*
 在JAVA程序设计语言之中，接口并不是类，
 而是对类的一组需求类要完成的一系列特定的功能进行描述。
 一个类可以实现多个接口，
 如果类遵循某个接口的话它就要提供这个接口所要求其要提供的服务。
*/

//2.接口之中可以存在的方法
/*
* A.普通方法：接口之中的方法都是默认是public abstract进行修饰的。
* 在进行实现的时候必须将方法声明为public否则将认为是类的
* B.静态方法：public static允许在接口之中进行静态方法的定义，通过接口名.进行调用
* C.默认方法：public default可以为接口的方法提供一个默认的实现，当实现类没有进行
* 重写的
* */

//3.接口的特性
/*
* 1.接口不是类，尤其不能够使用new运算符来创建一个接口对象
* 2.尽管我们不能创造接口的对象，我们可以创建接口的变量，来指向实现了这个接口的对象
* 如果声明了接口数组的话就是具有这一个功能的对象的集合。
* 3.就像我们可以使用instanceOf来判断对象是不是某特定类的实例，当这个类为声明这个对象的类
* 或者说是这个类的基类，那么就会返回true，否则就返回false，同理instanceOf也可以用来检查
* 一个对象是否实现了某一个接口
* 4.接口也可以进行扩展即继承另一个接口,仅仅可以进行接口的继承，不能够进行类的继承
* */

//4.与C++的不同
/*
* C++之中复杂的多继承被
* java简单的单一继承和多重实现进行了替代
* */

//5.默认方法的冲突解决
/*
* 1.为什么需要进行冲突解决，因为如果先在一个
* 接口之中将一个方法定义为一个默认的方法，然后
* 又在超类或者另一个接口之中定义相同的方法，会出现
* 问题
* */

//6.默认方法冲突解决JAVA规则如下：
/*
* 1.超类优先:如果超类提供了一个具体的方法，
* 同名而且有相同参数类型的默认方法将会被忽略。
*
* 2.接口冲突
* 如果至少有一个接口提供了一个默认的方法，另一个
* 接口提供了一个同名而且参数类型相同的方法，必须
* 覆盖这个方法来解决冲突。
* */
class Father implements Compare,Compare1
{
    String name;
    int age;

    @Override
    public int fly(String who)
    {
        System.out.println("I am going to fly");
        return 1;
    }

    //我们观察到这里继承了来自两个接口的默认方法DEFAULT，所以在这个实现类之中必须进行重写的操作
    @Override
    public void DEFAULT() {

    }


}
interface Compare1
{
    public default void DEFAULT()
    {
        System.out.println("我是一个与Compare之中的方法同名的方法");
    }
}

interface Compare{
    //1.抽象的public方法。
    int fly(String who);
    //2.使用静态的public方法
    public static void show()
    {
        System.out.println("hello world 我是静态方法");
    }
    //3.默认方法
    public default void DEFAULT()
    {
        System.out.println("我是接口的一个默认方法，如果实现我的类" +
                "没有将我进行重写的操作的话，就使用这个具有方法体的默认的方法");
    }
}

interface Compare_Son extends Compare
{
    @Override
    public default void DEFAULT()
    {

    }
}

public class INTERFACE {

}
class Start
{
  public static void main(String[]args)
  {

  }
}
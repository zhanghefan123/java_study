package 泛型程序设计;
//1.为什么我们需要进行泛型程序设计
/*
* 泛型程序设计意味着我们编写的代码可以被不同类型的
* 对象进行使用，就是类似于向上造型之中统一接口的作用。
* 比如我们的ArrayList既可以聚集File对象，也可以聚集
* String对象，C++之中也存在泛型程序设计，其依托的是模板
* */

//2.类型参数的学习
/*
在刚开始的时候JAVA之中没有添加泛型类的时候，
泛型程序设计是采用赋值兼容进行实现的，
ArrayList数组列表之中维护着一个Object引用数组，
这样的解决方案存在有两个问题，一个问题是当我们获取一个值
的时候必须进行强制类型转换。
另一个问题：我们无法判断我们向ArrayList之中到底添加了什么，
无法进行错误的检查。更好的解决方案：泛型类之中添加了一个类型
参数，ps：ArrayList<String> array = new ArrayList<>();
上面示例之中的String就是类型参数。
这个类型参数用来指定元素的类型。右侧那对尖括号之中省略的内容
可以从左侧的进行自动的推出。这样的话编译器就知道返回值类型是
String类型而不是Object类型。
**/

//3.谁该使用泛型该如何去使用泛型
/*
使用如同ArrayList那样的泛型类非常的容易，这个操作大多数的人
都可以了解，但是实现一个泛型类并没有那么容易，对于类型参数来
说，使用这段代码的程序员可能想要能够使用所有的类型，因此一个
泛型程序员的任务：就是预测出所有类的未来可能有的所有用途。举
一个困难的例子，就是ArrayList类有一个方法称之为addAll用来
添加另一个集合的全部元素，我们可以将经理集合添加到雇员集合，
但是反过来就无法进行实现，我们如何实现只能进行前一个调用，
但是不能进行后一个调用。JAVA通过通配符来进行实现，后面将进
行介绍。
* */

//4.使用泛型的三个程度
/*
1.仅仅使用JAVA提供的泛型类。我们不需要考虑他们是如何进行实现的。
2.自己系统学习java泛型。
3.实现自己的泛型类以及泛型方法。
* */

//5.简单定义泛型类
/*
一个泛型类就是具有一个或者多个泛型变量的类。注意类型变量要采用大写形式。
创建格式：public class Pair<T> ...//... public class Pair<T,U..>
使用格式：Pair<String>使用的时候我们只需要传递类型即可。
* */

//6.简单进行泛型的方法的定义
/*
泛型方法可以在普通类之中进行定义同样他也可以在泛型类之中进行定义，
当我们调用泛型的方法的时候我们需要在方法名前面的中括号之中
添加具体的类型相当于赋值给类型变量。
1.在泛型类之中进行泛型方法的定义
public T getFirst(){ return first; }
2.在普通类之中进行泛型方法的定义
public static<T> T getMiddle(T...a){ return a[a.length/2];}
对于这个方法如果我们给的参数是3.14 1729 0的话，
会进行自动的装箱成为Double 和 Integer 对象然后寻找共同的超类型成为T。
如果有两个或者多个唯一的补救措施是将他们都重新调整为double类型再进行传递。

*
*
* */
//对类型变量进行限定
/*
 * 出现的原因：有时候不是所有传递进来的参数我们都是可以进行接受的
 * 我们有时候要对其进行约束，以至于某些类型是不能够传递进来的，
 * 因为这个方法不能操作这种类型的数据，或者如果操作了意义就不同了。
 * PS：public static <T extends Comparable> T min(T[ ] a)
 * 为什么这个方法要进行这个约束，因为这个方法体的内部可能用到了compareTo方法，
 * 如果没有实现这个接口的类型被传递了进来，然后调用的话肯定会发生报错。
 * 还有注意这里使用的是extends而不是implements,如果想要表名这个类型有多个超类型
 * (超类型可以是超类或者是接口)
 * ：则使用&进行隔开
 * */

//类型擦除
/*
 * 为什么要进行类型擦除:无论何时定义一个泛型类型(即泛型类)，都自动的提供了一个
 * 相应的原始类型，原始类型就是删去了类型参数后的泛型类型名，然后擦除类型变量
 * 然后擦除类型变量，并且替换为限定类型（无限定的使用Object）(如果具有限定
 * 类型的则采用第一个限定的类型进行替换的操作)
 *
 * */

//泛型类
    /*
    *Public class Pair<T>
    {
    Private T first;
    Private T second;
    Public Pair(T first,T second)
    {
     This.first = first;
     This.second = second;
    }
    Public T getFirst(){return first;}
    Public T getSecond(){return second;}
    Public void setFirst(T newValue){first = newValue;}
    Public void setSecond(T newValue){Second = newValue;}
    }

    * */

//进行类型擦除之后的类
/*
 Public class Pair
{
Private Object first;
Private Object second;
Public Pair(Object first,Object second)
{
 This.first = first;
 This.second = second;
}
Public Object getFirst(){return first;}
Public Object getSecond(){return second;}
Public void setFirst(Object newValue){first = newValue;}
Public void setSecond(Object newValue){Second = newValue;}
}
**/

//翻译泛型表达式(为什么叫做翻译--因为经过了擦除)
/*
* 如果使用类型擦除的话对于上面我们定义的Pair类来说，返回类型为Object
* 的话可能又需要我们进行强制类型转换的添加，但是这一步编译器会自动帮我们
* 进行添加，它会根据尖括号之中提供的类型参数替我们进行强制类型转换
*
* */

//翻译泛型方法
/*
但是泛型方法经过擦除之后可能会出现问题，当我们创建一个子类继承自Pair类，
并且重写了其中的泛型方法的话，因为使用了擦除，所以在Pair类之中的方法
中的参数是Object类型，但是这个重写的类型是LocalDate.这时候就不是重写。
为了解决这个问题就应该像DateInterval之中生成一个桥方法。
Public void setSecond(Object second){setSecond((Date)second)}
用来对父类之中的setSecond方法进行覆盖。
Class DateInterval extends Pair<LocalDate>
{
 
Public void setSecond(Object second)
{
if(second.compareTo((LocalDate) second))
{
Super.setSecond(second);
}
}
}
*
*
*
* */

//约束与局限性
/*
*
1.不能用基本类型实例化参数，只能使用类类型。
2.运行时类型查询只适用于原始类型（经过擦除之后的类型），所有的类型查询只会产生原始类型if(a instanceof Pair<String>)会发生报错，if(a instanceof Pair<T>)会发生报错。
3.不能够创建参数化类型的数组
即不能Pair<String>[ ] table = new Pair<String>[10];
4.不能实例化类型变量。为什么不能使用像
new T()  new T[ ]  T.class这样的操作，因为经过类型擦除以后这些都将变为Object，我们肯定不想调用Object的构造器。但是也有一个解决方案是让调用者提供一个构造器表达式即为一个静态工厂方法public static <T> Pair<T> makePair(Supplier <T> constr)
{
return new Pair<>(constr.get(),constr.get());
}
5.不能构造泛型数组。
6.不能在静态域或者静态方法之中使用类型变量。
7.不能抛出或者是捕获泛型类对象，甚至泛型类扩展Throwable都是非法的。

*
*
*
* */

//通配符类型(然后就可以在上下限之间进行随意赋值而没有之前的固定的约束）)
/*
通配符类型之中，允许类型参数发生变化
Pair<？经常与extends a>result组合 必须为a子类或者相同
那么如果有返回result的那么可以将其赋值给a或其超类。
例如Pair<? Extends Employee>表示任何泛型，它继承于原始类型。然后Pair<Manager>继承于它。所以可以赋值给它
Pair<？经常与super b>result组合  必须为b的父类或者相同
那么如果有返回result的那么只能将其赋值给Object
？不与任何进行组合 是无限定通配符
 
统配符只能够放在参数列表之中当作类型来进行使用。？不能够当作类型
*
*
*
* */

//我们需要注意的是
/*
* List<String> 并不是List<Object>的子类
* List<? extends Student> 是 List<Student>的子类。
* List<? super ProStudent> 是 List<ProStudent>的超类
* */

//final修饰局部变量的时候，只要在使用之前进行初始化即可
import javafx.util.Pair;

import java.util.ArrayList;

public class ARRAYLIST {
    public static void main(String[] args)
    {
        //1.下列三行代码分别是对组的初始化，键值对的获取
        Pair<String,String> pair = new Pair<>("张贺凡","123");
        System.out.println(pair.getKey());
        System.out.println(pair.getValue());
        int n1 = 123;
        double n2 = 345;
        double n3 = 669;

        System.out.println(getMiddle(n1,n2,n3));
    }
    //在普通类之中进行方法的声明。
    /*
    * 这个方法如果我们给的参数是3.141729的话，会进行自动
    * 装箱成为Double对象，如果给的参数是0的话，可以装箱
    * 成为Integer对象然后寻找共同的超类T。最好是进行类型的统一
    * 再进行传递
    * */


    public static<T> T getMiddle(T...a)
    {
        return a[a.length/2];
    }
    //有的时候可以使用类型参数进行替代的操作
    public static<T extends Student> void getMiddle1(ArrayList<T> t)
    {

    }
    //这里就是使用通配符的方法。
    public static void getMiddle2(ArrayList<? extends Student> t)
    {

    }
}
class Student
{
    String name;
    int age;

}
class Pro_student extends Student
{
    String professional;
}
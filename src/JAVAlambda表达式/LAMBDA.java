package JAVAlambda表达式;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Supplier;

/*
* 1.LAMBDA表达式是一个可以进行传递的代码块
* (可以像代码或者数据一样进行传递的操作)可以在以后
* 执行一次或者是多次，都是将代码块传递给某个对象，然后
* 这个对象会在未来的某个时间进行调用，但是传递一个代码块并
* 不容易，所以需要构建一个对象(LAMBDA表达式在JAVA之中被视为
* 一个函数式接口的实例)，然后这个对象的类必须要有一个方法能够
* 包含所需的代码，比如我们的Arrays.sort方法的第二个参数要求接受一个实现
* 了Comparator接口的一个对象。
*
* 2.简单举例
*  Runnable r2 = ()->System.out.println("xxx");
*
* 3.LAMBDA表达式子的优点
* 使用LAMBDA表达式可以写出更加简介的代码，更加灵活的代码，作为
* 一种更加紧凑的代码的风格，使得JAVA鱼亚目表达能力得到了提升
*
* 4.LAMBDA表达式名字的由来:
* 为什么我们取了一个这样的名字，因为很多年前的那个时候还没有计算机，
* 一位逻辑学家想要能够进行形式化的标识能有效计算的数学函数
* 它使用了λ来标记参数
*
* */
public class LAMBDA {
}
class Start
{
    public static void main(String[] args) {
        //函数式接口
        /*
        * 1.函数式接口在JAVA之中是指:有且仅有一个抽象方法的接口
        * 需要提供这种类型接口的对象的时候。LAMBDA表达式可以派上用场
        * 匿名内部类也可以派上用场，匿名内部类也可以派上用场。
        * 实现类对象最麻烦但是也可以派上用场。
        * */


        //1.为Runnable接口引用指向对象,这是使用匿名内部类的方法。
        Runnable r1 = new Runnable(){
            @Override
            public void run()
            {
                System.out.println("xxx");

            }
        };
        //2.我们可以使用简单的LAMBDA表达式来对上述的操作进行替代的操作
        Runnable r2 = ()->System.out.println("xxx");
        //3.lambda表达式的格式
        /*
        * A.->:lambda操作符，也可以称之为箭头操作符
        * B.左边:lambda的形参列表，实际上就是接口之中抽象方法的形参
        * C.右边:其实就是重写的方法的方法体
        * */

        //4.分情况进行讲解
        //A.无参数无返回值类型
        /*
        * 对于要进行重写的方法没有返回值也没有形参列表，就和我们简单举例
        * 一样RUNNABLE接口之中的RUN帆帆发即为这样的方法，所以我们只要向例子
        * 之中所给出的一样使用:即可
        * */
        Runnable r3 = ()->System.out.println("xxx");
        //B.需要一个参数但是没有返回值
        /*
        * 对于Consumer接口来说它有一个公共的抽象方法
        * public interface Consumer<T>
          {
          public abstract void accept(T t);
          }
        * */
        //提示1：其中的小括号之中的String是可加可不加的，因为编译器会自动推断得出
        //提示2：LAMBDA表达式如果只有一个参数的话小括号也可以进行省略
        Consumer<String> con1 = (String s) ->{
            System.out.println("参数类型可以进行省略"+s);
        };

        Consumer<String> con2 = S->
        {
            System.out.println("小括号也可以进行省略"+S);
        };
        //C.需要两个以上的参数并且存在返回值
        /*
        * Comparator接口之中存在方法
        * int compare(T o1, T o2);
        * */
        Comparator<Integer> comparator1 = (o1,o2)->
        {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
        con1.accept("张贺凡");
        //提示：如果只有一条执行语句的话，大括号也可以进行省略的操作
        //并且这条语句还是返回语句的话return关键字也可以进行返回的操作

        //5.LAMBDA表达式的作用域
        /*
        * A.LAMBDA表达式分为三个部分，第一个部分为一个代码块
        * 第二个部分为自己定义的参数，第三个部分为自由变量即为
        * 引用外部的值。LAMBDA表达式之中捕获的变量必须为最终变量
        * 即初始化之后就不会再为它进行重新赋值的操作
        *
        * 在LAMBDA表达式之中声明的参数不能够于外围声明的局部变量的名字相同
        * 这一点与普通方法是一致的。
        *
        * 在LAMBDA表达式之中使用this关键字的话，this引用的对象是LAMBDA
        * 表达式所在方法的this所引用的对象
        *
        *
        * */

        //6.LAMBDA表达式的使用情况
        /*
        * 在一个单独的线程之中运行代码。
          多次运行代码
          在算法的适当位置运行代码
          发生某种情况的时候执行代码（点击按钮，数据到达）
        *
        * */

        //7.下面介绍一些常见的我们的函数式接口
        /*
        * A.Consumer消费者接口
        * public interface Consumer<T> {
        * void accept(T t);
        * }
        * */

        /*
        * B.Supplier<T>供给型函数式接口
        * 返回类型为T，包含方法：T get();
        * */

        /*
        * C.Function<T,R> 单参数，单返回值函数式接口
        * 对类型为T的对象应用操作，并且返回结果，结果是R类型
        * 的对象，包含方法:R apply(T t)
        *
        * */

        /*
        * D.Predicate<T> 断定型函数式接口
        * 参数类型为T,返回值为boolean类型，
        * 其方法是为了确定类型为T的对象是否满足某约束
        * 如果满足返回true，如果不满足则返回false
        *
        * */

        /*
        * E.双参数单返回值的函数式接口
        * BiFunction<T,U,R> 其中T,U为参数列表的类型 R为返回类型
        * 其中包含的方法为 R apply(T t)
        * */

        /*
        * F.对类型为T的对象进行一元运算，并返回T类型的结果，
        * UnaryOperator<T> 参数类型为T 返回类型为T，为BiFunction的子接口
        * 包含的方法为T apply(T t)
        *
        * */

        /*
        * G.BinaryOperator<T> 参数类型为T 返回类型为T
        * 对类型为T的对象进行一元运算，并返回T类型的结果，为BiFunction的子接口
        * 包括方法为 T apply(T t1,T t2),
        * */

        /*
        * H.BiConsumer<T,U>双通道消费者函数式接口
        *
        *
        *
        * */

        /*
        * I.BiPredicate<T,U>返回类型为void 对类型为T,U的参数进行获取并且判断是否符合
        * 包含的方法为boolean test(T t,U u)
        * */
    }
}

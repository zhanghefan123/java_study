package 枚举类的学习;
import org.junit.Test;
import java.util.Arrays;
import java.util.Scanner;
/*
* 枚举类能够确定用户输入的是一些有范围的离散的值，避免了用户的错误的输入
* 然后这个是可以用于switch之中的变量之中，我们需要注意到更加复杂的枚举类之中
* 构造函数是私有的，所以不能够在外部调用构造方法进行创建，所以
* 只能够使用内部创建的实例，枚举类之中有一个
* 1.--------values方法，values方法可以返回在内部创建的实例的名字组成的数组
* 2.--------valueOf方法
* 3.--------toString方法返回枚举常量名
* 4.--------compareTo进行枚举常量的比较，比较的就是在枚举类之中声明的次序
* */
public class Color2 {
    public static void main(String[]args)
    {
        Color color;
        Scanner input = new Scanner(System.in);
        System.out.println("PLEASE ENTER YOUR FAVORITE COLOR!");
        String str = input.next();
        if(str.equalsIgnoreCase("RED"))
        {
            color = Color.RED;
        }
        else if(str.equalsIgnoreCase("GREEN"))
        {
            color = Color.GREEN;
        }
        else if(str.equalsIgnoreCase("BLACK"))
        {
            color = Color.BLACK;
        }
        else if(str.equalsIgnoreCase("YELLOW"))
        {
            color = Color.YELLOW;
        }
        else
        {
            color = Color.NONE;
        }
        switch(color)
        {
            case RED:
            {
                System.out.println("your color is red");
                break;
            }
            case GREEN:
            {
                System.out.println("your color is green");
                break;
            }
            case BLACK:
            {
                System.out.println("your color is black");
            }
            case YELLOW:
            {
                System.out.println("your color is YELLOW");
            }
            default:
            {
                System.out.println("you choose none of this colors");
            }
        }
    }
    //要想进行单元测试的话，在这里需要写@Test并且将JUNIT4添加到classpath之中去。
    @Test
    public void test()
    {

        Color_Complex color_complex = Color_Complex.BLANK;
        //1.进行values方法的调用
        System.out.println(Arrays.toString(Color.values()));
        //2.进行Enum接口valueOf方法的调用,注意这个字符串一定要是内部实例的名字
        Color_Complex c2 = Enum.valueOf(Color_Complex.class,"GREEN");
        System.out.println(c2.getName());
        System.out.println(c2.getIndex());
        //3.使用toString方法返回枚举变量此刻指向的枚举对象的枚举名。
        Color_Complex c3 = Color_Complex.RED;
        System.out.println(c3.toString());
        //4.使用ordinal返回枚举常量即内部声明的实例的声明位置
        Color_Complex c4 = Color_Complex.GREEN;
        System.out.println(c4.ordinal());
        //5.使用compareTo方法来对两个枚举对象声明位置的大小进行比较,
        //因为c3为RED然后声明在GREEN之前所以返回的结果是-1.
        System.out.println(c3.compareTo(c4));
    }
}
enum Color
{
    RED,GREEN,BLACK,YELLOW,NONE;
}
enum Color_Complex {
    RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3);
    //这里是进行实例的定义，调用构造函数定义了四个枚举常量
    private String name ;
    private int index ;
    //注意这里的构造方法是私有的构造方法
    private Color_Complex( String name , int index ){
        this.name = name ;
        this.index = index ;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
}

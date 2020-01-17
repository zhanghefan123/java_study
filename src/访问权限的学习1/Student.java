package 访问权限的学习1;
/*
* 1.访问权限可以分为 当前类 同一PACKAGE 子孙类 其它PACKAGE
* public             ✔      ✔         ✔       ✔
* protected          ✔      ✔         ✔       ❌
* default            ✔      ✔         ❌       ❌
* private            ✔      ❌         ❌       ❌
* */

//类 的 修 饰 符(只有公共类以及默认类)
/*
* 1.只有公共类才可以在别的包之中被访问，
* 其它修饰符的不能够通过import来在别的包之中进行使用
* */

//方 法 的 修 饰 符
/*
* 1.public修饰的方法
* 2.private修饰的方法只能够在同一个类之中
* 进行访问。
* 3.默认的修饰的方法，能够在同一个包之中进行访问，在本类之中进行访问
* 4.protected修饰的方法可以在不同包的子类之中能够进行访问
*
* */

//变 量 的 修 饰 符
/*
*
*
*
*
* */
class AUTHORIZATION {
    public static void main(String[] args) {

    }
}
public class Student
{
    protected int score;
    protected void show()
    {
        System.out.println("I am a student");
    }
}
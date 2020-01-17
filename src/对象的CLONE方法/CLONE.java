package 对象的CLONE方法;
//CLONE方法
/*
* CLONE方法是Object的一个protected方法，protected是在其它包
* 之中的子类的方法之中可以进行访问，即通过this对象即子类对象进行
* 访问。
* */

//CLONEABLE接口的作用
/*
* CLONEABLE它其中没有任何方法，是一个空的方法体
* 它其实就是一个标识，用来标识这个类有没有复制的能力
* 如果一个类不实现这个接口就直接调用重写的clone方法的话
* 还是会抛出CloneNotSupportedException的错误。
* 所以要实现两个类的话，我们必须要对clone方法进行重写其原型为 protected native Object clone()
* 因为是native所有也没有方法体-------------------------ATTENTION native方法还需要进行深入的了解。
* */

//如何进行clone方法的重写
/*
* 若要进行浅拷贝的话直接调用Object类的clone方法即可
* 若要进行深拷贝即应对内部有引用数据类型的时候就进行
* 直接的clone方法
* */
public class CLONE
{
    public static void main(String [] args)
    {
        Student student = new Student();
        try
        {
            Student student_clone = student.clone();
            System.out.println(student.age);
            System.out.println(student.name);
            System.out.println(student.score.math);
            System.out.println(student_clone.age);
            System.out.println(student_clone.name);
            System.out.println(student_clone.score.math);
            System.out.println(student==student_clone);
        }
        catch(CloneNotSupportedException e)
        {
            e.printStackTrace();
        }

    }
}
class Student implements Cloneable
{
    String name;
    int age;
    Score score = new Score();
    public Student()
    {
        this.name = "张贺凡";
        this.age = 12;
    }

    public Student clone() throws CloneNotSupportedException {
        Student student = new Student();
        student = (Student) super.clone();//调用Object对象之中的clone方法
        student.score = student.score.clone();//调用Student之中引用数据类型的clone方法
        return student;
    }
}
class Score implements Cloneable
{
    double math;
    public Score()
    {
        this.math = 40;
    }
    public Score clone() throws CloneNotSupportedException {
        return (Score)super.clone();
    }
}
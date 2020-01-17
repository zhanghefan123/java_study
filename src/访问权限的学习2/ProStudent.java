package 访问权限的学习2;

import 访问权限的学习1.Student;

public class ProStudent extends Student {
    public void show2()
    {
        Student student = new Student();

        //创建了student但是不能够进行show方法的调用
        //但是可以直接使用show，即通过子类对象进行调用
        //这个超类的protected方法,或者protected变量
        show();
        System.out.println("I am a Pro_student");
        System.out.println(score);
    }
}
class Start
{
    public static void main(String[] args) {
        ProStudent proStudent = new ProStudent();
        proStudent.show2();
    }
}
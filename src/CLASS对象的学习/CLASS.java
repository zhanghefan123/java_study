package CLASS对象的学习;
/*
* 获取Class对象的三种方式
* 1). 利用对象调用getClass()方法获取该对象的Class实例
  2). 使用Class的静态方法forName()，用类的名字获取一个Class实例
  3). 运用.class的方式获取Class实例，对基本数据类型的封装类，还可以采用.TYPE来获取对应的基本数据类型的Class实例。
*
* */
class Student
{
    String name;
    double score;
}
public class CLASS {
    public static void main(String[] args) throws ClassNotFoundException {
        Student student = new Student();
        Class class1 = student.getClass();
        System.out.println(class1.getName());//获取完整包名+类名
        System.out.println(class1.getSuperclass());//获取超类的完整包名+类名
        System.out.println(Class.forName("CLASS对象的学习.Student"));//需要使用完整的包名加山类名
        System.out.println(Integer.TYPE);
    }
}

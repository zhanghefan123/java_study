package OBJECT所有类的超类;
/*
* 定义：
* JAVA之中的所有的类都是由它扩展而来，如果没有指出那基类就是为OBJECT类。
* 可以使用object类型的变量引用任意类型的对象。在JAVA之中只有基本类型不是对象。
* */

import java.util.Arrays;
import java.util.Objects;

/*
* 1.equals方法
* equals方法：equals方法用来检测一个对象是否等于另一个当对象，
* 在OBJECT类之中这个方法用来判断两个对象是否拥有相同的地址。如果有相同的对象那么他们必然是相等的。
  但是对于大多数来说我们不需要他们完全一致，只要他们内容一致就行。
  在intellij idea之中可以根据域进行自动生成重写之后的equals方法。

*
*
* */
/*
* 2.另外的两个equals方法
* >Arrays.equals方法：如果两个数组长度相同并且对应的位置上的数据元素也相同，并返回true。其中判断每个元素是否对应相等的判断是
* 通过每两个对象之间来调用equals方法来进行解决的。
* >Objects.equals方法：类似于object对象的equals方法，如果进行了重写则调用
* 重写之后的equals方法，但是如果两个都为null则返回true，如果只有一个为null则返回false
* */

/*
* toString方法
* >它返回用于表示对象的字符串，Object对象中的toString方法返回完整包名＋类名+@+哈希码十六进制表示。
* 所以如果重写了toString方法则不会出现这些。
* */
public class OBJECT {
    public static void main(String[] args) {
        Student student1 = new Student("张贺凡",200);
        Student student2 = new Student("张贺凡",200);
        Student[] students = new Student[3];
        Student[] students2 = new Student[3];
        students[0] = student1;
        students2[0] = student2;
        System.out.println(student1.equals(student2));//输出的结果为false，因为不是一个对象
        Teacher teacher1 = new Teacher("张金龙",1100);
        Teacher teacher2 = new Teacher("郑浩龙",2000);
        Teacher teacher3 = new Teacher("张金龙",1100);
        System.out.println(teacher1.equals(teacher2));//输出的结果为true，因为重写了hashcode和equals方法
        System.out.println(Objects.equals(teacher1,teacher3));//返回的结果为true
        System.out.println(Objects.hash(students));//如果进行重写了就调用的是自己的hashCode方法
        System.out.println(Objects.hash(students2));
        System.out.println(student1.toString());//默认的没有重写过toString方法结果OBJECT所有类的超类.Student@6dc2e19a
    }
}
class Student
{
    String name;
    double score;
    public Student(String name,double score)
    {
        this.name = name;
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Double.compare(student.score, score) == 0 &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }
}
class Teacher
{
    String name;
    double salary;
    public Teacher(String name,double salary)
    {
        this.name = name;
        this.salary = salary;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Double.compare(teacher.salary, salary) == 0 &&
                Objects.equals(name, teacher.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary);
    }
}
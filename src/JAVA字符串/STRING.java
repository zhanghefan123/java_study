package JAVA字符串;
//1.-----------------JAVA字符串的连接操作
/*
* JAVA字符串可以使用+运算符来进行连接的操作
* 当一个字符串与一个非字符串值进行拼接的时候
* 后者将会被转换成字符串并与前者进行连接的操作
* */

//2.-----------------JAVA字符串是不可变的字符串
/*
* JAVA字符串是引用数据类型，是一个对象
* JAVA字符串是不可变的字符串，我们不能修改其中的任何一个字符。
* 我们能够做的知识让字符串变量去引用另一个字符串。
* 因为JAVA编译器将字符串常量放在常量区之中进行共享的操作
* JAVA设计者认为共享所带来的高效率远远胜过提取，
* 拼接字符串所带来的低效率。
* */

//3.-----------------空串和null串
/*
* 1.其中空字符串是长度为0的字符串，可以调用String对象的length方法获取字符串的长度与0做相等性
* 比较来判断字符串是否为空。
  2.String变量还可以存放一个特殊的值为null，
  这表示目前还没有任何变量与这个变量进行关联。要判断是否为null直接使用==进行比较即可。
* */

//4.-----------------创建字符串的方法
/*
A.直接将字符串字面量赋值给String对象
B.直接根据字节数组进行String对象的创建
byte[ ] by1 = new byte[ ]{ };
String a = new(by1);
C.直接根据字节数组的一部分进行String对象的创建
String s3 = new String(bytes,2,3);
D.直接根据字符数组进行创建。
char[ ] by1 = new char[ ]{ };
String a = new(by1);
* */

//5.------------------根据String对象创建字符数组以及字节数组
/*
* 1.toCharArray用来将字符串对象转换成为字符数组
* 2.toByteArray用来将字符串对象转换成为字节数组
* */

import java.util.Arrays;

//6.-------------------字符串的方法
/*
* 1.比较两个字符串的方法
A.直接使用String对象的equals方法，不要使用双等号进行比较，
使用双等号进行比较的时候只能够进行比较是否放在相同的位置之上，
但是不能够比较内容是否相等，类似于比较的是C语言之中的地址。
B.直接使用String对象的equalsIgnoreCase方法，
检测两个字符串是否相等而忽略大小写的差别。。
C.直接使用String对象的int compareTo（String other）方法，
如果String对象位于other之前则返回一个负数，反之返回一个负数，
如果相等则返回0

* 2.返回给定位置的字符
* A.char charAt(int index)通过索引来获取字符。
*
* 3.判断字符串之中包含的内容
A.boolean contains (Charsequence S)判断是否包含由S子串，
若是则会返回true
B.boolean startsWith(String str) 判断字符串是否是以str开头
C.boolean endsWith(String str) 判断字符串是否是以str进行结尾

* 4.查找字符串的位置
A.int indexOf(String str) 从零开始查找str字符串第一次出现的位置
B.int indexOf(String str,int fromindex) 从fromindex查找字符串str第一次出现的位置
C.int lastIndexOf(String str)从末尾开始查找str字符串第一次出现的位置
D.int lastIndexOf(String str, int fromindex)从fromindex开始向前
*
*
* 5.改变整个字符串的大小写
A.String toLowerCase()将字符串所有字母转为小写
B.String toUpperCase()将字符串所有字母转为大写
*
* 6.字符串的替换
A.String replace(String oldString,String newString) 用新的字符串替换
* 原始字符串之中老的字符串，并且将替换过后的新的字符串进行返回的操作。
*
* 7.字符串的连接
* String join(String connect,String[] array);即使用connect字符串将array数组进行
* 连接的操作，然后将连接之后的结果进行返回的操作。
*
* 8.字符串的分开
* String[] split(String split)按照分隔符将字符串进行分开的操作。
* */

//2.字符串构建器StringBuilder和StringBuffer
/*
* 1.出现这个的原因是String对象是不可变的对象，每次要将String对象进行修改的结果会
* 创建一个新的字符串对象，然后将指针指向新的String对象，为了直接进行修改而不创建新
* 的对象，引入了这两个类，StringBuilder，StringBuffer
* 2.两着区别，StringBuffer是线程安全的，StringBuilder是线程不安全的，
* 因为StringBuffer加上了synchronized
* 3.下面以StringBuilder为例进行介绍
构造函数：
StringBuilder（）创建一个没有字符的字符串构造器。
StringBuilder（CharSequence seq）使用seq初始化构造器
StringBuilder（int capacity）创建一个指定容量的字符串构造器
StringBuilder（String str）使用str初始化构造器
向末尾进行字符串的追加：
StringBuilder append(String str) 向字符串的末尾追加str并且返回this
StringBuilder append(char c) 向字符串的末尾追加一个字符c并且返回this
将字符串构造器之中的某一个字符进行设置：
Void setCharAt(int I ,char c) 将位于i位置上的字符进行修改成c
插入一个字符串并且返回插入后的：
StringBuilder insert（int offset, String str）在offset位置插入一个字符串并且返回this,this指向的是插入后的字符串构造器
删除一段索引位置上的子字符串：
StringBuilder delete (int StartIndex,EndIndex)删除从StartIndex到EndIndex的字符并且返回this
*
*
* */
public class STRING {

}
class Start {
    public static void main(String[] args)
    {
        //1.字符串连接
        System.out.println("我的成绩是"+123);
        //2.字符串放在常量区进行共享
        String S1 = "HELLO";
        String S2 = "HELLO";
        System.out.println(S1==S2);//双等号的意思是同一个对象
        String S3 = "HE"+"LLO";
        System.out.println(S1==S3);
        int num1 = 123; String S4 = "OK";
        String S5 = "OK123";
        String S6 = num1+S4;
        System.out.println(S5==S6);
        //3.在通过new即构造函数创建的话一定会在堆内存之中创建一个
        //字符串对象，然后如果常量区没有的话还会再常量池之中创建
        //一个字符串
        String S7 = new String("ABC");
        String S8 = "ABC";
        System.out.println(S7==S8);
        //4.四种创建方式的介绍
        String Sa = "第一种方式";
        String Sb = new String("第二种方式");
        char[] char_array = new char[2];
        char_array[0]='A';
        char_array[1]='张';
        String Sc = new String(char_array);//第三种方式
        System.out.println(Sc);
        byte[] byte_array = new byte[]{'A','b'};//第四种方式
        String Sd = new String(byte_array);
        System.out.println(Sd);
        //5.字符串对象的方法
        String replace = new String("张贺凡");
        String changed = replace.replace("张","熊");
        System.out.println(changed);
        String information = new String("张贺凡,朱泽国");
        String[] array = new String[2];
        array = information.split(",");
        System.out.println(Arrays.toString(array));
        StringBuilder stringBuilder = new StringBuilder(4);
        stringBuilder.append("张贺凡正在玩游戏");
        String str = stringBuilder.toString();
        System.out.println(str);
    }
}
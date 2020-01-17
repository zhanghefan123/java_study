package 可变参数的学习;
//我们可以直接将可变参数当成我们的可变长度的一个数组来进行使用即可。
public class Changeable {
    public static void main(String[]args)
    {
        double[] array = new double[]{-1,2,3,2};
        System.out.println(Max(array));
    }
    public static double Max(double...values)
    {
        double max = values[0];
        for(int i = 1;i<values.length;i++)
        {
            if(values[i]>max)
            {
                max =values[i];
            }
        }
        return max;
    }
}

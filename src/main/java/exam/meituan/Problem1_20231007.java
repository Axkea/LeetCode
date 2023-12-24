package exam.meituan;

public class Problem1_20231007 {
    //如果一个十进制数字只有0和1，那这就是一个类二进制数字。例如:101和1100都是类二进制数字，而112和3001则不是。
    // 对于一个数n，小美想知道最少需要几个类二进制数字相加可以得到。
    // 样例：5034 ---> 5
    public int lessBinaryNumber(String s){
        int max=1;
        for (int i = 0; i < s.length(); i++) {
            max=Math.max(s.charAt(i)-'0',max);
        }
        return max;
    }
}

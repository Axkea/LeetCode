package exam.youka;

import java.util.Scanner;

/**
 * @Author Axkea
 * @Date 2023/11/1/001 19:23
 * @Description
 */
public class Problem3_20231101 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long a=in.nextLong(),b=in.nextLong(),c=in.nextLong();
        if (a==0||b==0||c==0){
            System.out.println(0);
        }
        long minMultiple=minMultiple(minMultiple(a,b),c);
        System.out.println((minMultiple/a)*(minMultiple/b)*(minMultiple/c));
    }

    public static long minMultiple(long m,long n){
        long max=(m>n)?m:n;
        long multiple=1;
        for (long i = max; i <= m*n ; i++) {
            if (i%n==0&&i%m==0){
                multiple=i;
                break;
            }
        }
        return multiple;
    }
}

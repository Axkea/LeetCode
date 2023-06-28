package exam;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        System.out.println();
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        long[] data1=new long[n];
        long[] data2=new long[m];
        for (int i = 0; i < n; i++) {
            data1[i]=sc.nextLong();
        }
        for (int i = 0; i < m; i++) {
            data2[i]=sc.nextLong();
        }
        Arrays.sort(data1);
        Arrays.sort(data2);
        long[] data3=new long[n];
        for (int i = 0; i < n; i++) {
            if(i==0){
                data3[i]=data1[i]*data1[i];
            }else{
                data3[i]=data1[i]*data1[i]+data3[i-1];
            }
        }

        for (int i = 0; i < m; i++) {
            int res=0;long rem=data2[i];
            for (int j = 0; j < n; j++) {
                if(rem<data3[j]){
                    res=j;
                    break;
                }
            }
            System.out.print(res);
        }
    }
}

package exam.baidu;

import java.util.HashMap;
import java.util.Scanner;

public class Problem1_20231010 {
    public static void main(String[] args) {

    }
    public static void main1(){
        Scanner in = new Scanner(System.in);
        int n=in.nextInt(),m=in.nextInt(),k=in.nextInt();
        HashMap<Integer,Integer> map=new HashMap<>();
        int res=0;
        for (int i = 0; i < n; i++) {
            int b=in.nextInt();
            int a=in.nextInt();
            if (map.containsKey(b)){
                int a1=map.get(b);
                int min=Math.min(a1,a);
                map.put(b,min);
                res=res-a1+min;
            }else{
                map.put(b,a);
                res+=a;
            }
        }
        res=Math.min(res,k);
        System.out.println(res);
    }
    public static void main2(){
        Scanner in = new Scanner(System.in);
        int n=in.nextInt(),m=in.nextInt(),k=in.nextInt();
//        HashMap<Integer,Integer> map=new HashMap<>();
        int[] map=new int[m];
        int res=0;
        for (int i = 0; i < n; i++) {
            int b=in.nextInt();
            int a=in.nextInt();
            if (map[b-1]!=0){
                int a1=map[b-1];
                int min=Math.min(a1,a);
                map[b-1]=min;
                res=res-a1+min;
            }else{
                map[b-1]=a;
                res+=a;
            }
        }
        res=Math.min(res,k);
        System.out.println(res);
    }
}

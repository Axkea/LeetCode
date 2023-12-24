package exam;


import exam.meituan.Problem3_20231007;
import exam.meituan.Problem4_20231007;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        HashSet<Integer>[] sets=new HashSet[3];
        HashSet<Integer> set1=new HashSet<>();
        set1.add(1);set1.add(2);
        sets[0]=set1;
        HashSet<Integer> set2=new HashSet<>();
        set2.add(1);set2.add(3);set2.add(5);
        sets[1]=set2;
        HashSet<Integer> set3=new HashSet<>();
        set3.add(1);set3.add(2);set3.add(3);set3.add(4);
        sets[2]=set3;
        System.out.println(new Problem4_20231007().findExpectation(sets));
    }
    public static void f1_1(){
        Scanner in = new Scanner(System.in);
        long max=1,record=in.nextLong(),remain=0;
        while(record!=0){
            remain=record%10;
            record=record/10;
            max=Math.max(max,remain);
        }
        System.out.println(remain);
    }
    public static void f1_2(){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();int max=1;
        for (int i = 0; i < s.length(); i++) {
            max=Math.max(s.charAt(i)-'0',max);
        }
        System.out.println(max);
    }
    public static void f2_1(){
        Scanner in = new Scanner(System.in);
        int num=in.nextInt();
        PriorityQueue<Integer> valueHeap=new PriorityQueue<>(num,(x,y)->(y-x));
        PriorityQueue<Integer> limitHeap=new PriorityQueue<>(num,(x,y)->(y-x));
        for (int i = 0; i < num; i++) {
            valueHeap.add(in.nextInt());
        }
        for (int i = 0; i < num; i++) {
            limitHeap.add(in.nextInt());
        }
        int maxValue=0;
        while (!limitHeap.isEmpty()){
            if (limitHeap.peek()<=valueHeap.peek()){
               maxValue++;
               valueHeap.poll();
            }
            limitHeap.poll();
        }
        System.out.println(maxValue);
    }
    public static void f3_1(){
        Scanner in = new Scanner(System.in);
        String next = in.next();

    }
    public static void f4_1(){
        Scanner in = new Scanner(System.in);
        int nums=in.nextInt();
        HashSet<Integer>[] sets=new HashSet[nums];
        for (int i = 0; i < nums; i++) {
            sets[i]=new HashSet<>();
            int count=in.nextInt();
            for (int j = 0; j < count; j++) {
                sets[i].add(in.nextInt());
            }
        }
        double countAll=0;
        for (int i = 0; i < nums-1; i++) {
            for (int j = i+1; j < nums; j++) {
                int countOnce=0;
                if (sets[i].size()<sets[j].size()){
                    countOnce=sets[j].size();
                    for (Integer integer:sets[i]){
                        if (!sets[j].contains(integer)) {
                            countOnce++;
                        }
                    }
                }else{
                    countOnce=sets[i].size();
                    for (Integer integer:sets[j]){
                        if (!sets[i].contains(integer)) {
                            countOnce++;
                        }
                    }
                }
                countAll+=countOnce;
            }
        }
        int allNum=(nums*(nums-1))/2;
        System.out.println(countAll/allNum);
    }
    public static void f4_2(){
        String s="abcdefg";
        StringBuilder stringBuilder=new StringBuilder("");
        System.out.println(stringBuilder.toString().contains("1"));
    }
}

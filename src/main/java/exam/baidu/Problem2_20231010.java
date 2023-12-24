package exam.baidu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Problem2_20231010 {
    public static HashMap<Character,Integer> map1=new HashMap();
    public static HashMap<Integer,Character> map2=new HashMap();
    public static HashMap<Character,Integer> map3=new HashMap<>();
    public static HashMap<Integer,String> map4=new HashMap<>();
    static {
        map1.put('r',4);map1.put('w',2);map1.put('x',1);map1.put('-',0);
        map2.put(4,'r');map2.put(2,'w');map2.put(1,'x');map2.put(0,'-');
        map3.put('u',0);map3.put('g',1);map3.put('o',2);
        map4.put(0,"---");map4.put(1,"--x");map4.put(2,"-w-");map4.put(3,"-wx");
        map4.put(4,"r--");map4.put(5,"r-x");map4.put(6,"rw-");map4.put(7,"rwx");
    }
    public static void main(String[] args) {
        String s="ch g+x baidu";
        System.out.println(s.split(" ")[1].split("[+]").length);
    }

    public static void main1() {
        Scanner in = new Scanner(System.in);
        String beginLimit=in.nextLine();
        int[] intBeginLimit=new int[3];
        for (int i = 0; i < beginLimit.length(); i++) {
            intBeginLimit[i/3]+=map1.get(beginLimit.charAt(i));
        }
        int lineNum=Integer.parseInt(in.nextLine());
        for (int i = 0; i < lineNum; i++) {
            String order=in.nextLine().split(" ")[1];
            parseLine(order,intBeginLimit);
        }
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < 3; i++) {
            int i1 = intBeginLimit[i];
            sb.append(map4.get(i1));
        }
        System.out.println(sb);
    }
    public static void parseLine(String order,int[] beginLimit){
        if (order.contains("+")){
            String[] split = order.split("[+]");
            int num=0;
            for (int i = 0; i < split[1].length(); i++) {
                num+=map1.get(split[1].charAt(i));
            }
            for (int i = 0; i < split[0].length(); i++) {
                char c=split[0].charAt(i);
                if (c=='a') {
                    for (int j = 0; j < 3; j++) {
                        beginLimit[j]=beginLimit[j]|num;
                    }
                }else{
                    Integer integer = map3.get(c);
                    beginLimit[integer]=beginLimit[integer]|num;
                }
            }
        }else if (order.contains("-")){
            String[] split = order.split("[-]");
            int num=0;
            for (int i = 0; i < split[1].length(); i++) {
                num+=map1.get(split[1].charAt(i));
            }
            for (int i = 0; i < split[0].length(); i++) {
                char c=split[0].charAt(i);
                if (c=='a') {
                    for (int j = 0; j < 3; j++) {
                        int limits=0;
                        for (int k = 0; k < 3; k++) {
                            if (((beginLimit[j]>>k)&1)==1&&((num>>k)&1)==0){
                                limits+=1<<k;
                            }
                        }
                        beginLimit[j]=limits;
                    }
                }else{
                    Integer integer = map3.get(c);
                    int limits=0;
                    for (int k = 0; k < 3; k++) {
                        if (((beginLimit[integer]>>k)&1)==1&&((num>>k)&1)==0){
                            limits+=1<<k;
                        }
                    }
                    beginLimit[integer]=limits;
                }
            }
        }else{
            String[] split = order.split("=");
            int num=0;
            for (int i = 0; i < split[1].length(); i++) {
                num+=map1.get(split[1].charAt(i));
            }
            for (int i = 0; i < split[0].length(); i++) {
                char c=split[0].charAt(i);
                if (c=='a') {
                    for (int j = 0; j < 3; j++) {
                        beginLimit[j]=num;
                    }
                }else{
                    Integer integer = map3.get(c);
                    beginLimit[integer]=num;
                }
            }
        }
    }
}

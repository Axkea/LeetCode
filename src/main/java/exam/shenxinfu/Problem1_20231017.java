package exam.shenxinfu;

import java.util.*;

public class Problem1_20231017 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt(),m=in.nextInt();
        HashMap<String,String> ipMap=new HashMap<>();
        ArrayList<Set<String>> setList=new ArrayList();
        for (int i = 0; i < n; i++) {
            ipMap.put(in.next(),in.next());
        }
        for (int i = 0; i < m; i++) {
            String a=in.next(),b=in.next();
            boolean isAdd=true;
            for(Set<String> set:setList){
                if (set.contains(a)||set.contains(b)){
                    set.add(a);
                    set.add(b);
                    isAdd=false;
                    break;
                }
            }
            if (isAdd){
                Set<String> sSet=new HashSet<>();
                sSet.add(a);
                sSet.add(b);
                setList.add(sSet);
            }
        }
        System.out.println(setList);
        int num=in.nextInt();
        System.out.println(num);
        for (int i = 0; i < num; i++) {
            String ipA=ipMap.get(in.next());
            String ipB=ipMap.get(in.next());
            boolean isAdd=true;
            for(Set<String> set:setList){
                if (set.contains(ipA)&&set.contains(ipB)){
                    System.out.println("Yes");
                    isAdd=false;
                    break;
                }
            }
            if (isAdd){
                System.out.println("No");
            }
        }
    }
}

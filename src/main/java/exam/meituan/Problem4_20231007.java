package exam.meituan;

import java.util.HashMap;
import java.util.HashSet;

//小美拿到了n个集合。她随机取出两个集合准备计算它们的并集大小，请你帮小美计算这个并集大小的期望。
//请注意，集合中是不存在两个相同元素的。例如[1,2]和[1,3,5]的并集为[1,2,3,5]
//3
//212
//3135   ----->  4.333333    (4+4+5)/3
//41234
public class Problem4_20231007 {
    public double findExpectation(HashSet<Integer>[] sets){
        double allCount=0;
        int length=sets.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < length; i++) {
            for (Integer integer:sets[i]){
                if (map.containsKey(integer)){
                    map.put(integer,map.get(integer)+1);
                }else{
                    map.put(integer,1);
                }
            }
        }
        for (Integer i:map.keySet()){
            Integer integer = map.get(i);
            allCount+=integer*(length-1);
            if (integer>1){
                allCount-=(integer*(integer-1))/2;
            }
        }
        int divide=(length*(length-1))/2;
        return allCount/divide;
    }
}

package other;

import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args){
//       PriorityQueue<Integer> heap=new PriorityQueue<Integer>((a,b)->{return  b-a;});
//       heap.add(1);
//       heap.add(6);
//       heap.add(3);
//       while(!heap.isEmpty()){
//           System.out.println(heap.poll());
//       }
//        L13Solution solution=new L13Solution();
//        System.out.println(solution.romanToInt("LIV"));
//        System.out.println(new L38Solution().countAndSay(4));
        System.out.println(new L60Solution().getPermutation(4, 6));
    }
}

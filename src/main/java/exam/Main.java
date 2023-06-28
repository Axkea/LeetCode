package exam;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            int m=sc.nextInt();
            Deque<Integer> stack=new LinkedList<>();
            int[] input=new int[m];
            int[] output=new int[m];
            for (int j = 0; j < m; j++) {
                input[j]=sc.nextInt();
            }
            for (int j = 0; j < m; j++) {
                output[j]=sc.nextInt();
            }
            int index=0;
            for (int j = 0; j < m; j++) {
                stack.push(input[j]);
                while(stack.peek()!=null&&stack.peek()==output[index]){
                    stack.pop();
                    index++;
                }
            }
            if(index==m&&stack.isEmpty()){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }

        }
    }
}

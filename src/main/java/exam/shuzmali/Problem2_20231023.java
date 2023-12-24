package exam.shuzmali;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Problem2_20231023 {

    public static void main(String[] args) {


    }

    public static void solution2(){
        Scanner in = new Scanner(System.in);
        Node dummy=new Node(0,null);
        int size=0;
        int num=Integer.parseInt(in.nextLine());
        for (int i = 0; i < num; i++) {
            if (in.next().equals("insert")){
                int x=in.nextInt();
                int y=in.nextInt();
                size++;
                Node p=dummy;
                boolean isInsert=false;
                while (p.next!=null){
                    if (p.next.val==x){
                        Node tmp=p.next;
                        p.next=new Node(y,tmp);
                        isInsert=true;
                        break;
                    }
                    p=p.next;
                }
                if (!isInsert){
                    p.next=new Node(y,null);
                }
            }else{
                int z=in.nextInt();
                Node p=dummy;
                while (p.next!=null){
                    if (p.next.val==z){
                       p.next=p.next.next;
                       size--;
                       break;
                    }
                    p=p.next;
                }
            }
        }
        if (size==0){
            System.out.println("NULL");
        }else{
            Node p=dummy;
            while (p.next!=null){
                System.out.print(p.next.val+" ");
                p=p.next;
            }
        }
    }

    public static void solution1(){
        Scanner in = new Scanner(System.in);
        int num=Integer.parseInt(in.nextLine());
        LinkedList<Integer> iList=new LinkedList<>();
        for (int i = 0; i < num; i++) {
            if (in.next().equals("insert")){
                int index=iList.size();
                int x=in.nextInt();
                for (int j = 0; j < iList.size(); j++) {
                    if (iList.get(j)==x){
                        index=j;
                        break;
                    }
                }
                iList.add(index,in.nextInt());
            }else{
                iList.remove(Integer.valueOf(in.nextInt()));
            }
        }
        if (iList.isEmpty()){
            System.out.println("NULL");
        }else{
            for (int i:iList){
                System.out.print(i+" ");
            }
        }
    }
}
class Node{
    int val;
    Node next;

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}

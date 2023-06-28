package datastruct.stu;

import java.util.Comparator;

public interface Ss {
    int data=10;
    void sh();
    default void show(){
        System.out.println(data);

    }
    static  void show1(){
        System.out.println("static");
    }

}

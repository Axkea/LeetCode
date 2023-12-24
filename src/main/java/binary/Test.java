package binary;

import java.util.Arrays;
import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
//        L476Solution test=new L476Solution();
//        System.out.println(test.findComplement(5));
//        System.out.println(Long.toOctalString(2832468078L));
        HashMap<String,String> map=new HashMap<>();
        map.put("1","1");
        map.put("2","2");
        for (String key:map.keySet()){
            if (key.equals("2")){
                map.remove("2");
            }
        }
    }
}

package check_set;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L399Solution2 {
    private Map<String,String> parent=new HashMap<>();
    private Map<String,Double> values=new HashMap<>();
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int m=equations.size();
        int n=queries.size();
        for (int i = 0; i < m; i++) {
            join(equations.get(i).get(0),equations.get(i).get(1),values[i]);
        }
        double[] res=new double[n];
        for (int i = 0; i < n; i++) {
            if(find(queries.get(i).get(0)).equals(find(queries.get(i).get(1)))){
                res[i]=count(queries.get(i).get(0))/count(queries.get(i).get(1));
            }else{
                res[i]=-1.0;
            }
        }
        return res;
    }
    private String find(String s){
        while(!parent.get(s).equals(s)){
            s=parent.get(s);
        }
        return s;
    }
    private void add(String s){
        if(!parent.containsKey(s)){
            parent.put(s,s);
            values.put(s,1.0);
        }
    }
    private Double count(String s){
        double val=1.0;
        while(!parent.get(s).equals(s)){
            val*=values.get(s);
            s=parent.get(s);
        }
        return val;
    }
    private void join(String child,String parent1,double val){
        add(child);
        add(parent1);
        String root1=find(child);
        String root2=find(parent1);
        if(!root1.equals(root2)){
            parent.put(root1,root2);
            values.put(root1,val*count(child)/count(parent1));
        }
    }
}

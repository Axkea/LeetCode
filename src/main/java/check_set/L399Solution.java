package check_set;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L399Solution {
    private Map<String,String> parents=new HashMap<>();
    private Map<String,Double> values=new HashMap<>();
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n=equations.size(),m=queries.size();
        for (int i = 0; i < n; i++) {
            join(equations.get(i).get(0),equations.get(i).get(1),values[i]);
        }
        double[] res=new double[m];
        for (int i = 0; i < m; i++) {
            if(!parents.containsKey(queries.get(i).get(0))||!parents.containsKey(queries.get(i).get(1))){
                res[i]=-1.0;
                continue;
            }
            if(!find(queries.get(i).get(0)).equals(find(queries.get(i).get(1)))){
                res[i]=-1.0;
                continue;
            }
            res[i]=count(queries.get(i).get(0))/count(queries.get(i).get(1));
        }
        return res;
    }
    private String find(String s){
        while(!parents.get(s).equals(s)){
            s=parents.get(s);
        }
        return s;
    }
    private void join(String child,String parent,double value){
        add(parent);
        add(child);
        String root1 = find(parent);
        String root2 = find(child);
        if(!root1.equals(root2)){
            parents.put(root2,root1);
            values.put(root2,value*(count(parent)/count(child)));
        }
    }
    private void add(String s){
        if(!parents.containsKey(s)){
            parents.put(s,s);
            values.put(s,1.0);
        }
    }
    private double count(String s){
        double v=1;
        while(!parents.get(s).equals(s)){
            v*=values.get(s);
            s=parents.get(s);
        }
        return v;
    }
}

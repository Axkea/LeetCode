package stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class SuffixExp{
    private Map<Character,Integer> isp=new HashMap<>();
    private Map<Character,Integer> icp=new HashMap<>();
    {
        isp.put('#',0);
        icp.put('#',0);
        isp.put('(',1);
        icp.put('(',6);
        isp.put('*',5);
        icp.put('*',4);
        isp.put('/',5);
        icp.put('/',4);
        isp.put('+',3);
        icp.put('+',2);
        isp.put('-',3);
        icp.put('-',2);
        isp.put(')',6);
        icp.put(')',1);
    }
    private boolean judgeOP(char input){
        switch (input){
            case '#':return true;
            case '(':return true;
            case '*':return true;
            case '/':return true;
            case '+':return true;
            case '-':return true;
            case ')':return true;
        }
        return false;
    }
    public String inFix2suffix(String inFix){
        StringBuffer sbs=new StringBuffer();
        int n=inFix.length();
        Deque<Character> opStack=new LinkedList<>();
        opStack.push('#');
        for (int i = 0; i < n; i++) {
            boolean isOp=judgeOP(inFix.charAt(i));
            Character c=inFix.charAt(i);
            while(isOp&&isp.get(opStack.peek())>=icp.get(c)){
                if(c==')'){
                    while(opStack.peek()!='('){
                        Character pop = opStack.pop();
                        sbs.append(pop);
                    }
                    opStack.pop();
                    break;
                }else{
                    Character pop = opStack.pop();
                    sbs.append(pop);
                }
            }
            if(isOp&&c!=')'){
                opStack.push(c);
            }else if(c!=')'){
                sbs.append(c);
            }
        }
        while (opStack.peek()!='#'){
            sbs.append(opStack.pop());
        }
        return new String(sbs);
    }
    private double count(double front,double back,char op){
        switch (op){
            case '+':return front+back;
            case '-':return front-back;
            case '*':return front*back;
            case '/':return front/back;
        }
        return 0;
    }
    public double mockCount(String exp){
        StringBuffer replace=new StringBuffer();
        Map<Character,Double> replMap=new HashMap<>();
        char start='a';
        //扫描出数字
        int n=exp.length();
        for (int i = 0; i < n; i++) {
            //扫描出操作数
            if((exp.charAt(i)=='-'&&i-1==-1)||(exp.charAt(i)=='-'&&exp.charAt(i-1)=='(')||!judgeOP(exp.charAt(i))){
                int j=i+1;
                while(j<n&&!judgeOP(exp.charAt(j))){
                    j++;
                }
                char now=start++;
                replMap.put(now,new Double(exp.substring(i,j)));
                replace.append(now);
                i=j-1;
            }else{
                replace.append(exp.charAt(i));
            }
        }
        String suffix=inFix2suffix(new String(replace));
        Deque<Double> stack=new LinkedList<>();
        for (int i = 0; i < suffix.length(); i++) {
            if(judgeOP(suffix.charAt(i))){
                Double back = stack.pop();
                Double front = stack.pop();
                double count = count(front, back, suffix.charAt(i));
                stack.push(count);
            }else{
                stack.push(replMap.get(suffix.charAt(i)));
            }
        }
        return stack.pop();
    }
}

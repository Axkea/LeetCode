package exam.tujiamingsu;

import java.util.ArrayList;

/**
 * @Author Axkea
 * @Date 2023/11/5/005 16:20
 * @Description
 */
public class Problem2_20231105 {
    public ArrayList<String> getMatchMatrixInfo (String query, String itemName) {
        // write code here
        int x=query.length(),y=itemName.length();
        int max=0,maxQ=0,maxI=0;
        int[][] dp=new int[x+1][y+1];
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                if (query.charAt(i-1)==itemName.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                    if (dp[i][j]>max){
                        max=dp[i][j];
                        maxQ=i;
                        maxI=j;
                    }
                }
            }
        }
        ArrayList<String> strings=new ArrayList<>();
        //打印字符串
        //先打印第一行
        StringBuilder sb1=new StringBuilder();
        for (int i = 0; i < y; i++) {
            sb1.append(",");
            sb1.append(itemName.charAt(i));
        }
        strings.add(sb1.toString());
        for (int i = 1; i < x+1; i++) {
            StringBuilder sb=new StringBuilder();
            for (int j = 0; j < y+1; j++) {
                if (j==0){
                    sb.append(query.charAt(i-1));
                    sb.append(",");
                }else if (j!=y){
                    sb.append(dp[i][j]);
                    sb.append(",");
                }else{
                    sb.append(dp[i][j]);
                }
            }
            strings.add(sb.toString());
        }
        strings.add("");
        //加入最长的匹配字符
        StringBuilder sb=new StringBuilder();
        sb.append(query.substring(maxQ-max,maxQ));
        sb.append(",");
        sb.append(maxQ-max+1);
        sb.append(",");
        sb.append(maxI-max+1);
        sb.append(",");
        sb.append(max);
        strings.add(sb.toString());
        return strings;
    }
}

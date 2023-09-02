package backtrack;

import org.jsoup.helper.StringUtil;

import java.util.ArrayList;
import java.util.List;

//有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
//
//例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
//给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
public class L93Solution {
    private List<String> res=new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        String[] resIp=new String[4];
        backTrack(s,resIp,0,0);
        return res;
    }

    private void backTrack(String s,String[] resIp,int dotNum,int sStart){
        if (dotNum==3){
            if (s.length()<=sStart||(s.length()-sStart)>3){
                return;
            }
            if ((s.charAt(sStart)=='0'&&sStart!=s.length()-1)||!isInScope(s.substring(sStart))){
                return;
            }
            StringBuilder builder=new StringBuilder();
            for (int i = 0; i < 3; i++) {
                builder.append(resIp[i]);
                builder.append('.');
            }
            builder.append(s.substring(sStart));
            res.add(builder.toString());
            return;
        }
        for (int i = sStart; i <sStart+3 ; i++) {
            if (i>=s.length()){
                return;
            }
            if ((i>sStart&&s.charAt(sStart)=='0')||!isInScope(s.substring(sStart,i+1))){
                return;
            }
            resIp[dotNum]=s.substring(sStart,i+1);
            backTrack(s,resIp,dotNum+1,i+1);
        }
    }

    private boolean isInScope(String s){
        int i = Integer.parseInt(s);
        if (i>=0&&i<=255){
            return true;
        }
        return false;
    }
}

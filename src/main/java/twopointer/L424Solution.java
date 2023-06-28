package twopointer;

//给你一个字符串 s 和一个整数 k 。你可以选择字符串中的任一字符，并将其更改为任何其他大写英文字符。该操作最多可执行 k 次。
//
//在执行上述操作后，返回包含相同字母的最长子字符串的长度。
//
public class L424Solution {
    public int characterReplacement(String s, int k) {
        int res=0,start=0,end=0,n=s.length(),max=0;
        int[] count_num=new int[26];
        while(end<n){
            max=Math.max(max,++count_num[s.charAt(end)-'A']);
            //每次只往后移动一位
            if(end-start+1>k+max){
                count_num[s.charAt(start)-'A']--;
                start++;
            }else{
                res=Math.max(res,end-start+1);
            }
            end++;
        }
        return res;
    }
}

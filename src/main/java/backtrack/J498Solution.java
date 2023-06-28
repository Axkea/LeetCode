package backtrack;


import java.util.Arrays;

public class J498Solution {
    public int numTilePossibilities(String tiles) {
        char[] chars = tiles.toCharArray();
        Arrays.sort(chars);
        int[] res=new int[1];
        backTrace(0,chars,new boolean[chars.length],res);
        return res[0];
    }
    private void backTrace(int index,char[] chars,boolean[] visited,int[] res){
        if(index==chars.length){
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if(visited[i]){
                continue;
            }
            if(i-1>=0&&chars[i]==chars[i-1]&&!visited[i-1]){
                continue;
            }
            visited[i]=true;
            index++;
            res[0]++;
            backTrace(index,chars,visited,res);
            index--;
            visited[i]=false;
        }
    }
}

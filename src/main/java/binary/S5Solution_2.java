package binary;

public class S5Solution_2 {
    public int maxProduct(String[] words) {
        int max=0;
        int[] change=new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                change[i]|=1<<(words[i].charAt(j)-'a');
            }
        }
        for (int i = 0; i < change.length-1; i++) {
            for (int j = i+1; j < change.length; j++) {
                if((change[i]&change[j])==0){
                    max=Math.max(max,words[i].length()*words[j].length());
                }
            }
        }
        return max;
    }
}

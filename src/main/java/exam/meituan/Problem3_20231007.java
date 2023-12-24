package exam.meituan;

//小美定义一个字符串是“美丽串”，当且仅当该字符串包含"mei"连续子串。例如"meimei"、"xiaomeichan"都是美丽串，
//而"meeii"则不是美丽串。现在小美拿到了一个字符串，她准备删除一些字符，但不能删除两个连续字符。
//小美希望最终字符串变成美丽串，她想知道有多少种删除方案?
//样例：meili ---> 3 方案1 不做任何操作  方案2 删除第四个  方案3 删除第五个
//当时没写出来，其实也不难，它的输入最大就20 直接深搜就完事了
public class Problem3_20231007 {
    private StringBuilder input;
    private int count;
    public int deleteScheme(String input){
        this.input=new StringBuilder(input);
        dfs(0);
        return count;
    }
    private void dfs(int index){
        if (index>=input.length()){
            if (new String(input).contains("mei")){
                count++;
            }
            return;
        }
        //删除当前字符
        char c = input.charAt(index);
        input.deleteCharAt(index);
        dfs(index+1);
        input.insert(index,c);
        //不删当前字符
        dfs(index+1);
    }
}

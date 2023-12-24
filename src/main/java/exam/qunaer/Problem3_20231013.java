package exam.qunaer;


public class Problem3_20231013 {
    private int a;
    private int b;
    private int N;
    private long victory;
    private long defeat;
    public double percent (int N, int a, int b) {
        // write code here
        this.a=a;
        this.b=b;
        this.N=N;
        dfs(0);
        return (double) victory/(victory+defeat);
    }
    public void dfs(int sum){
        if (sum>=a&&sum<b){
            victory++;
            return;
        }
        if (sum>=b){
            defeat++;
            return;
        }
        for (int i = 1; i <= N; i++) {
            sum+=i;
            dfs(sum);
            sum-=i;
        }
    }
}

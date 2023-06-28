package datastruct.stu;

public class StringHandle {
    public static String[] separateFilePath(String filePath){
        char c='a';int filename=0;int f=0;
        for(int i=filePath.length()-1;i>=0;i--){
            c=filePath.charAt(i);
            if(c=='\\'){
                filename=i;
                break;
            }
        }
        for(int i=filePath.length()-1;i>=0;i--){
            c=filePath.charAt(i);
            if(c=='.'){
                f=i;
                break;
            }
        }
        String a=new String(filePath.substring(0,filename));
        String b=new String(filePath.substring(filename+1,f));
        String d=new String(filePath.substring(f+1,filePath.length()));
        System.out.println(a);
        System.out.println(b);
        System.out.println(d);
        String[] res=new String[]{a,b,d};
        return res;
    }
    public static String ticketAnalysis(String ticket){
        StringBuffer sb=new StringBuffer();
        sb.append("考场号为：");
        sb.append(ticket.substring(0,2)+",");
        sb.append("考室为：");
        sb.append(ticket.substring(2,4)+",");
        sb.append("考生序号为：");
        sb.append(ticket.substring(4,8)+",");
        sb.append("考试类型为：");
        char c=ticket.charAt(8);
        if(c=='1'){
            sb.append("A类");
        }else if(c=='2'){
            sb.append("B类");
        }else if(c=='3'){
            sb.append("C类");
        }
        System.out.println(sb);
        return new String("10531"+ticket);
    }
    public static void test(){
        String s=new String();
        StringBuffer sb=new StringBuffer();
        long a=System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            s+="A";
        }
        long b=System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            sb.append("A");
        }
        long c=System.currentTimeMillis();
        System.out.println("String所消耗的时间为"+(b-a));
        System.out.println("StringBuffer所消耗的时间为"+(c-b));
    }
}

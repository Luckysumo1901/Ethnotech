import java.util.*;
public class Sample {
    public static void main(String[] args){
        ArrayList<String> a=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            String ar=sc.next();
            a.add(ar);
        }
        System.out.print(a);
        sc.close();
    }
}

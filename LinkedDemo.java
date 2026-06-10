import java.util.*;
public class LinkedDemo {
    public static void main(String[] args){
        List<String> l=new LinkedList<>();
       Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            String ar=sc.next();
            l.add(ar);
        }
        System.out.println(l);
        l.remove(1);
        System.out.println(l);
        System.out.println(l.contains("alice"));
    }     
}

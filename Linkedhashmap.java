import java.util.*;
public class Linkedhashmap {
    public static void main(String[] args) {
        HashMap<String,Integer> h=new HashMap<>();
        h.put("even",2);
        h.put("even",4);
        System.out.println(h);
        LinkedHashMap<String,Integer> l=new LinkedHashMap<>(h);
        System.out.println(l);
        l.put("odd",3);
        System.out.println(l);
    }
}

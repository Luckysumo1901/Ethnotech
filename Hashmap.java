import java.util.*;
public class Hashmap{
    public static void main(String[] args) {
        HashMap<String,String> livingbeing=new HashMap<String,String>();
        livingbeing.put("Tree","NeemTree");
        livingbeing.put("Bird","Parrot");
        livingbeing.put("Animal","Lion");
        System.out.println(livingbeing);
        System.out.println(livingbeing.get("Bird"));
        System.out.println(livingbeing.remove("Tree"));
        System.out.println(livingbeing.containsKey("Animal"));
        System.out.println(livingbeing.containsValue("Parrot"));
        System.out.println(livingbeing);
    }
}
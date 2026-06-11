class Busstop { 
    String stopname; 
    Busstop next; 
    Busstop(String stopname) { 
        this.stopname = stopname; 
        this.next = null; 
    } 
} 
public class Bussstop { 
    Busstop stop; 
    public void addition(String stopname) { 
        this.stop = new Busstop(stopname); 
    } 
    public static void main(String[] args) { 
        Bussstop route = new Bussstop();
        route.addition("Central Station");  
        System.out.println("First stop added: " + route.stop.stopname); 
    } 
}

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
class MessageSender extends Thread {
    public MessageSender(String name) {
        super(name);
    }
    public void run() {
        try{
            for(int i=0;i<2;i++){
                System.out.println("Message sent by "+Thread.currentThread().getName());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread interrupted");   
        }
        System.out.println("Message sent Successfully by "+Thread.currentThread().getName());
    }
}
public class MessageApp {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        for(int i=0;i<5;i++){
            Runnable messageSender=new MessageSender(""+i);
            executor.execute(messageSender);
        }
        executor.shutdown();
        while(!executor.isTerminated()) {
              }      System.out.println("All messages sent successfully");
    

        MessageSender t1 = new MessageSender("Thread 1");
        MessageSender t2 = new MessageSender("Thread 2");
        t1.start();
        t2.start();
    }
    
}


class MessageSender extends Thread{
    public MessageSender(String name){
        super(name); //Setter
    }
    @Override
    public void run(){
        try{
            for(int i=0;i<=3;i++){
                System.out.println(getName()+"Sending Message");
                Thread.sleep(1000);
            }
        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
            System.out.println("Thread interrupted"+e);
        }
        System.out.println("message send succesfully");
    }
}
public class MessageApp {
    public static void main(String[] args) {
        MessageSender m1=new MessageSender("Sender1");
        MessageSender m2=new MessageSender("Sender2");

        m1.start();
        m2.start();
        System.out.println("Message sent"+m1.isAlive()+m1.getState());
        System.out.println("Message sent"+m2.isAlive()+m2.getState());

    }
}

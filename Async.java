class MyThread extends Thread {
     @Override
    public void run() {
        System.out.println("pizza preparation...");
        preparePizza();
        System.out.println("Pizza is eaten");
    }

    public void preparePizza() {
        try {
            System.out.println("Preparing Pizza...");
            Thread.sleep(1000); 
            System.out.println("Pizza is ready");
        } catch (InterruptedException e) {
            System.out.println("Pizza preparation interrupted");
        }
    }
}
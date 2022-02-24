import java.util.concurrent.locks.ReentrantLock;


public class Q5b {

    static int exchangeCount=0;
    private static ReentrantLock lock1 = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {
        PenExchange rakesh = new PenExchange("Rakesh", 5);
        PenExchange tarun = new PenExchange("Tarun", 4);


        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {

                try{
                    Thread.sleep(5);
                }catch(InterruptedException ie){
                    ie.printStackTrace();
                }
                exchangePen(tarun, rakesh);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                try{
                    Thread.sleep(5);
                }catch(InterruptedException ie){
                    ie.printStackTrace();
                }
                exchangePen(rakesh,tarun);
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Total pens for Rakesh : " + rakesh.getTotalPens());
        System.out.println("Total pens for Tarun : " + tarun.getTotalPens());
    }

    public static void exchangePen(PenExchange seller, PenExchange buyer)
    {
        lock1.lock();
        exchangeCount++;
        buyer.takePen();
        seller.givePen();
        System.out.println(exchangeCount+". Pen exchanged- "+seller.getName()+" to "+buyer.getName());
        lock1.unlock();
    }
}
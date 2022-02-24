public class CreateThread {
    public static void main(String[] args)throws Exception {

        CreateThread d=new CreateThread();

        //using thread class
        new ThreadClass().start();


        //using runnable
       Thread f=new Thread(new ThreadClass2());
        f.start();
        f.join(1000);

        System.out.println("\nJoining after 1000"
                + " milliseconds: \n");
        System.out.println("Current thread: "
                + f.getName());

        // Checks if this thread is alive
        System.out.println("Is alive? " + f.isAlive());


        //using anonymous inner class
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hi");

            }
        }).start();

        //using lambda
        new Thread(()->System.out.println("Hi")).start();


    }
}

class ThreadClass extends Thread{
    public void run(){

        for (int i = 0; i < 4; i++) {
            System.out.println(
                    Thread.currentThread().getName() + "  "
                            + i);
            try {
                // thread to sleep for 1000 milliseconds
                Thread.sleep(1000);
            }

            catch (Exception e) {
                System.out.println(e);
            }
    }
}}


class ThreadClass2 implements Runnable{
    public void run(){

        Thread t = Thread.currentThread();
        System.out.println("Current thread: "
                + t.getName());

        // checks if current thread is alive
        System.out.println("Is Alive? " + t.isAlive());
    }
}


//Synchronized block





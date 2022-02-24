
import java.util.Random;
import java.util.concurrent.Callable;

class CallableExample implements Callable {


    public static void main(String args[])
    {


        Random generator = new Random();

        Integer randomNumber = generator.nextInt(5);


        try {
            Thread.sleep(randomNumber * 1000);
        }
        catch(InterruptedException e){
        e.printStackTrace();
    }}

    @Override
    public Object call() throws Exception {
        return null;
    }
}

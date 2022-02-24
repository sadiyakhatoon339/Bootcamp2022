class RailwayLine{
    public synchronized void getLine(){
        for(int i=0;i<3;i++){
            System.out.println(i);
            try{
                Thread.sleep(400);
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }
}

class Train extends Thread{
   RailwayLine line;
   Train(RailwayLine line){
       this.line=line;
    }

    @Override
    public void run(){
       line.getLine();
    }
}

public class SynchMethod {
    public static void main(String[] args) {
        RailwayLine ob=new RailwayLine();

        Train t=new Train(ob);
        Train t2=new Train(ob);
        t.start();
        t2.start();
    }

}
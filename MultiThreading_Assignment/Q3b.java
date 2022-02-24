import java.util.ArrayList;
import java.util.List;
class Emp{
    String empname="";
    int c=0;
    public void name(String empname,List<String>l){
        synchronized (this){
            this.empname=empname;
            c++;

        }
        l.add(empname);
    }
}



public class SyncBlock {
    public static void main(String[] args) {
        Emp e=new Emp();

        List<String> l=new ArrayList<>();

       e.name("Sadiya",l);


        System.out.println(e.empname);

    }
}

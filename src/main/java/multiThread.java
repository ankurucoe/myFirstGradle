public class multiThread implements Runnable{
    public void run(){
        try{
            System.out.println(Thread.currentThread().getId()+" id Running");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        int n = 8;
        for(int i=0;i<n;i++){
            Thread m = new Thread(new multiThread());
            m.start();
        }
    }

}

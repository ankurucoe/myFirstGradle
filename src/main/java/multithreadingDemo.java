public class multithreadingDemo extends Thread{
    public void run(){
        try{
            System.out.println("Thread id "+Thread.currentThread().getId()+" is running");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        int n = 9;
        for(int i=0;i<9;i++){
            multithreadingDemo m = new multithreadingDemo();
            m.start();
        }
    }
}

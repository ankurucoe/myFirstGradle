public class multiThread implements Runnable{
    public void run(){
        try{
            Thread.sleep(1500);
            System.out.println(Thread.currentThread().getId()+" Thread Sleeping");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(Test.thread1.getState()+"  State after Sleep function");

        try
        {
            Thread.sleep(200);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
class Test implements Runnable{
    public static Thread thread1;
    public static Test obj;

    public static void main(String[] args) {
        obj = new Test();
        thread1 = new Thread(obj);
        System.out.println(thread1.getState());
        thread1.start();
        System.out.println(thread1.getState());
        try{
            thread1.sleep(200);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(thread1.getState());
    }
    public void run(){
        multiThread myThread = new multiThread();
        Thread thread2 = new Thread(myThread);
        System.out.println(thread2.getState()+" ::State Before Start");
        thread2.start();
        System.out.println(thread2.getState()+" ::State after Start");
        try{
            thread2.sleep(200);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(thread2.getState()+" ::State after Sleep");
    }


}

public class singleTon {
    static singleTon instance = null;
    public int x = 10;
    private singleTon(){

    }
    static public singleTon getInstance(){
        if(instance == null){
            instance = new singleTon();
        }
        return instance;
    }
}

class main{
    public static void main(String[] args) {
        singleTon a = singleTon.getInstance();
        singleTon b = singleTon.getInstance();
        a.x = a.x + 30;
        System.out.println("Value of a is:: "+a.x);
        System.out.println("Value of b is:: "+b.x);
    }
}

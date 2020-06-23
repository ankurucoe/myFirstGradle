public class myException extends Exception{

    myException(){

    }
    myException(String msg){
        super(msg);
    }

    public static void main(String[] args) {
        try{
            throw new myException("my exception");
        }
        catch(myException | ArithmeticException | NullPointerException e){
            System.out.println("exception caught");
            System.out.println(e.getMessage());
        }
    }
}

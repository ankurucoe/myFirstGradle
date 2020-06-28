public class subClass extends superClass{

    public subClass(int x) {
        super(x);
    }

    @Override
    public void calculate() {
        super.calculate();
        System.out.println("Inside subClass");
    }
    public void calculate(int x){
        System.out.println(x);
    }
    private int calculate(int x, int y){
        return x+y;
    }
    static{
        System.out.println("Static Block Called");
    }
    {
        System.out.println("Initializer Block called");
    }
}
class testIt{
    public static void main(String[] args) {
        //subClass obj = new subClass();
        //new subClass();

    }
}
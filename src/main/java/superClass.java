public class superClass extends abs{
    int x;
    public superClass(int x){
        this.x = x;
        System.out.println("In Constructor of SuperClass");
    }
    void calculate() {
        System.out.println("Inside Super Class from Abstract Class");
    }

    @Override
    void calculateX() {

    }
}

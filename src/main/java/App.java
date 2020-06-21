import java.util.Stack;

public class App {
    boolean match(char a, char c){
        return ((a=='(' && c==')') || (a=='[' && c==']') || (a=='{' && c=='}'));
    }
    public String balancedParanth(String input){
        Stack<Character> s = new Stack<>();
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)=='('){
                s.push(')');
            }
            if(input.charAt(i)=='['){
                s.push(']');
            }
            if(input.charAt(i)=='{'){
                s.push('}');
            }
            if(input.charAt(i)==')' || input.charAt(i)==']' || input.charAt(i)=='}' ){
                if(!s.isEmpty() && input.charAt(i)==s.lastElement()){
                    s.pop();
                }
                else{
                    return "NO";
                }
            }
        }
        return s.isEmpty() ? "YES":"NO";
    }
    public static void main(String[] args) {
        System.out.println(new App().balancedParanth("{{)[](}}"));
    }
}

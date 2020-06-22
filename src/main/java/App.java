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

    public static void stockSpan(int [] price, int [] S, int n){
        Stack<Integer> st = new Stack<>();
        st.push(0);
        S[0] = 1;
        for(int i=1;i<n;i++){
            while(!st.empty() && price[st.peek()] <= price[i])
                st.pop();

            S[i] = (st.empty()) ? (i+1) : (i-st.peek());

            st.push(i);

        }
    }
    public void previousGreaterElement(int [] arr, int n){
        Stack<Integer> st = new Stack<>();
        st.push(arr[0]);
        System.out.print(-1+" ,");
        for(int i=1;i<n;i++){
            while(!st.empty() && st.peek()<arr[i]){
                st.pop();
            }
            if(st.empty()==true){
                System.out.print(-1+" ,");
            }
            else{
                System.out.print(st.peek()+" ,");
            }
            st.push(arr[i]);
        }
    }
    public static void main(String[] args) {
        //System.out.println(new App().balancedParanth("{{)[](}}"));
        int price[] = { 10, 4, 5, 90, 120, 80 };
        int n = price.length;
        int [] S = new int[n];
        stockSpan(price,S,n);
        //calculateSpan(price, n, S);
//        for(int i:S){
//            System.out.println(i);
//        }
        new App().previousGreaterElement(price, price.length);
    }
}

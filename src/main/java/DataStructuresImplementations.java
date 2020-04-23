
import java.lang.reflect.Array;
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Interval
{
    int start,end;

    Interval(int start, int end)
    {
        this.start=start;
        this.end=end;
    }
}
public class DataStructuresImplementations extends DataStructurePractice{

    public int findKthSmallest(int [] arr, int n){
        return n;
    }

    public int chocolateDistribution(){
        ArrayList<Integer> A = new ArrayList<>();
        A.size();
        return 1;
    }

    public int sortingArrayDiffValues(int [] arr){
        return 10;
    }

    public void mergeIntervals(Interval [] arr){
        Arrays.sort(arr, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o2.start-o1.start;
            }
        });
        int index = 0;
        for(int i=1;i<arr.length;i++){
            if(arr[index].end >= arr[i].start){
                arr[index].end = Math.max(arr[index].end, arr[i].end);
                arr[index].start = Math.min(arr[index].start, arr[i].start);
            }
            else{
                arr[index] = arr[i];
                index++;
            }
        }
        System.out.println("The Merger Intervals");
        for(int j=0;j<=index;j++){
            System.out.print(arr[j].start+" "+arr[j].end);
        }
    }
    public boolean circularSortHelper(int [] arr, int lo, int hi){
        boolean swapped = false;
        if(lo==hi){
            return false;
        }
        int l = lo, h = hi;
        while(lo<hi){
            if(arr[lo] > arr[hi]){
                swap(arr, lo, hi);
                swapped = true;
            }
            lo++;
            hi--;
        }
        if (lo == hi){
            if(arr[lo] > arr[hi+1]){
                swap(arr, lo, hi+1);
                swapped = true;
            }
        }
        int mid = (hi-lo)/2;
        boolean firstHalf = circularSortHelper(arr, lo, lo+mid);
        boolean secondHalf = circularSortHelper(arr, lo+mid+1, hi);

        return swapped || firstHalf || secondHalf;
    }

    public void circularSort(int [] arr, int n){
        if (n > 0){
            do{
                System.out.println(Arrays.toString(arr));
            }
            while(circularSortHelper(arr, 0, n-1) != false);

        }
    }
    // Function for counting sort in an array
    public void countingSort(int [] arr, int n, int k){
        int [] count = new int [k];
        for(int i=0;i<k;i++){
            count[i] = 0;
        }
        for(int i=0;i<n;i++){
            count[arr[i]]++;
        }
        for(int i=1;i<k;i++){
            count[i] = count[i-1] + count[i];
        }
        int [] output = new int[n];
        for(int i=n-1;i>=0;i--){
            output[count[arr[i]]-1] = arr[i];
            count[arr[i]]--;
        }
        for(int i=0;i<n;i++){
            arr[i] = output[i];
        }
    }
    public String convert(String inp){
        String name;
        int age;
        float hight;
        boolean married;
        //String [] input = new String[4];
        String [] input = inp.split(" ",4);
        name = input[0];
//        for(String k:input){ System.out.print(k+" ");
//        }
        age = Integer.parseInt(input[1]);
        hight = Float.parseFloat(input[2]);
        married = Boolean.parseBoolean(input[3]);

        return name+" is "+age+" years old and "+hight+"ft tall and is "+married;
    }
    public int josephus(int n, int k){
        if(n==1){
            return 0;
        }
        return (josephus(n-1,k)+k)%n;
    }
    public int slidingWindowAvg(int [] arr, int n, int k){
        int maxSum = 0;
        for(int i=0;i<n-k+1;i++){
            int sum = 0;
            for(int j=i;j<i+k;j++){
                sum = sum + arr[j];
            }
//            if(sum > maxSum){
//                maxSum = sum;
//            }
            System.out.println(sum);
        }
        return maxSum;
    }

    static int fibs(int n,int a, int b)
    {
        if (n == a)
            return a;
        else if(n == b)
            return b;
        return fibs(n - 1, a, b) + fibs(n - 2, a, b);
    }

    static int fibo(int aa, int bb, int n)
    {
        int mod = (int)1e9+7;
        int a = aa, b = bb, c;
        if (n < 1)
            return a;
        else if(n == 1)
            return a+b;
        else {
            for (int i = 0; i <n-1; i++) {
                c = (a % mod + b % mod) % mod;
                a = b % mod;
                b = c % mod;
            }
        }
        return b;
    }

    static int fib(int n)
    {
        /* Declare an array to store Fibonacci numbers. */
        int f[] = new int[n + 1];
        int i;

        /* 0th and 1st number of the series are 0 and 1*/
        f[0] = 0;

        if (n > 0) {
            f[1] = 1;

            for (i = 2; i <= n; i++) {
                /* Add the previous 2 numbers in the series
             and store it */
                f[i] = f[i - 1] + f[i - 2];
            }
        }

        return f[n];
    }

    public static int findArray(int [] arr, int n, int s){

        int start = -1;
        int end = -1;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){

            int cSum = 0;
            for(int j=i;j<n && (j-i+1)<min;j++){
                    cSum = cSum+ arr[j];
                    if(cSum == s){
                        start = i;
                        end = j;
                        min = end - start + 1;
                        break;
                    }
            }
        }
        return min;
    }

    public static int check(int [] arr, int k){
        int count = 0;
        int s = -1;
        int e = -1;

        for(int i=0;i<arr.length;i++){
            int c = 0;
            for(int j=i;j<arr.length && j-i+1>count;j++){
                if(arr[j]==1){
                    s = i;
                    e = j;
                    c = e-s+1;
                    break;
                }
                else{
                    //break;
                }
            }
            count = Math.max(count,c);

        }
        System.out.println(s+" "+e);
        return count;
    }
    public static int longestOnes(int[] A, int K) {
        int length = A.length;
        int max = 0;
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        int mainCount = 0;
        for (int i = 0; i < length; i ++) {
            if (K == 0 && !queue.isEmpty() && A[i] == 0) {
                K ++;
                count = mainCount - (queue.poll() + 1);
            }
            if (K == 0 && A[i] == 0) {
                count = 0;
                continue;
            }
            if (A[i] == 0) {
                queue.add(i);
                K --;
            }
            count += 1;
            max = Math.max(max, count);
            mainCount ++;
        }
        return max;
    }
    public static int turbulant(int [] arr){
        int n = arr.length;
        int sign = 1;
        int pre = 0;
        for(int i=0;i<n;i++){
        }
        return 0;
    }

    public static boolean equalSubset(int [] arr){
        int sum = 0;
        int act = 0;
        int exp = 0;
        for(int k:arr){
            sum += k;
        }
        exp = sum/2;
        Set<Integer> s = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            s.add(i);
            for(int j=0;j<arr.length;j++){
                if(j!=i && act<exp){
                    s.add(j);
                    act += arr[j];
                }
            }
            if(act == exp){
                break;
            }
        }
        System.out.println(act);
        int act1 = 0;
        if(act==exp){
            for(int m =0;m<arr.length;m++){
                if(!s.contains(m)){
                    act1 += arr[m];
                }
            }
        }
        System.out.println(act1);
        if(act1==act){
            return true;
        }
        return false;
    }
    static int mod = 1000000007;
    static int [] dp = new int[30001];

    public static int distributeHearts(int n) {
        dp[0] = 1;
        if (dp[n] != 0) {
            return dp[n];
        } else {
            for (int i = 1; i < n + 1; i++) {
                for (int j = i; j < n + 1; j++) {
                    dp[j] = (dp[j] % mod + dp[j - i] % mod) % mod;
                }
            }

        }
        return dp[n] - 1;
    }

    public static int ways(int n){
        int [] dp = new int [501];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 5;
        for(int i=5;i<=5;i++){
            dp[i] = dp[i-1] + dp[i-5];
        }
        return dp[n];
    }
    public boolean happy(int a){
        Set<Integer> s = new HashSet<>();
        int res = -1;
        while(true){
            res = 0;
            while(a>0){
                res = (int) (res + Math.pow(a%10,2));
                a = a/10;
            }
            if(res == 1){
                return true;
            }
            else if(s.contains(res)){
                return false;
            }
            s.add(res);
            a=res;
        }

    }
    static int N;
    void printSolution(int sol[][])
    {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + sol[i][j] + " ");
            System.out.println();
        }
    }
    boolean isSafe(int [][] maze, int x, int y){
        return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1);
    }

    boolean solveMazeUtil(int [][] maze, int x, int y, int [][] sol){
        if(x == N-1 && y == N-1 && maze[x][y] == 1){
                sol[x][y] = 1;
                return true;
        }
        if(isSafe(maze,x,y)==true){
            sol[x][y] = 1;
            // Checking down
            if(solveMazeUtil(maze, x+1, y, sol))
                return true;

            // Checking right
            if(solveMazeUtil(maze, x, y+1, sol))
                return true;

            // BackTrack
            maze[x][y] = 0;
            return false;
        }
        return false;
    }

    public boolean solveRatMaze(int [][] maze){
        int [][] sol = new int [N][N];

        if(solveMazeUtil(maze, 0,0,sol)== false){
            System.out.println("No Solution");
            return false;
        }
        printSolution(sol);
        return true;
    }
    public void magicNumber(int n){
        int [][] arr = new int[n][n];
        int row = 0, col = n/2, i,j, square = n*n;
        for(int p = 1;p <= square;p ++){
            arr[row][col] = p;
            if(p%n == 0){
                row++;
            }
            else {
                if( row == 0 ) row = n - 1;

                else row--;

                if( col == ( n - 1 ) ) col = 0;

                else col++;
            }
        }
        for(i=0;i<n;i++){
            for(j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public int getMin(int [] coins, int n, int val){
        if(val == 0){
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(coins[i]<=val){
                int sub_res = getMin(coins, n, val-coins[i]);
                if(sub_res != Integer.MAX_VALUE)
                {
                    res = Math.min(res, sub_res+1);
                }
            }
        }
        return res;
    }

    ArrayList<Integer> result;
    int[] cuts;
    int[][] parent;
    public ArrayList<Integer> rodCut(int rod, ArrayList<Integer> scores) {
        int n = scores.size() + 2;
        cuts = new int[n];
        cuts[0] = 0;
        for (int i = 0; i < scores.size(); i++) {
            cuts[i + 1] = scores.get(i);
        }
        cuts[n - 1] = rod;

        long[][] dp = new long[n][n];
        parent = new int[n][n];
        for (int len = 1; len <= n; len++) {
            for (int s = 0; s < n - len; s++) {
                int e = s + len;
                for (int k = s + 1; k < e; k++) {
                    long sum = cuts[e] - cuts[s] + dp[s][k] + dp[k][e];
                    if (dp[s][e] == 0 || sum < dp[s][e]) {
                        dp[s][e] = sum;
                        parent[s][e] = k;
                    }
                }
            }
        }

        result = new ArrayList<>();
        backTrack(0, n - 1);

        return result;
    }

    private void backTrack(int s, int e) {
        if (s + 1 >= e) {
            return;
        }

        result.add(cuts[parent[s][e]]);
        backTrack(s, parent[s][e]);
        backTrack(parent[s][e], e);
    }
    static int cutRod(int price[], int n)
    {
        if (n <= 0)
            return 0;
        int min_val = Integer.MAX_VALUE;


        for (int i = 0; i<n; i++)
            min_val = Math.min(min_val,
                    price[i] + cutRod(price, n-i-1));

        return min_val;
    }
    public int longestValidParentheses(String s) {
        // )()())
        int maxlen = 0;
        for(int i=0;i<s.length();i++){
            for(int j=i+2;j<=s.length();j++){
                System.out.println(s.substring(i,j));
                if(isValid(s.substring(i,j))){
                    maxlen = Math.max(maxlen, j-i);
                }
            }
        }
        return maxlen;
    }
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '(')
            {
                stack.push('(');
            }
            else if(!stack.empty() && stack.peek() == '('){
                stack.pop();
            }
            else {
                return false;
            }
        }
        return stack.empty();
    }
    public static void main(String[] args) {

        //int a = 19;

        int maze[][] = { { 1, 0, 0, 0 },
                         { 1, 1, 0, 1 },
                         { 1, 1, 0, 0 },
                         { 0, 1, 1, 1 } };
        N = maze.length;
        int [] coins = {25,10,5};
        int val = 30;
        ArrayList<Integer> ll = new ArrayList<>();
        ll.add(1);
        ll.add(2);
        ll.add(5);
        int a = 6;
        //System.out.println(new DataStructuresImplementations().rodCut(a,ll));
        //new DataStructuresImplementations().magicNumber(7);
        int [] arr = {1,2,5};
        int n = 6;
        System.out.println(new DataStructuresImplementations().longestValidParentheses(")()())"));
    }
}

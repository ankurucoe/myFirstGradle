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
        for(int i=5;i<=500;i++){
            dp[i] = dp[i-1] + dp[i-5];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int arr [] = {1,5,5,11};

        System.out.println(ways(20));
    }
}

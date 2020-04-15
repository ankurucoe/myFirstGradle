import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.xml.crypto.Data;
import java.util.Arrays;

public class DataStructurePractice {
    public void swap(int [] arr, int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    // Function to find pivot for Quick Sort
    public int partition(int [] arr, int hi, int lo){
        int pivot = arr[hi];
        int i = (lo-1);
        for(int j=lo;j<=hi-1;j++){
            if(arr[j]<=pivot){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, hi);
        return i+1;
    }

    public void quickSort(int [] arr, int hi, int lo){
        //int pi=0;
        if(lo < hi){
            int pi = partition(arr, hi, lo);
            quickSort(arr, lo, pi-1);
            quickSort(arr, pi+1, hi);
        }
    }

    public void mergeSort(int [] arr, int l, int r){
        if(l<r){
            int m = (l+r)/2;
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);
            mergeArray(arr, l, m, r);
        }
    }

    public void mergeArray(int [] arr, int s, int m, int e){
        int i,j,k;
        int [] temp = new int[e-s+1];
        i = s;
        j = m+1;
        k = 0;
        while(i<=m && j<=e){
            if(arr[i]<=arr[j]){
                temp[k] = arr[i];
                i++;
            }
            else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        while(i<=m){
            temp[k] = arr[i];
            i++;
            k++;
        }
        while(j<=e){
            temp[k] = arr[j];
            j++;
            k++;
        }
    }

    public void countSort(int [] arr, int n, int k){
        int [] count = new int [k];
        for(int m=0;m<k;m++){
            count[m] = 0;
        }
        for(int i=0;i<n;i++){
            count[arr[i]]++;
        }
        for(int j=1;j<k;j++){
            count[j] = count[j-1] + count[j];
        }
        int [] output = new int [n];
        for(int o=n-1;o>=0;o--){
            output[count[arr[o]]-1] = arr[o];
            count[arr[o]]--;
        }
        for(int p=0;p<n;p++){
            arr[p] = output[p];
        }
    }

    public void findIntersectionPoint(int [] arr, int [] arr1, int n, int m){
        int i=0, j=0;
        while(i<n && j<m){
            if(i>0 && arr[i]==arr[i-1]){
                i++;
                continue;
            }
            if(arr[i]<arr1[j]){
                i++;
            }
            else if(arr[i]>arr1[j]){
                j++;
            }
            else{
                System.out.print(arr[i]+" ");
                i++;
                j++;
            }
        }
    }
    public int countInversions(int [] arr, int l, int m, int r){
        int n1 = m-l+1, n2 = r-m;
        int [] a1 = new int[n1];
        int [] a2 = new int[n2];
        for(int i=0;i<n1;i++){ a1[i] = arr[l+i];}
        for(int j=0;j<n2;j++){ a2[j] = arr[m+j+1];}
        int res=0,i=0,j=0,k=l;
        while(i<n1 && j<n2)
        {
            if(a1[i]<=a2[j]){
                arr[k] = a1[i];
                i++;
            }
            else{
                arr[k] = a2[j];
                j++;
                res = res + n1-i;
            }
            k++;
        }
        while(i<n1){
            arr[k] = a1[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k] = a2[j];
            j++;
            k++;
        }
        return res;
    }
    //Lamuto Partition
    public int part(int [] arr, int l, int r){
        int pivot = arr[r]; // pivot last element
        int i = l-1;
        for(int j = i; j<l ; j++){
            if(arr[j]<=pivot){
                i++;
                swap(arr, i , j);
            }
        }
        swap(arr, i+1, r);
        return i+1;
    }
    public int hoarsPart(int [] arr, int l, int h){
        int pivot = arr[l];
        int i = l-1, j=h+1;
        while(true){
            do{
                i++;
            }
            while(arr[i] < pivot);
            do{
                j--;
            }
            while(arr[j] > pivot);
            if(i >= j) {
                return j;
            }
            swap(arr, i, j);
        }
    }
    static int N;

    /* A utility function to print solution matrix
    sol[N][N] */
    void printSolution(int sol[][])
    {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + sol[i][j] + " ");
            System.out.println();
        }
    }


    boolean isSafe(int maze[][], int x, int y)
    {

        return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1);
    }

    boolean solveMaze(int maze[][])
    {
        int sol[][] = new int[N][N];

        if (solveMazeUtil(maze, 0, 0, sol) == false) {
            System.out.print("Solution doesn't exist");
            return false;
        }

        printSolution(sol);
        return true;
    }


    boolean solveMazeUtil(int maze[][], int x, int y,
                          int sol[][])
    {
        // if (x, y is goal) return true
        if (x == N - 1 && y == N - 1 && maze[x][y] == 1) {
            sol[x][y] = 1;
            return true;
        }

        // Check if maze[x][y] is valid
        if (isSafe(maze, x, y) == true) {
            // mark x, y as part of solution path
            sol[x][y] = 1;

            /* Move forward in x direction */
            if (solveMazeUtil(maze, x + 1, y, sol))
                return true;

			/* If moving in x direction doesn't give
			solution then Move down in y direction */
            if (solveMazeUtil(maze, x, y + 1, sol))
                return true;

			/* If none of the above movements works then
			BACKTRACK: unmark x, y as part of solution
			path */
            sol[x][y] = 0;
            return false;
        }

        return false;
    }

    public int lcs(String a, String b, int m, int n){
        if(m==0 || n==0)
            return 0;
        if(a.charAt(m-1)==b.charAt(n-1))
            return 1+lcs(a,b,m-1, n-1);
        else
            return Math.max(lcs(a,b,m-1,n),lcs(a,b,m,n-1));
    }

    static int [][] dp = new int[100+1][100+1];
    public static void filldpArray(){
        for(int i=0;i<dp.length;i++)
            for(int j=0;j<dp[0].length;j++)
                dp[i][j] = -1;
    }
    //Using Memoization
    public int lcsdp(String a, String b, int m, int n){

        if(dp[m][n] != -1)
            return dp[m][n];

        if(m==0 || n==0)
            dp[m][n] = 0;

        else
            if(a.charAt(m-1)==b.charAt(n-1))
                dp[m][n] = 1 + lcs(a,b,m-1,n-1);
            else
                dp[m][n] = Math.max(lcs(a,b,m-1,n),lcs(a,b,m,n-1));


    return dp[m][n];
    }
    // DP Solution
    public int solve(String A, String B) {
        int[][] dp = new int[A.length()+1][B.length()+1];

        for(int i=0;i<=A.length();i++){
            for(int j=0;j<=B.length();j++){
                if(i==0||j==0){dp[i][j]=0;continue;}
                if(A.charAt(i-1)==B.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1],Math.max(dp[i-1][j],dp[i-1][j-1]));
                }
            }
        }

        return dp[A.length()][B.length()];
    }
    public int calculateCoin(int [] arr, int n,  int sum){
        int dp[][] = new int [sum+1][n+1];
        for(int i=0;i<=n;i++)
            dp[0][i] = 1;
        for(int i=1;i<=sum;i++)
            dp[i][0] = 0;
        int i=0,j=0;
        for(i=1;i<=sum;i++)
            for(j=1;j<=n;j++) {
                dp[i][j] = dp[i][j - 1];
                if (arr[j - 1] <= i) {
                    dp[i][j] += dp[i - arr[j - 1]][j];
                }
            }
        return dp[sum][n];
    }
    public static void main(String [] args){
        int maze[][] = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 } };
        N = maze.length;
        //new DataStructurePractice().solveMaze(maze);
        String a = "axy";
        String b = "baz";
        filldpArray();
        int [] arr = {1,2,3};
        //System.out.println(new DataStructurePractice().lcsdp(a,b,a.length(),b.length()));
        //System.out.println(new DataStructurePractice().calculateCoin(arr,arr.length,4));
        System.out.println(Integer.max(10,10));
    }
}

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
    public static void main(String[] args) {
//            Interval [] arr = new Interval[4];
//            arr[0] = new Interval(6,8);
//            arr[1] = new Interval(1,9);
//            arr[2] = new Interval(2,4);
//            arr[3] = new Interval(4,7);
//            new DataStructuresImplementations().mergeIntervals(arr);
        int [] arr = {7, 5, 3, 1, 2, 4, 6, 8};
        new DataStructuresImplementations().countingSort(arr, arr.length,9);
        for(int k:arr){
            System.out.print(k+" ");
        }


    }
}

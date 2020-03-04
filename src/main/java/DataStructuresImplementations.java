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

    public static void main(String[] args) {
            Interval [] arr = new Interval[4];
            arr[0] = new Interval(6,8);
            arr[1] = new Interval(1,9);
            arr[2] = new Interval(2,4);
            arr[3] = new Interval(4,7);
            new DataStructuresImplementations().mergeIntervals(arr);
    }
}

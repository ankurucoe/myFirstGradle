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

        }
    }

    public static void main(String[] args) {
            Interval [] arr = new Interval[4];
    }
}

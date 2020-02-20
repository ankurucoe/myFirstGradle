import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.xml.crypto.Data;

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

    public static void main(String [] args){
        int [] arr = {3, 5, 10 , 10, 10, 15, 15, 20};
        int [] arr1 = {5, 10 , 10, 15, 30};
        int [] arry = {2, 5, 8, 11, 3, 6, 9, 13};
        //System.out.println(new DataStructurePractice().partition(arr, arr.length-1, 0));
        //new DataStructurePractice().quickSort(arr, arr.length-1, 0);
        int n = arr.length;
        int m = arr1.length;
        //new DataStructurePractice().findIntersectionPoint(arr, arr1, n, m);
        int ln = arry.length;
        int mid = (0+(ln-1))/2;
        System.out.println(new DataStructurePractice().countInversions(arry, 0, mid, arry.length-1));
    }
}

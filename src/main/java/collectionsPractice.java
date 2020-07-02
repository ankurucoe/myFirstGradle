import java.util.*;
public class collectionsPractice {



    public static void main(String[] args) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(Map.Entry<Integer,Integer> itr:hm.entrySet()){
            System.out.println(itr.getKey()+" "+itr.getValue());
        }
    }
}

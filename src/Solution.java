import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public static  int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer,Integer> hmap = new HashMap<>();

        for (int i:arr2) {
            hmap.put(i, 0);
        }

        int arr[] = new int[arr1.length];
        int last = arr1.length-1;

        for (int i:arr1) {
            if(hmap.containsKey(i))
                hmap.put(i, hmap.get(i)+1);
            else
                arr[last--] = i;
        }

        int pos = 0;

        for (int i:arr2) {
            for (int j = 0; j < hmap.get(i); j++) {
                arr[pos++] = i;
            }
        }

        Arrays.sort(arr,pos,arr.length);
        return arr;
    }

    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19}, arr2 = {2,1,4,3,9,6};

        int[] ret = relativeSortArray(arr1, arr2);

        System.out.println(Arrays.toString(ret));

    }
}

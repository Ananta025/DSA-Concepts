/*
    Union and intersection of two arrays
    arr1[] = {7,3,9}
    arr2[] = {6,3,9,2,9,4}
    union = 6 (7,3,9,6,2,4)
    intersection = 2 (3,9)

    Time Complexity:O(n+m) n = size of arr1 & m = size of arr2
 */

package Hashing;
import java.util.*;
public class q4 {
    public static void main(String args[]){
        int arr1[] = {7,3,9};
        int arr2[] = {6,3,9,2,9,4};
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for(int i=0;i<arr1.length;i++){
            set.add(arr1[i]);
        }
        for(int i=0;i<arr2.length;i++){
            set.add(arr2[i]);
        }
        System.out.print(set.size());
        System.out.println(set);
        set.clear();

        for(int i=0;i<arr1.length;i++){
            set.add(arr1[i]);
        }
        int count = 0;
        for(int i=0;i<arr2.length;i++){
            if(set.contains(arr2[i])){
                count++;
                set2.add(arr2[i]);
                set.remove(arr2[i]);
            }
        }
        System.out.print(count);
        System.out.println(set2);


    }
}

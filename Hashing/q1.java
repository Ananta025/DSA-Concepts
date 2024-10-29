
/*
 Majority Element O(n)
 
 Given an integer array of size n,find all the elements that appear more then n/3 times.
 nums[]={1,3,2,5,1,3,1,5,1} expected output: 1
 nums[]={1,2} expected output: 1,2
 
 */
package Hashing;
import java.util.*;
public class q1 {
    public static void main (String args[]){
        int arr[] = {1,3,2,5,1,3,1,5,1};
        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int i=0;i<arr.length;i++){
            if(hm.containsKey(arr[i])){
                hm.put(arr[i], hm.get(arr[i])+1);
            }else{
                hm.put(arr[i], 1);
            }
            // OR
            // hm.put(arr[i], hm.getOrDefault(arr[i], 0)+1);
        }

        Set<Integer> keyset = hm.keySet();
        for (Integer key : keyset) {
            if(hm.get(key)>arr.length/3){
                System.out.println(key);
            }

        }
        /*
        OR
        for (Integer key : hm.keySet()) {
            if(hm.get(key)>arr.length/3){
                System.out.println(key);
            }

        } 
        */

    }
}

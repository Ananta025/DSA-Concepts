/*
    Largest subarray with 0 sum
    arr[] = {15,-2,2,-8,1,7,10,23}
    output: 5
    arr[] = {3,4,0}
    output: 0
    Approach:
    sum[i+1,j] = sum[0,j] - sum[0,i]  where j>i
 */

package Hashing;
import java.util.*;
public class q6 {
    public static void main(String args[]){
        int arr[] = {15,-2,2,-8,1,7,10,23};
        HashMap<Integer,Integer> map = new HashMap<>();

        //(sum,idx)
        int sum=0;
        int len=0;

        for(int j=0;j<arr.length;j++){
            sum += arr[j];
            if(map.containsKey(sum)){
                len = Math.max(len, j-map.get(sum));
            }else{
                map.put(sum, j);
            }
        }

        System.out.println("The length of Largest subarray with 0 sumis: "+len);
    }
}

/*
    Subarray sum equal to k o(n)
    arr[] = {1,2,3}  k=3  (return number of such subarray)
    output: 2 (1,2) (3)

    Approach: sum[i,j] = sum[0,j] - sum[0,i-1]  where j>i
    sum[0,j] = sum[0,i]+k
*/

package Hashing;
import java.util.*;
public class q7 {
    public static void main(String args[]){
        int arr[] = {1,2,3};
        int k = 3;

        HashMap<Integer,Integer> map = new HashMap<>();
        //(sum,count)
        map.put(0, 1);
        int sum = 0;
        int ans = 0;
        for(int j=0;j<arr.length;j++){
            sum += arr[j];
            if(map.containsKey(sum-k)){
                ans += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        System.out.println(ans);
    }
}

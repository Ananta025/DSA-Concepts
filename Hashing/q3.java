/*
    Count distinct Elements:
    num[] = {4,3,2,5,6,7,3,4,2,1}
    output:7
 */

package Hashing;
import java.util.*;
public class q3 {
    public static void main(String args[]){
        int num[] = {4,3,2,5,6,7,3,4,2,1};
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<num.length;i++){
            set.add(num[i]);
        }
        System.out.println(set.size());
    }
}
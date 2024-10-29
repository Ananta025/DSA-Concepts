/*
    HASHING
    
*/
/*
    HashMap 
*/

/*
    Linked hashMap (keys are insertion ordered)
*/

/*  TreeMap (keys are sorted)
    put ,get, remove O(logn) 
    in internal implementation treemap use "Red Black tree"(it is a special type of self balancing tree)
*/
package Hashing;
import java.util.*;
public class hashmap{
    public static void main(String args[]){

        HashMap<String, Integer> hm = new HashMap<>();

        // Insert O(1)
        hm.put("India",300);
        hm.put("China",400);
        hm.put("Nepal",42);
        hm.put("Bhutan",58);
        hm.put("Bangladesh",54);

        System.out.println(hm);

        // Get O(1)
        System.out.println("The population: "+hm.get("India"));
        System.out.println("The population: "+hm.get("USA"));

        //Contains Key O(1)(it Checks is any key  exist or not in the hash map)
        System.out.println(hm.containsKey("India"));

        //Remove o(1)
        System.out.println(hm.remove("Nepal"));
        System.out.println(hm);

        //Size O(1)
        System.out.println(hm.size());

        //Isempty(it checks if the HashMap is empty or not)
        System.out.println(hm.isEmpty());

        //SetKey 
        Set<String> keys = hm.keySet();
        System.out.println(keys);
        
        for (String k : keys) {
            System.out.println("key= "+k+",  value= "+hm.get(k));
        }
        //EntrySet
        System.out.println(hm.entrySet());

        // Clear (it clear all the key value pair from the HashMap)
        hm.clear();
        System.out.println(hm.isEmpty());
        System.out.println(hm);


        // Linked hashMap (keys are insertion ordered)

        LinkedHashMap<String,Integer> lhm = new LinkedHashMap<>();
        
        lhm.put("India", 100);
        lhm.put("China",400);
        lhm.put("Nepal",42);
        lhm.put("Bhutan",58);
        lhm.put("Bangladesh",54);

        System.out.println(lhm);


        // Tree map(keys are sorted)

        TreeMap<String,Integer> tm = new TreeMap<>();

        tm.put("India", 100);
        tm.put("China",400);
        tm.put("Nepal",42);
        tm.put("Bhutan",58);
        tm.put("Bangladesh",54);

        System.out.println(tm);
    }
}

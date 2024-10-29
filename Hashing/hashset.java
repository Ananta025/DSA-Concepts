
/*
Hashset (Hashset id implemented using hashmap)
all elements are quique,unordered,null value is allowed. 

 */

/*
Linked HashSet Ordered using DLL(Doubly linked list)
linked hashmap is used to emplement linked hashset

Performance:
LHM < HM
LHS < HS
we use LHM LHS for maintain order of element thats why performance slightly decrease but not that much so time complexity got changes,
thats why time complexity remais same.
 */

/*
TreeSet
Sorted in ascending order
null values are not allowed
treeset is internally implement using treemap
in treeset add remove like operation are performed in O(logn) time because internally sorting are there for maintaing the ascending order
thats why treeset are not optimize like hashset or linkedhashset.

 */
package Hashing;
import java.util.*;
public class hashset {
    public static void main(String args[]){
        HashSet<Integer> set = new HashSet<>();

        set.add(2);
        set.add(3);
        set.add(4);
        set.add(7);
        set.add(4);

        System.out.println(set);

        set.remove(2);
        System.out.println(set);
        System.out.println(set.size());

        System.out.println(set.isEmpty());
        System.out.println(set.contains(3));

        //Iteration in HashSet
        HashSet<String> cities = new HashSet<>();

        cities.add("Kolkata");
        cities.add("Jaypur");
        cities.add("Bengaluru");
        cities.add("pune");
        cities.add("Mumbai");

        /*
        Iterator it = cities.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        */

        for(String city: cities){
            System.out.println(city);
        }
        System.err.println(cities);

        //Linked HashSet

        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("Kolkata");
        lhs.add("Jaypur");
        lhs.add("Bengaluru");
        lhs.add("pune");
        lhs.add("Mumbai");

        System.out.println(lhs);

        // TreeSet

        TreeSet<String> ts = new TreeSet<>();
        ts.add("Kolkata");
        ts.add("Jaypur");
        ts.add("Bengaluru");
        ts.add("pune");
        ts.add("Mumbai");

        System.out.println(ts);

    }
}


// Implementation of hashmap 

package Hashing;
import java.util.*;
public class implementation {
    static class HashMap<k,v>{
        private class Node{
            k key;
            v value;
            public Node(k key,v value){
                this.key=key;
                this.value=value;
            }
        }
        private int n;
        private int N;
        private LinkedList<Node> buckets[];
        @SuppressWarnings("unchecked")
        public HashMap(){
            this.N = 4;
            this.buckets = new LinkedList[4];
            for(int i=0;i<4;i++){
                this.buckets[i] = new LinkedList<>();
            }
        }
        private int hashFunction(k key){
            int hc = key.hashCode();
            return Math.abs(hc)%N;
        }
        private int searchInLL(k key,int bi){
            LinkedList<Node> ll = buckets[bi];
            int di = 0;
            for(int i=0;i<ll.size();i++){
                Node node = ll.get(i);
                if(node.key == key){
                    return di;
                }
                di++;
            }
            return -1;
        }
        @SuppressWarnings("unchecked")
        private void rehash(){
            LinkedList<Node> oldBucket[] = buckets;
            buckets = new LinkedList[N*2];
            N = 2*N;
            for(int i=0;i<buckets.length;i++){
                buckets[i]=new LinkedList<>();
            }

            for(int i=0;i<oldBucket.length;i++){
                LinkedList<Node> ll = oldBucket[i];
                for(int j=0;j<ll.size();i++){
                    Node node = ll.get(j);
                    put(node.key, node.value);
                }
            }
        }

        // put function o(lambda)--> O(1)
        public void put(k key,v value){
            int bi = hashFunction(key);
            int di = searchInLL(key,bi);
            
            if(di != -1){
                Node node = buckets[bi].get(di);
                node.value = value;
            }else{
                buckets[bi].add(new Node(key, value));
                n++;
            }

            double lambda = (double)n/N;
            if(lambda == 2.0){
                rehash();
            }
        }
        // containsKey O(1)
        public boolean containsKey(k key){ 
            int bi = hashFunction(key);
            int di = searchInLL(key,bi);
            
            if(di != -1){
                return true;
            }else{
                return false;
            }
        }
        public v get(k key){ //O(1)
            int bi = hashFunction(key);
            int di = searchInLL(key,bi);
            
            if(di != -1){
                Node node = buckets[bi].get(di);
                return node.value;
            }else{
                return null;
            }
        }

        //remove function O(1)
        public v remove(k key){
            int bi = hashFunction(key);
            int di = searchInLL(key,bi);
            
            if(di != -1){
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            }else{
                return null;
            }
        }
        public ArrayList<k> KeySet(){
            ArrayList<k> keys = new ArrayList<>();

            for(int i=0;i<buckets.length;i++){
                LinkedList<Node> ll =buckets[i];

                for (Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }
        public boolean isEmpty(){
            return n == 0;
        }
    }


    public static void main(String args[]){
        HashMap<String,Integer> hm =new HashMap<>();
        hm.put("India",300);
        hm.put("China",400);
        hm.put("Nepal",42);
        hm.put("Bhutan",58);
        hm.put("Bangladesh",54);

        ArrayList<String> keys = hm.KeySet();
        for (String key : keys) {
            System.out.println(key);
        }
    }
}

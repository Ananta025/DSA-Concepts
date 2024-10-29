/*
    Tries (prefix tree / retrival tree / k-ary tree)
            2
        / /  \ \
       1 5   3  4
      / \
     6   7
                The Trie data structure is a tree-like data structure used for storing a dynamic set of strings.
                It is commonly used for efficient retrieval and storage of keys in a large dataset.
                The structure supports operations such as insertion, search, and deletion of keys, 
                making it a valuable tool in fields like computer science and information retrieval.

                in tries there can be many Node in same level so in most of the cases time complexity is lower as compare to 
                norml trees.(speciall where we have to search some word or prefix or suffix )

                word[] = "The","a","There","Their","any","thee"
     */

package Tries;
import java.util.*;
public class intro {
    public class Node{
        Node children[] = new Node[26];
        boolean eow = false;

        Node(){
            for(int i=0;i<26;i++){
                children[i] = null;
            }
        }
    }
    public static Node root = new Node();
    public static void main(String args[]){
        String word[] = {"The","a","There","Their","any","thee"};

    }
}

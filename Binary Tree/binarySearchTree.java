import java.util.*;
public class binarySearchTree {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.left=null;
            this.right=null;
        }
    }
    public static Node insert(Node root,int val){
        if(root==null){
            root=new Node(val);
            return root;
        }
        if(root.data>val){
            root.left = insert(root.left,val);
        }else{
            root.right = insert(root.right,val);
        }
        return root;
    }
    public static void inOrder(Node root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public static boolean search(Node root,int val){
        if(root==null){
            return false;
        }                               //O(H)
        if(root.data==val){
            return true;
        }
        if(root.data>val){
            return search(root.left,val);
        }else{
            return search(root.right,val);
        }
    }

    public static Node delete(Node root,int val){
        if(root.data>val){
            root.left=delete(root.left,val);
        }else if(root.data<val){
            root.right=delete(root.right,val);
        }else{
            //case 1: No child (leaf node)
            if(root.left==null || root.right==null){
                return null;
            }

            //case 2: One child
            if(root.left==null){
                return root.right;
            }else if(root.right==null){
                return root.left;
            }

            //case 3: two child
            Node IS = findInorderSuccessor(root.right);
            root.data=IS.data;
            root.right=delete(root.right,IS.data);
        }
        return root;
    }
    public static Node findInorderSuccessor(Node root){
        while(root.left != null){
            root=root.left;
        }
        return root;
    }

    public static void printInRange(Node root,int k1, int k2){
        if(root==null){
            return;
        }

        if(root.data>=k1 && root.data<=k2){
            printInRange(root.left,k1,k2);
            System.out.print(root.data+" ");
            printInRange(root.right,k1,k2);
        }else if(root.data<k1){
            printInRange(root.left,k1,k2);
        }else{
            printInRange(root.right,k1,k2);
        }
    }
    public static void printPath(ArrayList<Integer> path){
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i)+"-> ");
        }
        System.out.println("Null");
    }
    public static void printRoot2leaf(Node root,ArrayList<Integer> path){
        if(root==null){
            return;
        }
        path.add(root.data);
        if(root.left==null && root.right==null){
            printPath(path);
        }
        printRoot2leaf(root.left,path);
        printRoot2leaf(root.right,path);
        path.remove(path.size()-1);
        
    }
    public static boolean isValidBST(Node root,Node min,Node max){
        if(root==null){
            return true;
        }
        if(min != null && root.data<=min.data){
            return false;
        }
        if(max != null && root.data>=max.data){
            return false;
        }
        return isValidBST(root.left,min,root) && isValidBST(root.right,root,max);
    }
    public static void main(String[] args){
        int values[]={8,5,3,1,4,6,10,11,14};
        Node root=null;

        for(int i=0;i<values.length;i++){
            root=insert(root,values[i]);
        }

        inOrder(root);
        System.out.println();

        if(search(root, 1)){
            System.out.println("found");
        }else{
            System.out.println("not found");
        }

        root=delete(root,1);
        System.out.println();
        inOrder(root);
        System.out.println();

        printInRange(root, 5, 12);

        System.out.println();
        printRoot2leaf(root, new ArrayList<>());

        if(isValidBST(root, null, null)){
            System.out.println("valid");
        }else{
            System.out.println("Invalid");
        }
    }
}

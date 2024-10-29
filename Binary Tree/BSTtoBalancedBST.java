import java.util.*;
public class BSTtoBalancedBST {
    static class Node{
        int data;
        Node left;
        Node right;
        Node (int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    public static void preOrder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void getInOrder(Node root,ArrayList<Integer> inOrder){
        if(root==null){
            return;
        }
        getInOrder(root.left, inOrder);
        inOrder.add(root.data);
        getInOrder(root.right, inOrder);
    }
    public static Node createBST(ArrayList<Integer> inOrder,int si,int ei){
        if(si>ei){
            return null;
        }
        int mid=(si+ei)/2;
        Node root = new Node(inOrder.get(mid));
        root.left=createBST(inOrder, si, mid-1);
        root.right=createBST(inOrder, mid+1, ei);
        return root;
    }
    public static Node balanceBST(Node root){
        //Inorder sequence
        ArrayList<Integer> inOrder = new ArrayList<>();
        getInOrder(root, inOrder);

        // Sorted inorder to balanced bst
        root=createBST(inOrder, 0, inOrder.size()-1);
        return root;
    }
    public static void main(String[] args){

        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);
        
        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);

        root=balanceBST(root);
        preOrder(root);
    }

}

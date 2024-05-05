package Advance_dsa_java.BinaryTrees;

public class minDistanc {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node Lca(Node root, int n1, int n2) {

        if (root == null || root.data == n1 || root.data == n2) {

            return root;
        }

        Node leftLca = Lca(root.left,n1,n2);
        Node rightLca = Lca(root.right,n1,n2);

        if(leftLca == null){
            return  rightLca;
        }
        if(rightLca == null){
            return leftLca;
        }

        return root;
    }


    public static int lcaDistance(Node root,int n){

        if(root == null){
            return -1;
        }

        if(root.data == n){
            return 0;
        }

        int leftDistance = lcaDistance(root.left,n);
        int rightDistance = lcaDistance(root.right,n);


        if(leftDistance == -1 && rightDistance == -1){
            return -1;
        }
        else if(leftDistance == -1){
            return rightDistance+1;
        }
        else {
            return leftDistance+1;
        }

    }
    public static int minDistance(Node root,int n1,int n2){

        Node lca = Lca(root,n1,n2);
        int dist1 = lcaDistance(lca,n1);
        int dist2 = lcaDistance(lca,n2);

        return dist1+dist2;
    }

    public static void main(String[] args){

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);


        int n1 = 4;
        int n2 = 6;
        System.out.println(minDistance(root,n1,n2));


    }
}
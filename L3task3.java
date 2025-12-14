// Task 3: Binary Search Tree (BST) Implementation
//Description: Implement a Binary Search Tree in Java with functionalities like insertion, deletion, search, and traversal (in-order, pre-order, post-order).
// Objectives:
//Create a TreeNode class to represent nodes of the tree.
 //Implement methods to insert, delete, and search nodes.
 //Perform in-order, pre-order, and post-order traversalsof the tree.


public class L3task3 {
    
    public static class TreeNode{
        int data;
        TreeNode left,right;
        
        public TreeNode(int item){
            data=item;
            left=right=null;
        }
    }
    
    public static class BST{
        TreeNode root;
        
        public BST(){
            root=null;
        }
        
        public void insert(int data){
            root=insertRec(root,data);
        }
        
        private TreeNode insertRec(TreeNode root,int data){
            if(root==null){
                root=new TreeNode(data);
                return root;
            }
            if(data<root.data){
                root.left=insertRec(root.left,data);
            }else if(data>root.data){
                root.right=insertRec(root.right,data);
            }
            return root;
        }
        
        public boolean search(int data){
            return searchRec(root,data);
        }
        
        private boolean searchRec(TreeNode root,int data){
            if(root==null){
                return false;
            }
            if(root.data==data){
                return true;
            }
            return data<root.data ? searchRec(root.left,data) : searchRec(root.right,data);
        }
        
        public void inorder(){
            inorderRec(root);
        }
        
        private void inorderRec(TreeNode root){
            if(root!=null){
                inorderRec(root.left);
                System.out.print(root.data+" ");
                inorderRec(root.right);
            }
        }

        public void preorder(){
            preorderRec(root);
        }
        
        private void preorderRec(TreeNode root){
            if(root!=null){
                System.out.print(root.data+" ");
                preorderRec(root.left);
                preorderRec(root.right);
            }
        }
        
        public void postorder(){
            postorderRec(root);
        }
        
        private void postorderRec(TreeNode root){
            if(root!=null){
                postorderRec(root.left);
                postorderRec(root.right);
                System.out.print(root.data+" ");
            }
        }
        public void delete(int data){
            root=deleteRec(root,data);
        }
        private TreeNode deleteRec(TreeNode root,int data){
            if(root==null){
                return root;
            }
            if(data<root.data){
                root.left=deleteRec(root.left,data);
            }else if(data>root.data){
                root.right=deleteRec(root.right,data);
            }else{
                if(root.left==null)
                    return root.right;
                else if(root.right==null)
                    return root.left;
                
                root.data=minValue(root.right);
                root.right=deleteRec(root.right,root.data);
            }
            return root;
        }
        
        private int minValue(TreeNode root){
            int minv=root.data;
            while(root.left!=null){
                minv=root.left.data;
                root=root.left;
            }
            return minv;
        }



    }
    
    public static void main (String [] args){
        BST tree=new BST();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        
        System.out.println("In-order traversal:");
        tree.inorder();
        
        int key=40;
        if(tree.search(key)){
            System.out.println("\n"+key+" found in the tree.");
        }else{
            System.out.println("\n"+key+" not found in the tree.");
        }
        System.out.println("Pre-order traversal:");
        tree.preorder();
        System.out.println("\nPost-order traversal:");
        tree.postorder();
        System.out.println("\nDelete 20:");
        tree.delete(20);
        System.out.println("In-order traversal after deletion:");
        tree.inorder();

        
    }
}

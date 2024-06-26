class Node{
   int value;
   Node left, right;
   
   public Node(int value){
      this.value = value;
      left = null;
      right = null;
   }

}

class BinarySearchTree{

   Node root;
   
   
   /*
   recursive insert method
   */
   public Node insert(Node root, int value){
      //base case
      if(root == null){
         root = new Node(value);
         return root;
      }
      
      //recursive step
      if(value < root.value){
         root.left = insert(root.left, value); 
      }else{
         root.right = insert(root.right, value);
      }
      
      return root;
   }
   
   
   
   /*
   pre-order traversal
   */

   /**
    * Traverses the binary search tree recursively in preOrder
    * @param root, provides the method with the starting root
    */
   public void preOrderTraversal(Node root){
      //implement me
      if(root == null){
         return;
      }

      System.out.print(root.value + " ");
      preOrderTraversal(root.left);
      preOrderTraversal(root.right);
   }

   
   
   /*
   in-order traversal
   */

   /**
    * Traverses the binary search tree recursively in order
    * @param root provides the method with the starting root
    */
   public void inOrderTraversal(Node root){
      //implement me
      if(root == null){
         return;
      }

      inOrderTraversal(root.left);
      System.out.print(root.value + " ");
      inOrderTraversal(root.right);
   }
   
   
   
   /*
   post-order traversal
   */

   /**
    * Traverses the binary search tree recursively in post order
    * @param root provides the method with the starting root
    */
   public void postOrderTraversal(Node root){
      //implement me
      if(root == null){
         return;
      }

      postOrderTraversal(root.left);
      postOrderTraversal(root.right);
      System.out.print(root.value + " ");
   }
   
   
   
   /*
   a method to find the node in the tree
   with a specific value
   */

   /**
    * Finds the node at the location of the key, and then returns true or false depending on if it finds it or not
    * @param root provides the method with the root
    * @param key provides the method with the location
    * @return
    */
   public boolean find(Node root, int key){
	  //implement me
      if(root == null){
         return false;
      }
      if(key == root.value){
         return true;
      } else if(key < root.value){
         return find(root.left, key);
      } else {
         return find(root.right, key);
      }
   }
   
   
   
   /*
   a method to find the node in the tree
   with a smallest key
   */

   /**
    * Gets the minimum node in the binary search tree
    * @param root provides the method with the starting root
    * @return
    */
   public int getMin(Node root){
      //implement me
      if(root.left == null){
         return root.value;
      } else {
         return getMin(root.left);
      }
   }
  
  
  
   /*
   a method to find the node in the tree
   with a largest key
   */

   /**
    * Gets the maximum node inside of the binary search tree
    * @param root provides the method with the starting root
    * @return
    */
   public int getMax(Node root){
	  //implement me
      if(root.right == null){
         return root.value;
      } else {
         return getMax(root.right);
      }
   }
   
   
   
   /*
   this method will not compile until getMax
   is implemented
   */
   public Node delete(Node root, int key){
      
      if(root == null){
         return root;
      }else if(key < root.value){
         root.left = delete(root.left, key);
      }else if(key > root.value){
         root.right = delete(root.right, key);
      }else{
         //node has been found
         if(root.left==null && root.right==null){
            //case #1: leaf node
            root = null;
         }else if(root.right == null){
            //case #2 : only left child
            root = root.left;
         }else if(root.left == null){
            //case #2 : only right child
            root = root.right;
         }else{
            //case #3 : 2 children
            root.value = getMax(root.left);
            root.left = delete(root.left, root.value);
         }
      }
      return root;  
   }
   
   
   
}



public class TreeDemo{
   public static void main(String[] args){
      BinarySearchTree t1  = new BinarySearchTree();
      t1.insert(24);
      t1.insert(80);
      t1.insert(18);
      t1.insert(9);
      t1.insert(90);
      t1.insert(22);
            
      System.out.print("in-order :   ");
      t1.inOrderTraversal(t1.root);
      System.out.println();
           
      
   }  
}
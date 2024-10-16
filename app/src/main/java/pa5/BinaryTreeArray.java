/*
 * This source file was generated by the Gradle 'init' task
 */
package pa5;

/**
 *  Interface for a binary tree implemented using an array
*   The tree must adhere to the properties of a complete binary tree: 
*      A complete binary tree is a binary tree in which every level,
*      The tree is completely filled on all levels except possibly 
*      for the lowest level, which is filled from left to right.
 */
interface ArrayBasedBinaryTree {

    /**
     * Inserts an element into the tree. 
     * Assume `element` is always a positive integer
     */
    void insert(int element);

    /**
     * Returns the tree in level order
     */
    String levelOrder();

    /**
     * Returns the tree in in-order
     */
    String inOrder();

    /**
     * Returns the tree in pre-order
     */
    String preOrder();

    /**
     * Returns the tree in post-order
     */
    String postOrder();

    /**
     * Return the length of the longest path in the tree
     */
    int longestPath();

    /**
     * Delete an element from the tree
     * Ensure that the tree remains a complete binary tree
     */
    void delete(int element);
}
//implements ArrayBasedBinaryTree

// Uncomment the following code to implement the BinaryTreeArray class
public class BinaryTreeArray implements ArrayBasedBinaryTree{
    public int[] data;
    
    private int size = 0;

    public BinaryTreeArray(int maxCapacity){
        data = new int[maxCapacity];
    }

    public void insert(int element){
        this.data[this.size] = element;
        this.size +=1;

    }

    public String levelOrder(){
        int i = 0;
        String result = "";
        while (i < this.size){
            result = result + this.data[i];
            if (i < this.size - 1){
                result = result + " ";
            }
            i += 1;
        }
        return result;

    }

    public String inOrder(){
        return inOrderHelper(this.data, 0);

    }

    private String inOrderHelper(int[] list, int i){
        String result = "";
        if (i >= this.size){
            return "";
        }
        else{
            int left = 2 * i + 1;
            result += this.inOrderHelper(list, left);
            result += list[i] + " ";
            int right = 2 * i + 2;
            result += this.inOrderHelper(list, right);
        }
        return result;
    }

    public String preOrder(){
        return preOrderHelper(0);

    }

    private String preOrderHelper(int i){
        String result = "";
        if (i >= this.size){
            return "";
        }
        else{
            result = this.data[i] + " ";
            int left = 2 * i + 1;
            result += this.preOrderHelper(left);
            int right = 2 * i + 2;
            result += this.preOrderHelper(right);
            return result;
        }
    }

    public String postOrder(){
        return postOrderHelper(0);
    
    }
    
    private String postOrderHelper(int i){
        String result = "";
        if (i >= this.size){
            return "";
        }
        else{
            int left = 2*i + 1;
            result += this.postOrderHelper(left);
            int right =  2*i + 2;
            result += this.postOrderHelper(right);
            result += this.data[i] + " ";
            return result;
        }
    }

    public int longestPath(){
        return longestPathHelper(0, 0);


    }
    private int longestPathHelper(int i, int count){
        if (i >= this.size){
            return count-1;
        }
        else{
            int left = 2*i + 1;

            int height = longestPathHelper(left, count+1);
            return height;
            
        }
    
    }

    public void delete(int element){
        int i = 0;
        while (i < this.size){
            if (this.data[i] == element){
                while (i < this.size-1){
                    int tmp2 = this.data[i+1];
                    this.data[i+1] = this.data[i];
                    this.data[i] = tmp2;
                    i = i+1;
                }
                this.size = this.size - 1;
                break;
            }
            i = i + 1;
        }

    }

    

    public static void main(String[] args){
        BinaryTreeArray tree = new BinaryTreeArray(10);
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        // tree.insert(7);
        // tree.insert(8);
        // tree.insert(9);
        // tree.insert(10);

        System.out.println(tree.longestPath());

        
    }   
}

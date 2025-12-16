/*
1A: Estimation of asymptotic running time
Skewed BST: O(N) because it can be a long chain, like a linked list. 
Balanced BST: O(logN) because it splits the tree evenly, avoiding the linked list issue of a skewed tree. 

1B: Justified conjecture
The skewed tree will have a longer time complexity due to the linked list effect that occurs 
with the worst case scenario of a skewed tree. A long line of nodes on either side of the tree.


3: Nanosecond Chart

4: Comparing results to initial conjecture


*/

import java.util.Random;

public class BSTOperations {

    public static BinarySearchTree<Integer> skewedSearchTree(int x) {
        BinarySearchTree<Integer> skewedTree = new BinarySearchTree<>();
        
        for (int i = 1; i <= x; i++) {
            skewedTree.insert(i);
        }
        return skewedTree;
        
    }

    public static BinarySearchTree<Integer> randomSearchTree(int x) {
        Random random = new Random();
        BinarySearchTree<Integer> randomTree = new BinarySearchTree<>();

        for (int i = 1; i <= x; i++) {
            int randomNum = random.nextInt(1000000000);
            randomTree.insert(randomNum);
        }
        return randomTree;
    }
}

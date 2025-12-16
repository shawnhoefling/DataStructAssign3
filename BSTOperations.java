/*
1A: Estimation of asymptotic running time
Skewed BST: O(N) because it can be a long chain, like a linked list. 
Balanced BST: O(logN) because it splits the tree evenly, avoiding the linked list issue of a skewed tree. 

1B: Justified conjecture
The skewed tree will have a longer time complexity due to the linked list effect that occurs 
with the worst case scenario of a skewed tree. A long line of nodes on either side of the tree.
The BinarySearchTree class contains the structure to build a binary search tree. The insert method 
inserts the nodes one by one, which will result into the linked list, O(N) worst case scenario run time.
The contains method traverses the tree from root to leaf, so when a tree is balanced, the search time is essentially
half, or O(logN).

3: Nanosecond Chart (done in base 5)
Skewed BST: 4208, 6958, 33583, 155125, 350541
Balanced BST: 708, 1417, 1292, 2125, 2208

4: Comparing results to initial conjecture
The results directly compare to my conjecture. In the skewed tree the values rises linearly, each value exponentially increasing over the last.
The Balanced Tree follows the logN approach, as the data set increases, the time doesn't increase as much. 

*/

import java.util.Random;

public class BSTOperations {
    private static final int experimentSize = 15625;

    public static BinarySearchTree<Integer> skewedSearchTree(int x) {
        BinarySearchTree<Integer> skewedTree = new BinarySearchTree<>();
        
        for (int i = 1; i <= x; i++) { // looping through x times in order, starting from 1. 
            skewedTree.insert(i);
        }
        return skewedTree;
        
    }

    public static BinarySearchTree<Integer> randomSearchTree(int x) {
        Random random = new Random();
        BinarySearchTree<Integer> randomTree = new BinarySearchTree<>();

        for (int i = 1; i <= x; i++) { // loops through x times, inserting a random integer using a large number
            int bound = 1000000000;
            int randomNum = random.nextInt(bound);
            randomTree.insert(randomNum);
        }
        return randomTree;
    }

    // measuring the search time 
    public static long measureTime (BinarySearchTree<Integer> tree, int valSearched) {
        long startTime = System.nanoTime();
        tree.contains(valSearched); 
        long endTime = System.nanoTime();
        return endTime - startTime;
    }



// driver method to run time testing

public static void main(String[] args) {
    final int xSize = experimentSize;
    // creating both trees using the fixed experiment size of 5000, any larger causes compiler issues
    BinarySearchTree<Integer> skewedTree = skewedSearchTree(xSize);
    BinarySearchTree<Integer> randomTree = randomSearchTree(xSize);

    int searchValS = xSize + 1; // doesnt exist (<=x, != x+1)

    Random rand = new Random();
    int searchValR = rand.nextInt(1000000000); // same bound as before

    // calling measure time for both trees with specified parameters 
    long timeS = measureTime(skewedTree, searchValS); 
    long timeR = measureTime(randomTree, searchValR);

    System.out.println(timeS);
    System.out.println(timeR);

}

}
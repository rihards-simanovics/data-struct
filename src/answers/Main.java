package answers;

import answers.recursion.ArraySum;
import answers.recursion.Factorial;
import answers.recursion.Fibonacci;
import answers.recursion.FlattenList;
import answers.recursion.GCD;
import answers.recursion.MergeSort;
import answers.recursion.PalindromeCheck;
import answers.recursion.Power;
import answers.recursion.RecursiveBinarySearch;
import answers.recursion.ReverseString;
import answers.recursion.StringPermutations;
import answers.recursion.TowerOfHanoi;
import answers.search.Binary;
import answers.search.Linear;
import answers.sort.Bubble;
import answers.sort.Selection;
import answers.structures.Array;
import answers.structures.CircularLinkedList;
import answers.structures.CircularQueue;
import answers.structures.Deque;
import answers.structures.DoublyLinkedList;
import answers.structures.DynamicQueueWithShifting;
import answers.structures.DynamicStack;
import answers.structures.PriorityQueueArray;
import answers.structures.QueueWithShifting;
import answers.structures.SinglyLinkedList;
import answers.structures.StablePriorityQueueArray;
import answers.structures.Stack;
import answers.trees.AVLTree;
import answers.trees.BinarySearchTreeNode;
import answers.trees.BinaryTree;
import answers.trees.RedBlackTree;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] numbers = {2, 4, 6, 8, 8, 8, 10, 12, 64, 34, 25, 12, 22, 11, 90};
        int target = 8;

        result("Bubble unsorted ascending", numbers);
        Bubble.ascending(numbers);
        result("Bubble sorted ascending", numbers);
        Bubble.descending(numbers);
        result("Bubble sorted descending", numbers);
        Selection.ascending(numbers);
        result("Selection sorted ascending", numbers);
        Selection.descending(numbers);
        result("Selection sorted descending", numbers);
        Selection.ascending(numbers);

        result("Linear Search", Linear.findOne(numbers, target));
        result("Linear Search", Linear.findAll(numbers, target));

        result("Binary Search", Binary.findOne(numbers, target));
        result("Binary Search", Binary.findAll(numbers, target));

        System.out.println();
        System.out.println();

        // Array
        Array arrayOps = new Array(5);
        // Insert elements
        arrayOps.insert(10);
        arrayOps.insert(20);
        arrayOps.insert(30);
        arrayOps.insert(40);
        arrayOps.insert(50);
        arrayOps.display(); // Output: 10 20 30 40 50
        // Insert more elements to trigger resize
        arrayOps.insert(60); // Array resizes here
        arrayOps.display(); // Output: 10 20 30 40 50 60
        // Delete an element
        arrayOps.delete(30);
        arrayOps.display(); // Output: 10 20 40 50 60
        // Search for an element
        int index = arrayOps.search(50);
        System.out.println("Element found at index: " + index); // Output: Element found at index: 3 // Invalid input validation
        int[] emptyArray = {};
        arrayOps.isValidInput(emptyArray); // Output: Invalid input: array is empty or null.

        System.out.println();
        System.out.println();

        // SinglyLinkedList
        SinglyLinkedList singlyList = new SinglyLinkedList();
        // Insert elements
        singlyList.insert(10);
        singlyList.insert(20);
        singlyList.insert(30);
        singlyList.insert(40);
        singlyList.display(); // Output: 10 20 30 40
        // Search for an element
        boolean found = singlyList.search(30);
        System.out.println("Element found: " + found); // Output: Element found: true
        // Delete an element
        singlyList.delete(20);
        singlyList.display(); // Output: 10 30 40

        System.out.println();
        System.out.println();

        DoublyLinkedList doublyList = new DoublyLinkedList();
        // Insert elements
        doublyList.insert(10);
        doublyList.insert(20);
        doublyList.insert(30);
        doublyList.insert(40);
        doublyList.display(); // Output: 10 20 30 40
        // Search for an element
        boolean foundDoubly = doublyList.search(20);
        System.out.println("Element found: " + foundDoubly); // Output: Element found: true
        // Delete an element
        doublyList.delete(20);
        doublyList.display(); // Output: 10 30 40

        System.out.println();
        System.out.println();

        CircularLinkedList circularList = new CircularLinkedList();
        // Insert elements
        circularList.insert(10);
        circularList.insert(20);
        circularList.insert(30);
        circularList.insert(40);
        circularList.display(); // Output: 10 20 30 40
        // Search for an element
        int circularIndex = circularList.search(30);
        System.out.println("Element found at index: " + circularIndex); // Output: Element found at index: 2 // Get size of the list
        System.out.println("Size: " + circularList.getSize()); // Output: Size: 4
        // Delete an element
        circularList.delete(20);
        circularList.display(); // Output: 10 30 40
        // Remove the last node
        circularList.removeLast();
        circularList.display(); // Output: 10 30
        // Reverse the list
        circularList.reverse();
        circularList.display(); // Output: 30 10
        // Edge cases
        circularList.delete(50); // Output: Element not found.
        circularList.display(); // Output: List is empty.
        circularList.removeLast(); // Output: 30
        circularList.removeLast(); // Output: 10
        circularList.removeLast(); // Output: List is empty.
        circularList.display(); // Output: List is empty.

        System.out.println();
        System.out.println();

        Stack stack = new Stack(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display();
        System.out.println("Peek: " + stack.peek());
        stack.display();
        System.out.println("Popped: " + stack.pop());
        stack.display();

        System.out.println();
        System.out.println();

        DynamicStack dynamicStack = new DynamicStack(3);
        dynamicStack.push(10);
        dynamicStack.push(20);
        dynamicStack.push(30);
        dynamicStack.display();
        dynamicStack.push(40); // Triggers resizing
        dynamicStack.display();
        System.out.println("Peek: " + dynamicStack.peek());
        System.out.println("Popped: " + dynamicStack.pop());
        dynamicStack.display();

        System.out.println();
        System.out.println();

        QueueWithShifting queueWithoutShifting = new QueueWithShifting(5);
        queueWithoutShifting.enqueue(10);
        queueWithoutShifting.enqueue(20);
        queueWithoutShifting.enqueue(30);
        queueWithoutShifting.enqueue(40);
        queueWithoutShifting.enqueue(50); // Queue is now full
        queueWithoutShifting.display();
        System.out.println("Dequeued: " + queueWithoutShifting.dequeue());
        System.out.println("Peek: " + queueWithoutShifting.peek());
        queueWithoutShifting.enqueue(60); // Adds after dequeueing
        queueWithoutShifting.display();

        System.out.println();
        System.out.println();

        DynamicQueueWithShifting queueWithShifting = new DynamicQueueWithShifting(5);
        queueWithShifting.enqueue(10);
        queueWithShifting.enqueue(20);
        queueWithShifting.enqueue(30);
        queueWithShifting.enqueue(40);
        queueWithShifting.enqueue(50); // Queue is now full
        queueWithShifting.display();
        System.out.println("Dequeued: " + queueWithShifting.dequeue());
        System.out.println("Peek: " + queueWithShifting.peek());
        queueWithShifting.enqueue(60); // Adds after dequeueing
        queueWithShifting.display();

        System.out.println();
        System.out.println();

        CircularQueue circularQueue = new CircularQueue(5);
        circularQueue.enqueue(10);
        circularQueue.enqueue(20);
        circularQueue.enqueue(30);
        circularQueue.enqueue(40);
        circularQueue.enqueue(50); // Queue is full now
        circularQueue.display();
        System.out.println("Dequeued: " + circularQueue.dequeue());
        circularQueue.display();
        circularQueue.enqueue(60); // Adds after dequeueing
        circularQueue.display();
        System.out.println("Peek: " + circularQueue.peek());

        System.out.println();
        System.out.println();

        PriorityQueueArray pq = new PriorityQueueArray(5);
        // Enqueue elements
        pq.enqueue(10, 2); // value 10, priority 2
        pq.enqueue(20, 5); // value 20, priority 5
        pq.enqueue(30, 1); // value 30, priority 1
        pq.enqueue(40, 3); // value 40, priority 3
        // Display and dequeue elements based on highest priority
        System.out.println("Dequeued element: " + pq.dequeue()); // Should be value 20, priority 5
        System.out.println("Dequeued element: " + pq.dequeue()); // Should be value 40, priority 3
        System.out.println("Dequeued element: " + pq.dequeue()); // Should be value 10, priority 2
        System.out.println("Dequeued element: " + pq.dequeue()); // Should be value 30, priority

        System.out.println();
        System.out.println();

        StablePriorityQueueArray spq = new StablePriorityQueueArray(5);
        // Enqueue elements with priorities
        spq.enqueue(10, 2); // value 10, priority 2
        spq.enqueue(20, 5); // value 20, priority 5
        spq.enqueue(30, 1); // value 30, priority 1
        spq.enqueue(40, 3); // value 40, priority 3
        spq.enqueue(50, 2); // value 50, priority 2 (same priority as value 10)
        // Display and dequeue elements based on priority and FIFO
        System.out.println("Dequeued element: " + spq.dequeue()); // Should be value 20, priority 5
        System.out.println("Dequeued element: " + spq.dequeue()); // Should be value 40, priority 3
        System.out.println("Dequeued element: " + spq.dequeue()); // Should be value 10, priority 2 (FIFO)
        System.out.println("Dequeued element: " + spq.dequeue()); // Should be value 50, priority 2 (FIFO)
        System.out.println("Dequeued element: " + spq.dequeue()); // Should be value 30, priority 1

        System.out.println();
        System.out.println();

        Deque deque = new Deque(5);
        // Enqueue elements at the front and rear
        deque.enqueueRear(10);
        deque.enqueueRear(20);
        deque.enqueueFront(5);
        deque.enqueueFront(2);

        // Display elements
        System.out.println("Front element: " + deque.peekFront()); // Should be 2
        System.out.println("Rear element: " + deque.peekRear()); // Should be 20

        // Dequeue elements from front and rear
        System.out.println("Dequeued from front: " + deque.dequeueFront()); // Should be 2
        System.out.println("Dequeued from rear: " + deque.dequeueRear()); // Should be 20 // Final elements after dequeue
        System.out.println("Front element after dequeue: " + deque.peekFront()); //Should be 5
        System.out.println(
                "Rear element after dequeue: " + deque.peekRear()); //Should be 10

        System.out.println();
        System.out.println();

        int num = 5;
        System.out.println("Factorial of " + num + " is: " + Factorial.factorial(num));

        System.out.println();
        System.out.println();

        int num2 = 10;
        System.out.println("Fibonacci of " + num2 + " is: " + Fibonacci.fibonacci(num2));

        System.out.println();
        System.out.println();

        int x = 2, n = 3;
        System.out.println(x + " raised to the power " + n + " is: " + Power.power(x, n));

        System.out.println();
        System.out.println();

        String input = "hello";
        System.out.println("Reversed string: " + ReverseString.reverse(input));

        System.out.println();
        System.out.println();

        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("Sum of array elements: " + ArraySum.sum(arr, arr.length));

        System.out.println();
        System.out.println();

        int[] arr2 = {2, 3, 4, 10, 40};
        int target2 = 10;
        int result = RecursiveBinarySearch.binarySearch(arr2, 0, arr2.length - 1, target2);
        if (result == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index: " + result);
        }

        System.out.println();
        System.out.println();

        int numDisks = 3;
        TowerOfHanoi.hanoi(numDisks, 'A', 'C', 'B'); // A: Source, B: Auxiliary, C: Destination

        System.out.println();
        System.out.println();

        int[] arr3 = {12, 11, 13, 5, 6, 7};
        MergeSort.mergeSort(arr3, 0, arr3.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(arr3));

        System.out.println();
        System.out.println();

        String input2 = "ABC";
        List<String> permutations = StringPermutations.permute(input2);
        System.out.println("Permutations of " + input2 + ": " + permutations);

        System.out.println();
        System.out.println();

        String input3 = "madam";
        if (PalindromeCheck.isPalindrome(input3)) {
            System.out.println(input3 + " is a palindrome.");
        } else {
            System.out.println(input3 + " is not a palindrome.");
        }

        System.out.println();
        System.out.println();

        int a = 48, b = 18;
        System.out.println("GCD of " + a + " and " + b + " is: " + GCD.gcd(a, b));

        System.out.println();
        System.out.println();

        List<Object> nestedList = Arrays.asList(1, Arrays.asList(2, 3, Arrays.asList(4, 5)), 6);
        List<Integer> flatList = FlattenList.flattenList(nestedList);
        System.out.println("Flattened list: " + flatList);

        System.out.println();
        System.out.println();

        BinaryTree tree = new BinaryTree();
        tree.root = tree.insert(tree.root, 50);
        tree.insert(tree.root, 30);
        tree.insert(tree.root, 70);
        tree.insert(tree.root, 20);
        tree.insert(tree.root, 40);
        tree.insert(tree.root, 60);
        tree.insert(tree.root, 80);
        System.out.println("In-order traversal:");
        tree.inorder(tree.root);
        System.out.println();
        System.out.println("Pre-order traversal:");
        tree.preorder(tree.root);
        System.out.println();
        System.out.println("Post-order traversal:");
        tree.postorder(tree.root);
        System.out.println();
        System.out.println("Level-order traversal:");
        tree.levelOrder(tree.root);
        System.out.println();
        System.out.println("Delete 20");
        tree.delete(tree.root, 20);
        System.out.println("In-order traversal after deletion:");
        tree.inorder(tree.root);
        System.out.println();

        System.out.println();
        System.out.println();

        BinarySearchTreeNode root = new BinarySearchTreeNode(10);
        root = root.insert(5);
        root = root.insert(15);
        root = root.insert(3);
        root = root.insert(7);
        root = root.insert(12);
        root = root.insert(17);
        System.out.println("In-order traversal:");
        root.inOrderTraversal(); // Should print: 3 5 7 10 12 15 17
        System.out.println();
        BinarySearchTreeNode searchResult = root.search(7);
        System.out.println("Search for 7: " + (searchResult != null ? "Found" : "Not Found"));
        root = root.delete(15);
        System.out.println("In-order traversal after deleting 15:");
        root.inOrderTraversal(); // Should print: 3 5 7 10 12 17
        System.out.println();

        System.out.println();
        System.out.println();

        AVLTree tree2 = new AVLTree();
        // Sample operations
        tree2.insert(10);
        tree2.insert(20);
        tree2.insert(30);
        tree2.insert(40);
        tree2.insert(50);
        tree2.insert(25);
        System.out.println("In-Order Traversal after insertion:");
        tree2.inOrder();
        tree2.delete(30);
        System.out.println("In-Order Traversal after deletion:");
        tree2.inOrder();
        System.out.println("Search for 25: " + tree2.search(25));
        System.out.println("Search for 100: " + tree2.search(100));

        System.out.println();
        System.out.println();

        RedBlackTree bst = new RedBlackTree();

        bst.insert(55);
        bst.insert(40);
        bst.insert(65);
        bst.insert(30);
        bst.insert(50);
        bst.insert(60);
        bst.insert(70);
        System.out.println("Preorder traversal:");
        bst.preOrder(); // Output the preorder traversal
    }

    // Method to print the array
    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void result(String alg, int index) {
        if (index != -1) {
            System.out.println(alg + ": Element found at indices: " + index);
        } else {
            System.out.println(alg + ": Element not found.");
        }
    }

    public static void result(String alg, List<Integer> indices) {
        if (!indices.isEmpty()) {
            System.out.println(alg + ": Element found at indices: " + indices);
        } else {
            System.out.println(alg + ": Element not found.");
        }

    }

    public static void result(String alg, int[] array) {
        System.out.println(alg + ":");
        printArray(array);
    }
}

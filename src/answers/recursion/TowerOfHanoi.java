package answers.recursion;

public class TowerOfHanoi {

    public static void hanoi(int n, char source, char destination, char auxiliary) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }
        hanoi(n - 1, source, auxiliary, destination);
        System.out.println("Move disk " + n + " from " + source + " to " + destination);
        hanoi(n - 1, auxiliary, destination, source);
    }

}

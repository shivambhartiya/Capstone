public class SIT_304 {
    public static void main(String[] args) {
        int n = 3; // number of disks
        play(n, 'A', 'B', 'C');
    }

    static void play(int n, char source, char helper, char destination) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }

        // Step 1: move n-1 disks from source → helper
        play(n - 1, source, destination, helper);

        // Step 2: move nth disk from source → destination
        System.out.println("Move disk " + n + " from " + source + " to " + destination);

        // Step 3: move n-1 disks from helper → destination
        play(n - 1, helper, source, destination);
    }
}
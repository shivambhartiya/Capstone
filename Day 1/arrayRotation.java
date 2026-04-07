// CCTV footage camera rotation problem
// Security office stores the last few camera snapshots in an array
// input = [101, 102, 103, 104, 105]
//k = 3
//Output = [104, 105, 101, 102, 103]    



public class arrayRotation {
    public static void main(String[] args) {
        int[] input = {101, 102, 103, 104, 105};
        int k = 3;
        rotateArray(input, k);
        for (int num : input) {
            System.out.print(num + " ");
        }
    }
    static void rotateArray(int[] arr, int k) {
        int n = arr.length;
        k = k % n; // Handle cases where k is greater than n
        reverse(arr, 0, n - 1); // Reverse the entire array
        reverse(arr, 0, k - 1); // Reverse the first k elements
        reverse(arr, k, n - 1); // Reverse the remaining elements
    }
    static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}

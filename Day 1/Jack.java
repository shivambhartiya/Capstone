import java.util.Scanner;

// Jack is always excited about Sunday
// When he gets to play all day 
// So everytime the months start he gets super excited and starts counting the number of Sundays in that month.
// The month can start on any day
// Count the number of Sundays he gets within n number of days

public class Jack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of days: ");
        int n = scanner.nextInt();
        
        System.out.print("Enter the starting day (1=Monday, 2=Tuesday, ..., 7=Sunday): ");
        int startDay = scanner.nextInt();
        
        int sundays = countSundays(n, startDay);
        System.out.println("Number of Sundays in the month: " + sundays);
        
        scanner.close();
    }

    static int countSundays(int n, int startDay) {
        int sundays = 0;
        for (int i = 0; i < n; i++) {
            if ((startDay + i) % 7 == 0) { // Check if the day is Sunday
                sundays++;
            }
        }
        return sundays;
    }
}
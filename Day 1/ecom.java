// Payment gateway for e-commerce platforms website user
// 1. UPI payment
// 2. Credit/Debit card payment
// Both have processPayment() method to process the payment
//A hybridPaymentSystem support both 
import java.util.Scanner;

interface UpiPayment {
    default void processPayment() {
        System.out.println("Processing UPI payment.");
    }
}

interface CardPayment {
    default void processPayment() {
        System.out.println("Processing card payment.");
    }
}

class HybridPaymentSystem implements UpiPayment, CardPayment {

    Scanner scanner = new Scanner(System.in);

    @Override
    public void processPayment() {
        // Resolving the conflict by choosing one of the default methods
        System.out.println("Choose payment method:");
        System.out.println("1. UPI");
        System.out.println("2. Card");
        int choice = scanner.nextInt();
        if (choice == 1) {
            UpiPayment.super.processPayment();
        } else if (choice == 2) {
            CardPayment.super.processPayment();
        }else{
            System.err.println("Please choose a valid payment method.");
        }
    }
}

public class ecom {
   public static void main(String[] args) {
        HybridPaymentSystem paymentSystem = new HybridPaymentSystem();
        while (true) {
            paymentSystem.processPayment();
            System.out.println("Do you want to make another payment? (yes/no)");
            String again = paymentSystem.scanner.next();
            if (!again.equalsIgnoreCase("yes")) {
                break;
            }
        }
    }
}

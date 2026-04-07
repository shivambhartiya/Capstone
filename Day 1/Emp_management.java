//Q3: Employee management system
// (Diamond Structure)
// Create a real time notification system 
// A is employee, B is email notification, C is SMS notification, D is Manager
// Both B and C inherit from A

interface Employee {

    void notifyEmployee();

}

interface EmailNotification extends Employee {
    default void notifyEmployee() {
        System.out.println("Sending email notification.");
    }
}

interface SMSNotification extends Employee {
    default void notifyEmployee() {
        System.out.println("Sending SMS notification.");
    }
}

class Manager implements EmailNotification, SMSNotification {
    @Override
    public void notifyEmployee() {
        // Resolving the conflict by choosing one of the default methods
        EmailNotification.super.notifyEmployee();
        SMSNotification.super.notifyEmployee();
    }
}

public class Emp_management {
    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.notifyEmployee();
    }
}

// Java does not support multiple inheritance through classes, 
// so this topic is usually demonstrated using interfaces.

//Q: A smart home system with device A and device B, both the system have same operations like turnOn()
//Sol: Smart Device implements both method/interface
interface DeviceA {
    default void turnOn() {
        System.out.println("Device A is turned on.");
    }
}
interface DeviceB {
    default void turnOn() {
        System.out.println("Device B is turned on.");
    }
}

class SmartDevice implements DeviceA, DeviceB {
    @Override
    public void turnOn() {
        // Resolving the conflict by choosing one of the default methods
        DeviceA.super.turnOn(); // or DeviceB.super.turnOn();
        DeviceB.super.turnOn(); // or DeviceA.super.turnOn();
    }
}

public class SIT_101 {

    public static void main(String[] args) {
        SmartDevice smartDevice = new SmartDevice();
        smartDevice.turnOn();
    }
}

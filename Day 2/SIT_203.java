class Order {
    int orderId;
    String customerName;
    double orderAmount;
    int deliveryTime;

    public Order(int orderId, String customerName, double orderAmount, int deliveryTime) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderAmount = orderAmount;
        this.deliveryTime = deliveryTime;
    }
}

public class SIT_203 {
    static void displayOrders(Order[] orders) {
        System.out.println("Order Details:");
        for (Order order : orders) {
            System.out.println("ID: " + order.orderId + ", Customer: " + order.customerName + 
                             ", Amount: " + order.orderAmount + ", Delivery Time: " + order.deliveryTime + " days");
        }
    }

    static void mergeSort(Order[] orders, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(orders, left, mid);
            mergeSort(orders, mid + 1, right);
            merge(orders, left, mid, right);
        }
    }

    static void merge(Order[] orders, int left, int mid, int right) {
        Order[] temp = new Order[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (orders[i].orderId <= orders[j].orderId) {
                temp[k++] = orders[i++];
            } else {
                temp[k++] = orders[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = orders[i++];
        }

        while (j <= right) {
            temp[k++] = orders[j++];
        }

        for (i = left, k = 0; i <= right; i++, k++) {
            orders[i] = temp[k];
        }
    }

    public static void main(String[] args) {
        Order[] orders = {
            new Order(103, "Bob", 800.0, 7),
            new Order(101, "John", 500.0, 5),
            new Order(102, "Alice", 1200.0, 3)
        };
        
        System.out.println("Before Sorting:");
        displayOrders(orders);
        
        mergeSort(orders, 0, orders.length - 1);
        
        System.out.println("\nAfter Sorting (by Order ID):");
        displayOrders(orders);
    }
}

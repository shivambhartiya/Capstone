class Order {
    int orderID;
    String customerType;
    double orderValue;
    int deliveryTime;

    Order(int orderID, String customerType, double orderValue, int deliveryTime) {
        this.orderID = orderID;
        this.customerType = customerType;
        this.orderValue = orderValue;
        this.deliveryTime = deliveryTime;
    }

    public String toString() {
        return "{" + orderID + ", " + customerType + ", " + orderValue + ", " + deliveryTime + "}";
    }
}

public class SIT_301 {

    public static void main(String[] args) {

        Order[] orders = {
            new Order(101, "Regular", 500.0, 5),
            new Order(102, "Prime", 300.0, 3),
            new Order(103, "Prime", 700.0, 4),
            new Order(104, "Regular", 500.0, 2),
            new Order(105, "Prime", 700.0, 2)
        };

        mergeSort(orders, 0, orders.length - 1);

        for (Order o : orders) {
            System.out.println(o);
        }
    }

    static void mergeSort(Order[] orders, int left, int right) {
        if (left < right) { // divide till single element
            int mid = (left + right) / 2;

            // recursion
            mergeSort(orders, left, mid);
            mergeSort(orders, mid + 1, right);

            merge(orders, left, mid, right);
        }
    }

    static void merge(Order[] orders, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        // temporary arrays
        Order[] L = new Order[n1];
        Order[] R = new Order[n2];

        // copy left
        for (int i = 0; i < n1; i++) {
            L[i] = orders[left + i];
        }

        // copy right
        for (int j = 0; j < n2; j++) {
            R[j] = orders[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        // merge
        while (i < n1 && j < n2) {
            if (compare(L[i], R[j]) <= 0) {
                orders[k++] = L[i++];
            } else {
                orders[k++] = R[j++];
            }
        }

        // remaining elements
        while (i < n1) {
            orders[k++] = L[i++];
        }

        while (j < n2) {
            orders[k++] = R[j++];
        }
    }

    static int compare(Order a, Order b) {

        // 1. Prime customers first
        if (!a.customerType.equals(b.customerType)) {
            return a.customerType.equals("Prime") ? -1 : 1;
        }

        // 2. Higher order value first
        if (a.orderValue != b.orderValue) {
            return Double.compare(b.orderValue, a.orderValue);
        }

        // 3. Lower delivery time first
        if (a.deliveryTime != b.deliveryTime) {
            return Double.compare(a.deliveryTime, b.deliveryTime);
        }

        // maintain stability
        return 0;
    }
}
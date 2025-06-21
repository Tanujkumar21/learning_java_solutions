package week1;

public class Ecommerce_platform {

    public static int linearSearch(Product[] products, String targetName) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].productName.equalsIgnoreCase(targetName)) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(Product[] products, String targetName) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int compare = products[mid].productName.compareToIgnoreCase(targetName);

            if (compare == 0) return mid;
            else if (compare < 0) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Shoes", "Fashion"),
            new Product(3, "Mobile", "Electronics"),
            new Product(4, "Watch", "Accessories")
        };

        int index1 = linearSearch(products, "Mobile");
        System.out.println("Linear Search Result: " + (index1 != -1 ? products[index1].productName : "Not Found"));

        java.util.Arrays.sort(products, (a, b) -> a.productName.compareToIgnoreCase(b.productName));

        int index2 = binarySearch(products, "Mobile");
        System.out.println("Binary Search Result: " + (index2 != -1 ? products[index2].productName : "Not Found"));
    }
}

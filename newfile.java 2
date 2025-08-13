import java.util.*;

class Customer {
    private String name;
    private int number;

    public Customer(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "[" + number + "] " + name;
    }
}

public class BankQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Customer> queue = new LinkedList<>();
        int customerCounter = 1;
        int choice;

        do {
            System.out.println("\n--- Bank Queue Menu ---");
            System.out.println("1. Add customer to queue");
            System.out.println("2. Serve next customer");
            System.out.println("3. View queue");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String name = sc.nextLine();
                    Customer newCustomer = new Customer(name, customerCounter++);
                    queue.add(newCustomer);
                    System.out.println("Customer added: " + newCustomer);
                    break;
                case 2:
                    if (queue.isEmpty()) {
                        System.out.println("No customers to serve.");
                    } else {
                        Customer served = queue.poll();
                        System.out.println("Serving customer: " + served);
                    }
                    break;
                case 3:
                    if (queue.isEmpty()) {
                        System.out.println("Queue is empty.");
                    } else {
                        System.out.println("Current queue:");
                        for (Customer c : queue) {
                            System.out.println(c);
                        }
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);

        sc.close();
    }
}

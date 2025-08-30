import java.util.Scanner;

// TaskNode.java
class TaskNode {
    String title;
    TaskNode next;

    TaskNode(String title) {
        this.title = title;
        this.next = null;
    }
}

// ToDoList.java
class ToDoList {
    private TaskNode head;

    public void addTask(String title) {
        TaskNode newNode = new TaskNode(title);
        if (head == null) {
            head = newNode;
        } else {
            TaskNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Task added!");
    }

    public void deleteTask(String title) {
        if (head == null) {
            System.out.println("No tasks to delete.");
            return;
        }
        if (head.title.equalsIgnoreCase(title)) {
            head = head.next;
            System.out.println("Task deleted!");
            return;
        }
        TaskNode current = head;
        while (current.next != null && !current.next.title.equalsIgnoreCase(title)) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Task not found.");
        } else {
            current.next = current.next.next;
            System.out.println("Task deleted!");
        }
    }

    public void printTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        System.out.println("Your Tasks:");
        TaskNode current = head;
        while (current != null) {
            System.out.println("- " + current.title);
            current = current.next;
        }
    }

    public boolean contains(String title) {
        TaskNode current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
}

// Main.java

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ToDoList list = new ToDoList();
        int choice;

        do {
            System.out.println("\n1. Add task");
            System.out.println("2. Delete task");
            System.out.println("3. View all tasks");
            System.out.println("4. Search task");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task title: ");
                    String titleToAdd = sc.nextLine();
                    list.addTask(titleToAdd);
                    break;
                case 2:
                    System.out.print("Enter task title to delete: ");
                    String titleToDelete = sc.nextLine();
                    list.deleteTask(titleToDelete);
                    break;
                case 3:
                    list.printTasks();
                    break;
                case 4:
                    System.out.print("Enter task title to search: ");
                    String titleToSearch = sc.nextLine();
                    if (list.contains(titleToSearch)) {
                        System.out.println("Task found!");
                    } else {
                        System.out.println("Task not found.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}
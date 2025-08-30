
public class PseudoLinkedList {
    private String[] data;  // our array to store elements
    private int size;       // number of elements in the list

    // Constructor with default capacity
    public PseudoLinkedList(int capacity) {
        data = new String[capacity];
        size = 0;
    }

    // Add element to the end
    public void add(String value) {
        if (size == data.length) {
            expandCapacity(); // expand array if full
        }
        data[size] = value;
        size++;
    }

    // Poll: remove and return the first element (like a queue)
    public String poll() {
        if (size == 0) {
            return null; // nothing to poll
        }
        String first = data[0];
        // shift all elements to the left
        for (int i = 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        data[size - 1] = null;
        size--;
        return first;
    }

    // Peek: return the first element without removing
    public String peek() {
        if (size == 0) {
            return null;
        }
        return data[0];
    }

    // Pop: remove and return the last element (like a stack)
    public String pop() {
        if (size == 0) {
            return null;
        }
        String last = data[size - 1];
        data[size - 1] = null;
        size--;
        return last;
    }

    // Helper: expand capacity if array is full
    private void expandCapacity() {
        String[] newData = new String[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    // Display all elements
    public void display() {
        System.out.print("List: ");
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    // Testing
    public static void main(String[] args) {
        PseudoLinkedList list = new PseudoLinkedList(5);

        list.add("A");
        list.add("B");
        list.add("C");
        list.display(); // A B C

        System.out.println("Peek: " + list.peek()); // A
        System.out.println("Poll: " + list.poll()); // A
        list.display(); // B C

        System.out.println("Pop: " + list.pop()); // C
        list.display(); // B
    }
}

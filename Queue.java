import java.util.*;
/*
vidchayada abhicharttibutra 672115044
*/
class QueueOP {
    private String[] queueArray;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public QueueOP(int capacity) {
        this.capacity = capacity;
        this.queueArray = new String[capacity];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(String stname) {
        if (isFull()) {
            System.out.println("Queue is full");
        } 
        queueArray[rear] = stname;
        rear = (rear + 1) % capacity;
        size++;
        System.out.println("Enqueue " + stname);
        displayQueue();
        
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Dequeue " + queueArray[front]);
            queueArray[front] = null;
            front = (front + 1) % capacity;
            size--;
            displayQueue();
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }
    public boolean isFull() {
        return size == capacity;
    }

    private void displayQueue() {
        System.out.print("[");
        for (int i = 0; i < capacity; i++) {
            System.out.print(queueArray[i] + (i < capacity - 1 ? ", " : ""));
        }
        System.out.print("] ");
        System.out.println("[first = " + front + ", rear = " + rear + ", length = " + size + "]");
    }
}

public class Queue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QueueOP queue = new QueueOP(5);
        
        while (true) {
            System.out.print("Please enter student name (enter 'quite' for exit the program): ");
            String studentName = sc.nextLine();
            if (studentName.equalsIgnoreCase("quite")) {
                break;
            }
            queue.enqueue(studentName);
            if (queue.size() > 2) {
                queue.dequeue();
            }
        }
    }
}

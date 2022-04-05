class MovingAverage {
    Node head;
    int size;
    int capacity;
    public MovingAverage(int size) {
        this.head = new Node(0, null);
        this.size = size;
        this.capacity = 0;
    }
    
    public double next(int val) {
        double result = 0;
        Node node = new Node(val, this.head);
        Node temp = node;
        double tempSum = 0;
        int i = 0;
        if(capacity < size) {
            this.capacity++;
            i = capacity; 
        } else {
            i = size;
        }
        while(i != 0) {
            tempSum += temp.val;
            temp = temp.next;
            i--;
        }
        result = tempSum / (this.capacity > this.size ? this.size : this.capacity);
        head = node;
        return result;
    }
}
​
class Node {
    double val;
    Node next;
    Node(double val, Node next) {
        this.val = val;
        this.next = next;
    }
}
​
/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);

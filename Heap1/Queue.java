public class Queue {
    Node start;
    Node current;

    public Queue() {
        this.start = this.current = null;
    }

    //O(n) enqueue
    public void enqueue(Integer newPrio) {
        Node temp = new Node(newPrio);
        current = start;
        if (start == null) {
            start = temp;
        } else {
            if (start.prio > newPrio) {
                temp.tail = start;
                start = temp;
            } else {
                while (current.tail.prio > newPrio && current.tail != null) {
                    current = current.tail;
                }
                temp.tail = current.tail;
                current.tail = temp;
            }
        }
    }

    //O(1) dequeue
    public Integer dequeue(){
        Integer returnvalue = start.prio;

        start = start.tail;
        return returnvalue;
    }
}

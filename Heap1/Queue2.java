public class Queue2 {
    Node start;
    Node current;

    public Queue2() {
        this.start = this.current = null;
    }

    //O(1) enqueue
    public void enqueue(Integer newPrio) {
        Node temp = new Node(newPrio);

        if (start == null) {
            start = temp;
        } else {
            temp.tail = start;
            start = temp;
        }

    }

    //O(n) dequeue
    public Integer dequeue() {
        if(start == null){
            return null;
        }
        
        Node priorityNode = start;
        Node previousNode = start;
        current = start;

        while(current.tail != null){
            if(priorityNode.prio > current.tail.prio){
                priorityNode = current.tail;
                previousNode = current;
            }
            current = current.tail;
        }

        if(priorityNode == start){
            start = start.tail;
        } else {
            previousNode.tail = previousNode.tail.tail;
        }

        return priorityNode.prio;
    }
}

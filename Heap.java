public class Heap {
    Node root;
    Node currentNode;

    public Heap() {
        this.root = null;
        this.currentNode = root;
    }

    public void add(Integer newValue) {

        if (currentNode != null) {
            currentNode.size++;
            //System.out.println("size got bigger");
        }
        // if the tree is empty create it.
        if (root == null) {
            root = new Node(newValue);
            currentNode = root;
            //System.out.println("created root");
            return;
        }
        // if the current nodes value is smaller switch it out
        // and run again with the bigger value
        if (currentNode.value != null && newValue < currentNode.value) {
            int temp = newValue;
            newValue = currentNode.value;
            currentNode.value = temp;
            //System.out.println("swapped a value");

        }

        // checks if right and left are empty if they are it adds the node and the run
        // is over
        // else it moves down to the right or left (depending on which has smallest
        // size) and runs add again.
        if (currentNode.left == null) {
            currentNode.left = new Node(newValue);
            currentNode = root;
            //System.out.println("added to left");
            return;
        } else if (currentNode.right == null) {
            currentNode.right = new Node(newValue);
            currentNode = root;
            //System.out.println("added to right");
            return;
        } else {
            if (currentNode.right.size < currentNode.left.size) {
                currentNode = currentNode.right;
                //System.out.println("stepped down a level and to the right");
                add(newValue);
            } else {
                currentNode = currentNode.left;
                //System.out.println("stepped down a level and to the left");
                add(newValue);
            }
        }

    }

    public Integer remove() {
        currentNode = root;
        if (root == null) {
            return null;
        } else {


            Node temp = root;

            promote();

            return temp.value;
        }

    }

    //input = integer that raises value and puts it lower in heap.
    public Integer push(Integer Incr){
        Integer levelDrop = 0;
        currentNode = root;
        currentNode.value += Incr;
        Integer temp;
        
        while(currentNode.right != null && currentNode.left != null){
            if(currentNode.value > currentNode.right.value && currentNode.right.value < currentNode.left.value || currentNode.right != null && currentNode.left == null){
                temp = currentNode.value;
                currentNode.value = currentNode.right.value;
                currentNode.right.value = temp;
                currentNode = currentNode.right;
                levelDrop++;


            } else if (currentNode.value > currentNode.left.value && currentNode.right.value > currentNode.left.value || currentNode.left != null && currentNode.right == null){
                temp = currentNode.value;
                currentNode.value = currentNode.left.value;
                currentNode.left.value = temp;
                currentNode = currentNode.left;
                levelDrop++;
            } else if(currentNode.right == null && currentNode.left == null){
                return levelDrop;
            } else {
                return levelDrop;
            }
        }
        return levelDrop;
    }

    public void promote() {

        if (currentNode.size == 0) {

            currentNode.value = null;
            currentNode.size = 0;
            return;
        } else {

            if (currentNode.left == null && currentNode.right != null || currentNode.left.value == null && currentNode.right.value != null) {
                currentNode.value = currentNode.right.value;
                currentNode.size--;
                currentNode = currentNode.right;
                promote();

            }
             if (currentNode.right == null && currentNode.left != null || currentNode.right.value == null && currentNode.left.value != null) {
                currentNode.value = currentNode.left.value;
                currentNode.size--;
                currentNode = currentNode.left;
                promote();

            } else {
                if (currentNode.right.value < currentNode.left.value) {
                    currentNode.value = currentNode.right.value;
                    currentNode.size--;
                    currentNode = currentNode.right;
                    promote();

                } else if (currentNode.right.value > currentNode.left.value) {
                    currentNode.value = currentNode.left.value;
                    currentNode.size--;
                    currentNode = currentNode.left;
                    promote();

                }
            }
        }
    }
}

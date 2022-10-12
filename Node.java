public class Node{
    //size is the size of the tree below current node. Check Heap.add for how it works
    Integer value;
    Integer size = 0;
    Node left,right;

    public Node( Integer value){
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
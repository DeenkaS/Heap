public class heaptest {
    public static void main(String []args){
        Heap hip = new Heap();
        

        hip.add(7);
        hip.add(2);
        hip.add(5);
        hip.add(4);
        hip.add(8);
        hip.add(1);
        hip.add(3);
        hip.add(6);
        hip.add(0);

        System.out.println(hip.root.value);

        

        System.out.println(hip.remove());
        System.out.println(hip.remove());
        System.out.println(hip.remove());
        System.out.println(hip.remove());
        System.out.println(hip.remove());
        System.out.println(hip.remove());
        System.out.println(hip.remove());
        System.out.println(hip.remove());





    }
}

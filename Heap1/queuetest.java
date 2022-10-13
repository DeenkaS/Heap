public class queuetest{
    public static void main(String[]args){
        Queue2 test = new Queue2();

        test.enqueue(1);
        test.enqueue(5);
        test.enqueue(4);
        test.enqueue(8);
        test.enqueue(17);
        test.enqueue(2);
        test.enqueue(32);
        test.enqueue(10);
        test.enqueue(0);

        System.out.println(test.dequeue());
        System.out.println(test.dequeue());
        System.out.println(test.dequeue());


        Queue test2 = new Queue();

        test2.enqueue(1);
        test2.enqueue(5);
        test2.enqueue(4);
        test2.enqueue(8);
        test2.enqueue(17);
        test2.enqueue(2);
        test2.enqueue(32);
        test2.enqueue(10);
        test2.enqueue(0);

        System.out.println(test2.dequeue());
        System.out.println(test2.dequeue());
        System.out.println(test2.dequeue());
    }
}
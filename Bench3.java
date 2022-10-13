import java.util.Random;
public class Bench3 {
    public static void main(String[] args){
        
        int[] list = {64, 128, 256, 512, 1024, 2048};
        Random rnd = new Random();
        System.out.printf("Number of elements: %10s%15s%15s\n", "Add time", "Push time", "Remove time");
        double k = 10000;
        long t0 = 0;
        long t1 = 0;
        long t2 = 0;
        long t3 = 0;
        long t4 = 0;
        long t5 = 0;
        for(int num : list){
        Heap test = new Heap();
        System.out.printf("%8d", num);
        for(int i = 0; i < k; i++){
            for(int j = 0; j < num; j++){
                int random = rnd.nextInt(num);
                t0 = System.nanoTime();
                test.add(random);
                t1 += System.nanoTime() - t0;
            }
            /*for(int j = 0; j < num; j++){
                int random = rnd.nextInt(num);
                t2 = System.nanoTime();
                //test.increment(random);
                t3 += System.nanoTime() - t2;
            }*/
            
            for(int j = 0; j < num; j++){
                t4 = System.nanoTime();
                test.remove();
                t5 += System.nanoTime() - t4;
            }
        }
        System.out.printf("%20.0f", t1 / (k*num));
        System.out.printf("%15.0f", t3 / (k*num));
        System.out.printf("%15.0f\n",t5 / (k*num));
        }
    }
}
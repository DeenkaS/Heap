import java.util.Random;

public class heaptest {
    public static void main(String []args){
        Heap hip = new Heap();
        Random rand = new Random();
        int k = 100;
        Integer pushSum = 0;
        

       for(int i = 0; i < k ; i++){
            for(int j = 0; j < 64; j++){
                hip.add((rand.nextInt(100)));
            }

            for(int j = 0; j < 64; j++){   
               pushSum += hip.push(rand.nextInt(100));
                
            }

            for(int j = 0; j < 64; j++){
                hip.remove();
            }

       }
       System.out.println(pushSum);
       System.out.println("average depth of push down a tree of size 64: " + (pushSum/(k*64) ));





    }
}

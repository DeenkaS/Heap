public class HeapArray {
    // array[0] = root
    // the node at position n
    // -> left branch at n * 2 + 1
    // -> right branch at n * 2 + 2
    Integer size = 4096;
    Integer[] treeArray = new Integer[size];
    Integer g = 0;

    public void add(Integer prio) {
        
        // first item
        if (treeArray[0] == null) {
            treeArray[0] = prio;
            // System.out.println("Empty tree " + prio + " added as root");
            return;
        }
        // iterate until we reach an empty slot
        while (treeArray[g] != null && g < size) {
            g++;
        }
        treeArray[g] = prio;
        // System.out.println(prio + " added at " + g);
        while (g >= 0) {
            // check if slot is an even index
            if (g % 2 == 0 && g != 0) { // even number has parent at g-2/2
                if (treeArray[g] < treeArray[(g - 2) / 2]) {
                    // swap
                    Integer temp = Integer.valueOf(treeArray[g]);
                    treeArray[g] = treeArray[(g - 2) / 2];
                    treeArray[(g - 2) / 2] = temp;
                    // System.out.println(treeArray[g] + " swapped with " + treeArray[(g-2)/2]);
                    g = ((g - 2) / 2);
                } else {
                    return;
                }
            }
            // if the slot is not an even index, it will be an odd index
            else {// odd number has parent at g-1/2
                if (treeArray[g] < treeArray[(g - 1) / 2]) {
                    // swap
                    Integer temp = Integer.valueOf(treeArray[g]);
                    treeArray[g] = treeArray[(g - 1) / 2];
                    treeArray[(g - 1) / 2] = temp;
                    // System.out.println(treeArray[g] + " swapped with " + treeArray[(g-1)/2]);
                    g = ((g - 1) / 2);
                } else {
                    return;
                }
            }
        }
    }

    public void increment(Integer inc_value) {
        Integer n = treeArray.length - 1;
        treeArray[0] += inc_value;
        Integer temp = Integer.valueOf(0);
        Integer leaf = n;
        Integer i = 0;
        while (n < leaf && n < 31) {
            if (treeArray[i * 2 + 1] == null || treeArray[i * 2 + 2] == null) {
                n = leaf;
                return;
            }
            if (treeArray[i * 2 + 1] < treeArray[i]) {
                temp = treeArray[i];
                treeArray[i] = treeArray[i * 2 + 1];
                treeArray[i * 2 + 1] = temp;
                i = ((i * 2) + 1);
            } else if (treeArray[((i * 2) + 2)] < treeArray[i]) {
                temp = treeArray[i];
                treeArray[i] = treeArray[i * 2 + 2];
                treeArray[i * 2 + 2] = temp;
                i = ((i * 2) + 2);
            }
        }
        n = leaf;
    }

    public void remove() {
        Integer n = 0;
        for (int i = 0; i < treeArray.length; i++) {
            if (treeArray[i] != null) {
                n++;
            }
        }
        n = n - 1;
        Integer temp = Integer.valueOf(treeArray[n]);
        treeArray[n] = treeArray[0];
        treeArray[0] = temp;
        treeArray[n] = null;
        Integer leaf = n;
        n = 0;
        while (n < 31) {
            if (treeArray[n * 2 + 1] == null || treeArray[n * 2 + 2] == null) {
                n = leaf - 1;
                return;
            }
            if (treeArray[n * 2 + 1] < treeArray[n]) {
                temp = treeArray[n];
                treeArray[n] = treeArray[n * 2 + 1];
                treeArray[n * 2 + 1] = temp;
                n = ((n * 2) + 1);
            } else if (treeArray[((n * 2) + 2)] < treeArray[n]) {
                temp = treeArray[n];
                treeArray[n] = treeArray[n * 2 + 2];
                treeArray[n * 2 + 2] = temp;
                n = ((n * 2) + 2);
            } else {
                n = leaf - 1;
                return;
            }
        }
    }

    public void printList() {
        for (int i = 0; i < treeArray.length; i++) {
            if (treeArray[i] != null) {
                System.out.println(treeArray[i]);
            }
        }
    }
}
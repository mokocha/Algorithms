public class HeapSort {

    public static void sort(int[] A) {
        System.out.println("heap sort    " + toString(A));

        int n = A.length;

        erstelleHeap(A, n);

        //takes the head, puts it at the end, and shifts everything up
        for(int i = n; i > 1; i--) {
            System.out.println("switching head with last node");
            int temp = A[0];
            A[0] = A[i-1];
            A[i-1] = temp;
            versickere(A,1,i-1);
        }
        System.out.println("Sorted: " + toString(A));
    }


    public static void versickere(int[] A, int i, int max) {
        System.out.println("------------------------------");
        System.out.println("versickere : " + toString(A) + ", i=" + i + ", m=" + max);

        int j;

        while(2*i <= max) {  //A[i] has a left child

            j = 2*i; // j is left child

            //A[i] has a right child
            if(j < max) {
                 if(A[j-1] < A[j]) {  // if A[2*i] < A[2*i+1}
                     j += 1; //A[j] is the biggest child
                 }
            }

            //A[i] doesn't have a right child
            if(A[i-1] < A[j-1]) {
                int temp = A[i-1];
                A[i-1] = A[j-1];
                A[j-1] = temp;
                i = j; //versickere weiter
            } else {
                i=max; //stop; heap criteria satisfied
            }
        }

        System.out.println("versickere : " + toString(A) + ", i=" + i + ", m=" + max);
        System.out.println("------------------------------");
    }

    //builds the heap from bottom up
    public static void erstelleHeap(int[] A, int n) {
        System.out.println("erstell heap " +toString(A) + ", n=" + n);

        for(int i = n/2; i>=1;i--) {
            versickere(A,i,n);
        }
    }





    private static String toString(int[] A) {
        String s = "[";

        for(int n = 0; n < A.length; n++) {
            s += A[n];
            if(n != A.length-1) s+=",";
        }
        s += "]";
        return s;
    }

//    private static String toString(int[] A) {
//        String s = "";
//        int level = 1;
//
//        int k = 5;
//
//        for(int n = 0; n < A.length; n++) {
//            int count = 0;
//            String space = "";
//
//            for(int x = 10*(A.length/2) - n * k; x > 0; x --) {
//                space += " ";
//            }
//
//
//            s += space + "| " + A[n] + " |";
//            count++;
//
//            if(count == level) {
//                s+="\n";
//                level++;
//            }
//        }
//
//        return s;
//    }
}

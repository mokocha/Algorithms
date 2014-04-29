
public class QuickSort {

    public static void sort(int[] A)
    {
        int[] sorted = quickSort(A, 0, A.length-1);
        System.out.println("sorted :" + toString(sorted));
    }

    public static int[] quickSort(int[] A, int l, int r)
    {
        if(l < r) { //if or while
            int x = A[r]; //key value
            int pivot = Partition(A,l,r,x);
            quickSort(A,l,pivot - 1);
            quickSort(A,pivot + 1,r);
        }
        return A;
    }

    public static int Partition(int[] A, int l, int r, int key) {

        //TODO remove
        if(l >= r) return l; //nichts zu tun

        int j = r;
        int pivot = l - 1;

        do // bis key >= r
        {

            do //while A[val] < key, move pivot right
            {
                pivot += 1;
            }
            while(A[pivot] < key);

            do // r <= pivot || A[r] <= key
            {
                r -= 1; //key = r, so no need to check, decrease
            }
            while(r > pivot && A[r] > key); ///?????????????????

            if(pivot < r)
            {
                int temp = A[pivot];
                A[pivot] = A[r];
                A[r] = temp;
            }

        }
        while (r > pivot);

        int temp = A[pivot];
        A[pivot] = A[j];
        A[j] = temp;

        return pivot;
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
}
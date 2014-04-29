/*
* EINGABE: zu sortierende Folge in Feld A (d.h. in A[1],....,A[n})
* AUSGABE: sortierte Folge in Feld A
* VARIABLE(n): Zahl key; Indizes i, j
* 1: for j = 2,...,n {
* 2:    key = A[j];
* 3:    //insert A[j] in sorted array A[1],...,A[j-1]
* 4:    i = j - 1;
* 5:    while i > 0 and A[i] > key {
* 6:        A[i+1] = A[i];
* 7:        i = i - 1;
* 8:    }
* 9:    A[i+1] = key;
* 10: }
* */

public class InsertionSort {

    static int step = 0;

    public static int[] sort(int[] array) {

        int n,key,i,j;

        n = array.length;

        for(j=1; j < n;j++) {
            key = array[j];
            i = j - 1;

            while(i >= 0 && array[i] > key) {
                array[i+1] = array[i];
                i -= 1;
            }
            array[i+1] = key;
            print(array);
        }
        return array;
    }

    public static void print(int[] array) {
        System.out.print("step " + String.valueOf(step++)  + ": ");

        for(int x : array) {
            System.out.print(String.valueOf(x) + " ");
        }

        System.out.print('\n');
    }
}

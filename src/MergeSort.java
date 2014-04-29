/**

 EINGABE: Folge A; Indexgrenzen l und r (falls l >= r ist nichts zu tun)
 AUSGABE: sortierte Teilfolge in A[l],...,A[r]
 VARIABLE(n): Index middle

 1: if l < r then {
 2:    middle = [(l+r)/2];
 3:    Merge-Sort(A,l,middle);
 4:    Merge-Sort(A,middle+l,r);
 5:    Merge(A,l,middle,r);
 6: }

*/

import java.util.Arrays;

public class MergeSort {

    public static void sort(int[] array)
    {

        int[] tmp = new int[array.length];
        sort(array,tmp,0, array.length-1);

    }

    public static void sort(int[] array, int[] tmp, int left, int right)
    {

        if(left < right)
        {
            int center = (left + right) / 2;

            //System.out.println("left sort(" + Arrays.toString(array) + ", " + Arrays.toString(tmp) + ", " + String.valueOf(left) + ", " + String.valueOf(center) + ")");
            sort(array, tmp, left, center);         //sort left  side
            System.out.println("left sort return " + Arrays.toString(array) + ", " + Arrays.toString(tmp));

            //System.out.println("right sort(" + Arrays.toString(array) + ", " + Arrays.toString(tmp) + ", " + String.valueOf(center) + "+1, " + String.valueOf(right) + ")");
            sort(array, tmp, center + 1, right);      //sort right side
            System.out.println("right sort return " + Arrays.toString(array) + ", " + Arrays.toString(tmp));

            //System.out.println("merge(" + Arrays.toString(array) + ", " + Arrays.toString(tmp) + ", " + String.valueOf(left) + ", " + String.valueOf(center) + ", " + String.valueOf(right) + ")");
            merge(array, tmp, left, center + 1, right);
            System.out.println("merge return " + Arrays.toString(array) + ", " + Arrays.toString(tmp));
        }
    }

    public static void merge(int[] a, int[] tmp, int left, int center, int rightEnd)
    {

        int leftEnd = center - 1;
        int key = left;
        int num = rightEnd - left + 1;

        while(left <= leftEnd && center <= rightEnd) {

            if(a[left] < a[center])
                tmp[key++] = a[left++];
            else
                tmp[key++] = a[center++];
        }

        while(left <= leftEnd)          //copy rest of left half
            tmp[key++] = a[left++];

        while(center <= rightEnd)       //copy rest of right half
            tmp[key++] = a[center++];

        //copy tmp back
        for(int i = 0; i < num; i++, rightEnd--) {
            a[rightEnd] = tmp[rightEnd];
        }
    }
}
import java.util.Arrays;

/*
* EINGABE: Folge A; Indexgrenzen l und r (falls l >= r ist nichts zu tun)
* AUSGABE: sortierte Teilfolge in A[l],...,A[r]
* VARIABLE(n): Index middle
*
* 1: if l < r then {
* 2:    middle = [(l+r)/2];
* 3:    Merge-Sort(A,l,middle);
* 4:    Merge-Sort(A,middle+l,r);
* 5:    Merge(A,l,middle,r);
* 6: }
*
* */

public class MergeSort {

    public static void main(String[] args)
    {
        int[] array = {14,3,5,12,7,2,19,12,1};
        sort(array);
        System.out.println(Arrays.toString(array));

    }

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
            //System.out.println("left sort return " + Arrays.toString(array) + ", " + Arrays.toString(tmp));

            //System.out.println("right sort(" + Arrays.toString(array) + ", " + Arrays.toString(tmp) + ", " + String.valueOf(center) + "+1, " + String.valueOf(right) + ")");
            sort(array, tmp, center + 1, right);      //sort right side
            //System.out.println("right sort return " + Arrays.toString(array) + ", " + Arrays.toString(tmp));

            //System.out.println("merge(" + Arrays.toString(array) + ", " + Arrays.toString(tmp) + ", " + String.valueOf(left) + ", " + String.valueOf(center) + ", " + String.valueOf(right) + ")");
            merge(array, tmp, left, center + 1, right);
            //System.out.println("merge return " + Arrays.toString(array) + ", " + Arrays.toString(tmp));

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


/*
 	left sort([5, 2, 4, 7, 6, 1, 8, 3], [0, 0, 0, 0, 0, 0, 0, 0], 0, 3)
	left sort([5, 2, 4, 7, 6, 1, 8, 3], [0, 0, 0, 0, 0, 0, 0, 0], 0, 1)

            merge([5, 2, 4, 7, 6, 1, 8, 3], [0, 0, 0, 0, 0, 0, 0, 0], 0, 0, 1)
     merge return [2, 5, 4, 7, 6, 1, 8, 3], [2, 5, 0, 0, 0, 0, 0, 0]

       right sort([2, 5, 4, 7, 6, 1, 8, 3], [2, 5, 0, 0, 0, 0, 0, 0], 1+1, 3)
            merge([2, 5, 4, 7, 6, 1, 8, 3], [2, 5, 0, 0, 0, 0, 0, 0], 2, 2, 3)
     merge return [2, 5, 4, 7, 6, 1, 8, 3], [2, 5, 4, 7, 0, 0, 0, 0]

            merge([2, 5, 4, 7, 6, 1, 8, 3], [2, 5, 4, 7, 0, 0, 0, 0], 0, 1, 3)
     merge return [2, 4, 5, 7, 6, 1, 8, 3], [2, 4, 5, 7, 0, 0, 0, 0]

       right sort([2, 4, 5, 7, 6, 1, 8, 3], [2, 4, 5, 7, 0, 0, 0, 0], 3+1, 7)
        left sort([2, 4, 5, 7, 6, 1, 8, 3], [2, 4, 5, 7, 0, 0, 0, 0], 4, 5)

            merge([2, 4, 5, 7, 6, 1, 8, 3], [2, 4, 5, 7, 0, 0, 0, 0], 4, 4, 5)
     merge return [2, 4, 5, 7, 1, 6, 8, 3], [2, 4, 5, 7, 1, 6, 0, 0]

       right sort([2, 4, 5, 7, 1, 6, 8, 3], [2, 4, 5, 7, 1, 6, 0, 0], 5+1, 7)
            merge([2, 4, 5, 7, 1, 6, 8, 3], [2, 4, 5, 7, 1, 6, 0, 0], 6, 6, 7)
     merge return [2, 4, 5, 7, 1, 6, 3, 8], [2, 4, 5, 7, 1, 6, 3, 8]
right sort return [2, 4, 5, 7, 1, 6, 3, 8], [2, 4, 5, 7, 1, 6, 3, 8]

            merge([2, 4, 5, 7, 1, 6, 3, 8], [2, 4, 5, 7, 1, 6, 3, 8], 4, 5, 7)
     merge return [2, 4, 5, 7, 1, 3, 6, 8], [2, 4, 5, 7, 1, 3, 6, 8]
right sort return [2, 4, 5, 7, 1, 3, 6, 8], [2, 4, 5, 7, 1, 3, 6, 8]
            merge([2, 4, 5, 7, 1, 3, 6, 8], [2, 4, 5, 7, 1, 3, 6, 8], 0, 3, 7)

     merge return [1, 2, 3, 4, 5, 6, 7, 8], [1, 2, 3, 4, 5, 6, 7, 8]
                  [1, 2, 3, 4, 5, 6, 7, 8]

* */
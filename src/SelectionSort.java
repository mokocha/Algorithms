/**

 EINGABE: Folge in Feld A
 AUSGABE: sortierte Folge in Feld A
 VARIABLE: indizes minpos,i,j

 1:  for j = 1,2,...,n-1 {
 2:    //Bestimme Position des Minimums aus A[j],...,A[n]
 3:    minpos = j;
 4:    for i = j + 1,...,n {
 5:        if A[i].key < A[minpos].key then {
 6:            minpos = i;
 7:        }
 8:    }
 9:    if minpos > j then {
 10:       Vertausche A[minpos] mit A[j];
 11:   }
 12: }

 */

public class SelectionSort {

    static int step = 0;

    public static int[] sort(int[] array) {

        int minpos,n;

        n = array.length;

        for(int j = 0; j < n;j++) {
            minpos = j; //points to the lowest value found

            for(int i=j+1;i < n;i++) { //finds the lowest value in the array
                if(array[minpos] > array[i]) { //compare this key with the next
                    minpos = i; //if the next value is lower, point 'minpos' on that value
                }
            }

            if(minpos > j) { //if the minimal value key has higher index than our current iteration, switch
                int temp = array[j];
                array[j] = array[minpos];
                array[minpos] = temp;
            }
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

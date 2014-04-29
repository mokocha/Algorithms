import com.sun.xml.internal.bind.v2.model.annotation.Quick;

public class Test {

    public static void main(String[] args) {
      //int[] i = {5,6,8,7,3,2,1,4};
      //int[] i = {8,6,7,3,4,5,2,1};
      //int[] x = {111,11,1,1,110,111,1};
      int[] a = {50,60,80,70,10,40,30,20};

      //MergeSort.sort(i);
      //HeapSort.sort(x);
      QuickSort.sort(a);
    }
}

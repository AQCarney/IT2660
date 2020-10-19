package Assignment6;

public class MergeSort {
    public static void mergeSort(int[] sort){
        if (sort.length > 1){
            int[] oneHalf = new int[sort.length /2];
            System.arraycopy(sort,0, oneHalf, 0, sort.length / 2);
            mergeSort(oneHalf);

            int otherHalfLenght = sort.length - sort.length /2;
            int[] otherhalf = new int[otherHalfLenght];
            System.arraycopy(sort, sort.length / 2, otherhalf, 0, otherHalfLenght);
            mergeSort(otherhalf);

            merge(oneHalf, otherhalf, sort);
        }
    }

    private static void merge(int[] oneHalf, int[] otherhalf, int[] sort) {
    }
    
}
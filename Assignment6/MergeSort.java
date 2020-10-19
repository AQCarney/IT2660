package Assignment6;

public class MergeSort {
    void merge(int arr[], int a, int b, int c){
        int n1 = b - a + 1;
        int n2 = c - b;

        int L [] = new int[n1];
        int R [] = new int[n2];

        for (int i = 0; i < n1; i++)
        L[i] = arr[a + i];
        for (int j = 0; j < n2; j++)
        R[j] = arr[b + 1 + j];

        int i = 0, j =0;

        int k = a;
        while (i < n1 && j < n2){
            if (L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    
}
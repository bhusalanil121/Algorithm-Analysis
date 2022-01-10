/**
 * Name: Anil Bhusal 
 * CSC 22000
 * Programming project #1
 * 
 */


package csc220project;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Csc220Project {
 
public static void main(String[] args){
    long startTime, compileTime;
    int input; 
    do{
    Scanner Obj = new Scanner(System.in);
            menu(); 
     System.out.print("Please select one of the sorting option or press -1 to exit: ");
      input = Obj.nextInt();
    switch(input){
        case 1:
            System.out.print("Enter the array size for Insertion sort: ");
            int n = Obj.nextInt();
            int A[] = new int[n];
            fillArray(A);
            startTime = System.nanoTime();
            insertionSort(A);
            compileTime = System.nanoTime() - startTime;
            System.out.println("Compile time: " + compileTime +" nanoseconds \n");     
            break;
        
        case 2:
            System.out.print("Enter the array size for Merge sort: ");
            int n1 = Obj.nextInt();
            int A1[] = new int[n1];
            fillArray(A1);
            startTime = System.nanoTime();
            mergeSort(A1);
            compileTime = System.nanoTime() - startTime;
            System.out.println("Compile time: " + compileTime +" nanoseconds\n");     
            break;
        
        case 3:
            System.out.print("Enter the array size for Heap sort: ");
            int n2 = Obj.nextInt();
            int A2[] = new int[n2];          
            fillArray(A2);
            startTime = System.nanoTime();
            heapSort(A2);
            compileTime = System.nanoTime() - startTime;
            System.out.println("Compile time: " + compileTime +" nanoseconds\n");     
            break;
            
        case 4:
            System.out.print("Enter the array size for Quick sort: ");
            int n3 = Obj.nextInt();            
            int A3[] = new int[n3];
            fillArray(A3);
            startTime = System.nanoTime();
            quickSort(A3);
            compileTime = System.nanoTime() - startTime;
            System.out.println("Compile time: " + compileTime +" nanoseconds\n");     
            break;
        
        case 5:
           
            System.out.print("Enter the array size for Quick sort with random pivot: ");
            int n4 = Obj.nextInt();
            int A4[] = new int[n4];
            fillArray(A4);
            startTime = System.nanoTime();
            quickSortRandom(A4);
            compileTime = System.nanoTime() - startTime;
            System.out.println("Compile time: " + compileTime +" nanoseconds\n");     
            break;
        
        case 6:
            System.out.print("Enter the array size for Radix sort: ");
            int n5 = Obj.nextInt();
            int A5[] = new int[n5];
            fillArray(A5);
            startTime = System.nanoTime();
            radixsort(A5);
            compileTime = System.nanoTime() - startTime;
            System.out.println("Compile time: " + compileTime +" nanoseconds\n");     
            break;
        
        case -1:
            System.out.println("You choose to exit the program !!!!");
            break;
            
  
        default: 
            System.out.println("You entered an invalid choice. Please choose correctly!!!! \n");
    }      
                 
    }
    while (input!=-1);
  
    
             
   }

public static void menu(){
    System.out.println("Menu for Sorting");
    System.out.println("1. Insertion Sort");
    System.out.println("2. Merge Sort");
    System.out.println("3. Heap Sort");
    System.out.println("4. Quick Sort");
    System.out.println("5. Quick Sort with random pivot");
    System.out.println("6. Radix Sort"); 
}

 
public static void fillArray(int A[]) {
    int size = A.length;
    Random R = new Random();
    for(int i=0; i<size; i++){
    A[i] = R.nextInt(1000000) + 1;
            }
     }

    //Insertion Sort 
    public static void insertionSort(int A[]){
       int size = A.length;
      int key,j;
      for(int i=1;i<size; i++){
            key = A[i];
            j=i-1;
       while(j>=0 && A[j]>key){
            A[j+1]=A[j];
            j=j-1;
            }
       A[j+1]=key;
      } 
    }
    
  
    
    //Merge Sort
    public static void mergeSort(int A[]) {
        mergeSort(A, 0, A.length - 1);
        }

    private static void mergeSort(int[] A, int left, int right) {
        if (left < right) {
           int mid = (left + right) / 2;
           mergeSort(A, left, mid);
           mergeSort(A, mid + 1, right);
           merge(A, left, mid, right);
           }
    }

    private static void merge(int A[], int left, int mid, int right) {
        int L = mid - left + 1;
        int R = right - mid;
        int leftArray[] = new int[L];
        int rightArray[] = new int[R];

     for(int i=0; i<L;i++){
         leftArray[i] = A[left + i];
          }
    for(int i=0; i<R;i++) {
      rightArray[i] = A[mid + i + 1];
       }
    int i = 0, j = 0, k = left;
    while (i < L && j < R) {
        if (leftArray[i] < rightArray[j]) {
            A[k] = leftArray[i];
            i++;
            }
        else {A[k] = rightArray[j]; j++;
        }
          k++;
        }
    
    while (i < L) { A[k] = leftArray[i];
        i++; k++;
      }
    while (j < R) {
        A[k] = rightArray[j];
        k++;
        j++;
    }
 }

// Heap sort
public static void heapSort(int[] A) {
   int size = A.length;
       for (int i=size/2 - 1; i >= 0; i--){
            maxHeapify(A, size, i);
                }
        for (int i = size - 1; i >= 0; i--) {
            swap(A, 0, i);
            maxHeapify(A, i, 0);
                }
        }

private static void maxHeapify(int[] A, int n, int i) {
    int largest = i;
    int left = 2*i + 1;
    int right = 2*i+2;
        if (left < n && A[left] > A[largest]) {
            largest = left;
                }

        if (right < n && A[right] > A[largest]) {
             largest = right;
               }

        if (largest != i) {
            swap(A, i, largest);
            maxHeapify(A, n, largest);
                }
        }
    
// Quick sort
public static void quickSort(int A[]) {
    int size = A.length;
      quickSort(A, 0, size- 1);
        }

private static void quickSort(int A[], int first, int last) {
    if (first < last) {
       int part = partition(A, first, last);
       quickSort(A, first, part - 1);
       quickSort(A, part + 1, last);
    }
}

private static int partition(int[] A, int first, int last) {
   int pivot = A[last];
   int j = first-1;
   for (int i = first; i < last; i++) {
    if (A[i] < pivot) {
        j = j + 1;
        swap(A,i,j);
    }
   }
    j = j + 1;
   swap(A, j, last);
   return j;
  }
    
// Quick sort with random pivot
public static void quickSortRandom(int A[]) {
    int size = A.length;
    quickSortRandom(A, 0, size -1);
        }
private static void quickSortRandom(int A[], int left, int right){
     if (left  < right) {
       int p = partitionR(A, left, right);
        quickSortRandom(A, left, p - 1);
        quickSortRandom(A, p + 1, right);
            }
        }

private static int partitionR(int A[], int left, int right) {
    
Random rand = new Random();
int pivotIndex = left + rand.nextInt(right - left + 1);
swap(A, pivotIndex, right);

    int pivot = A[right];
    int leftPtr = left - 1;
    int rightPtr = right;
    
    while (true) {
      while (A[++leftPtr] < pivot);
      while (rightPtr > 0 && A[--rightPtr] > pivot);
        if (leftPtr >= rightPtr)
           break;
        else
           swap(A, leftPtr, rightPtr);
             }
    swap(A, leftPtr, right);
        return leftPtr;
       }
// Radix Sort
public static void radixsort(int[] A) {
    int size = A.length;
    radixsort(A,size);
        }

private static void radixsort(int A[], int size) {
     int m=getMax(A, size);

    for (int exp = 1; m/exp > 0; exp *= 10)
           countSort(A, size, exp);
        }

private static void countSort(int A[], int size, int exp) {
        int output[] = new int[size];
        int j;
        int count[] = new int[10];
        Arrays.fill(count, 0);

    for (j = 0; j < size; j++){
    count[(A[j] / exp) % 10]++;
    }
    
    for (j = 1; j < 10; j++){
    count[j] += count[j - 1];
    }
    
    for (j = size - 1; j >= 0; j--) {
    output[count[(A[j] / exp) % 10] - 1] = A[j];
    count[(A[j] / exp) % 10]--;
        }
    for (j = 0; j < size; j++)
    A[j] = output[j];
        }

   private static int getMax(int A[], int size) {
                int max = A[0];
                for (int i = 1; i < size; i++)
                        if (A[i] > max)
                                max = A[i];
                return max;
        }
   
   
// swaping
private static void swap(int[] A, int a, int b) {
    int temp = A[a]; 
    A[a]=A[b];
    A[b]=temp; 
    }
}

//End of the program

























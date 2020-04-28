package sorting;

import java.util.Arrays;

public class InsertionSort {

    public static  <T extends Comparable<T>> void sort(T[] elems){
        for(int i =1;i< elems.length;i++){
            int cursor = i;
            while(cursor> 0&& elems[cursor-1].compareTo(elems[cursor]) > 0){
                T temp = elems[cursor];
                elems[cursor] = elems[cursor-1];
                elems[cursor-1] = temp;
                cursor--;
            }
        }
    }

    public static void main(String[] args) {
        Character[] chars = new Character[] { 'b', 'c','a'};
        Double[] doubles = {0.35, 0.02, 0.36, 0.82, 0.27, 0.49, 0.41, 0.17, 0.30, 0.89, 0.37, 0.66, 0.82, 0.17, 0.20, 0.96, 0.18, 0.25, 0.37, 0.52};

        printAndSort(chars);
        printAndSort(doubles);
    }

    private static <T extends Comparable<T>> void printAndSort(T[] elems) {
        System.out.println("Before sort: " + Arrays.toString( elems));
        sort(elems);
        System.out.println("After sort: " +Arrays.toString(elems));
    }
}

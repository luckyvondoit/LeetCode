package Algorithm.Sorting;

import java.util.Arrays;

import Algorithm.Sorting.Sort.Sort;
import Algorithm.Sorting.Sort.CountingSort;
import Algorithm.Sorting.Sort.RadixSort;
import Algorithm.Sorting.Sort.BubbleSort3;
import Algorithm.Sorting.Sort.HeapSort;
import Algorithm.Sorting.Sort.InsertionSort3;
import Algorithm.Sorting.Sort.MergeSort;
import Algorithm.Sorting.Sort.QuickSort;
import Algorithm.Sorting.Sort.SelectionSort;
import Algorithm.Sorting.Sort.ShellSort;
import Algorithm.Sorting.Tool.Asserts;
import Algorithm.Sorting.Tool.Integers;

@SuppressWarnings({"rawtypes", "unchecked", "unused"})
public class Main {

	public static void main(String[] args) {
		Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8};
		
		testSorts(array, 
//				new RadixSort()
//				new InsertionSort1(),
//				new InsertionSort2(),
//				new InsertionSort3(),
//				new SelectionSort(), 
//				new HeapSort(), 
//				new MergeSort(),
				new BubbleSort3()
//				new QuickSort(),
//				new ShellSort()
				);
	}
	
	static void testSorts(Integer[] array, Sort... sorts) {
		for (Sort sort : sorts) {
			Integer[] newArray = Integers.copy(array);
			sort.sort(newArray);
			Asserts.test(Integers.isAscOrder(newArray));
		}
		Arrays.sort(sorts);
		
		for (Sort sort : sorts) {
			System.out.println(sort);
		}
	}
	
//	static void selectionSort(Integer[] array) {
//		for (int end = array.length - 1; end > 0; end--) {
//			int maxIndex = 0;
//			for (int begin = 1; begin <= end; begin++) {
//				if (array[maxIndex] <= array[begin]) {
//					maxIndex = begin;
//				}
//			}
//			int tmp = array[maxIndex];
//			array[maxIndex] = array[end];
//			array[end] = tmp;
//		}
//		
//		// 8 10 9 10 
//	}
//	
//	static void bubbleSort1(Integer[] array) {
//		for (int end = array.length - 1; end > 0; end--) {
//			for (int begin = 1; begin <= end; begin++) {
//				if (array[begin] < array[begin - 1]) {
//					int tmp = array[begin];
//					array[begin] = array[begin - 1];
//					array[begin - 1] = tmp;
//				}
//			}
//		}
//	}
//	
//	static void bubbleSort2(Integer[] array) {
//		for (int end = array.length - 1; end > 0; end--) {
//			boolean sorted = true;
//			for (int begin = 1; begin <= end; begin++) {
//				if (array[begin] < array[begin - 1]) {
//					int tmp = array[begin];
//					array[begin] = array[begin - 1];
//					array[begin - 1] = tmp;
//					sorted = false;
//				}
//			}
//			if (sorted) break;
//		}
//	}
//
//	static void bubbleSort3(Integer[] array) {
//		for (int end = array.length - 1; end > 0; end--) {
//			// sortedIndex????????????????????????????????????????????????
//			int sortedIndex = 1;
//			for (int begin = 1; begin <= end; begin++) {
//				if (array[begin] < array[begin - 1]) {
//					int tmp = array[begin];
//					array[begin] = array[begin - 1];
//					array[begin - 1] = tmp;
//					sortedIndex = begin;
//				}
//			}
//			end = sortedIndex;
//		}
//	}
}

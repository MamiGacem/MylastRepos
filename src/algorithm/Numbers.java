package algorithm;

import databases.ConnectToMongoDB;
import databases.ConnectToSqlDB;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Numbers {

	/*
	 * Show all the different kind of sorting algorithm by applying into (num array).
	 * Display the execution time for each sorting.Example in below.
	 *
	 * Use any databases[MongoDB, Oracle or MySql] to store data and retrieve data.
	 *
	 * At the end. After running all the sorting algo, come to a conclusion which one is suitable on given data set.
	 *
	 */

	public static void main(String[] args) throws Exception {
		
		int [] num = new int[1000000];
		storeRandomNumbers(num);
		ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();

		//Selection Sort
		Sort algo = new Sort();
		algo.selectionSort(num);
		long selectionSortExecutionTime = algo.executionTime;
		System.out.println("Total Execution Time of "+ num.length + " numbers in Selection Sort take: " + selectionSortExecutionTime + " milli sec");
        connectToSqlDB.insertDataFromArrayToSqlTable(num, "selection_sort", "SortingNumbers");
        List<String> numbers = connectToSqlDB.readDataBase("selection_sort", "SortingNumbers");
        printValue(numbers);
		int n = num.length;
		randomize (num, n);

		//Insertion Sort
		algo.insertionSort(num);
		long insertionSortExecutionTime = algo.executionTime;
		System.out.println("Total Execution Time of " + num.length + " numbers in Insertion Sort take: " + insertionSortExecutionTime + " milli sec");
		connectToSqlDB.insertDataFromArrayToSqlTable(num, "insertion_sort", "SortingNumbers");
		List<String> number = connectToSqlDB.readDataBase("insertion_sort", "SortingNumbers");
		printValue(numbers);
		int a1 = num.length;
		randomize (num, a1);

// bubble Sort
		algo.bubbleSort(num);
		long bobbleSortExecutionTime = algo.executionTime;
		System.out.println("Total Execution Time of " + num.length + " numbers in Bobble Sort take: " + bobbleSortExecutionTime + " milli sec");
		connectToSqlDB.insertDataFromArrayToSqlTable(num, "bobble_sort", "SortingNumbers");
		List<String> number1 = connectToSqlDB.readDataBase("bobble_sort", "SortingNumbers");
		printValue(numbers);
		int a2 = num.length;
		randomize (num, a2);

	// merge sort
		algo.mergeSort(num);
		long mergeSortExecutionTime = algo.executionTime;
		System.out.println("Total Execution Time of " + num.length + " numbers in Merge Sort take: " + mergeSortExecutionTime + " milli sec");
		connectToSqlDB.insertDataFromArrayToSqlTable(num, "merge_sort", "SortingNumbers");
		List<String> number2 = connectToSqlDB.readDataBase("merge_sort", "SortingNumbers");
		printValue(numbers);
		int a3 = num.length;
		randomize (num, a3);

		//quickSort
		algo.quickSort(num);
		long quickSortExecutionTime = algo.executionTime;
		System.out.println("Total Execution Time of " + num.length + " numbers in quick Sort take: " + quickSortExecutionTime + " milli sec");
		connectToSqlDB.insertDataFromArrayToSqlTable(num, "quick_sort", "SortingNumbers");
		List<String> number3 = connectToSqlDB.readDataBase("quick_sort", "SortingNumbers");
		printValue(numbers);
		int a4 = num.length;
		randomize (num, a4);

		//heapSort
		algo.heapSort(num);
		long heapSortExecutionTime = algo.executionTime;
		System.out.println("Total Execution Time of " + num.length + " numbers in heap Sort take: " + heapSortExecutionTime + " milli sec");
		connectToSqlDB.insertDataFromArrayToSqlTable(num, "heap_sort", "SortingNumbers");
		List<String> number4 = connectToSqlDB.readDataBase("heap_sort", "SortingNumbers");
		printValue(numbers);
		int a5= num.length;
		randomize (num, a5);

		//bucketSort
		algo.bucketSort(num);
		long bucketSortExecutionTime = algo.executionTime;
		System.out.println("Total Execution Time of " + num.length + " numbers in bucket Sort take: " + bucketSortExecutionTime + " milli sec");
		connectToSqlDB.insertDataFromArrayToSqlTable(num, "bucket_sort", "SortingNumbers");
		List<String> number5= connectToSqlDB.readDataBase("bucket_sort", "SortingNumbers");
		printValue(numbers);
		int a6= num.length;
		randomize (num, a6);

		//shellSort
		algo.shellSort(num);
		long shellSortExecutionTime = algo.executionTime;
		System.out.println("Total Execution Time of " + num.length + " numbers in shell Sort take: " + shellSortExecutionTime + " milli sec");
		connectToSqlDB.insertDataFromArrayToSqlTable(num, "shell_sort", "SortingNumbers");
		List<String> number6= connectToSqlDB.readDataBase("shell_sort", "SortingNumbers");
		printValue(numbers);
		int a7= num.length;
		randomize (num, a7);


	}


	public static void storeRandomNumbers(int [] num){
		Random rand = new Random();
		for(int i=0; i<num.length; i++){
			num[i] = rand.nextInt(1000000);
		}
	}

	public static void randomize( int arr[], int n)
	{
		Random r = new Random();
		// Start from the last element and swap one by one. We don't
		// need to run for the first element that's why i > 0
		for (int i = n-1; i > 0; i--) {
			int j = r.nextInt(i);
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		System.out.println(Arrays.toString(arr));
	}


	public static void printValue(List<String> array){
		for(String st:array){
			System.out.println(st);
		}
		ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();

		Assert.assertEquals("", "");

	}
}

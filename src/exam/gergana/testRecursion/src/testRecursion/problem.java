package testRecursion;

import java.util.Scanner;

public class problem {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = new int[n];
		System.out.println("Input elements :");
		input(arr, 0);
		System.out.println("input k :");
		int k = scan.nextInt();
		
		int minElement = minElementK68(arr, arr.length, k);
		
		if (minElement == -1)
		{
			System.out.println("no");
		}
		else
		{
			System.out.println("min correct number : " + minElement);
		}
		
		minElement = min(arr, arr.length);
		System.out.println("Min Element digits: ");
		printMinElementLetters(minElement);
		
		System.out.println("new arr:");
		printNewArr(arr, k, 0);
	}
	public static void input(int[] arr, int i)
	{
		Scanner scanner = new Scanner(System.in);
		if (i == arr.length)
			return;
		
		int value = scanner.nextInt();
		arr[i] = value;
		input(arr, i + 1);
	}
	
	public static int minElementK68(int[] arr, int index, int k)
	{
		if (index == 1)
			return arr[0];
		
		int currentMin = minElementK68(arr, index - 1, k);
		
		if(arr[index-1] < currentMin && (arr[index - 1] % 2 == 0 && (arr[index - 1] % 3==0 || arr[index - 1] % 4 == 0)))
			return arr[index-1];
		else return currentMin;
	
	}
	
	public static int min(int[] arr, int n)
	{
		if (n == 1)
			return arr[0];
		
		int currentMin = min(arr, n - 1);
		
		if(arr[n-1] < currentMin)
			return arr[n-1];
		else return currentMin;
	}
	
	public static void printMinElementLetters(int minElement) 
	{
		if (minElement == 0)
			return;
		
		printMinElementLetters(minElement / 10);
		System.out.println(minElement % 10);
	}
	
	public static void printNewArr(int arr[], int k, int index) 
	{
		if (index == arr.length)
			return;
		
		arr[index] *= k;
		System.out.println(arr[index]);
		printNewArr(arr, k, index + 1);
	}
	
}

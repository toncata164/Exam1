package edu;

import java.util.Scanner;

public class RecursionExam {

	public static void main(String[] args) 
	{
		
		int[] arr = {2, 6, 9, 10, 12};
		findGreatest(arr, 1, 2);
		findSmallest(arr, 1);

	}
	
	public static void findGreatest(int[] arr, int index, int k)
	{
		if(index > arr.length)
		{
			return;
		}
		int max = arr[0];	
		if(arr[index] > max && arr[index]%k == 0)
		{
			arr[index] = max;
			findGreatest(arr, index+1, k);
			System.out.println(max);
		}
		else
		{
			System.out.println("NO");
		}
	}
	
	public static void findSmallest(int[] arr, int index)
	{
		if(index > arr.length)
		{
			return;
		}
		int min = arr[0];
		if(arr[index] < min && arr[index]%10 == 0)
		{
			arr[index] = min;
			findSmallest(arr, index+1);
			System.out.println(min);
		}
		
	}
	
	public static void allElements(int[] arr, int index)
	{
		if(arr[index] < 10)
		{
			return;
		}

	}

}

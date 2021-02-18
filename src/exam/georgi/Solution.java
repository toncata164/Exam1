package exam.georgi;

import java.util.Arrays;
import java.util.Scanner;

public class Solution
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
	
		int[] arr = createArray(scan);
		
		System.out.print("Enter k = ");
		int k = scan.nextInt();
		
		int maxIndex = findMaxIndex(arr, -1, 0, k);
		
		String result = maxIndex >= 0 
				? Integer.toString(arr[maxIndex]) : "NO";

		System.out.print("Max item: " + result);
		
		int minKDigit = Integer.toString(k).charAt(0) - '0';
		minKDigit = minDigit(Integer.toString(k), minKDigit, 0);
		
		int minIndex = findMinIndex(arr, -1, 0, Integer.toString(minKDigit));
		
		result = minIndex >= 0 
				? Integer.toString(arr[minIndex]) : "NO";
		
		System.out.println("\nMin item: " + result);
		
		mapArrToBinary(arr, 0);
		
		System.out.println("Array final state: ");
		System.out.println(Arrays.toString(arr));
		
		scan.close();
	}

	static void mapArrToBinary(int[] arr, int index)
	{
		if (index < arr.length)
		{
			String item = Integer.toBinaryString(arr[index]);
			arr[index] *= item.charAt(item.length() - 1) - '0';
			mapArrToBinary(arr, index + 1);
		}
	}
	
	static int findMinIndex(int[] arr, int minIndex, int currentIndex, String minKDigit)
	{
		if (currentIndex < arr.length)
		{
			int current = arr[currentIndex];
			
			if (Integer.toString(current).contains(minKDigit))
			{
				if (minIndex < 0)
				{
					minIndex = currentIndex;
				}
				else if (minIndex >= 0 && arr[minIndex] > current)
				{
					minIndex = currentIndex;
				}
			}
			
			return findMinIndex(arr, minIndex, currentIndex + 1, minKDigit);
		}
		
		return minIndex;
	}
	
	static int minDigit(String number, int min, int index)
	{
		if (index < number.length())
		{
			int current = number.charAt(index) - '0';
			
			if (min > current)
			{
				min = current;
			}
			
			return minDigit(number, min, index + 1);
		}
		
		return min;
	}
	
	static int findMaxIndex(int[] arr, int maxIndex, int currentIndex, int k)
	{
		if (currentIndex < arr.length)
		{
			int current = arr[currentIndex];
					
			if (current % k == 0 && 
					Integer.toString(current).contains("7"))
			{
				if (maxIndex < 0)	
				{
					maxIndex = currentIndex;				
				}
				else if (maxIndex >= 0 && current > arr[maxIndex])
				{
					maxIndex = currentIndex;
				}
			}		
					
			return findMaxIndex(arr, maxIndex, currentIndex + 1, k);
		}
		
		return maxIndex;
	}
	
	static int[] createArray(Scanner scan)
	{
		System.out.print("Enter n: ");
		int n = scan.nextInt();
		int[] arr = new int[n];
		readNextItem(arr, 0, scan);
		return arr;
	}
	
	static void readNextItem(int[] arr, int index, Scanner scan)
	{
		if (index < arr.length)
		{
			System.out.print("[" + index + "] = ");
			arr[index] = scan.nextInt();
			readNextItem(arr, index + 1, scan);
		}
	}
}

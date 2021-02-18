package exam.yova;

import java.util.Scanner;

public class SecondProblem {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		//create and fill your array
		System.out.println("Enter the size of your array: ");
		int n = input.nextInt();
		int[] arr = new int[n];
		initialiseArray(arr, n, 0, input);
		//choose your k
		System.out.println("Eenter k: ");
		int k = input.nextInt();
		//check the work of findSmallestK
		findSmallestK(arr, k, 0, -1);
		//check the work of findBiggestTwo
		findBiggestTwo(arr, 0, -1);
		//check the work of printNumbers
		printNumbers(arr, 0);
		
;	}
	
	public static void initialiseArray(int[] arr, int n, int index, Scanner input)
	{
		//this method initializes an array
		if(index == n)
		{
			return;
		}
		System.out.println("Enter an element of your array: ");
		arr[index] = input.nextInt();
		initialiseArray(arr, n, index + 1, input);
	}
	
	public static void findSmallestK(int[] arr, int k, int index, int currentValue)
	{
		//this method finds and prints the smallest array element
		//which is divisible by k and is greater than or equal to k * 2 + 7
		//if such exists. If not it prints "NO"
		if(index == arr.length)
		{
			if(currentValue == - 1)
			{
				System.out.println("NO");
			}
			else
				System.out.println(currentValue);
			return;
		}
		if(arr[index] % k == 0 && (arr[index] >= (k * 2 + 7)))
			{
				if(arr[index] < currentValue || currentValue == -1)
				{
					currentValue = arr[index];
				}
			}
		findSmallestK(arr, k, index + 1, currentValue);
	}
	
	public static void findBiggestTwo(int[] arr, int index, int currentValue)
	{
		//this method finds and prints the biggest element of the array which contains
		//the digit 2, if such exists. If not, it prints "NO"
		if(index == arr.length)
		{
			if(currentValue == -1)
				System.out.println("NO");
			else
			{
				System.out.println(currentValue);
			}
			return;
		}
		if(checkForTwo(arr[index]))
		{
			if(arr[index] > currentValue || currentValue == -1)
			{
				currentValue = arr[index];
			}
		}
		findBiggestTwo(arr, index + 1, currentValue);
	}
	
	private static boolean checkForTwo(int a)
	{
		//this method checks if a number has the digit 2 in itself
		if(a == 0)
		{
			return false;
		}
		if(a == 2)
		{
			return true;
		}
		if(a / 10 == 2)
		{
			return true;
		}
		if(a % 10 == 2)
		{
			return true;
		}
		return checkForTwo(a / 10);
		
	}
	
	public static void printNumbers(int[] arr, int index)
	{
		//this method prints all the elements in the array
		//multiplied by their biggest digit
		if(index == arr.length)
		{
			return;
		}
		System.out.println(arr[index] + " * " + findBiggestDigit(arr[index], 0) + " = " + arr[index] * findBiggestDigit(arr[index], 0));
		printNumbers(arr, index + 1);
	}
	
	private static int findBiggestDigit(int a, int k)
	{
		//this method finds and returns the biggest digit in the number a
		if(a == 0)
		{
			return k;
		}
		if(a % 10 > k)
		{
			k = a % 10;
		}
		return findBiggestDigit(a / 10, k);
	}
	

}

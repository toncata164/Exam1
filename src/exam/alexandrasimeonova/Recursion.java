package exam.alexandrasimeonova;

import java.util.Scanner;

public class Recursion {
	public static void main(String[] args)
	{
		int n;
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		int[] arr = new int[n];
		input(arr, 0, input);
		int k = input.nextInt();
		int resultFirst = first(arr, 0, -1, k);
		if(resultFirst != -1)
		{
			System.out.println(arr[resultFirst]);
		}
		else
		{
			System.out.println("NO");
		}
		int resultSecond = second(arr, 0, -1);
		if(resultSecond != -1)
		{
			System.out.println(arr[resultSecond]);
		}
		else
		{
			System.out.println("NO");
		}
		print(arr, 0);
	}
	
	public static void input(int[] arr, int index, Scanner in)
	{
		if(arr.length == index)
			return;
		arr[index] = in.nextInt();
		input(arr, index+1, in);
	}
	
	public static int first(int[] arr, int index, int indexOfMax, int k)
	{
		if(index == arr.length)
			return indexOfMax;
		if(arr[index] % k == 0)
		{
			if(indexOfMax != -1)//if not invalid
				if(arr[index] > arr[indexOfMax])
				{
					return first(arr, index+1, index, k);
				}
				else
				{
					return first(arr, index+1, indexOfMax, k);
				}
			else
			{
				return first(arr, index+1, index, k);
			}
		}
		else
		{
			return first(arr, index+1, indexOfMax, k);
		}
	}
	
	public static boolean hasZero(int n)
	{
		return hasZero(n, true);
	}
	
	public static boolean hasZero(int n, boolean isFirstTimeCalled)
	{
		if(n == 0 && isFirstTimeCalled)
			return true;
		if(n == 0 && !isFirstTimeCalled)
			return false;
		if(n%10 == 0)
			return true;
		return hasZero(n/10, false);
	}
	
	public static int second(int[] arr, int index, int indexOfMin)
	{
		if(arr.length == index)
			return indexOfMin;
		if(hasZero(arr[index]))
		{
			if(indexOfMin != -1)
				if(arr[index] < arr[indexOfMin])
				{
					return second(arr, index+1, index);
				}
				else
				{
					return second(arr, index+1, indexOfMin);
				}
			else
			{
				return second(arr, index+1, index);
			}
		}
		else
		{
			return second(arr, index+1, indexOfMin);
		}
	}
	public static int smallestDigit(int n, int smallest)
	{
		if(n == 0)
			return smallest;
		if(n%10 < smallest && n%10 > 0)
			return smallestDigit(n/10, n%10);
		return smallestDigit(n/10, smallest);
	}
	
	public static void print(int[] arr, int index)
	{
		if(arr.length == index)
			return;
		int s = smallestDigit(arr[index], 10);
		if(s == 10)
		{
			System.out.println(arr[index]);
		}
		else
		{
			System.out.println(arr[index]*s);
		}
		print(arr, index+1);
	}
}

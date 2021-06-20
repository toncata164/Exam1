package exam.alexandrasimeonova;

import java.util.Scanner;

public class RecursionTasSteisi
{

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int n;
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
		secondPrint(arr[resultSecond]);
		third(arr, 0, k);
	}
	
	public static void input(int[] arr, int index, Scanner in)
	{
		if(index == arr.length)
		{
			return;
		}
		arr[index] = in.nextInt();
		input(arr, index + 1, in);
	}
	
	public static boolean has6or8(int n)
	{
		if(n == 0)
		{
			return true;
		}
		if(n > 0)
		{
			if(n % 10 == 6 || n % 10 == 8)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		return has6or8(n/10);
	}
	
	public static int first(int[] arr, int index, int indexOfMin, int k)
	{
		if(index == arr.length)
		{
			return indexOfMin;
		}
		if(has6or8(arr[index]))
		{
			if(arr[index] % k == 0)
			{
				if(indexOfMin != -1)
				{
					if(arr[index] < arr[indexOfMin])
					{
						return first(arr, index + 1, index, k);
					}
					else 
					{
						return first(arr, index + 1, indexOfMin, k);
					}
				}
				else
				{
					return first(arr, index + 1, index, k);
				}
			}
			else
			{
				return first(arr, index + 1, indexOfMin, k);
			}
		}
		else
		{
			return first(arr, index + 1, indexOfMin, k);
		}
	}
	
	public static int second(int[] arr, int index, int indexOfMin)
	{
		if(index == arr.length)
		{
			return indexOfMin;
		}
		if(indexOfMin != -1)
		{
			if(arr[index] < arr[indexOfMin])
			{
				return second(arr, index + 1, index);
			}
			else
			{
				return second(arr, index + 1, indexOfMin);
			}
		}
		else
		{
			return second(arr, index + 1, index);
		}
	}
	
	public static void secondPrint(int n)
	{
		if(n == 0)
			return;
		System.out.println(n%10);
		secondPrint(n/10);
	}
	
	public static void third(int[] arr, int index, int k)
	{
		if(index == arr.length)
			return;
		int kRight = k % 10;
		System.out.println(arr[index] * kRight);
		third(arr, index + 1, k);
	}

}

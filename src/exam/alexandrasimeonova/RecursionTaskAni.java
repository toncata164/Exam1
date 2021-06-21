package exam.alexandrasimeonova;

import java.util.Scanner;

public class RecursionTaskAni {

	public static void main(String[] args) 
	{
		int n;
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		int[] arr = new int[n];
		input(arr, 0, input);
		int k = input.nextInt();
		System.out.println(smallestDigit(k, 10));
		/*int resultFirst = first(arr, 0, -1, k);
		if(resultFirst != -1)
		{
			System.out.println(arr[resultFirst]);
		}
		else
		{
			System.out.println("NO");
		}
		*/
		int resultSecond = second(arr, 0, 0, k);
		if(resultSecond != -1)
		{
			System.out.println(arr[resultSecond]);
		}
		else
		{
			System.out.println("NO");
		}
		
		//third(arr, 0);
		
	}
	
	public static void input(int[] arr, int index, Scanner in)
	{
		if(index == arr.length)
			return;
		arr[index] = in.nextInt();
		input(arr, index + 1, in);
	}

	public static boolean has7(int n)
	{
		if(n == 0)
			return true;
		if(n > 0)
		{
			if(n%10 == 7)
			{
				return true;
			}
			else
				return has7(n/10);
		}
		return false;
		
	}
	
	public static int first(int[] arr, int index, int indexOfMax, int k)
	{
		if(index == arr.length)
		{
			return indexOfMax;
		}
		if(has7(arr[index]))
		{
			if(arr[index] % k == 0)
			{
				if(indexOfMax != -1)
				{
					if(arr[index] > arr[indexOfMax])
					{
						return first(arr, index + 1, index, k);
					}
					else
					{
						return first(arr, index + 1, indexOfMax, k);
					}
				}
				else
				{
					return first(arr, index + 1, index, k);
				}
			}
			else
			{
				return first(arr, index + 1, indexOfMax, k);
			}
		}
		else
		{
			return first(arr, index + 1, indexOfMax, k);
		}
	}
	
	public static int smallestDigit(int n, int min)
	{
		if(n == 0)
		{
			return min;
		}
		if(n % 10 < min) // n % 10 < 0
		{
			return smallestDigit(n/10, n%10);
		}
		return smallestDigit(n/10, min);
	}
	
	public static int second(int[] arr, int index, int indexOfMin, int k)
	{
		if(index == arr.length)
			return indexOfMin;
		int s = smallestDigit(k, 10);
		if(arr[index] % 10 == s)
		{
			if(indexOfMin != -1)
			{
				if(arr[index] < arr[indexOfMin])
				{
					return second(arr, index + 1, index, k);
				}
				else
				{
					return second(arr, index + 1, indexOfMin, k);
				}
			}
			else
			{
				return second(arr, index + 1, index, k);
			}
			
		}
		return second(arr, index + 1, indexOfMin, k);
	}
	
	public static void third(int[]arr, int index)
	{
		if(index == arr.length)
		{
			return;
		}
		System.out.println(arr[index] * arr[index]%10);
		third(arr, index + 1);
	}
}

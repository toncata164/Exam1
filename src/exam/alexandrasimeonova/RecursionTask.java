package exam.alexandrasimeonova;

import java.util.Scanner;

public class RecursionTask 
{
	public static int greatestElementInArrayWhichCanBeDividedByK(int[] arr, int index, int max, int k)
	{
		if(index == arr.length)
		{
			return max;
		}
		if(arr[index] % k == 0 && arr[index] > max)
		{
			max = arr[index];
		}
		return greatestElementInArrayWhichCanBeDividedByK(arr, index + 1, max, k);
	}
	
	public static int smallestElementWith0InIt(int[] arr, int index, int min)
	{
		if(index == arr.length)
		{
			return min;
		}
		if(arr[index] % 10 == 0 && arr[index] < min)
		{
			min = arr[index];
			arr[index] /= 10;
		}
		return smallestElementWith0InIt(arr, index + 1, min);
	
	}

	public static void main(String[] args) 
	{
		Scanner scan =  new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < arr.length; i++)
		{
			arr[i] = scan.nextInt();
		}
		System.out.println("Insert k");
		int k = scan.nextInt();

		//System.out.println(greatestElementInArrayWhichCanBeDividedByK(arr, 0, 0, k));
		
		System.out.println(smallestElementWith0InIt(arr, 0, 0));
	}

}

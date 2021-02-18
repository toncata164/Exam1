package project;

import java.util.Scanner;

public class zadacha 
{
	/*public static void solve(int k)
	  {
	  	
	  }
	 */
	public static void maxN(int[] arr, int max, int current, int k)
	{
		if(current == arr.length - 1)
		{
			if(max / k == 0)
			{
				System.out.println(max);
				return;
			}
		}
		
		if(max < arr[current]) 
		{
			max = arr[current];
		}
		maxN(arr, max, current + 1, k);
		
	}
	
	public static void minN(int[] arr, int min, int current, int k)
	{
		if(current == arr.length - 1)
		{
			System.out.println(min);
			return;
		}
		
		if(min > arr[current]) 
		{
			min = arr[current];
		}
		minN(arr, min, current + 1, k);
	}


	public static void main(String[] args) 
	{
		Scanner size = new Scanner(System.in); 
		int n = size.nextInt(); 
		int[] arr = new int[n];
		Scanner devider = new Scanner(System.in);
		int k = devider.nextInt();
		
		
		size.close();
		devider.close();
	}

}

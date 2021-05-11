package exam.ekaterina;

import java.util.Scanner;

public class Recursion {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr = new int[n];
		int k = s.nextInt();
	  multiple(arr,10 , 5);
		
		

	}

	public static void multiple(int[] arr, int n, int k )
	{
		
		int i = 0;
		int max = 0;
		if(arr.length <= 0)
		{
			System.out.println("NO");
		}
		
		if(arr[i] >= max && arr[i]%k == 0)
		{
			arr[i] = max;
			
		}
		multiple(arr, n-1, k);
		System.out.println(max);
		
	}
		
		public static void smallest(int[] arr, int n)	
		{
			int min = 0;
			int i = n-1;
			if(arr[i] < min)
			{
				arr[i] = min;
			}
			
			smallest(arr, n--);
			System.out.println(min);
				
				
		}
	
}
//2


	// , 2, 4, 5, 6, 3, 8, 10, 1
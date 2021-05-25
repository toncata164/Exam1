package exam.alexandra;

import java.util.Scanner;

public class Recursion {

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int arr[] = new int[n];
		for(int i = 0; i < arr.length; i++)
		{
			arr[i] = scan.nextInt();
		}
	}
	
	public static void theGreatestElementWhichCanBeDividedByK(int[] arr, int k, int index)
	{
		if(index >= arr.length)
		{
			return;
		}
			
	}

}

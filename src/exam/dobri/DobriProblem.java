package exam.dobri;
import java.util.Scanner;

public class DobriProblem {
	
	public static int[] numbersInput(int n, int count, int[] arr)
	{
		Scanner s = new Scanner(System.in);
		if(count<n)
		{
			arr[count] = s.nextInt();
			numbersInput(n, count+1, arr);
		}
		return arr;

		
		
	}
	
	public static void smallestElement(int k, int[] arr, int smallest, int counter) 
	{
		if (counter == 0)
		{
			smallest = Integer.MIN_VALUE;
		}
		
		if (arr[counter] % k == 0 && arr[counter] < smallest
			&& String.valueOf(arr[counter]).contains("6")
			|| String.valueOf(arr[counter]).contains("8")) 
		{
			smallest = arr[counter];
		}
		if(counter + 1 < arr.length)
		{
			smallestElement(k, arr, smallest, counter+1);
		}
		
		
		if (counter == arr.length-1 && smallest != Integer.MIN_VALUE)
		{
			System.out.println(smallest);
		}else if (counter >= arr.length-1 && smallest == Integer.MIN_VALUE)
		{
			System.out.println("NO");
		}
		
	}
	
	public static int smallestNumber(int[] arr, int smallest, int counter)
	{
		if (counter == 0 ) 
		{
			smallest = Integer.MAX_VALUE;
		}
		
		if (arr[counter] < smallest)
		{
		smallest = arr[counter];
		}
		if (counter+1 < arr.length) {		
			return smallestNumber(arr, smallest, counter+1);
		}
		else
		{
			return smallest;
			
		}
		
	}
	
	public static void numberDigits(int number, int counter) 
	{
		if (counter < String.valueOf(number).length())
		{
			System.out.println(String.valueOf(number).charAt(counter));
		}
		if (counter + 1 <  String.valueOf(number).length()) 
		{
			numberDigits(number,counter+1);
		}else
		{
		return;	
		}
	}
	
	public static void allElementsMultipliedByK(int[] arr, int counter, int kLastDigit)
	{
		if (counter < arr.length) 
		{
			System.out.println(arr[counter]*kLastDigit);
		}
		
		if (counter < arr.length + 1) 
		{
			allElementsMultipliedByK(arr,counter+1,kLastDigit);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		
		// Input for array Length
		System.out.println("Array length: ");
		int n = s.nextInt();
		int[] arr = new int[n];	
		
		// Input for Array elements
		System.out.println("Array elements: ");
		arr = numbersInput(n, 0, arr);
		
		//Input for k
		System.out.println("Enter k: ");
		int k = s.nextInt();
		// closing scanner
		s.close();
		
		// Printing the the smallest element that can be devided by k and contains 6 or 8
		System.out.print("The smallest element that can be devided by k and contains 6 or 8 is: -> ");
		smallestElement(k, arr, 0, 0);
		
		// Prints the smallest number
		int smallestNumber = smallestNumber(arr, 0, 0);
		System.out.println("The smallest number in the array is: " + smallestNumber);
		System.out.println("The digits of the smallest number are: ");
		
		// calling number digits method and printing
		numberDigits(smallestNumber, 0);
		
		
		String kString = String.valueOf(k);
		int lastDigitOfK = Integer.parseInt(String.valueOf(String.valueOf(k).charAt(kString.length()-1)));
		System.out.println("Last digit of k is: "+ lastDigitOfK);
		
		
		//Printing all elements of the array multiplied by k
		System.out.println("All elements of the array multiplied by k");
		allElementsMultipliedByK(arr, 0, lastDigitOfK);
	}

}

import java.util.Scanner;

public class zadacha 
{
	
	public static void inizializeArray(int[]arr, int size, int index) // инициализация на масива
	{
		Scanner scan = new Scanner(System.in);
		if(index == size )
		{
			return;
		}
		System.out.print("Enter number");
		arr[index] = scan.nextInt();
		inizializeArray(arr, size, ++index);
	}
	
	public static void getSmallestNumber(int[] arr, int min,int index, int k) // за да намира min в arr + parsingMin
	{
		if(index == arr.length - 1)
		{
			if((min%k == 0))
			{
				if((isSixEightExist(min)))
				{
					System.out.println(min);
					parsingMin(min);
					return;												
				}
			}
			else System.out.println("No");
			parsingMin(min);
			return;
		}
		if(min > arr[index])
		{
			min = arr[index];
		}
		getSmallestNumber(arr, min, ++index, k);
	}

	
	public static void parsingMin(int min) // разделя числото от дясно наляво
	{
		if(min == 0)
		{
			return;
		}
		parsingMin(min/10);
		System.out.println((min%10)+ ("|"));	
	}
	
	public static boolean isSixEightExist(int min)// да проверява дали 8 или 6 ги има като цифра на min
	{
		if(min == 0)
		{
			return false;
		}
		if(min%10 == 6 || min%10 == 8)
		{
			return true;
		}
		return isSixEightExist(min/10);
	}
	
	public static void multiplicationWithK(int k, int[]arr, int size, int index)//за умножаване на масива с най- дясната част на к
	{
		int divider = k%10;
		if(index == size )
		{
			return;
		}
		arr[index] = arr[index]*divider;
		multiplicationWithK(k, arr, size, ++index);
	}
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter array size - ");
		int size = scan.nextInt();
		int[] arr = new int[size];
		inizializeArray(arr, size, 0);
		System.out.print("Enter k");
		int k = scan.nextInt();
		getSmallestNumber(arr, arr[0], 0, k); // 
		
		multiplicationWithK(k, arr, size, 0); //за умножаване на масива с най- дясната част на к
	}

}

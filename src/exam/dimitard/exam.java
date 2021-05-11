package exam.dimitard;

import java.util.Scanner;

public class exam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner (System.in);
		int n = scan.nextInt();
		int [] numbers = new int [n];
		numbers=getNumbers(n,numbers,1);
		int k = scan.nextInt();
		find7Max(0,numbers,-1,k);
		findMin(2147483647,findSmallestDigit(10,k),numbers,0);
		scan.close();
	}
	
	public static int[] getNumbers(int n, int [] numbers,int current) {
		Scanner scan = new Scanner (System.in);
		if(n==current) {
			
			int temp = scan.nextInt();
			numbers[current-1]=temp;
			return numbers;
		}
		else{
			
			int temp = scan.nextInt();
			numbers[current-1]=temp;
			
			return getNumbers(n,numbers,current+1);
		}
		
	}
	
	public static void find7Max(int current, int [] numbers, int max,int k) {
		if(current == numbers.length) {
			
			if(max==-1) {
				
				System.out.println("NO");
			}
			
			if(max!=-1) {
				System.out.println("max: " + max);
			}
		}
		
		if(current != numbers.length) {
			
			if(numbers[current]%k==0&&numbers[current]>max) {
				if(is7aDigit(numbers[current])) {
					
					max=numbers[current];
					find7Max(current+1,numbers,max,k);
				}
				else {
					
					find7Max(current+1,numbers,max,k);
				}
			}
			else {
				
				find7Max(current+1,numbers,max,k);
			}
		}
	}
	
	public static void findMin(int min, int neededDigit, int [] numbers, int current) {
		
		if(current == numbers.length) {
		
			
			if(min==2147483647) {
				
				System.out.println("NO");
			}
			
			if(min!=2147483647) {
				System.out.println("min:" + min);
			}
		}
		
		if(current != numbers.length) {
			if(min>numbers[current]&&checkDigits(numbers[current],neededDigit)) {
				min = numbers[current];
				 findMin(min,neededDigit,numbers,current+1);
			}
			else 
				 findMin(min,neededDigit,numbers,current+1);
		
		}
		
		
	}
	
	//Izkarva veren rezultat no po nqkakva prichina dava exception
	
	public static void outNumbers(int [] numbers, int current) {
		if(current == numbers.length-1) {
			System.out.println("end");
		}
		if(current != numbers.length) {
			int temp = numbers[current]*numbers[current]%10;
			System.out.println(Calculate2System(temp,""));
			outNumbers(numbers,current+1);
		}
		
	}
	
	public static boolean is7aDigit(int number) {
		if(number==0) {
			return false;
		}
		if(number%10==7) {
			return true;
		}
		if(number%10!=7) {
			return is7aDigit(number/10);
		}
		return false;
	}
	
	public static int findSmallestDigit(int min,int k) {
		if(k==0) {
			return min;
		}
		if(k%10<min) {
			min=k%10;
			return findSmallestDigit(min,k/10);
		}
		if(k%10>=min) {
			return findSmallestDigit(min,k/10);
		}
		return 0;
	}
	
	public static boolean checkDigits(int number, int searched) {
		if(number==0) {
			return false;
		}
		if(number%10==searched) {
			return true;
		}
		if(number%10==searched) {
			return checkDigits(number/10,searched);
		}
		return false;
	}
	
	public static String Calculate2System(int number,String System2) {
		if(number == 0 ) {
			return System2; 
		}
		if(number != 0) {
			System2 = Integer.toBinaryString(number);
			System.out.println(System2);
		}
		
		return ""; 
	}
	//6
}

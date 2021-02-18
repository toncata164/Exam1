package zadacha.edu;

import java.util.Scanner;

public class Zadacha1 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		
		int[] a = new int[n]; 
		int i = 0;
		
		
		wuwediWMassive(a,i,s);
		
		System.out.println("Wuwedi chisloto k:");
		int k = s.nextInt();
		
		

	}
	
	
	public static void wuwediWMassive(int[]  a, int i, Scanner s) {
		
		if(i == a.length) {
			return;
		}
		else {
			a[i] = s.nextInt();
			wuwediWMassive(a, i+1,s);
		}
		
	}

}

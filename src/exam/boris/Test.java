package exam.boris;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		int n=scan.nextInt();
		int[] arr=new int[n];
		createArray(arr,n,0);
		int k=scan.nextInt();
		findElement(arr,n,k,0);
		findBiggestElement(arr,n,0);
		multiply(arr,n,0);
		scan.close();

	}
	public static void createArray(int[] arr, int n,int temp) 
	{
		Scanner scan= new Scanner(System.in);
		if(temp == n) 
		{
			return;
		}
		arr[temp]=scan.nextInt();
		createArray(arr,n,temp+1);
	}
	public static void findElement(int[] arr, int n, int k,int temp) 
	{
		if(n==0) 
		{
			return;
		}
		if(arr[n-1] %k ==0  && arr[n-1]>=2*k+7) 
		{
			if(temp==0) 
			{
				temp=arr[n-1];
			}
			else if(arr[n-1]<temp) 
			{
				 temp=arr[n-1];
			}
		}
		findElement(arr,n-1,k,temp);
		if(temp==0) 
		{
			System.out.println("NO");
		}
		else 
		{
			System.out.println(temp);
		}
		
	}
    public static void findBiggestElement(int[] arr,int n,int temp)
    {
    	if(n==0) 
		{
			return;
		}
    	if(arr[n-1]/10==2 || arr[n-1]%10==2 || (arr[n-1]%10)/10==0) 
    	{
    		if(temp==0) 
			{
				temp=arr[n-1];
			}
			else 
			if(arr[n-1]>temp) 
			{
				 temp=arr[n-1];
			}
    	}
    	findBiggestElement(arr,n-1,temp);
    	if(temp==0) 
		{
			System.out.println("NO");
		}
		else 
		{
			System.out.println(temp);
		}
    	
    }
    public static void multiply(int[] arr,int n,int temp) 
    {
    	if(temp == n) 
		{
			return;
		}
    	if(arr[temp]>0 && arr[temp]<=9) 
    	{
    		System.out.println(arr[temp]*arr[temp]);
    	}
    	if(arr[temp]/10 >= arr[temp]%10 && arr[temp]/10 >= (arr[temp]%10)/10) 
    	{
    		System.out.println(arr[temp]*arr[temp]/10);
    	}
    	if(arr[temp]%10 >= arr[temp]/10 && arr[temp]%10 >= (arr[temp]%10)/10) 
    	{
    		System.out.println(arr[temp]*arr[temp]%10);
    	}
    	if((arr[temp]%10)/10 >= arr[temp]/10 && arr[temp]%10 <= (arr[temp]%10)/10) 
    	{
    		System.out.println(arr[temp]*(arr[temp]%10)/10);
    	}
    	multiply(arr,n,temp+1);
    }
	

}

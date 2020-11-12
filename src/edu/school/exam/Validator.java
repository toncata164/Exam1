package edu.school.exam;

public class Validator 
{
	public static boolean isNullOrEmpty(String value)
	{
		return value == null || value.length() == 0;
	}
}

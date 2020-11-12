package edu.school.exam;

public class Validator 
{
	public static boolean isNull(Object value)
	{
		return value == null;
	}
	
	public static boolean isNullOrEmpty(String value)
	{
		boolean nullOrEmpty = isNull(value) || value.length() == 0;
		return nullOrEmpty;
	}
	
	public static boolean isInRange(int actual, int min, int max)
	{
		boolean inRange = actual >= min && actual <= max;
		return inRange;
	}
}

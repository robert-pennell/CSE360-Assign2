/* 
 * 
 * Name: Robert Pennell
 * Class ID: 405
 * Assignment: Assignment 2
 * 
 * This file implements all of the needed functions that were given in the assignment.
 * 
 * SimpleList: Will create an array with size 10 as well as setting a count to 0.
 * 
 * add: Adds a number into the list, numbers in the list will be pushed towards the end of 
 * 		the list when a new number is added in. If a number is past the size of the array
 * 		it will fall of the end of the array.
 * 		Add now checks to see if the list is full and will use the remake function in order
 * 		to size the array 50% larger.
 * 
 * remake: This function will now allow to be able to resize the array to what the question
 * 			asks for.
 * 
 * remove: Removes a number that is told to be removed from the list.
 * 		   Uses the search function to look for the specified number in
 * 		   the list.
 * 		   Remove now has the ability to see if the list has more than 
 * 		   25% empty space and if it does then it will decrease the size
 * 		   of the list down to amount of elements in the list.
 * 
 * count: Returns the count of the list to show how many elements are in
 * 		  the list.
 * 
 * toString: Turns the list into a string, allows to compare with another string
 * 			 to see what is in the list. Can also print out the string if wanted
 * 			 to.
 * 
 * search: Uses a for loop to look for the specified element and will return the
 *         index of the element. If the element is not in the list it will return
 *         -1.
 *         
 * append: Will append the parameter at the end of the list. If there is no room for
 * 		   the append then it will increase the size of the array by 50%.
 * 
 * first: First simply returns that first element in the list. If there is nothing in
 * 		  the list it will return -1.
 * 
 * last:  Last returns the last element in the list. If there happens to be no elements in
 * 		  the list it will return -1.
 *         
 */
package cse360assign2;
import java.util.Arrays;


public class SimpleList 
{
	
	private int list[];
	private int count;
	
	public SimpleList()
	{
		
		list = new int[10];
		this.count = 0;
		
	}
	
	public void add(int num)
	{
		if(count == list.length)
		{
			int half = count / 2;
			remake(count + half);
		}
		if (count == 0)
		{
			
			list[count] = num;
			count++;
			
		}
		else if (count < 10) 
		{
			
			for (int i  = count; i >= 0; i--)
			{
				
				list[i + 1] = list[i];
				
			}
			
			list[0] = num;
			count++;
			
		}
		else
		{
			
			list[count - 1] = 0;
			
			for (int i = 0; i >= 0; i--)
			{
				
				list[i + 1] = list[i];
				
			}
			
			list[0] = num;
			count++;
			
		}
		
		System.out.println("Successfuly added number.");
		
	}
	
	private void remake(int size)
	{
		int array[] = new int[size];
		
		for(int i = 0; i < size && i < count; i++)
		{
			array[i] = list[i];
		}
		
		list = array;
		
		if(size < count)
		{
			count = size;
		}
	}
	
	
	public void remove(int num)
	{
		
		int index = search(num);
		
		if (index != -1)
		{
			
			for (int i = index; i < count - 1; i++)
			{
				
				list[i] = list[i + 1];
				
			}
			
			count--;
			
			System.out.println("Element has been removed.");
			
		}
		else 
		{
			
			System.out.println(num + " element not found.");
			
		}
		
		int n;
		n = (3 * list.length) / 4;
		
		if(count < n)
		{
			remake(count);
		}
		
	}
	
	public int count()
	{
		
		return count;
		
	}
	
	public String toString()
	{
		
		String str = "";
		
		for (int i = 0; i < count; i++)
		{
			
			str += list[i];
			if (i != count - 1)
			{
				
				str += " ";
				
			}
			
		}
		
		return str;
		
	}
	
	public int search(int num)
	{
		
		int index = -1;
		
		for (int i = 0; i < count; i++)
		{
			
			if (list[i] == num)
			{
				
				index = i;
				
			}
			
		}
		
		return index;
		
	}
	
	public void append(int key)
	{
		
		if(count == list.length)
		{
			int sizing = count / 2;
			remake(count + sizing);
		}
		
		list[count] = key;
		count++;
		
	}
	
	public int first()
	{
		int finalValue;
		
		if(count == 0)
		{
			finalValue = -1;
		}
		else
		{
			finalValue = list[0];
		}
		
		return finalValue;
	}
	
	public int last()
	{
		int finalValue;
		
		if(count == 0)
		{
			finalValue = -1;
		}
		else
		{
			finalValue = list[count];
		}
		
		return finalValue;
		
		
	}
	
	public int size()
	{
		return list.length;
	}
	
}

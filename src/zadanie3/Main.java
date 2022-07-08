package zadanie3;

import Listy.*;
import java.util.*;

public class Main{
	
	private static final int tests = 30;
	volatile long time;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main main = new Main();
		long time=0, time_all=0;
		int size = 10;
		System.out.println("Array length: " + size);
		System.out.println("Tests for InnerSort: ");
		for(int i=0; i<tests; i++)
		{
			String[] array = new String[size];
			main.add(array, size);
			time = main.InsertSort(array);
			time_all +=time;
			System.out.println(time);
		}
		time = 0;
		time_all = 0;
		System.out.println("Tests for SelectSort: ");
		for(int i=0; i<tests; i++)
		{
			String[] array = new String[size];
			main.add(array, size);
			time = main.SelectSort(array);
			time_all += time;
			System.out.println(time);
		}
		time = 0;
		time_all = 0;
		System.out.println("Tests for BubbleSort: ");
		for(int i=0; i<tests; i++)
		{
			String[] array = new String[size];
			main.add(array, size);
			time = main.BubbleSort(array);
			time_all +=time;
			System.out.println(time);
		}
		
	}
	
	public long  BubbleSort(String[] array)
	{
		int size = array.length;
		long Start=0, Stop=0;
		time = 0;
		Start = System.currentTimeMillis();
		for (int pass = 1; pass < size; ++pass) 
		{
			for (int left = 0; left < (size - pass); ++left) 
			{
				int right = left + 1;
				String value = array[left];
				if (value.compareTo(array[right]) > 0)
					swap(array, left, right);
			}
		}
		Stop = System.currentTimeMillis();
		time = Stop - Start;
		return time;
	}
	
	public long SelectSort(String [] array) 
	{
		String value = "";
		int size = array.length;
		long Start=0, Stop=0;
		time = 0;
		Start = System.currentTimeMillis();
		for (int slot = 0; slot < size - 1; ++slot) 
		{
			int smallest = slot; // pozycja wartoœci minimalnej
			for (int check = slot + 1; check < size; ++check) 
			{
				value = array[check];
				if (value.compareTo(array[smallest]) < 0)
					smallest = check;
			}
			swap(array, smallest, slot);
			}
		Stop = System.currentTimeMillis();
		time = Stop - Start;
		return time;
	}
	
	public long InsertSort(String[] array)
	{
		long Start=0, Stop=0;
		time = 0;
		Start = System.currentTimeMillis();
		for (int i = 1; i < array.length; ++i) {
			String value = array[i],temp;
			int j; 
			for (j = i; j > 0 && (value.compareTo(temp=array[j - 1])< 0); --j)
				array[j] = temp;
			array[j] = value;
		}
		Stop = System.currentTimeMillis();
		time = Stop - Start;
		return time;
	}
	
	private void swap(String[] array, int left, int right) 
	{
		String temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
	
	public void add(String[] array, int size)
	{
		Random g = new Random();
		String value = "";
		for(int k = 0; k<size; k++)
		{
			int tmp = g.nextInt(5)+1;
			for(int l = 0; l<tmp; l++)
			{
				char z = (char)(g.nextInt(122-97)+97);
				value += z;
			}
			array[k] = value;
			value = "";
		}
	}
	
	public void display(String[] array)
	{
		for(int i=0; i<array.length; i++)
		{
			System.out.print(array[i] + " ");
		}
		System.out.println('\n');
	}

}

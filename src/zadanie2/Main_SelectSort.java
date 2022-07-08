package zadanie2;

import java.util.Iterator;
import java.util.Random;

import Listy.IList;
import Listy.MyString;
import Listy.OneWayLinkedListWithHead;

public class Main_SelectSort {
	
	volatile long time;
	
	private final int elements = 1000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main_SelectSort main = new Main_SelectSort();
		IList<MyString>list_my = new OneWayLinkedListWithHead<MyString>();
		IList<String>list_string = new OneWayLinkedListWithHead<String>();
		IList<MyString>list_comp = new OneWayLinkedListWithHead<MyString>();
		main.adding(list_my);
		main.adding(list_comp);
		main.adding_String(list_string);
		System.out.println("Done");
		MyString[] array_my = new MyString[list_my.size()];
		String[] array_string = new String[list_string.size()];
		MyString[] array_comp = new MyString[list_comp.size()];
		main.write(list_my, array_my);
		main.write(list_comp, array_comp);
		main.write_string(list_string, array_string);
		System.out.println("Select Sort on lists:");
		System.out.println("Time for my comparator: " + main.sort_my_comp(list_my));
		System.out.println("\n\n");
		System.out.println("Time for comparator: " + main.sort_comp(list_comp));
		System.out.println("\n\n");
		System.out.println("Time for String comparator: " + main.sort_String(list_string));
		System.out.println("\nSelect Sort on arrays:");
		System.out.println("Time for my comparator: " + main.sort_my_comp_array(array_my));
		main.write_back(list_my, array_my);
		System.out.println("\n\n");
		System.out.println("Time for comparator: " + main.sort_comp_array(array_comp));
		main.write_back(list_comp, array_comp);
		System.out.println("\n\n");
		System.out.println("Time for String comparator: " + main.sort_String_array(array_string));
		main.write_back_string(list_string, array_string);
		System.out.println("\n\n");
		
	}
	
	public long sort_my_comp(IList<MyString> list) 
	{
		MyString value = null;
		long Start, Stop;
		int size = list.size();
		Start = System.currentTimeMillis();
		for (int slot = 0; slot < size - 1; ++slot) 
		{
			int smallest = slot; // pozycja wartoœci minimalnej
			for (int check = slot + 1; check < size; ++check) 
			{
				value = list.get(check);
				if (value.MycompareTo(list.get(smallest)) < 0)
					smallest = check;
			}
			swap(list, smallest, slot);
			}
		Stop = System.currentTimeMillis();
		time = Stop - Start;
		return time;
	}
	
	public long sort_comp(IList<MyString> list) 
	{
		MyString value = null;
		long Start, Stop;
		int size = list.size();
		Start = System.currentTimeMillis();
		for (int slot = 0; slot < size - 1; ++slot) 
		{
			int smallest = slot; // pozycja wartoœci minimalnej
			for (int check = slot + 1; check < size; ++check) 
			{
				value = list.get(check);
				if (value.compareTo(list.get(smallest)) < 0)
					smallest = check;
			}
			swap(list, smallest, slot);
			}
		Stop = System.currentTimeMillis();
		time = Stop - Start;
		return time;
	}

	
	public long sort_String(IList<String> list) 
	{
		String value = null;
		long Start, Stop;
		int size = list.size();
		Start = System.currentTimeMillis();
		for (int slot = 0; slot < size - 1; ++slot) 
		{
			int smallest = slot; // pozycja wartoœci minimalnej
			for (int check = slot + 1; check < size; ++check) 
			{
				value = list.get(check);
				if (value.compareTo(list.get(smallest)) < 0)
					smallest = check;
			}
			swap_String(list, smallest, slot);
			}
		Stop = System.currentTimeMillis();
		time = Stop - Start;
		return time;
	}
	
	public void adding_String(IList<String>list)
	{
		Random g = new Random();
		String value = "";
		for(int k = 0; k<elements; k++)
		{
			int tmp = g.nextInt(5)+1;
			for(int l = 0; l<tmp; l++)
			{
				char z = (char)(g.nextInt(122-97)+97);
				value += z;
			}
			list.add(value);
			value = "";
		}
	}
	
	public void adding(IList<MyString>list)
	{
		Random g = new Random();
		String value = "";
		for(int k = 0; k<elements; k++)
		{
			int tmp = g.nextInt(5)+1;
			for(int l = 0; l<tmp; l++)
			{
				char z = (char)(g.nextInt(122-97)+97);
				value += z;
			}
			MyString tmp_string = new MyString(value);
			list.add(tmp_string);
			value = "";
		}
	}
	
	public void display(IList<MyString> list)
	{
		Iterator iter = list.iterator();
		while(iter.hasNext())
		{
			System.out.println(iter.next().toString());
		}
	}
	
	public void display_String(IList<String> list)
	{
		Iterator iter = list.iterator();
		while(iter.hasNext())
		{
			System.out.println(iter.next());
		}
	}
	
	private void swap(IList<MyString> list, int left, int right) 
	{
		MyString temp = list.get(left);
		list.set(left, list.get(right));
		list.set(right, temp);
	}
	
	private void swap_String(IList<String> list, int left, int right) 
	{
		String temp = list.get(left);
		list.set(left, list.get(right));
		list.set(right, temp);
	}
	
	private void write(IList<MyString> list, MyString [] array)
	{
		int size = list.size();
		for(int i=0; i<size; i++)
		{
			array[i] = list.get(i);
		}
	}
	
	private void write_string(IList<String> list, String [] array)
	{
		int size = list.size();
		for(int i=0; i<size; i++)
		{
			array[i] = list.get(i);
		}
	}
	
	private void write_back(IList<MyString> list, MyString [] array)
	{
		int size = list.size();
		for(int i=0; i<size; i++)
		{
			list.set(i, array[i]);
		}
	}
	
	private void write_back_string(IList<String> list, String [] array)
	{
		int size = list.size();
		for(int i=0; i<size; i++)
		{
			list.set(i, array[i]);
		}
	}
	
	public long sort_my_comp_array(MyString [] array) 
	{
		MyString value = null;
		int size = array.length;
		long Start, Stop;
		Start = System.currentTimeMillis();
		for (int slot = 0; slot < size - 1; ++slot) 
		{
			int smallest = slot; // pozycja wartoœci minimalnej
			for (int check = slot + 1; check < size; ++check) 
			{
				value = array[check];
				if (value.MycompareTo(array[smallest]) < 0)
					smallest = check;
			}
			swap_array(array, smallest, slot);
			}
		Stop = System.currentTimeMillis();
		time = Stop - Start;
		return time;
	}
	
	public long sort_comp_array(MyString [] array) 
	{
		MyString value = null;
		long Start, Stop;
		int size = array.length;
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
			swap_array(array, smallest, slot);
			}
		Stop = System.currentTimeMillis();
		time = Stop - Start;
		return time;
	}
	
	public long sort_String_array(String [] array) 
	{
		String value = null;
		int size = array.length;
		long Start, Stop;
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
			swap_array_String(array, smallest, slot);
			}
		Stop = System.currentTimeMillis();
		time = Stop - Start;
		return time;
	}
	
	private void swap_array(MyString[] list, int left, int right) 
	{
		MyString temp = list[left];
		list[left] = list[right];
		list[right] = temp;
	}
	
	private void swap_array_String(String[] list, int left, int right) 
	{
		String temp = list[left];
		list[left] = list[right];
		list[right] = temp;
	}
	
}

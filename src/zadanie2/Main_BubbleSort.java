package zadanie2;
import java.util.*;
import Listy.*;


public class Main_BubbleSort {
	
	volatile long time=0;
	private final int elements = 5000;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main_BubbleSort main = new Main_BubbleSort();
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
		System.out.println("Bubble Sort on lists:");
		System.out.println("Time for my comparator: " + main.sort_my_comp(list_my));
		System.out.println("\n\n");
		System.out.println("Time for comparator: " + main.sort_comp(list_comp));
		System.out.println("\n\n");
		System.out.println("Time for String comparator: " + main.sort_String(list_string));
		System.out.println("\nBubble Sort on arrays:");
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
		int size = list.size();
		long Start, Stop;
		Start = System.currentTimeMillis();
		for (int pass = 1; pass < size; ++pass) 
		{
			for (int left = 0; left < (size - pass); ++left) 
			{
				int right = left + 1;
				MyString value = list.get(left);
				if (value.MycompareTo(list.get(right)) > 0)
					swap(list, left, right);
			}
		}
		Stop = System.currentTimeMillis();
		time = Stop - Start;
		return time;
	}

	
	public long sort_comp(IList<MyString> list)
	{
		int size = list.size();
		long Start, Stop;
		Start = System.currentTimeMillis();
		for (int pass = 1; pass < size; ++pass) 
		{
			for (int left = 0; left < (size - pass); ++left) 
			{
				int right = left + 1;
				MyString value = list.get(left);
				if (value.compareTo(list.get(right)) > 0)
					swap(list, left, right);
			}
		}
		Stop = System.currentTimeMillis();
		time = Stop - Start;
		return time;
	}
	
	public long sort_String(IList<String> list)
	{
		int size = list.size();
		long Start, Stop;
		Start = System.currentTimeMillis();
		for (int pass = 1; pass < size; ++pass) 
		{
			for (int left = 0; left < (size - pass); ++left) 
			{
				int right = left + 1;
				String value = list.get(left);
				if (value.compareTo(list.get(right)) > 0)
					swap_String(list, left, right);
			}
		}
		Stop = System.currentTimeMillis();
		time = Stop - Start;
		return time;
	}
	
	public long sort_my_comp_array(MyString[] array)
	{
		int size = array.length;
		long Start, Stop;
		Start = System.currentTimeMillis();
		for (int pass = 1; pass < size; ++pass) 
		{
			for (int left = 0; left < (size - pass); ++left) 
			{
				int right = left + 1;
				MyString value = array[left];
				if (value.MycompareTo(array[right]) > 0)
					swap_array(array, left, right);
			}
		}
		Stop = System.currentTimeMillis();
		time = Stop - Start;
		return time;
	}

	
	public long sort_comp_array(MyString[] array)
	{
		int size = array.length;
		long Start, Stop;
		Start = System.currentTimeMillis();
		for (int pass = 1; pass < size; ++pass) 
		{
			for (int left = 0; left < (size - pass); ++left) 
			{
				int right = left + 1;
				MyString value = array[left];
				if (value.compareTo(array[right]) > 0)
					swap_array(array, left, right);
			}
		}
		Stop = System.currentTimeMillis();
		time = Stop - Start;
		return time;
	}
	
	public long sort_String_array(String[] array)
	{
		int size = array.length;
		long Start, Stop;
		Start = System.currentTimeMillis();
		for (int pass = 1; pass < size; ++pass) 
		{
			for (int left = 0; left < (size - pass); ++left) 
			{
				int right = left + 1;
				String value = array[left];
				if (value.compareTo(array[right]) > 0)
					swap_array_String(array, left, right);
			}
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
			System.out.print(iter.next());
		}
		System.out.println('\n');
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

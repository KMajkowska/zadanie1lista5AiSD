package zadanie2;
import Listy.*;
import java.util.*;
public class Main_InsertSort {
	
	volatile long time =0;
	private final int elements = 5000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main_InsertSort main = new Main_InsertSort();
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
		System.out.println("Insert Sort on lists:");
		System.out.println("Time for my comparator: " + main.sort_my_comp(list_my));
		System.out.println("\n\n");
		System.out.println("Time for comparator: " + main.sort_comp(list_comp));
		System.out.println("\n\n");
		System.out.println("Time for String comparator: " + main.sort_String(list_string));
		System.out.println("\nInsert Sort on arrays:");
		System.out.println("Time for my comparator: " + main.sort_my_comp_array(array_my));
		main.write_back(list_my, array_my);
		System.out.println("\n\n");
		System.out.println("Time for comparator: " + main.sort_comp_array(array_comp));
		main.write_back(list_comp, array_comp);
		System.out.println("\n\n");
		System.out.println("Time for String comparator: " + main.sort_String_array(array_string));
		main.write_back_string(list_string, array_string);
		//main.display(list_my);
		System.out.println("\n\n");
	}
	
	public long sort_my_comp(IList<MyString> list)
	{
		long Start, Stop;
		Start = System.currentTimeMillis();
		for (int i = 1; i < list.size(); ++i) {
			MyString value = list.get(i),temp;
			int j; 
			for (j = i; j > 0 && (value.MycompareTo(temp=list.get(j - 1))< 0); --j)
			list.set(j,temp);
			list.set(j, value);
		}
		Stop = System.currentTimeMillis();
		time = Stop - Start;
		return time;
	}
	
	public long sort_comp(IList<MyString> list)
	{
		long Start, Stop;
		Start = System.currentTimeMillis();
		for (int i = 1; i < list.size(); ++i) {
			MyString value = list.get(i),temp;
			int j; 
			for (j = i; j > 0 && (value.compareTo(temp=list.get(j - 1))< 0); --j)
			list.set(j,temp);
			list.set(j, value);
		}
		Stop = System.currentTimeMillis();
		time = Stop - Start;
		return time;
	}
	
	public long sort_String(IList<String> list)
	{
		long Start, Stop;
		Start = System.currentTimeMillis();
		for (int i = 1; i < list.size(); ++i) {
			String value = list.get(i),temp;
			int j; 
			for (j = i; j > 0 && (value.compareTo(temp=list.get(j - 1))< 0); --j)
			list.set(j,temp);
			list.set(j, value);
		}
		Stop = System.currentTimeMillis();
		time = Stop - Start;
		return time;
	}
	
	public long sort_my_comp_array(MyString[] array)
	{
		long Start, Stop;
		Start = System.currentTimeMillis();
		for (int i = 1; i < array.length; ++i) {
			MyString value = array[i],temp;
			int j; 
			for (j = i; j > 0 && (value.MycompareTo(temp=array[j - 1])< 0); --j)
				array[j] = temp;
			array[j] = value;
		}
		Stop = System.currentTimeMillis();
		time = Stop - Start;
		return time;
	}
	
	public long sort_comp_array(MyString[] array)
	{
		long Start, Stop;
		Start = System.currentTimeMillis();
		for (int i = 1; i < array.length; ++i) {
			MyString value = array[i],temp;
			int j; 
			for (j = i; j > 0 && (value.compareTo(temp=array[j - 1])< 0); --j)
				array[j] = temp;
			array[j] = value;
		}
		Stop = System.currentTimeMillis();
		time = Stop - Start;
		return time;
	}
	
	public long sort_String_array(String[] array)
	{
		long Start, Stop;
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

}

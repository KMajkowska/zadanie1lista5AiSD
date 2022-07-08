package Listy;

public class MyString implements Comparable<MyString>{
	String inner_string;
	public  MyString( String inner_string ) {
		 this.inner_string = inner_string;
	 }
	 public int MycompareTo( MyString other_string ) // tutaj jest mój komparator
	 {
		 int size = inner_string.length();
		 if(size > other_string.size_String()) 
			{
			 for(int i=0; i<other_string.size_String(); i++)
			 {
				 if(inner_string.charAt(i) > other_string.char_String(i))
					 return 1;
				 else if(inner_string.charAt(i) < other_string.char_String(i))
					 return -1;
				}
			 return 1;
			}
		 else if(size < other_string.size_String()) 
		{
			for(int i=0; i<size; i++)
			 {
				 if(inner_string.charAt(i) > other_string.char_String(i))
					 return 1;
				 else if(inner_string.charAt(i) < other_string.char_String(i))
					 return -1;
			 }
				return -1;
		}
		 else
		 {
			 for(int i=0; i<size; i++)
			 {
				 if(inner_string.charAt(i) > other_string.char_String(i))
					 return 1;
				 else if(inner_string.charAt(i) < other_string.char_String(i))
					 return -1;
			 }
			return 0;
		 }
	 }
	 public int size_String()
	 {
		 return inner_string.length();
	 }

	 public int char_String(int i) {
		 return inner_string.charAt(i);
	 }
	 public int compareTo(MyString other_string) // tutaj jest ten komparator, na który w skrócie mówiê ¿e jest wbudowany
	 {
		 return inner_string.compareTo( other_string.inner_string );
	 }
	 public String toString()
	 {
		 return inner_string;
	 }
	 //a jak chce porównywaæ zwyk³e stringi, nie obiekty klasy MyString, to po prostu w odpowiedniej metodzie sortuj¹cej jest compareTo, które za argumenty ma zwyk³ê Stringi

}

package Listy;
import java.util.Iterator;

public class OneWayLinkedListWithHead<E> extends AbstractList<E>{
	
	Element head=null;
	public OneWayLinkedListWithHead() {
		
	}
	public boolean isEmpty()
	{
		return head==null;
	}

	public void clear() 
	{
		head=null;
	}
	
	public int size() {
		int pos=0;
		Element actElem=head;
		while(actElem!=null)
		{
			pos++;
			actElem=actElem.getNext();
		}
		return pos;
	}
	
	private Element getElement(int index)
	{
		if(index<0) throw new IndexOutOfBoundsException();
		Element actElem=head;
		while(index>0 && actElem!=null){
			index--;
			actElem=actElem.getNext();
		}
		if (actElem==null)
			throw new IndexOutOfBoundsException();
		return actElem;
	}
	
	public boolean add(E e) {
		Element newElem=new Element(e);
		if(head==null){
			head=newElem;
			return true;
		}
		Element tail=head;
			while(tail.getNext()!=null)
				tail=tail.getNext();
		tail.setNext(newElem);
		return true;
	}


	
	public void add(int index, E data) {
		if(index<0) throw new IndexOutOfBoundsException();
			Element newElem=new Element(data);
		if(index==0)
		{
			newElem.setNext(head);
			head=newElem;
		}
		else 
		{
			Element actElem=getElement(index-1);
			newElem.setNext(actElem.getNext());
			actElem.setNext(newElem);
		}
	}
	@Override
	public int indexOf(E data) {
		int pos=0;
		Element actElem=head;
		while(actElem!=null)
		{
			if(actElem.getValue().equals(data))
				return pos;
			pos++;
			actElem=actElem.getNext();
		}
		return -1;
	}

	@Override
	public boolean contains(E data) 
	{
		return indexOf(data)>=0;
	}
	@Override
	public E get(int index) 
	{
		Element actElem=getElement(index);
		return (E)actElem.getValue();
	}
	@Override
	public E set(int index, E data) 
	{
		Element actElem=getElement(index);
		E elemData=(E)actElem.getValue();
		actElem.setValue(data);
		return elemData;
	}

	@Override
	public E remove(int index) 
	{
		if(index<0 || head==null) throw new IndexOutOfBoundsException();
		if(index==0)
		{
			E retValue=(E)head.getValue();
			head=head.getNext();
			return retValue;
		}
		Element actElem=getElement(index-1);
		if(actElem.getNext()==null)
			throw new IndexOutOfBoundsException();
		E retValue=(E)actElem.getNext().getValue();
		actElem.setNext(actElem.getNext().getNext());
		return retValue;
	}
	@Override
	public boolean remove(Element value) {
		if(head==null) 
			return false;
		if(head.getValue().equals(value.getValue()))
		{
			head=head.getNext();
			return true;
		}
		Element actElem=head;
		while(actElem.getNext()!=null && !actElem.getNext().getValue().equals(value.getValue())) 
			actElem=actElem.getNext();
		if(actElem.getNext()==null)	
				return false;
		actElem.setNext(actElem.getNext().getNext());
		return true;
	}
	@Override
	public Iterator<E> iterator() {
		Iterator<E> it = new ListIterator();
		return it;
	}


	private class ListIterator<E> implements Iterator<E> {
		
		Element actElem;
		ListIterator() 
		{
			actElem=head;
		}
		@Override
		public boolean hasNext() {
			return actElem!=null;
		}
		@Override
		public E next() {
			E value=(E)actElem.getValue();
			actElem=actElem.getNext();
			return value;
		}


}

}
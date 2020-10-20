import java.util.*;
import java.io.*;
class Slip14{
	public static void main(String args[])throws IOException{
		LinkedList ll=new LinkedList();
		ll.add("Red");
		ll.add("Blue");
		ll.add("Yellow");
		ll.add("Orange");
		
		Iterator itr=ll.iterator();
		System.out.println("Existing colours are\n");
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		
		ListIterator litr=ll.listIterator(ll.size());
		System.out.println("\nReverse Order\n");
		while(litr.hasPrevious()){
			System.out.println(litr.previous());
		}		
		
		LinkedList l2=new LinkedList();
		l2.add("Pink");
		l2.add("Green");
		ll.addAll(2,l2);
		
		itr=ll.iterator();
		System.out.println("\nUpdated Colours are\n");
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}
}

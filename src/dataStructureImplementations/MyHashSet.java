package dataStructureImplementations;

import java.util.AbstractSet;
import java.util.HashMap;
import java.util.Iterator;

public class MyHashSet extends AbstractSet {

	static HashMap<Object, Object> map = null;
	   private static final Object tempObject = new Object(); //duplicate keys not allowed, but duplicate values => can take an empty object or the key as a value as well
	
	MyHashSet() {
		map = new HashMap<>();
		
	}
	public boolean add(Object object) {
		 map.put(object, object); //duplicate keys not allowed, but duplicate values => can take an empty object or the key as a value as well
	      return map.put(object, object)==null;
	   }
	
	
	   public int size() {
	      return map.size();
	   }
	   
	   @Override
	   public Iterator iterator() {
	      return map.keySet().iterator();
	   }
	  
	  
	public static void main(String[] args) {
		MyHashSet test = new MyHashSet();
	      test.add("India");
	      test.add("Australia");
	      test.add("England");
	      test.add("Australia");
	      for(Object object : test) {
	          System.out.println(object.toString());
	       }
	   }
	
}

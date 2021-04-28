package dataStructureImplementations;

import java.util.Arrays;

public class MyArrayList {
	static final int cap = 10;
	int size;
	Object[] data;
	
	public MyArrayList() {
		size = 0;
		data = new Object[10];
	}
	
	public void ensureCap() {
		int newSize = data.length * 2;
		data = Arrays.copyOf(data, newSize);
		//or, if no extra libraries allowed
		Object[] newData = new Object[newSize];
		for (int i=0; i<data.length;i++) {
			newData[i] = data[i];
		}
		this.data=newData;
	}
	
	
	public int getSize() {
		return size;
	}
	
	public void add(Object o) {
		if (size == data.length) {
			ensureCap();
		}
		data[size++] = o;
	}
	
	public Object get(int index) {
		if (index < size && index >= 0) {
			return data[index];
		}
		else return null;
		
	}
	
	
	
	public static void main(String[]args) {
		MyArrayList myList = new MyArrayList();
		myList.add("Test");
		for (int i=0; i<myList.getSize(); i++) {
			System.out.println(myList.get(i));
		}
	}
}

package dataStructureRawImplementations;

public class List {
	static final int DEFAULT_CAPACITY = 10;
	Object[] data;
	int size;

	public List() {
		clear();
	}

	public void clear() {
		size = 0;
//		ensureCapacity(DEFAULT_CAPACITY);
		data = new Object[DEFAULT_CAPACITY];
	}

	public void ensureCapacity() {
		if (size > 0) {
			int newCap = data.length * 2;
			Object[] old_data = data;
			data = new Object[newCap];
			for (int i = 0; i < old_data.length; i++) {
				data[i] = old_data[i];
			}
		}
	}

//	public void ensureCapacity(int newCapacity) {
//		if (size > 0) {
//			if (newCapacity < size) {
//				return;
//			}
//			Object[] old_data = data;
//			data = new Object[newCapacity];
//			for (int i = 0; i < old_data.length; i++) {
//				data[i] = old_data[i];
//			}
//		}
//	}

	public int size() {
		return size;
	}

	public Object get(int index) {
		if (index < 0 || index >= size)
			throw new ArrayIndexOutOfBoundsException();
		return data[index];
	}

	public void add(Object o) {
		if (data.length != 0) {
			if (size == data.length) {
				ensureCapacity();
			}
		}
		data[size++] = o;

	}

//	public boolean add(int index, Object o) {
//		if (data.length == size)
//			ensureCapacity(size * 2 + 1);
//		for (int i = 0; i < size; i++) {
//
//		}
//		data[size++] = o;
//		return true;
//	}

	public Object remove(int index) {
		Object toRemove = data[index];
		for (int i = index; i < data.length; i++) {
			data[i] = data[i + 1];
		}
		size--;
		return toRemove;
	}

	public static void main(String[] args) {
		List myList = new List();
		myList.add("Test");
		for (int i = 0; i < myList.size(); i++) {
			System.out.println(myList.get(i));

		}
	}

}

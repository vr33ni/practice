package dataStructureImplementations;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

//HashMap is a dictionary data structure provided by java. 
//It’s a Map-based collection class that is used to store data in Key & Value pairs.
//We can have a list containing all the key, values and to access we need to search all of it.
//But the main point of hash map is to access the keys faster in 0(1) access time.
//Here, hashing comes into play. We can hash the key and relate it with the index to retrieve data faster.
//Hash comes with a problem too, collision. 
//It is always recommended to use a better hash function that can reduce chances of collision.
//Multiple hash can have same hash key. 
//For that reason, there is a bucket or container for each key where all the values are store if collision occurs.
//////////////////
//array to store all the keys, a bucket model to store all the entry and a wrapper for our key, value pair.

//wrapper
public class MyHashMap<K, V> {

	//performance influenced by capacity and load factor (0.75 default)
	//When the number of entries in the hash table exceeds the product of the load factor and the current capacity, the hash table is rehashed (that is, internal data structures are rebuilt) so that the hash table has approximately twice the number of buckets.
	//The capacity is the number of buckets in the hash table, and
	// the initial capacity is simply the capacity at the time the hash table is created
	static int CAPACITY = 10; 
	MyMapBucket[] bucket; // array of buckets to store all the keys
	int size = 0;

	MyHashMap() {
		this.bucket = new MyMapBucket[CAPACITY];
	}

	int getHashCode(K key) {
		return (key.hashCode() & 0xfffffff) % CAPACITY;
	}
	
	  void put(K key, V value) {
	        if(containsKey(key)) {
	            Entry entry = getEntry(key);
	            entry.setValue(value);
	        } else {
	            int hash = getHashCode(key);
	            if(bucket[hash] == null) {
	                bucket[hash] = new MyMapBucket();
	            }
	            bucket[hash].addEntry(new Entry<>(key, value));
	            size++;
	        }
	    }

	    V get(K key) {
	        return containsKey(key) ? (V) getEntry(key).getValue() : null;
	    }
	    
	    //Check if the bucket is null
	    //If not, then the bucket contains the key.
	    boolean containsKey(K key) {
	        int hash = getHashCode(key);
	        return !(Objects.isNull(bucket[hash]) || Objects.isNull(getEntry(key)));
	    }

	
	    Entry getEntry(K key) {
	        int hash = getHashCode(key);
	        for (int i = 0; i < bucket[hash].getEntries().size(); i++) {
	        	Entry e = bucket[hash].getEntries().get(i);
	            if(e.getKey().equals(key)) {
	                return e;
	            }
	        }
	        return null;
	    }
	    
	    
	public static void main(String[]args) {
		
	}

}

class Entry<K, V> {
	K key;
	V value;

	public Entry(K key, V value) {
		this.key = key;

	}
	
	//getters and setters
	public K getKey() {
		return this.key;
	}
	
	public V getValue() {
		return this.value;
	}
	public void setValue(V value) {
		this.value = value;
	}
}

//bucket model to store all the entries
class MyMapBucket {
	private List<Entry> entries;

	public MyMapBucket() {
		if (entries == null) {
			entries = new LinkedList<>();
		}
	}

	public List<Entry> getEntries() {
		return entries;
	}

	public void addEntry(Entry entry) {
		this.entries.add(entry);
	}

	public void removeEntry(Entry entry) {
		this.entries.remove(entry);
	}
}

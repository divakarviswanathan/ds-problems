package edu.diva.ds.my.implementation.map;

class MyEntry {
	String key;
	String val;
	MyEntry next;
	
	MyEntry(String k, String v) {
		this.key = k;
		this.val = v;
		this.next = null;
	}
	
	public boolean equals(MyEntry obj) {
		if(obj != null && this.key.equals(obj.key) && this.val.equals(obj.val)) {
			return true;
		}
		return false;
	}
}

public class MyHashMap {
	
	MyEntry[] entries;
	int size;
	
	MyHashMap() {
		this.size = 16;
		entries = new MyEntry[this.size];
	}
	
	MyHashMap(int n) {
		this.size = n;
		entries = new MyEntry[n];
	}
	
	public void put(String k, String v) {
		int loc = getLocation(k.hashCode());
		MyEntry obj = new MyEntry(k, v);
		if(entries[loc] == null) {
			entries[loc] = obj;
		} else {
			MyEntry entry = entries[loc];
			if(!entry.key.equals(obj.key)) {
				while(entry.next != null) {
					entry = entry.next;
					if(entry.key.equals(obj.key)) {
						entry.val = obj.val;
						break;
					}
				}
				entry.next = obj;
			} else {
				entry.val = obj.val;
			}
		}
	}
	
	public String get(String k) {
		int loc = getLocation(k.hashCode());
		MyEntry obj = entries[loc];
		if(obj != null) {
			while(obj != null) {
				if(obj.key.equals(k)) {
					return obj.val;
				}
				obj = obj.next;
			}
		}
		return null;
	}
	
	private int getLocation(int hash) {
		return hash%this.size;
	}

	public static void main(String[] args) {
		MyHashMap m = new MyHashMap();
		m.put("a", "b");
		System.out.println(m.get("a"));
		m.put("c", "d");
		System.out.println(m.get("c"));
		m.put("a", "c");
		System.out.println(m.get("a"));
	}

}

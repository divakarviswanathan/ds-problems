package edu.diva.ds.my.implementation.map;

class MyLinkedEntry {
	String key;
	String val;
	MyLinkedEntry next;
	MyLinkedEntry head;
	
	MyLinkedEntry(String k, String v) {
		this.key = k;
		this.val = v;
		this.next = null;
	}
	
	public boolean equals(MyLinkedEntry obj) {
		if(obj != null && this.key.equals(obj.key) && this.val.equals(obj.val)) {
			return true;
		}
		return false;
	}
}

public class MyLinkedHashMap {
	
	MyLinkedEntry[] entries;
	int size;
	
	MyLinkedHashMap() {
		this.size = 16;
		entries = new MyLinkedEntry[this.size];
	}
	
	MyLinkedHashMap(int n) {
		this.size = n;
		entries = new MyLinkedEntry[n];
	}
	
	public void put(String k, String v) {
		int loc = getLocation(k.hashCode());
		MyLinkedEntry obj = new MyLinkedEntry(k, v);
		if(entries[loc] == null) {
			entries[loc] = obj;
		} else {
			MyLinkedEntry entry = entries[loc];
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
		MyLinkedEntry obj = entries[loc];
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
		MyLinkedHashMap m = new MyLinkedHashMap();
		m.put("a", "b");
		System.out.println(m.get("a"));
		m.put("c", "d");
		System.out.println(m.get("c"));
		m.put("a", "c");
		System.out.println(m.get("a"));
	}

}

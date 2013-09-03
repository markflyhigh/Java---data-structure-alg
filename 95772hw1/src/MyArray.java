
public class MyArray {
	private String[] str;
	private int capacity;
	private int size;
	
	public MyArray(int length) {
		str = new String[length];
		capacity = length;
		size = 0;
	}

	public void add(String newstr) {
		if(newstr.length() == 0) return;
		
		if(size + 1 > capacity) {
			String[] tmpstr = new String[capacity * 2 + 1];
			System.arraycopy(str, 0, tmpstr, 0, size);
			str = tmpstr;
			capacity = capacity * 2 + 1;
		}
		str[size] = newstr;
		size++;
	}
	
	public boolean search(String key) {
		if(key.length() == 0) return false;
		
		for(int i=0; i<size; i++)
			if(str[i].equals(key))
				return true;
		return false;		
	}
	
	public int size() {
		return size;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public void display() {
		if(size == 0) return;
		
		for(int i=0; i<size; i++)
			System.out.print(str[i] + " ");
		System.out.println();
	}
	
	public void removeDups() {
		for(int i=1; i<size; i++) 
			for(int j=0; j<i; j++) 
				if(str[i].equals(str[j]))
					str = remove(i);
	}
	
	private String[] remove(int index) {
		String[] newstr = new String[capacity];
		
		if(index > size || index < 0) return str;
		
		System.arraycopy(str, 0, newstr, 0, index);
		System.arraycopy(str, index+1, newstr, index, size-index-1);
		size--;
		return newstr;
	}
}

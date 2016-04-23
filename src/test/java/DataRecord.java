
public class DataRecord {

	public static final int NEVER_USED = 0;
	public static final int PREVIOUSLY_USED = 1;
	public static final DataRecord maxLength = null;
	private DataRecord next;
	private String name;
	private int used;
	


	public int getUsed() {
		return used;
	}
	public void setUsed(int used) {
		this.used = used;
	}

	public DataRecord getNext() {
		return next;
	}
	public void setNext(DataRecord next) {
		this.next = next;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "<" + name + "> -->";
	}

	public int getSize() {
		int length = 0;
		while(maxLength != null)
		{
			length++;
			
		}
		return(length);
	}
	
	
}

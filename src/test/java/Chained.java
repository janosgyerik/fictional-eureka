
public class Chained {
	static final int TABLE_SIZE = 127;
	static final DataRecord NEVER_USED = null;
	private DataRecord []table = new DataRecord[TABLE_SIZE];
	
	
	public Chained() {
		for (int i = 0; i < TABLE_SIZE; i++) {
			table[i] = NEVER_USED;
		}
	}
	//stores where the variable goes
	private int hashFunction(String word) {
		int result = 0;
		for (int i = 0; i < word.length(); i++) {
			//converts to ASCII gets the total vaule in each for ASCII for each letter
			result = result + (int) word.charAt(i);
		}

		return result % TABLE_SIZE;
		
	}
	 public int getLongestChain(String name) {
		 int length = Add(name);
		 System.out.println("length" + length);
		 return length;
	 }
//	 public DataRecord getSmallestChain() {
//	        DataRecord smallestChain;
//
//	        if (table == null) {
//	        	System.out.println("nothing");
//	        }
//
//	        smallestChain = table[0].maxLength;
//	        for (int i = 0; i < TABLE_SIZE; i++) {
//	            if (table[i] < smallestChain) {
//	            	smallestChain = table[i];
//	            }
//	        }
//	        return smallestChain;
//	    }
	public void getDistinctWords(){
		
	}
	public void getTotalWordCount(){
		
	}
	public void getWordFrequency(){
		
	}
	public int size(){
		return TABLE_SIZE;
	}
	public DataRecord search(String name) {
		int bucket = hashFunction(name);
		///System.out.println("bucket" + bucket);
		DataRecord b = table[bucket];

		while (b != null) {
			if (b.getName().equalsIgnoreCase(name)) {
				// This is it
				return b;
			}
			
			b = b.getNext();
		}
		
		return null;
	}

	private int searchForAdd(String name) {
		return hashFunction(name);
	}
	public int Add(String name) {
		int length = 0;
		while(search(name) == null) {
			int bucket = searchForAdd(name);
			DataRecord d = new DataRecord();
			d.setName(name);
			d.setNext(table[bucket]);
			table[bucket] = d;
			length ++;

	
	}
		return length;

}

//	public void Add(String name) {
//		if (search(name) != null) {
//			
//			return;
//		}
//	
//		// So find a bucket
//		int bucket = searchForAdd(name);
//		
//		DataRecord d = new DataRecord();
//		d.setName(name);
//		d.setNext(table[bucket]);
//		table[bucket] = d;
//	}

	public String toString() {
		String rtn = "";
		
		for (int i = 0; i < TABLE_SIZE; i++) {
			rtn += "bucket[" + i + "] = ";
			if (table[i] == NEVER_USED) {
				rtn += "NEVER_USED\n";
			} else {
				DataRecord n = table[i];
				rtn += "[ ";
				while (n != null) {
					rtn += n + " ";
					n = n.getNext();
				}
				rtn += "]\n";
			}
		}
		
		return rtn;
	}

}

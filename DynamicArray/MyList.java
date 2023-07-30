package DynamicArray;

public class MyList<T> {

	private int capacity;
	private T[] array;
	
	
	public MyList(){
		setCapacity(10);
		setArray(new Object[getCapacity()]);
	}
	
	
	public MyList(int capacity) {
		setCapacity(capacity);
		setArray(new Object[getCapacity()]);
	}
	
	
	public void CheckCapacity(int numOfElements) {
		if(numOfElements>freeSpaceOfArray()) {
			
		}
		
	}
	
	
	//double the capacity
	public void doubleCapacity() {
		T[] oldArray=getArray();
		setCapacity(getCapacity()*2);
		setArray((new Object[getCapacity()]));
		
		int i=0;
		for(T oldElement: oldArray) {
			this.getArray()[i]=oldElement;
			i++;
		}
		
	}
	
	
	//adds the element
	public void add(T element) {
		checkCapacity(1);
		getArray()[sizeOfArray()]=element;
	}
	
	//checking the array
	public void checkCapacity(int number) {
		if(number>freeSpaceOfArray()) {
			doubleCapacity();
			checkCapacity(number);
		}
	}
	
	
	//clean the array
	public void clear() {
		for(int i=0; i<sizeOfArray(); i++) {
			getArray()[i]=null;
		}
	}
	
	
	// How many elemets avaliable in array to insert 
	public int freeSpaceOfArray() {
		int freeSpace=getCapacity()-sizeOfArray();
		return freeSpace;
	}
	
	
	// how many element there are in array
	public int sizeOfArray() {
		int counter=0;
		for(int i=0; i<this.array.length;i++) {
			if(this.array[i]!=null) {
				counter++;
			}
		}
		
		return counter;
	}
	
	
	// Getting Value by index
	public T get(int index) {
		if(getArray()[index]==null) {
			return null;
		}
		T value=getArray()[index];
		return value;
	}
	
	//Setting Value by index
	public void set(int index, T data) {
		if(getArray()[index]!=null) {
			getArray()[index]=data;
		}
	}
	
	
	 public int lastIndexOf(T element){
	        int index = -1;
	        int lastIndex = -1;
	        for(T i : getArray()){
	            index++;
	            if(i == element){
	                lastIndex = index;
	            }
	        }
	        return lastIndex;
	    }

	
	
	
	
	//remove the element of giving index and shift the elements 
	public void remove(int index){

        if(getArray()[index] != null){
            getArray()[index] = null;
            int i;
            for(i = index + 1; i == sizeOfArray(); i++){
                getArray()[i-1] = getArray()[i];
            }
        }

    }
	
	
	// list of the array
	public String toString() {
		String list="[";
		for(T element:getArray()) {
			if(element!=null) {
				list+=element;
				list+=",";
			};
				
		}
		list+="]";
		return list;
	}
	
	// returns index of giving number
	public int indexOf(T data) {
		int i=0;
		for(T element: getArray()) {
			if(element==data) {
				return i;
			}
			i++;
		}
		return -1;
	}
	
	// checks whether array include element or not
	public boolean isEmpty() {
		boolean isEmpty=true;
		for(T element: getArray()) {
			if(element!=null) {
				isEmpty=false;
				break;
			}
		}
		return isEmpty;
		
	}
	
	//arranges the items in the list into an array in the same order
	public T[] toArray(){
		T[] newArray=(T[]) new Object[sizeOfArray()];
		int i;
		for(i=0;i<sizeOfArray();i++) {
			newArray[i]=getArray()[i];
		}
		return newArray;
	}
	
	
	
	public MyList<T> subList(int start,int finish){
		if(start>=0 && finish>=0) {
			if(start<=this.getCapacity() && finish<=this.getCapacity()) {
				int size=finish-start+1;
				
				MyList<T> myList=new MyList<>(size);
				for(int i=start;i<=finish;i++) {
					myList.add(get(i));
					
				}
				return myList;
				
				
			}
		}return null;
	}
	
	
	//returns true if the param is in the array
	public boolean isContain(T param) {
		boolean isContain=false;
		for(int i=0;i<=sizeOfArray();i++) {
			if(getArray()[i]==param) {
				isContain=true;
			}
		}
		return isContain;
	}
	
	// Getters and Setters
	
	public int getCapacity() {
		return this.capacity;
	}
	
	public void setCapacity(int capacity) {
		this.capacity=capacity;
	}
	
	public T[] getArray() {
		return this.array;
	}
	

	public void setArray (Object[] array) {
		this.array=(T[]) array;
	}
	
	
}

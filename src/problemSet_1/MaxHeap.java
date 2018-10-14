package problemSet_1;

public class MaxHeap {
	
	// Last Index
	private int lastIndexOfHeap;
	private int SIZE;
	//private Class<T> classType;
	//private T[] heapArray;
	private int[] heapArray;
	
	MaxHeap(int size){
		this.SIZE = size;
		//this.classType = classType;
		//this.heapArray = (T[]) Array.newInstance(this.classType, this.SIZE);
		//this.heapArray = (T[]) new Object[this.SIZE];
		this.heapArray = new int[this.SIZE];
	}
	
	public int getLeftChildIndex(int parentIndex){
		int left = (parentIndex * 2) + 1;
		return left > lastIndexOfHeap ? -1 : left;
	}
	
	public int getRightChildIndex(int parentIndex){
		int right = (parentIndex * 2) +2;
		return right > lastIndexOfHeap ? -1 : right;
	}
	
	public int getParentIndex(int childIndex){
		if(childIndex < 1 || childIndex > lastIndexOfHeap)
			return -1;
		return (childIndex - 1)/2;
	}
	
	// O(log n) - Time complexity
	public void percolateDown(int index){
		int leftIndex = getLeftChildIndex(index);
		int rightIndex = getRightChildIndex(index);
		int maxIndex = -1;
		if(leftIndex > 0 && rightIndex > 0){
			int temp  = heapArray[leftIndex] > heapArray[rightIndex] ? leftIndex : rightIndex;
			maxIndex = heapArray[temp] > heapArray[index] ? temp : index;
		} else if(leftIndex > 0 && rightIndex == -1){
			maxIndex = heapArray[leftIndex] > heapArray[leftIndex] ? leftIndex : index;
		} else if(leftIndex == -1 && rightIndex > 0){
			maxIndex = heapArray[rightIndex] > heapArray[rightIndex] ? rightIndex : index;
		}
		
		if(maxIndex != index){
			swap(heapArray, maxIndex, index);
			percolateDown(maxIndex); 
		}
		
	}
	
	private void swap(int[] heapArray, int i, int j){
		int temp = heapArray[i];
		heapArray[i] = heapArray[j];
		heapArray[j] = temp;
	}
	
	public void deleteMax(){
		heapArray[0] = heapArray[lastIndexOfHeap];
		lastIndexOfHeap--;
		percolateDown(0);
	}
	
	public int getMaxAndDelete(){
		int max = heapArray[0];
		deleteMax();
		return max;
	}
	
	public void insert(int data){
		if(lastIndexOfHeap +1  == heapArray.length)
			resizeHeap();
		
		int index = ++this.lastIndexOfHeap;
		while(index >= 0 && data > heapArray[getParentIndex(index)]){
			heapArray[index] = heapArray[getParentIndex(index)];
			index = getParentIndex(index);
		}
		heapArray[index] = data;
	}
	
	private void resizeHeap(){
		int[] newHeapArray = new int[heapArray.length * 2];
		for(int i = 0; i< heapArray.length; i++){
			newHeapArray[i] = heapArray[i];
		}
		heapArray = newHeapArray;
		newHeapArray = null;
	}

}

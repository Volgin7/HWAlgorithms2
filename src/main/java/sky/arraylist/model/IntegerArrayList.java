package sky.arraylist.model;

import sky.arraylist.exception.ElementNotFoundException;
import sky.arraylist.exception.InvalidIndexException;
import sky.arraylist.exception.NullItemException;
import sky.arraylist.exception.StorageIsFullException;

import java.util.Arrays;

public class IntegerArrayList implements IntegerArrayListInterface{
    private final Integer[] storage;
    private final int MAX_SIZE = 5;
    int size;
    public IntegerArrayList() {
        this.storage  = new Integer[MAX_SIZE];
    }

    @Override
    public Integer add(Integer item) {
        validateItem(item);
        validateSize();
        storage[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer number) {
        validateItem(number);
        validateSize();
        validateIndex(index);
        if(index == size) {
            storage[size++] = number;
            return number;
        }
        System.arraycopy(storage,index,storage,index+1,size-1);
        storage[size++] = number;

        return number;
    }

    @Override
    public Integer set(int index, Integer number) {
        validateIndex(index);
        validateItem(number);
        storage[index] = number;
        return number;
    }

    @Override
    public Integer remove(Integer number) {
        validateItem(number);
        int index = indexOf(number);
        if(index == -1) {
            throw new ElementNotFoundException();
        }
        return remove(index);
    }

    @Override
    public Integer remove(int index) {
        validateIndex(index);
        Integer item = storage[index];
        if(index != size){
            System.arraycopy(storage,index+1,storage,index,size-index);
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(Integer number) {
        return indexOf(number) != -1;
    }

    @Override
    public int indexOf(Integer number) {
        for (int i = 0; i < size; i++) {
            if(storage[i].equals(number)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer number) {
        for (int i = size - 1; i >= 0; i--) {
            if(storage[i].equals(number)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        validateIndex(index);
        return storage[index];
    }

    @Override
    public boolean equals(IntegerArrayList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(storage,size);
    }

    private void validateItem(Integer number){
        if(number == null) {
            throw new NullItemException();
        }
    }
    private void validateSize(){
        if(size == storage.length) {
            throw new StorageIsFullException();
        }
    }

    private void validateIndex(int index){
        if(index < 0 || index >= size) {
            throw new InvalidIndexException();
        }
    }
    @Override
    public void sort() {
        int i, j, minIndex;
        int size = this.size;
        for (i = 0; i < size - 1; i++) {
            minIndex = i;
            for (j = i + 1; j < size; j++) {
                if (storage[j] < storage[minIndex])  {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(storage,minIndex,i);
            }
        }
    }
    public void swap(Integer[] array, int index1, int index2) {
        Integer tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    @Override
    public int binarySearch(Integer number) {
        int index = -1;
        int low = 0;
        int high = size - 1;

        while (low <= high) {
            int mid = low  + ((high - low) / 2);
            if ((int) storage[mid] < (int) number) {
                low = mid + 1;
            } else if ((int) storage[mid] > (int) number) {
                high = mid - 1;
            } else if ((int) storage[mid] == (int) number) {
                index = mid;
                break;
            }
        }
        return index;
    }



}

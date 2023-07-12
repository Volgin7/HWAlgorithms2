package sky.arraylist.model;

public interface IntegerArrayListInterface {
    Integer add(Integer number);
    Integer add(int index, Integer number);
    Integer set(int index, Integer number);
    Integer remove(Integer number);
    Integer remove(int index);
    boolean contains(Integer number);
    int indexOf(Integer number);
    int lastIndexOf(Integer number);
    Integer get(int index);
    boolean equals(IntegerArrayList otherList);
    int size();
    boolean isEmpty();
    void clear();
    Integer[] toArray();
    void sort();
    int binarySearch(Integer number);  // returns index of item, returns -1 if item not found


}

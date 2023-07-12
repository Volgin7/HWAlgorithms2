package sky.arraylist;

import sky.arraylist.model.IntegerArrayList;
import sky.arraylist.model.StringArrayList;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
 /*
        StringArrayList stringList = new StringArrayList();
        stringList.add("String 1");
        stringList.add("String 2");
        stringList.add("String 3");
        stringList.add("String 4");
        stringList.add("String 5");
        stringList.add("String 5");
        stringList.set(4,"String 55");
        System.out.println(Arrays.toString(stringList.toArray()));
        System.out.println("stringList.size() = " + stringList.size());
*/

        IntegerArrayList integerList = new IntegerArrayList();
        integerList.add(1);
        integerList.add(5);
        integerList.add(3);
        integerList.add(777);
        integerList.add(10);


        //integerList.add(6);
        //integerList.set(4,55);
        System.out.println("integerList.size() = " + integerList.size());
        System.out.println(Arrays.toString(integerList.toArray()));
        integerList.sort();
        System.out.println(Arrays.toString(integerList.toArray()));
        System.out.println(integerList.binarySearch(777));
    }
}
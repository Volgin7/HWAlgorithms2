package sky.arraylist;

import sky.arraylist.model.IntegerArrayList;
import sky.arraylist.model.StringArrayList;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        IntegerArrayList integerList = new IntegerArrayList();

        for (int i = 0; i < 11; i++) {
            integerList.add(i);
        }
        System.out.println(Arrays.toString(integerList.toArray()));
        System.out.println("integerList.size() = " + integerList.size());

        for (int i = 0; i < 11; i++) {
            integerList.add(i*100);
        }
        System.out.println(Arrays.toString(integerList.toArray()));
        System.out.println("integerList.size() = " + integerList.size());



        IntegerArrayList integerList2 = new IntegerArrayList();
        integerList2.add(1);
        integerList2.add(7);
        integerList2.add(4);
        integerList2.add(5);
        integerList2.add(17);
        integerList2.add(44);

        integerList2.sortQuick(0,integerList2.size()-1);
        System.out.println(Arrays.toString(integerList2.toArray()));
        System.out.println("integerList.size() = " + integerList2.size());

    }


}
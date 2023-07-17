package sky.arraylist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sky.arraylist.exception.ElementNotFoundException;
import sky.arraylist.exception.InvalidIndexException;
import sky.arraylist.exception.StorageIsFullException;
import sky.arraylist.model.IntegerArrayList;
import sky.arraylist.model.StringArrayList;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IntegerArrayListTest {
    @Test
    @DisplayName("Test of add method")
    void addTest()  {
        IntegerArrayList integerList = new IntegerArrayList();

        Assertions.assertEquals(777, integerList.add(777));
    }
    @Test
    @DisplayName("Test of add method exceptions")
    void addOutOfLimitsExceptionTest() {
        IntegerArrayList integerList = new IntegerArrayList();
        integerList.add(0);
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);

        assertDoesNotThrow(() -> integerList.add(4));
        assertThrows(StorageIsFullException.class, () -> integerList.add(777));
        assertThrows(StorageIsFullException.class, () -> integerList.add(4,777));
    }

    @Test
    @DisplayName("Test of add by Index method")
    void addToIndexTest() {
        IntegerArrayList integerList = new IntegerArrayList();
        integerList.add(0);
        integerList.add(1);

        Assertions.assertEquals(777, integerList.add(1,777));
    }

    @Test
    @DisplayName("Test of set method")
    void setTest() {
        IntegerArrayList integerList = new IntegerArrayList();
        integerList.add(0);
        integerList.add(2);

        Assertions.assertEquals(777, integerList.set(0,777));
    }

    @Test
    @DisplayName("Test of set method exceptions")
    void setExceptionsTest() {
        IntegerArrayList integerList = new IntegerArrayList();
        integerList.add(0);

        Assertions.assertThrows(InvalidIndexException.class, ()->integerList.set(1,777));
        Assertions.assertDoesNotThrow(()->integerList.set(0,777));
    }

    @Test
    @DisplayName("Test of remove by index method")
    void removeByIndexTest() {
        IntegerArrayList integerList = new IntegerArrayList();
        integerList.add(777);

        Assertions.assertEquals(777, integerList.remove(0));
    }
    @Test
    @DisplayName("Test of remove by index method exception")
    void removeByIndexExceptionTest() {
        IntegerArrayList integerList = new IntegerArrayList();
        integerList.add(777);

        Assertions.assertDoesNotThrow(()->integerList.remove(0));
        Assertions.assertThrows(InvalidIndexException.class, ()->integerList.remove(1));
    }

    @Test
    @DisplayName("Test of remove by value method")
    void removeByValueTest() {
        IntegerArrayList integerList = new IntegerArrayList();
        Integer value = 777;
        integerList.add(value);

        Assertions.assertEquals(value, integerList.remove(value));
    }

    @Test
    @DisplayName("Test of remove by value method exception")
    void removeByValueExceptionTest() {
        IntegerArrayList integerList = new IntegerArrayList();
        Integer value = 777;
        integerList.add(0);

        Assertions.assertThrows(ElementNotFoundException.class, ()->integerList.remove(value));
    }
    @Test
    @DisplayName("Test of contains method - positive")
    void containsPositiveTest() {
        IntegerArrayList integerList = new IntegerArrayList();
        integerList.add(777);

        Assertions.assertTrue(()->integerList.contains(777));
    }

    @Test
    @DisplayName("Test of contains method - negative")
    void containsNegativeTest() {
        IntegerArrayList integerList = new IntegerArrayList();
        integerList.add(1);
        integerList.add(2);

        Assertions.assertFalse(()->integerList.contains(777));
    }

    @Test
    @DisplayName("Test of index method")
    void indexOfTest() {
        IntegerArrayList integerList = new IntegerArrayList();
        integerList.add(1);
        integerList.add(2);
        integerList.add(1);


        Assertions.assertEquals(0, integerList.indexOf(1));
        Assertions.assertEquals(2, integerList.lastIndexOf(1));
        Assertions.assertEquals(-1, integerList.indexOf(777));
        Assertions.assertEquals(-1, integerList.lastIndexOf(777));
    }

    @Test
    @DisplayName("Test of get method")
    void getTest() {
        IntegerArrayList integerList = new IntegerArrayList();
        integerList.add(1);
        integerList.add(2);

        Assertions.assertEquals(2, integerList.get(1));
    }
    @Test
    @DisplayName("Test of get method exception")
    void getExceptionTest() {
        IntegerArrayList integerList = new IntegerArrayList();
        integerList.add(1);
        integerList.add(2);

        Assertions.assertThrows(InvalidIndexException.class,()->integerList.get(3));
    }

    @Test
    @DisplayName("Test of equals method - positive")
    void equalsPositiveTest() {
        IntegerArrayList integerList = new IntegerArrayList();
        integerList.add(1);
        integerList.add(2);

        IntegerArrayList integerList2 = new IntegerArrayList();
        integerList2.add(1);
        integerList2.add(2);

        Assertions.assertTrue(integerList.equals(integerList2));
    }
    @Test
    @DisplayName("Test of equals method - negative")
    void equalsNegativeTest() {
        IntegerArrayList integerList = new IntegerArrayList();
        integerList.add(1);
        integerList.add(2);

        IntegerArrayList integerList2 = new IntegerArrayList();
        integerList2.add(1);
        integerList2.add(777);

        Assertions.assertFalse(integerList.equals(integerList2));
    }

    @Test
    @DisplayName("Test of size method")
    void getSize() {
        IntegerArrayList integerList = new IntegerArrayList();
        integerList.add(1);
        integerList.add(2);

        Assertions.assertEquals(2, integerList.size());
    }
    @Test
    @DisplayName("Test of isEmpty method - negative")
    void isEmptyNegativeTest() {
        IntegerArrayList integerList = new IntegerArrayList();
        integerList.add(1);

        Assertions.assertFalse(integerList.isEmpty());
    }

    @Test
    @DisplayName("Test of isEmpty method - positive")
    void isEmptyPositiveTest()  {
        IntegerArrayList integerList = new IntegerArrayList();

        Assertions.assertTrue(integerList.isEmpty());
    }

    @Test
    @DisplayName("Test of clear method")
    void clearTest()  {
        IntegerArrayList integerList = new IntegerArrayList();
        integerList.add(1);
        integerList.add(2);

        integerList.clear();
        Assertions.assertEquals(0,integerList.size());
    }

    @Test
    @DisplayName("Test of clear method - exception")
    void clearExceptionTest() {
        IntegerArrayList integerList = new IntegerArrayList();
        integerList.add(1);
        integerList.add(2);

        integerList.clear();
        Assertions.assertThrows(InvalidIndexException.class, ()->integerList.get(0));
    }

    @Test
    @DisplayName("Test of toArray method")
    void toArrayTest() {
        IntegerArrayList integerList = new IntegerArrayList();
        integerList.add(1);
        integerList.add(2);

        Integer[] newArray = integerList.toArray();
        Assertions.assertEquals(integerList.get(1), newArray[1]);
        Assertions.assertEquals(integerList.get(0), newArray[0]);
    }

    @Test
    @DisplayName("Test of sortSelect method")
    void sortSelectTest() {
        IntegerArrayList integerList = new IntegerArrayList();
        integerList.add(1);
        integerList.add(3);
        integerList.add(2);

        IntegerArrayList integerList2 = new IntegerArrayList();
        integerList2.add(1);
        integerList2.add(2);
        integerList2.add(3);

        Assertions.assertFalse(integerList.equals(integerList2));
        integerList.sortSelect();
        Assertions.assertTrue(integerList.equals(integerList2));
    }

    @Test
    @DisplayName("Test of sortQuick method")
    void sortQuickTest() {
        IntegerArrayList integerList = new IntegerArrayList();
        integerList.add(1);
        integerList.add(3);
        integerList.add(2);

        IntegerArrayList integerList2 = new IntegerArrayList();
        integerList2.add(1);
        integerList2.add(2);
        integerList2.add(3);

        Assertions.assertFalse(integerList.equals(integerList2));
        integerList.sortQuick(0, integerList.size() - 1);
        Assertions.assertTrue(integerList.equals(integerList2));
    }

    @Test
    @DisplayName("Test of binary method")
    void binarySearchTest() {
        IntegerArrayList integerList = new IntegerArrayList();
        integerList.add(1);
        integerList.add(777);
        integerList.add(2);
        integerList.add(3);

        Assertions.assertEquals(1, integerList.binarySearch(777));
    }

    @Test
    @DisplayName("Test of grow method")
    void growTest() {
        IntegerArrayList integerList = new IntegerArrayList();
        integerList.add(1);
        integerList.add(2);

        for (int i = 0; i < 1000; i++) {
            integerList.add(i+3);
        }
        Assertions.assertEquals(1002, integerList.size());
    }
}

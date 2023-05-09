//import com.gradescope.jh61b.grader.GradedTest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class LinkedListCheckpoint {
    static final int MAXIMUN_NUM = 20;

    DoublyLinkedList<Integer> intList, intLongList, int_empty, int_many, int_one, list;

    /////////////// CHECKPOINT: 2.75 pts in total  //////////////////////////////

    @Before
    public void setup() {
        // This tests assume the add functions works properly
        intLongList = new DoublyLinkedList<>();
        int_empty = new DoublyLinkedList<>();
        intList = new DoublyLinkedList<>();
        list = new DoublyLinkedList<>();
        for (int i = 0; i < MAXIMUN_NUM; i++) {
            intLongList.add(i);
        }
        int_many = intLongList;
        int_one = new DoublyLinkedList();
        int_one.add(1);
    }


    @Test(timeout=1000)
   //@GradedTest(name="DLL: Size", max_score=0.5)
    public void testDLLSize() {
        assertEquals("0 times add() call should have size of 0", 0, int_empty.size());
        assertEquals("200 times add() call should have size of 20", 20, intLongList.size());
    }

    @Test (expected = IndexOutOfBoundsException.class)
    //@GradedTest(name="DLL: get throw index out of bound on empty list", max_score=0.5)
    public void testDLLGetEmptyException() {
        int_empty.get(0);
        fail("getting index 0 of empty list should throw IndexOutOfBoundsException");
    }

    @Test(timeout=1000)
    //@GradedTest(name="DLL: simple add on simple list", max_score=1)
    public void testDLLAddSimple() {
        list.add(0);
        list.add(10);
        list.add(20);
        list.add(30);
        // 0 -> 10 -> 20 -> 30
        assertEquals(10, (int) list.get(1));

        list.add(2, 15);
        // 0 -> 10 -> 15 -> 20 -> 30
        assertEquals("previous values should not be changed", 10, (int) list.get(1));
        assertEquals("Values added to the index 2 should be 15", 15, (int) list.get(2));
        assertEquals("Original Index 2 shifted to right", 20, (int) list.get(3));
    }

    @Test(timeout=1000)
    //@GradedTest(name="DLL: Remove", max_score=0.75)
    public void testRemove() {
        assertEquals("remove() should remove the element at the specified index", 1, (int) int_one.remove(0));
        assertEquals("remove() should reduce the size of the list by one", 0, int_one.size());
    }


    
}
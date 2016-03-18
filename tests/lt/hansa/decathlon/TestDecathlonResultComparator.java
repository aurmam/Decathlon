package lt.hansa.decathlon;

import junit.framework.TestCase;
import java.util.TreeSet;
import java.util.Iterator;
import lt.hansa.decathlon.data.DecathlonResultComparator;

/**
 * Created by IntelliJ IDEA.
 * User: Aurimas Mameniskis
 * Date: Jun 3, 2008
 * Time: 8:38:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestDecathlonResultComparator extends TestCase {
       public void testDecathlonResultComparator() {
        TreeSet<Integer> set = new TreeSet<Integer>(new DecathlonResultComparator());
        set.add(10);
        set.add(5);
        set.add(5);
        set.add(13);
        set.add(1);
        Iterator iterator = set.iterator();
        assertEquals(13, iterator.next());
        assertEquals(10, iterator.next());
        assertEquals(5, iterator.next());
        assertEquals(1, iterator.next());   
        assertFalse(iterator.hasNext());
    }
}

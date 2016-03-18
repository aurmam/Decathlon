package lt.hansa.decathlon.data;

import java.util.Comparator;

/**
 * Created by IntelliJ IDEA.
 * User: Aurimas Mameniskis
 * Date: Jun 2, 2008
 * Time: 8:40:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class DecathlonResultComparator implements Comparator<Integer> {
    /**
     * 
     * @param result_nr1
     * @param result_nr2
     * @return
     */
    public int compare(Integer result_nr1, Integer result_nr2) {
        return result_nr2.compareTo(result_nr1);
    }
}

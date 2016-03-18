package lt.hansa.decathlon.data;

import lt.hansa.decathlon.xml.OutputProc;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by IntelliJ IDEA.
 * User: Aurimas Mameniskis
 * Date: 2008.08.02
 * Time: 17:48:30
 * To change this template use File | Settings | File Templates.
 */
public class DecathlonPlaceCalc {
    private TreeMap<Integer, List<DecathlonRez>> places = new TreeMap<Integer, List<DecathlonRez>>(new DecathlonResultComparator());

    /**
     * @param results
     */
    public void addResults(List<DecathlonRez> results) {
        for (DecathlonRez result : results) {
            addResult(result);
        }
    }

    /**
     * @param result
     */
    public void addResult(DecathlonRez result) {
        if (!places.containsKey(result.getTotalPoints())) {
            places.put(result.getTotalPoints(), new ArrayList<DecathlonRez>());
        }
        List<DecathlonRez> results = places.get(result.getTotalPoints());
        results.add(result);
    }

    /**
     * @param outputProcessor
     */
    public void outputResults(OutputProc outputProcessor) {
        int counter = 1;
        for (List<DecathlonRez> results : places.values()) {
            String place = getPlaceName(counter, results.size());
            for (DecathlonRez result : results) {
                outputProcessor.writeResultToXML(place, result);
            }
            // if there are people that devides some plases we need to push counter with the count of people
            counter = counter + results.size();
        }
        outputProcessor.closeXML();
    }

    /**
     * getting place name for competitor
     * @param cnt
     * @param size
     * @return place
     */
    private static String getPlaceName(int cnt, int size) {
        if (size == 1) {
            //if person is one than return place
            return Integer.toString(cnt);
        }
        //return place if somebody divides the place;
        return "" + cnt + "-" + (cnt + size - 1);
    }

}

package lt.hansa.decathlon;

import junit.framework.TestCase;
import lt.hansa.decathlon.data.DecathlonPlaceCalc;
import lt.hansa.decathlon.data.DecathlonRez;
import lt.hansa.decathlon.xml.OutputProc;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by IntelliJ IDEA.
 * User: Aurimas Mameniskis
 * Date: Jun 3, 2008
 * Time: 8:48:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestDecathlonPlaceCalc extends TestCase {
    DecathlonPlaceCalc athlet;

    protected void setUp() throws Exception {
        super.setUp();
        athlet = new DecathlonPlaceCalc();
    }

    private class Processor implements OutputProc {
        public List<DecathlonRez> results = new ArrayList<DecathlonRez>();
        public List<String> names = new ArrayList<String>();

        public void writeResultToXML(String placeName, DecathlonRez result) {
            results.add(result);
            names.add(placeName);
        }

        public void closeXML() {

        }
    }

    public void testDecathlonPlaceCalc() {
        athlet.addResult(new DecathlonRez("Siim Susi", 12.61, 500, 9.22, 150, 60.39, 16.43, 21.60, 260, 35.81, 325.72));
        athlet.addResult(new DecathlonRez("Jaana Lind",13.75, 484, 10.12, 150, 68.44, 19.18, 30.85, 280, 33.88, 382.75 ));
        athlet.addResult(new DecathlonRez("Jona Lindiene",13.75, 484, 10.12, 150, 68.44, 19.18, 30.85, 280, 33.88, 382.75 ));
        athlet.addResult(new DecathlonRez("Aurimas Loop", 11.43, 435.0, 8.64, 150.0, 66.06, 19.05, 24.89, 220.0, 33.48, 411.01  ));
        Processor proc = new Processor();

        athlet.outputResults(proc);

        assertEquals("Siim Susi", proc.results.get(0).getAthlet());
        assertEquals(4200, proc.results.get(0).getTotalPoints());
        assertEquals("1", proc.names.get(0));

        assertEquals("Jaana Lind", proc.results.get(1).getAthlet());
        assertEquals(3495, proc.results.get(1).getTotalPoints());
        assertEquals("2-3", proc.names.get(1));

        assertEquals("Jona Lindiene", proc.results.get(2).getAthlet());
        assertEquals(3495, proc.results.get(2).getTotalPoints());
        assertEquals("2-3", proc.names.get(2));

        assertEquals("Aurimas Loop", proc.results.get(3).getAthlet());
        assertEquals(3469, proc.results.get(3).getTotalPoints());
        assertEquals("4", proc.names.get(3));
    }
}

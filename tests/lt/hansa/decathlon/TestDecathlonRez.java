package lt.hansa.decathlon;

import junit.framework.TestCase;
import lt.hansa.decathlon.data.DecathlonRez;
import lt.hansa.decathlon.data.EventConstants;

/**
 * Created by IntelliJ IDEA.
 * User: Aurimas Mameniskis
 * Date: Jun 3, 2008
 * Time: 8:15:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestDecathlonRez extends TestCase {

    public void testDecathlonRezults() {
        DecathlonRez rez = new DecathlonRez("Siim Susi", 12.61, 500, 9.22, 150, 60.39, 16.43, 21.60, 260, 35.81, 325.72);
        assertEquals("Siim Susi", rez.getAthlet());
        assertEquals(4200, rez.getTotalPoints());
        assertEquals(12.61d, rez.getRunning100m());
        assertEquals(500d, rez.getLongJump());
        assertEquals(9.22d, rez.getShotPut());
        assertEquals(150d, rez.getHighJump());
        assertEquals(60.39d, rez.getRunning400m());
        assertEquals(16.43d, rez.getRunning100mHurdles());
        assertEquals(21.60d, rez.getDiscusThrow());
        assertEquals(260d, rez.getPoleVault());
        assertEquals(35.81d, rez.getJavelinThrow());
        assertEquals(325.72d, rez.getRunning1500m());
    }

    public void testRunFormula() {
        assertEquals(536, DecathlonRez.RunFormula(EventConstants.RUN_100M, 12.61));
        assertEquals(400, DecathlonRez.RunFormula(EventConstants.RUN_400M, 60.39));
        assertEquals(685, DecathlonRez.RunFormula(EventConstants.RUN_100M_HURDLES, 16.43));
        assertEquals(421, DecathlonRez.RunFormula(EventConstants.RUN_1500M, 325.72));
    }

    public void testFieldFormula() {
        assertEquals(382, DecathlonRez.FieldFormula(EventConstants.LONG_JUMP, 500));
        assertEquals(439, DecathlonRez.FieldFormula(EventConstants.SHOT_PUT, 9.22));
        assertEquals(389, DecathlonRez.FieldFormula(EventConstants.HIGH_JUMP, 150));
        assertEquals(302, DecathlonRez.FieldFormula(EventConstants.DISCUS_THROW, 21.60));
        assertEquals(264, DecathlonRez.FieldFormula(EventConstants.POLE_VAULT, 260));
        assertEquals(382, DecathlonRez.FieldFormula(EventConstants.JAVELIN_THROW, 35.81));
    }
}
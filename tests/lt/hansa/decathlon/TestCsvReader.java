package lt.hansa.decathlon;

import junit.framework.TestCase;
import lt.hansa.decathlon.data.DecathlonRez;
import lt.hansa.decathlon.data.CsvReader;
import lt.hansa.decathlon.app.DecathlonApplication;

/**
 * Created by IntelliJ IDEA.
 * User: Aurimas Mameniskis
 * Date: Jun 3, 2008
 * Time: 6:34:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestCsvReader extends TestCase {

    protected void setUp() throws Exception {
        super.setUp();
        DecathlonApplication.getApplication().init("conf/DecathlonApplication.properties");
    }

    public void testparseAthletData() {
        DecathlonRez rez = CsvReader.parseAthletData("Siim Susi;12.61;5.00;9.22;1.50;60.39;16.43;21.60;2.60;35.81;5.25.72");
        assertEquals("Siim Susi", rez.getAthlet());
        assertEquals(4200, rez.getTotalPoints());
    }


    public void testConvertTime() {
        double value = CsvReader.ConvertTime("12.34");
        assertEquals(12.340, value);
    }

    public void testConvertCM() {
        double value = CsvReader.ConvertCM("5.00");
        assertEquals(500.0, value);
    }

    public void testConvertStrToDouble() {
        double value = CsvReader.ConvertStrToDouble("12.34");
        assertEquals(12.340, value);
    }

    public void testConvertTimeWithMilliSeconds() {
        double value = CsvReader.ConvertTime("5.25.72");
        assertEquals(325.72, value);
    }

}

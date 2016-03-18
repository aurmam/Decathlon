package lt.hansa.decathlon.xml;

import lt.hansa.decathlon.data.DecathlonRez;

/**
 * Created by IntelliJ IDEA.
 * User: Aurimas Mameniskis
 * Date: Jun 2, 2008
 * Time: 8:19:43 PM
 * To change this template use File | Settings | File Templates.
 */
public interface OutputProc {
    /**
     * function to write results to the xml file
     * @param AthletPlace
     * @param result
     */
    void writeResultToXML(String AthletPlace, DecathlonRez result);

    /**
     * 
     */
    void closeXML();
}

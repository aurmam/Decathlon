package lt.hansa.decathlon.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.ProcessingInstruction;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.OutputStream;

import lt.hansa.decathlon.data.DecathlonRez;
import static lt.hansa.decathlon.conf.AppParameters.XSL_FILE;
import static lt.hansa.decathlon.app.DecathlonApplication.getApplication;

/**
 * Created by IntelliJ IDEA.
 * User: Aurimas Mameniskis
 * Date: Jun 2, 2008
 * Time: 8:19:43 PM
 * To change this template use File | Settings | File Templates.
 */

public class XmlOutput implements OutputProc {

    private Element root;
    private Document document;
    private OutputStream outputStream;

    /**
     * Constructor
     *
     * @param outputStream
     */
    public XmlOutput(OutputStream outputStream) {
        this.outputStream = outputStream;
        try {

            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            ProcessingInstruction instruction = document.createProcessingInstruction("xml-stylesheet", "type=\"text/xsl\" href=\"" + getApplication().getProperty(XSL_FILE) + "\"");
            document.appendChild(instruction);
            root = document.createElement("RESULTS");
            document.appendChild(root);
        } catch (ParserConfigurationException e) {
            throw new IllegalStateException("Cann't create XML", e);
        }
    }

    /**
     * @param placeName
     * @param result
     */
    public void writeResultToXML(String placeName, DecathlonRez result) {
        Element results = document.createElement("ATHLET");
        results.setAttribute("PLACE", placeName);
        results.setAttribute("NAME", result.getAthlet());
        results.setAttribute("SCORE", Integer.toString(result.getTotalPoints()));
        results.setAttribute("running100m", Double.toString(result.getRunning100m()));
        results.setAttribute("longJump", Double.toString(result.getLongJump()));
        results.setAttribute("shotPut", Double.toString(result.getShotPut()));
        results.setAttribute("highJump", Double.toString(result.getHighJump()));
        results.setAttribute("running400m", Double.toString(result.getRunning400m()));
        results.setAttribute("running100mHurdles", Double.toString(result.getRunning100mHurdles()));
        results.setAttribute("discusThrow", Double.toString(result.getDiscusThrow()));
        results.setAttribute("poleVault", Double.toString(result.getPoleVault()));
        results.setAttribute("javelinThrow", Double.toString(result.getJavelinThrow()));
        results.setAttribute("running1500m", Double.toString(result.getRunning1500m()));
        root.appendChild(results);

    }

    /**
     *
     */
    public void closeXML() {
        try {
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer();
            transformer.transform(new DOMSource(document), new StreamResult(outputStream));
            outputStream.flush();
            outputStream.close();
        } catch (TransformerConfigurationException e) {
            throw new IllegalStateException("Cann't write XML", e);
        } catch (TransformerException e) {
            throw new IllegalStateException("Cann't write XML", e);
        } catch (IOException e) {
            throw new IllegalStateException("Cann't write XML", e);
        }
    }

}

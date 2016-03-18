package lt.hansa.decathlon.app;

import lt.hansa.decathlon.data.CsvReader;
import lt.hansa.decathlon.data.DecathlonPlaceCalc;
import static lt.hansa.decathlon.conf.AppParameters.*;
import lt.hansa.decathlon.xml.XmlOutput;


import java.io.*;
import java.util.Properties;

/**
 * Created by IntelliJ IDEA.
 * User: Aurimas Mameniskis
 * Date: May 30, 2008
 * Time: 8:28:01 AM
 */

public class DecathlonApplication {

    private static Properties prop;

    private static DecathlonApplication app = null;

    /**
     * Returns instance of application
     * @return application
     */
    public static DecathlonApplication getApplication() {
        if (app == null) {
            app = new DecathlonApplication();
        }
        return app;
    }

    /**
     * This program entry point
     *
     * @param args
     */
    public static void main(String[] args) {
        app = new DecathlonApplication();
        app.init("conf/DecathlonApplication.properties");
        try {
            app.run();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void run() throws FileNotFoundException {
        info("Preparing csv " + prop.getProperty(INPUT_FILE) + " file");
        DecathlonPlaceCalc place = new DecathlonPlaceCalc();
        place.addResults(new CsvReader(new FileInputStream(prop.getProperty(INPUT_FILE))).getResults());
        info("Preparing output " + prop.getProperty(OUTPUT_FILE) + " file");
        place.outputResults(new XmlOutput(new FileOutputStream(prop.getProperty(OUTPUT_FILE))));
        info("program exiting ... ");
    }

    /**
     * Initializes applicaion properties
     *
     * @param path
     */
    public void init(String path) {
        prop = new Properties();
        try {
            prop.load(new FileInputStream(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retuns application property value
     *
     * @param property
     * @return Retuns application property value
     */
    public static String getProperty(String property) {
        return prop.getProperty(property);
    }

    private static void info(String value) {
        System.out.println(value);
    }
}

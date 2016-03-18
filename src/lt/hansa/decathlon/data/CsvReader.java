package lt.hansa.decathlon.data;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import static lt.hansa.decathlon.conf.AppParameters.CSV_DELIMITER;
import static lt.hansa.decathlon.app.DecathlonApplication.getApplication;

/**
 * Created by IntelliJ IDEA.
 * User: Aurimas Mameniskis
 * Date: May 30, 2008
 * Time: 8:39:53 AM
 * To change this template use File | Settings | File Templates.
 */
public class CsvReader {
    private BufferedReader reader;

    /**
     * @param input
     */
    public CsvReader(InputStream input) {
        reader = new BufferedReader(new InputStreamReader(input));
    }

    /**
     * @return results
     */
    public List<DecathlonRez> getResults() {
        List<DecathlonRez> results = new ArrayList<DecathlonRez>();
        try {
            String line = null;
            while ((line = reader.readLine()) != null) {
                //cheking if line is not empty, if empty we skip that line
                if (line.trim().length() > 0) {
                    results.add(parseAthletData(line));
                } else {
                    continue;
                }
            }
        } catch (IOException e) {
            System.out.println("Read error.. " + e.getMessage());
        }
        return results;
    }

    /**
     * @param line
     * @return object
     */
    public static DecathlonRez parseAthletData(String line) {
        //geting parameter from config file csv delimiter
        String[] temp = line.split(getApplication().getProperty(CSV_DELIMITER));
        return new DecathlonRez(
                temp[0],
                ConvertTime(temp[1]),
                ConvertCM(temp[2]),
                ConvertStrToDouble(temp[3]),
                ConvertCM(temp[4]),
                ConvertTime(temp[5]),
                ConvertTime(temp[6]),
                ConvertStrToDouble(temp[7]),
                ConvertCM(temp[8]),
                ConvertStrToDouble(temp[9]),
                ConvertTime(temp[10])
        );
    }

    /**
     * funtion to convert value to centimeters.
     * @param value
     * @return
     * @throws NumberFormatException
     */
    public static double ConvertCM(String value) throws NumberFormatException {
        return ConvertStrToDouble(value) * 100;
    }

    /**
     * function to convert time to seconds, dos not matter if time is with mills or not
     * @param value
     * @return
     * @throws NumberFormatException
     */
    public static double ConvertTime(String value) throws NumberFormatException {
        int FirstIndex = value.indexOf(".");
        int LastIndex = value.lastIndexOf(".");
        //cheking if time has mili seconds
        if (FirstIndex == LastIndex) {
            //if not than return just that value that were.
            return ConvertStrToDouble(value);
        } else {
            String minutesStr = value.substring(0, FirstIndex);
            value = value.substring(FirstIndex + 1);
            return ConvertStrToDouble(minutesStr) * 60 + ConvertStrToDouble(value);
        }
    }

    /**
     * simple functiont to convert string value to double
     * @param value
     * @return
     * @throws NumberFormatException
     */
    public static double ConvertStrToDouble(String value) throws NumberFormatException {
        return Double.parseDouble(value);
    }

}

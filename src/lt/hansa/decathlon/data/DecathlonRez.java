package lt.hansa.decathlon.data;

import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * User: Aurimas Mameniskis
 * Date: May 30, 2008
 * Time: 9:51:12 AM
 * To change this template use File | Settings | File Templates.
 */
public class DecathlonRez {
    /*
        class variables
     */
    private String Athlet;
    private double running100m;
    private double longJump;
    private double shotPut;
    private double highJump;
    private double running400m;
    private double running100mHurdles;
    private double discusThrow;
    private double poleVault;
    private double javelinThrow;
    private double running1500m;

    private int TotalPoints;


    /**
     * @param Athlet
     * @param running100m
     * @param longJump
     * @param shotPut
     * @param highJump
     * @param running400m
     * @param running100mHurdles
     * @param discusThrow
     * @param poleVault
     * @param javelinThrow
     * @param running1500m
     */
    public DecathlonRez(
            String Athlet
            , double running100m
            , double longJump
            , double shotPut
            , double highJump
            , double running400m
            , double running100mHurdles
            , double discusThrow
            , double poleVault
            , double javelinThrow
            , double running1500m) {

        /*
            asigning all the variables to class vars.
         */
        this.Athlet = Athlet;
        this.running100m = round(running100m, 2);
        this.longJump = round(longJump, 2);
        this.shotPut = round(shotPut, 2);
        this.highJump = round(highJump, 2);
        this.running400m = round(running400m, 2);
        this.running100mHurdles = round(running100mHurdles, 2);
        this.discusThrow = round(discusThrow, 2);
        this.poleVault = round(poleVault, 2);
        this.javelinThrow = round(javelinThrow, 2);
        this.running1500m = round(running1500m, 2);

        /*
            calculation of total score for Decathlon
            it is made for automatic calculation, if it would be
            manual than we need to uncomment values
         */
        this.TotalPoints = 0;
        this.TotalPoints += RunFormula(EventConstants.RUN_100M, running100m /*+ 0.24*/);
        this.TotalPoints += FieldFormula(EventConstants.LONG_JUMP, longJump);
        this.TotalPoints += FieldFormula(EventConstants.SHOT_PUT, shotPut);
        this.TotalPoints += FieldFormula(EventConstants.HIGH_JUMP, highJump);
        this.TotalPoints += RunFormula(EventConstants.RUN_400M, running400m /*+ 0.14 */);
        this.TotalPoints += RunFormula(EventConstants.RUN_100M_HURDLES, running100mHurdles/* + 0.24*/);
        this.TotalPoints += FieldFormula(EventConstants.DISCUS_THROW, discusThrow);
        this.TotalPoints += FieldFormula(EventConstants.POLE_VAULT, poleVault);
        this.TotalPoints += FieldFormula(EventConstants.JAVELIN_THROW, javelinThrow);
        this.TotalPoints += RunFormula(EventConstants.RUN_1500M, running1500m);

    }

    /**
     * @return Athlet
     */
    public String getAthlet() {
        return Athlet;
    }

    /**
     * @return running100m
     */
    public double getRunning100m() {
        return running100m;
    }

    /**
     * @return longJump
     */
    public double getLongJump() {
        return longJump;
    }

    /**
     * @return shotPut
     */
    public double getShotPut() {
        return shotPut;
    }

    /**
     * @return highJump
     */
    public double getHighJump() {
        return highJump;
    }

    /**
     * @return running400m
     */
    public double getRunning400m() {
        return running400m;
    }

    /**
     * @return running100mHurdles
     */
    public double getRunning100mHurdles() {
        return running100mHurdles;
    }

    /**
     * @return discusThrow
     */
    public double getDiscusThrow() {
        return discusThrow;
    }

    /**
     * @return poleVault
     */
    public double getPoleVault() {
        return poleVault;
    }

    /**
     * @return javelinThrow
     */
    public double getJavelinThrow() {
        return javelinThrow;
    }

    /**
     * @return running1500m
     */
    public double getRunning1500m() {
        return running1500m;
    }

    /**
     * @return TotalPoints
     */
    public int getTotalPoints() {
        return TotalPoints;
    }

    /**
     * Runnin formula
     * @param constant
     * @param P
     * @return score
     */
    public static int RunFormula(EventConstants constant, double P) {
        int score = (int) Math.floor(constant.a * Math.pow((constant.b - P), constant.c));
        return score;
    }

    /**
     * Field Formula
     * @param constant
     * @param P
     * @return score
     */
    public static int FieldFormula(EventConstants constant, double P) {
        int score = (int) Math.floor(constant.a * Math.pow((P - constant.b), constant.c));
        return score;
    }

    /**
     * function to round double numbers 
     * @param d
     * @param decimalPlace
     * @return
     */
    private static double round(double d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Double.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.doubleValue();
    }

}

package lt.hansa.decathlon.data;

/**
 * Created by IntelliJ IDEA.
 * User: Aurimas Mameniskis
 * Date: May 30, 2008
 * Time: 9:23:49 AM
 * To change this template use File | Settings | File Templates.
 */
public enum EventConstants {
    /*
        constants for each event.
     */
    RUN_100M(25.437, 18.0, 1.81),
    LONG_JUMP(0.14354, 220, 1.40),
    SHOT_PUT(51.39, 1.5, 1.05),
    HIGH_JUMP(0.8465, 75, 1.42),
    RUN_400M(1.53775, 82, 1.81),
    RUN_100M_HURDLES(5.74352, 28.5, 1.92),
    DISCUS_THROW(12.91, 4.0, 1.1),
    POLE_VAULT(0.2797, 100, 1.35),
    JAVELIN_THROW(10.14, 7.0, 1.08),
    RUN_1500M(0.03768, 480, 1.85);

    public double a;
    public double b;
    public double c;

    /**
     * @param A
     * @param B
     * @param C
     */
    EventConstants(double A, double B, double C) {
        a = A;
        b = B;
        c = C;
    }
}

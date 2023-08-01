package model;
import java.util.HashMap;
import java.util.Map;

public class TimeConverter {
    public enum TimeUnit {
        SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS
    }

    private static final Map<TimeUnit, Double> TIME_UNIT_TO_SECONDS = new HashMap<>();
    private static final Map<TimeUnit, Double> SECONDS_TO_TIME_UNIT = new HashMap<>();

    static {
        TIME_UNIT_TO_SECONDS.put(TimeUnit.SECONDS, 1.0);
        TIME_UNIT_TO_SECONDS.put(TimeUnit.MINUTES, 60.0);
        TIME_UNIT_TO_SECONDS.put(TimeUnit.HOURS, 3600.0);
        TIME_UNIT_TO_SECONDS.put(TimeUnit.DAYS, 86400.0);
        TIME_UNIT_TO_SECONDS.put(TimeUnit.WEEKS, 604800.0);
        TIME_UNIT_TO_SECONDS.put(TimeUnit.MONTHS, 2592000.0); // Aproximación de 30 días por mes
        TIME_UNIT_TO_SECONDS.put(TimeUnit.YEARS, 31536000.0); // Aproximación de 365 días por año

        SECONDS_TO_TIME_UNIT.put(TimeUnit.SECONDS, 1.0);
        SECONDS_TO_TIME_UNIT.put(TimeUnit.MINUTES, 1.0 / 60.0);
        SECONDS_TO_TIME_UNIT.put(TimeUnit.HOURS, 1.0 / 3600.0);
        SECONDS_TO_TIME_UNIT.put(TimeUnit.DAYS, 1.0 / 86400.0);
        SECONDS_TO_TIME_UNIT.put(TimeUnit.WEEKS, 1.0 / 604800.0);
        SECONDS_TO_TIME_UNIT.put(TimeUnit.MONTHS, 1.0 / 2592000.0); // Aproximación de 30 días por mes
        SECONDS_TO_TIME_UNIT.put(TimeUnit.YEARS, 1.0 / 31536000.0); // Aproximación de 365 días por año
    }

    public double convertTime(double value, TimeUnit fromUnit, TimeUnit toUnit) {
        double seconds = value * TIME_UNIT_TO_SECONDS.get(fromUnit);
        return seconds * SECONDS_TO_TIME_UNIT.get(toUnit);
    }
}

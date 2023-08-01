package model;

public class TimeConverterTest {
    public static void main(String[] args) {
        TimeConverter converter = new TimeConverter();

        // Casos de prueba
        double value = 60;

        // Convertir 10 segundos a otras unidades de tiempo
        System.out.println("10 segundos equivale a:");
        System.out.println("Minutos: " + converter.convertTime(value, TimeConverter.TimeUnit.SECONDS, TimeConverter.TimeUnit.MINUTES));
        System.out.println("Horas: " + converter.convertTime(value, TimeConverter.TimeUnit.SECONDS, TimeConverter.TimeUnit.HOURS));
        System.out.println("Días: " + converter.convertTime(value, TimeConverter.TimeUnit.SECONDS, TimeConverter.TimeUnit.DAYS));
        System.out.println("Semanas: " + converter.convertTime(value, TimeConverter.TimeUnit.SECONDS, TimeConverter.TimeUnit.WEEKS));
        System.out.println("Meses: " + converter.convertTime(value, TimeConverter.TimeUnit.SECONDS, TimeConverter.TimeUnit.MONTHS));
        System.out.println("Años: " + converter.convertTime(value, TimeConverter.TimeUnit.SECONDS, TimeConverter.TimeUnit.YEARS));

        // Convertir 10 minutos a otras unidades de tiempo
        System.out.println("\n10 minutos equivale a:");
        System.out.println("Segundos: " + converter.convertTime(value, TimeConverter.TimeUnit.MINUTES, TimeConverter.TimeUnit.SECONDS));
        System.out.println("Horas: " + converter.convertTime(value, TimeConverter.TimeUnit.MINUTES, TimeConverter.TimeUnit.HOURS));
        System.out.println("Días: " + converter.convertTime(value, TimeConverter.TimeUnit.MINUTES, TimeConverter.TimeUnit.DAYS));
        System.out.println("Semanas: " + converter.convertTime(value, TimeConverter.TimeUnit.MINUTES, TimeConverter.TimeUnit.WEEKS));
        System.out.println("Meses: " + converter.convertTime(value, TimeConverter.TimeUnit.MINUTES, TimeConverter.TimeUnit.MONTHS));
        System.out.println("Años: " + converter.convertTime(value, TimeConverter.TimeUnit.MINUTES, TimeConverter.TimeUnit.YEARS));

        // Agrega más casos de prueba según tus necesidades
    }
}

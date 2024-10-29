package utils;

import java.util.regex.Pattern;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.regex.Matcher;


public class Fecha {
    private String dia;
    private String mes;
    private String anio;
    private String entrada;

    public Fecha(String entrada){
        this.entrada = entrada;
    }

    public boolean esFechaValida() {
        // Expresión regular para el formato dd/mm/aaaa
        String regex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(\\d{4})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(this.entrada);
        
        if (!matcher.matches()) {
            return false; // Formato incorrecto
        }

        // Ahora verifica la validez de la fecha
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        formatoFecha.setLenient(false); // Establecemos a false para que lance excepción en fechas inválidas

        try {
            Date fechaDate = formatoFecha.parse(this.entrada);
            String fechaTemp = fechaDate.toString();

            String[] partesFecha = fechaTemp.split("\s");
            this.dia = partesFecha[2];
            this.mes = switch(partesFecha[1]){
                case "Jan" -> "01";
                case "Feb" -> "02";
                case "Mar" -> "03";
                case "Apr" -> "04";
                case "May" -> "05";
                case "Jun" -> "06";
                case "Jul" -> "07";
                case "Aug" -> "08";
                case "Sep" -> "09";
                case "Oct" -> "10";
                case "Nov" -> "11";
                case "Dic" -> "12";
                default -> null;
            };
            this.anio = partesFecha[5];

            return true; // Fecha válida
        } catch (Exception e) {
            return false; // Fecha inválida
        }
    }

    public static boolean verificarFechaMayorALaActual(Fecha fechaAComparar){
        String fechaYHoraActual = Clock.systemUTC().instant().toString();
        String soloFechaActual = fechaYHoraActual.split("T")[0];
        String[] partesFechaActual = soloFechaActual.split("-");
        return Integer.parseInt(fechaAComparar.anio) >= Integer.parseInt(partesFechaActual[0]) &&
               Integer.parseInt(fechaAComparar.mes) >= Integer.parseInt(partesFechaActual[1]) &&
               Integer.parseInt(fechaAComparar.dia) >= Integer.parseInt(partesFechaActual[2]);
    }

    public String getFechaConFormatoValidoEnBD(){
        return this.anio + "-" + this.mes + "-" + this.dia;  
    }
}

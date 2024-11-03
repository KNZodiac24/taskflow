package utils;

import java.util.regex.Pattern;


import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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

        return rellenarFecha();
    }

    public boolean rellenarFecha(){
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
                case "Dec" -> "12";
                default -> null;
            };
            this.anio = partesFecha[5];

            return true; // Fecha válida
        } catch (Exception e) {
            return false; // Fecha inválida
        }
    }

    public static int verificarFechaMayorALaActual(String fechaAComparar){
        Date fechaActual = new Date();
        Date fechaComparar = null;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        formato.setLenient(false);
        
        try {
            fechaComparar = formato.parse(fechaAComparar);
        }catch (ParseException e){
            System.out.println(e);
        }

        fechaActual = removerTiempo(fechaActual);

        return fechaComparar.compareTo(fechaActual);
    }

    private static Date removerTiempo(Date fechaYHora) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaYHora);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static boolean haPasadoUnMinuto(Date fechaDeCreacion){
        long diferenciaEnMillis = new Date().getTime() - fechaDeCreacion.getTime();
        
        return diferenciaEnMillis > 60000;
    }

    public String getFechaConFormatoValidoEnBD(){
        return this.anio + "-" + this.mes + "-" + this.dia;  
    }

    @Override
    public String toString(){
        return this.dia + "/" + this.mes + "/" + this.anio;
    }
}

package com.maquistemas.reactivo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpresionesRegulares {
	
	/**
         * http://chuwiki.chuidiang.org/index.php?title=Expresiones_Regulares_en_Java
		 *
    */

    public static void main(String[] args) {
        String regexp = "\\d{1,2}/\\d{1,2}/\\d{4}";

// Lo siguiente devuelve true
        System.out.println(Pattern.matches(regexp, "11/12/2014"));
        System.out.println(Pattern.matches(regexp, "1/12/2014"));
        System.out.println(Pattern.matches(regexp, "11/2/2014"));


// Los siguientes devuelven false
        System.out.println(Pattern.matches(regexp, "11/12/14"));  // El año no tiene cuatro cifras
        System.out.println(Pattern.matches(regexp, "11//2014"));  // el mes no tiene una o dos cifras
        System.out.println(Pattern.matches(regexp, "11/12/14perico"));  // Sobra "perico"

        System.out.println("--------------------------------Codigo con parámetro------------------------------------");
        String currency = "PEN";
        String regex = "(AMOUNT_)"+currency+"_"+"(CCE|BCR)";
        String param = "AMOUNT_PEN_CCE";
        if(Pattern.matches(regex, param)) {
            System.out.println("Bienvenido");
        }else {
            System.out.println("No estas bienvenido");
        }

        System.out.println("-------------------------------DNI y NOMBRE------------------------------------");
        String regex01 = "\\d{8}(JOHN)";
        String param01 = "40199696JOHN";
        System.out.println("regex01: "+ Pattern.matches(regex01, param01));

        System.out.println("-------------------------------DNI y solo una letra Sin Vocales ni Ñ------------------------------------");
        String regex02 = "\\d{8}[B-DF-HJ-NP-TV-Z]";
        String param02 = "40199696J";
        System.out.println("regex02: "+ Pattern.matches(regex02, param02));

        System.out.println("-------------------------------DNI y Dos a mas letras Sin Vocales ni Ñ------------------------------------");
        String regex03 = "\\d{8}[B-DF-HJ-NP-TV-Z]{2,}";
        String param03 = "40199696JHN";
        System.out.println("regex03: "+ Pattern.matches(regex03, param03));

        System.out.println("-------------------------------Email------------------------------------");
        String regex04 = "[^@]+@[^@]+\\.[a-zA-Z]{2,}";
        String param04 = "mi_email@hotmail.com";
        System.out.println("regex04: "+ Pattern.matches(regex04, param04));

        System.out.println("-------------------------------Remplazar ------------------------------------");
        String regex05 = "\\d{16}";
        String param05 = "1234567890123456";
        System.out.println(param05.replaceAll(regex05,"***"));

        System.out.println("-------------------------------Remplazar json------------------------------------");
        String param06 = "{\n" +
                "  \"name\":\"John\",\n" +
                "  \"age\":30,\n" +
                "  \"cars\": {\n" +
                "    \"car1\":\"Ford\",\n" +
                "    \"car2\":\"BMW\",\n" +
                "    \"car3\":\"Fiat\"\n" +
                "  }\n" +
                " }";

        String regex06 = "car1\":\\s*\"[^\"]+?([^\\/\"]+)";
        String replace = "car1\":\"***";
        System.out.println(param06.replaceAll(regex06,replace));


        System.out.println("-------------------------------Remplazar json2------------------------------------");
        String param07 = "{\n" +
                "  \"name\":\"John\",\n" +
                "  \"age\":30,\n" +
                "  \"cars\": {\n" +
                "    \"car1\":\"Ford\",\n" +
                "    \"car2\":\"BMW\",\n" +
                "    \"car3\":\"Fiat\"\n" +
                "  }\n" +
                " }";

        String regex07 = "name\":\\s*\"[^\"]+?([^\\/\"]+)";
        String replace01 = "name\":\"***";
        String regex08 = "car1\":\\s*\"[^\"]+?([^\\/\"]+)";
        String replace02 = "car1\":\"***";
        String s1 = param06.replaceAll(regex07,replace01).replaceAll(regex08, replace02);
        System.out.println(s1);


        System.out.println("-------------------------------split------------------------------------");

        String cadena = "23+12=35";
        Pattern patron = Pattern.compile("(\\d+)\\+(\\d+)=(\\d+)");
        Matcher matcher = patron.matcher(cadena);
        matcher.find();
        System.out.println(matcher.group(1));
        System.out.println(matcher.group(2));
        System.out.println(matcher.group(3));

    }


}


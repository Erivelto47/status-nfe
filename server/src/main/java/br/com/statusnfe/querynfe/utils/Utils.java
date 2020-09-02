package br.com.statusnfe.querynfe.utils;

public class Utils {

    public static String removeHtmlTags(String htmlString) {
        return htmlString.replaceAll("<[^>]*>", "");
    }

    public static String removeHifens(String string) {
        return string.replaceAll("-", "");
    }

    public static String removeAll(String string) {
        return removeHifens(removeHtmlTags(string));
    }
}

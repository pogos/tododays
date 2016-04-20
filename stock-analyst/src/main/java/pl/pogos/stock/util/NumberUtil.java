package pl.pogos.stock.util;

public final class NumberUtil {

    private NumberUtil() {
    }

    public static Double parse(String value) {
        try {
            return Double.parseDouble(value.trim().replaceAll(" ", "").replaceAll(",", "."));
        } catch (NumberFormatException ex) {
            return null;
        }
    }
}

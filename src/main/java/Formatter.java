import java.text.DecimalFormat;

public class Formatter {
    public String formatRub(double price) {

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String formatPrice = decimalFormat.format(price);

        int priceRub = (int) price;
        if (priceRub == 11 || priceRub == 12 || priceRub == 13 || priceRub == 14) {
            return formatPrice + " рублей";
        }
        else if (priceRub % 10 == 1) {
            return formatPrice + " рубль";
        }
        else if (priceRub % 10 == 2 || priceRub % 10 == 3 || priceRub % 10 == 4 ) {
            return formatPrice + " рубля";
        }
        else {
            return formatPrice + " рублей";
        }
    }

}




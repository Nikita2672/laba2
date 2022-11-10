package util;

import java.math.BigDecimal;

public class Validator {
    public static boolean validate(String r, String x, String y, String fromG) {
        try {
            BigDecimal paramY = new BigDecimal(y);
            BigDecimal paramR = new BigDecimal(r);
            if (fromG.equals("true")) {
                Double.parseDouble(x);
                return true;
            } else {
                int paramX = Integer.parseInt(x);
                if (paramX < -3) {
                    return false;
                } else if (paramX > 5) {
                    return false;
                } else if (paramY.compareTo(new BigDecimal(5)) > 0) {
                    return false;
                } else if (paramY.compareTo(new BigDecimal(-5)) < 0) {
                    return false;
                } else if (paramR.compareTo(new BigDecimal(2)) < 0) {
                    return false;
                } else return paramR.compareTo(new BigDecimal(5)) <= 0;
            }
        } catch (IllegalArgumentException | NullPointerException e) {
            return false;
        }
    }
}

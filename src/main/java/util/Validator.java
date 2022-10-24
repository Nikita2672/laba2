package util;

public class Validator {
    public static boolean validate(String r, String x, String y, String fromG) {
        try {
            double paramY = Double.parseDouble(y);
            double paramR = Double.parseDouble(r);
            if (fromG.equals("true")) {
                Double.parseDouble(x);
                return true;
            } else {
                int paramX = Integer.parseInt(x);
                return paramX >= -3 && paramX <= 5 && (paramY >= -5) && (paramY <= 5) && (paramR >= 2) && (paramR <= 5);
            }
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}

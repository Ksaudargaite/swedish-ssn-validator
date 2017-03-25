package lt.kristinute;

public class SSNValidator {

    public boolean isValidSwedishSsn(String ssn) {
        int[] multiples = new int[9];
        int multipliedNumberBy1or2;
        int sumOf9Numbers = 0;
        int valid10thNumber;
        if (ssn.length() != 10 || !ssn.matches("^[0-9]+$")) return false;
        for (int i = 0; i < ssn.length() - 1; ++i) {
            int numberAtIndexI = Integer.parseInt(ssn.substring(i, i + 1));
            if (i % 2 == 0) {
                multipliedNumberBy1or2 = numberAtIndexI * 2;
            } else {
                multipliedNumberBy1or2 = numberAtIndexI;
            }
            if (multipliedNumberBy1or2 > 9) multipliedNumberBy1or2 = 1 + (multipliedNumberBy1or2 % 10);
            multiples[i] = multipliedNumberBy1or2;
        }
        for (int element : multiples) {
            sumOf9Numbers += element;
        }
        valid10thNumber = (10 - (sumOf9Numbers % 10)) % 10;
        return valid10thNumber == Integer.parseInt(ssn.substring(9));

    }

}

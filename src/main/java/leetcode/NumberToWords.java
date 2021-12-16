package leetcode;

public class NumberToWords {

    private String one(int number) {
        switch (number) {
            case 1:
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            case 5:
                return "Five";
            case 6:
                return "Six";
            case 7:
                return "Seven";
            case 8:
                return "Eight";
            case 9:
                return "Nine";
        }
        return "";
    }

    private String twoSmaller20(int number) {
        switch (number) {
            case 10:
                return "Ten";
            case 11:
                return "Eleven";
            case 12:
                return "Twelve";
            case 13:
                return "Thirteen";
            case 14:
                return "Fourteen";
            case 15:
                return "Fifteen";
            case 16:
                return "Sixteen";
            case 17:
                return "Seventeen";
            case 18:
                return "Eighteen";
            case 19:
                return "Nineteen";
        }
        return "";
    }

    private String twoLarger20(int number) {
        String result = "";
        boolean hasRemainder = number%10 != 0;
        switch ((number/10)*10) {
            case 20:
                result += "Twenty";
                break;
            case 30:
                result += "Thirty";
                break;
            case 40:
                result += "Forty";
                break;
            case 50:
                result += "Fifty";
                break;
            case 60:
                result += "Sixty";
                break;
            case 70:
                result += "Seventy";
                break;
            case 80:
                result += "Eighty";
                break;
            case 90:
                result += "Ninety";
                break;
        }

        if (hasRemainder) {
            if (!result.isEmpty()) result += " ";
            result += one(number%10);
        }
        return result;
    }

    private String two(int number) {
        if (number < 20) {
            return twoSmaller20(number);
        }
        return twoLarger20(number);
    }

    public String numberToWords(int num) {


        int hundreds = num/100;

        if (hundreds != 0) {
            return three(num);
        }
        return "";
    }

    private String three(int num) {
        String result = "";
        int hundreds = num/100;
        int rest = num%100;

        if (!result.isEmpty()) result += " ";
        result += one(hundreds);

        if (hundreds > 0) {
            if (!result.isEmpty()) result += " ";
            result += "Hundred";
        }

        if (!result.isEmpty()) result += " ";
        if (rest/20 > 0) {
            result += two(num%100);
        } else {
            result += one(num%100);
        }
        return result;
    }
}

public class ClockWiseAngle {
    private static final int oneMinAngle = 6;
    private static final int oneHourAngle = 30;
    private static final String ERR_EMPTY_INPUT = "Sorry, empty input";
    private static final String ERR_INVALID_INPUT = "Sorry, invalid input";
    private static final String ERR_INVALID_HOUR_INPUT = "Sorry, invalid HOUR input data";
    private static final String ERR_INVALID_MINUTE_INPUT = "Sorry, invalid MINUTE input data";

    public static void main(String[] args) {
        System.out.print("TEST1: Empty input data [], ");
        new ClockWiseAngle().clocke("");
        System.out.print("TEST2: Empty input data [ ], ");
        new ClockWiseAngle().clocke(" ");
        System.out.print("TEST3: Invalid input data [1], ");
        new ClockWiseAngle().clocke("1");
        System.out.print("TEST4: Invalid input data [12345], ");
        new ClockWiseAngle().clocke("12345");
        System.out.print("TEST5: Invalid input data [abcd], ");
        new ClockWiseAngle().clocke("abcd");
        System.out.print("TEST6: Invalid input data [-123], ");
        new ClockWiseAngle().clocke("-123");
        System.out.print("TEST7: Invalid HOUR input data [2534], ");
        new ClockWiseAngle().clocke("2534");
        System.out.print("TEST8: Invalid MINUTE data [1460], ");
        new ClockWiseAngle().clocke("1460");
        System.out.println("=========================================================================");
        System.out.print("TEST9: input data [1230], ");
        new ClockWiseAngle().clocke("1230");
        System.out.print("TEST10: input data [0245], ");
        new ClockWiseAngle().clocke("0245");
        System.out.print("TEST11: input data [1445], ");
        new ClockWiseAngle().clocke("1445");
        System.out.print("TEST12: input data [1754], ");
        new ClockWiseAngle().clocke("1754");
        System.out.print("TEST13: input data [1710], ");
        new ClockWiseAngle().clocke("1710");
        System.out.print("TEST14: input data [1200], ");
        new ClockWiseAngle().clocke("1200");
    }

    public void clocke(String str) {
        if (!isValidInput(str)) {
            return;
        }

        int hour = getHour(str);
        int minute = getMinute(str);

        if (!isValidData(hour, minute)) {
            return;
        }

        double minuteAngle = oneMinAngle * minute;
        double hourAngle = (hour % 12 + minute / 60.0) * oneHourAngle;
        double result = hourAngle > minuteAngle ? 360 - (hourAngle - minuteAngle) : minuteAngle - hourAngle;

        System.out.println(result);
    }

    private boolean isValidInput(String str) {
        if (str == null || str.trim().length() == 0) {
            System.out.println(ERR_EMPTY_INPUT);
            return false;
        }

        if (str.length() != 4) {
            System.out.println(ERR_INVALID_INPUT);
            return false;
        }

        if (!str.chars().allMatch(Character::isDigit)) {
            System.out.println(ERR_INVALID_INPUT);
            return false;
        }

        return true;
    }

    private boolean isValidData(int hour, int minute) {
        if (hour > 24 || hour < 0) {
            System.out.println(ERR_INVALID_HOUR_INPUT);
            return false;
        }
        if (minute > 59 || minute < 0) {
            System.out.println(ERR_INVALID_MINUTE_INPUT);
            return false;
        }

        return true;
    }

    private int getHour(String str) {
        return Integer.parseInt(str.substring(0, 2));
    }

    private int getMinute(String str) {
        return Integer.parseInt(str.substring(2));
    }
}
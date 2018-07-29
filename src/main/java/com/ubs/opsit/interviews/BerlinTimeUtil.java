package com.ubs.opsit.interviews;

public class BerlinTimeUtil {

    public static String getBerlinHour(int hour) {
        StringBuilder hourBuilder = new StringBuilder();
        buildHourRow(hourBuilder, hour / 5);
        nextLine(hourBuilder);
        buildHourRow(hourBuilder, hour % 5);
        return hourBuilder.toString();
    }

    public static String getBerlinMinute(int minute) {
        StringBuilder minuteBuilder = new StringBuilder();
        buildMinuteFirstRow(minuteBuilder, minute / 5);
        nextLine(minuteBuilder);
        buildMinuteSecondRow(minuteBuilder, minute % 5);
        return minuteBuilder.toString();
    }

    public static String getBerlinSecond(int second) {
        if (second == 0 || second % 2 == 0) {
            return "Y";
        }
        return "O";
    }

    private static void buildHourRow(StringBuilder hourBuilder, int row) {
        int lightCount = 4;
        while (row > 0) {
            hourBuilder.append("R");
            row--;
            lightCount--;
        }
        fillVoidSpace(hourBuilder, lightCount);
    }

    private static void buildMinuteFirstRow(StringBuilder minuteBuilder, int firstRow) {
        int count = 1;
        int rowLength = 11;
        while (count <= firstRow) {
            if (count % 3 == 0) {
                minuteBuilder.append("R");
            } else {
                minuteBuilder.append("Y");
            }
            count++;
            rowLength--;
        }
        fillVoidSpace(minuteBuilder, rowLength);
    }

    private static void buildMinuteSecondRow(StringBuilder minuteBuilder, int secondRow) {
        int rowLength = 4;
        while (secondRow > 0) {
            minuteBuilder.append("Y");
            secondRow--;
            rowLength--;
        }
        fillVoidSpace(minuteBuilder, rowLength);
    }

    private static void fillVoidSpace(StringBuilder minuteBuilder, int rowLength) {
        while (rowLength > 0) {
            minuteBuilder.append("O");
            rowLength--;
        }
    }

    private static void nextLine(StringBuilder builder) {
        builder.append("\n");
    }
}

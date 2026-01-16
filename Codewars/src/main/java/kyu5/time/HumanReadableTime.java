package kyu5.time;

public class HumanReadableTime {

    public static String makeReadable(int totalSeconds) {

        final TimeResult hours = calculateTimeResult(totalSeconds, 3600);
        final String humanReadableHours = toHumanReadable(hours.getValue());
        final TimeResult minutes = calculateTimeResult(hours.getRemainder(), 60);
        final String humanReadAbleMinutes = toHumanReadable(minutes.getValue());
        final String humanReadableSeconds = toHumanReadable(minutes.getRemainder());

        return String.format("%s:%s:%s", humanReadableHours, humanReadAbleMinutes, humanReadableSeconds);
    }

    private static String toHumanReadable(int value){
        return isSingleDigit(value)? "0" + value: String.valueOf(value);
    }
    private static TimeResult calculateTimeResult(int totalSeconds, int factor){
        final int value = totalSeconds / factor;
        final int remainder = totalSeconds % factor;
        return new TimeResult(value, remainder);
    }
    private static boolean isSingleDigit(int time){
        return String.valueOf(time).length() == 1;
    }

}

/*
    public class HumanReadableTime {
        public static String makeReadable(int seconds) {
             return String.format("%02d:%02d:%02d", seconds / 3600, (seconds / 60) % 60, seconds % 60);
        }
     }
 */

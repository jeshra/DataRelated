import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class PrintDates {
    public static void main(String[] args) {
        System.out.println(printDateRangeForNumberOfDays("2019-02-28", 15));
        /**
         * [2019-03-31, 2019-04-01, 2019-04-02, 2019-04-03, 2019-04-04, 2019-04-05, 2019-04-06, 2019-04-07, 2019-04-08, 2019-04-09, 2019-04-10, 2019-04-11, 2019-04-12, 2019-04-13, 2019-04-14]
         */
        System.out.println(printDateRangeBetweenDates("2019-04-09", "2019-03-31"));
        /**
         * [2019-03-31, 2019-04-01, 2019-04-02, 2019-04-03, 2019-04-04, 2019-04-05, 2019-04-06, 2019-04-07, 2019-04-08, 2019-04-09]
         */
    }

    public static List<LocalDate> printDateRangeForNumberOfDays(String startDate, int numberOfDays) {
        LocalDate startOflocalDate = LocalDate.parse(startDate);
        //Function<LocalDate, LocalDate> localDateLocalDateFunction = (LocalDate g) -> g.plusDays(1);
        return Stream.iterate(startOflocalDate, vLocalDate -> vLocalDate.plusDays(1)).
                limit(Math.abs(numberOfDays))
                .collect(Collectors.toList());
    }

    public static List<LocalDate> printDateRangeBetweenDates(String startDate, String endDate) {
        LocalDate startOflocalDate = LocalDate.parse(startDate);
        LocalDate endOflocalDate = LocalDate.parse(endDate);
        //Function<LocalDate, LocalDate> localDateLocalDateFunction = (LocalDate g) -> g.plusDays(1);
        LocalDate startWithDate;
        startWithDate = startOflocalDate.isBefore(endOflocalDate) ? startOflocalDate : endOflocalDate;
        return Stream.iterate(startWithDate, vLocalDate -> vLocalDate.plusDays(1)).
                limit(Math.abs(ChronoUnit.DAYS.between(startOflocalDate, endOflocalDate)) + 1)
                .collect(Collectors.toList());

    }
}

package pl.pogos.stock.util;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by SG0952928 on 2016-04-20.
 */
@RunWith(DataProviderRunner.class)
public class DateUtilTest {

    @DataProvider
    public static Object[][] provideHoursAndDates() {
        return new Object[][] {
                {"05:29", 5, 29},
                {"5:29", 5, 29},
                {"16:10", 16, 10},
                {"11:07", 11, 7}
        };
    }

    @Test
    @UseDataProvider("provideHoursAndDates")
    public void shouldReturnTodayDateWithTime(String strTime, int hour, int minute) {
        //GIVEN
        LocalDateTime todayWithHour = getTodayWithHour(hour, minute);

        //WHEN
        Date date = DateUtil.todayAt(strTime);

        //THEN
        assertThat(todayWithHour, equalTo(LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault())));
    }

    private LocalDateTime getTodayWithHour(int hour, int minute) {
        return LocalDateTime.of(LocalDate.now(), LocalTime.of(hour, minute));
    }

}
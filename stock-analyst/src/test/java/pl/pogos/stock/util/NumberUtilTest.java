package pl.pogos.stock.util;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by SG0952928 on 2016-04-19.
 */
@RunWith(DataProviderRunner.class)
public class NumberUtilTest {

    @DataProvider
    public static Object[][] provideStringAndExpectedValue() {
        return new Object[][] {
                {"1 962,37", 1962.37},
                {"0,82", 0.82},
                {"367 947,90", 367947.90}
        };
    }

    @Test
    @UseDataProvider("provideStringAndExpectedValue")
    public void shouldConvertStringValueToDouble(String strValue, Double doubleValue) {
        //GIVEN

        //WHEN
        Double result = NumberUtil.parse(strValue);

        //THEN
        assertThat(result, equalTo(doubleValue));
    }

    @Test
    public void shouldReturnNullIfCanNotParseString() {
        //GIVEN

        //WHEN
        Double result = NumberUtil.parse("---");

        //THEN
        assertThat(result, nullValue());
    }



}
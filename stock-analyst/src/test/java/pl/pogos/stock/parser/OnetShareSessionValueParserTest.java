package pl.pogos.stock.parser;

import org.junit.Test;
import pl.pogos.stock.dto.ValueDTO;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;

/**
 * Created by SG0952928 on 2016-04-19.
 */
public class OnetShareSessionValueParserTest {

    @Test
    public void shouldGetSharesValuesFormOnetPage() {
        //GIVEN
        OnetShareValueParser parser = new OnetShareValueParser();

        //WHEN
        List<ValueDTO> list = parser.parse();

        //THAN
        assertThat(list, is(not(empty())));
    }


}
package pl.pogos.stock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import pl.pogos.stock.config.DatabaseConfiguration;
import pl.pogos.stock.config.ServiceConfiguration;
import pl.pogos.stock.dto.ValueDTO;
import pl.pogos.stock.model.SessionValue;
import pl.pogos.stock.parser.OnetShareValueParser;
import pl.pogos.stock.parser.ShareValueParser;
import pl.pogos.stock.repository.ValueRepository;

import javax.inject.Inject;
import java.util.List;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {ServiceConfiguration.class, DatabaseConfiguration.class})
@WebAppConfiguration
public class ParseServiceTest {

    @Inject
    private ParseService parseService;

    @Inject
    private ValueRepository valueRepository;


    private ShareValueParser shareValueParser = new OnetShareValueParser();

    @Test
    public void shouldSaveParsedData() {
        //GIVEN
        List<ValueDTO> dtos = shareValueParser.parse();

        //WHEN
        parseService.saveShareValues(dtos);

        //THAN
        List<SessionValue> sessionValueList = valueRepository.findAll();
        assertThat(sessionValueList, not(nullValue()));
    }

}
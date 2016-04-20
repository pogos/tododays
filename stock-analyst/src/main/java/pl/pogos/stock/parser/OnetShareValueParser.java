package pl.pogos.stock.parser;

import com.codahale.metrics.annotation.Timed;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import pl.pogos.stock.dto.ValueDTO;
import pl.pogos.stock.util.DateUtil;
import pl.pogos.stock.util.NumberUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by SG0952928 on 2016-04-19.
 */
@Component
public class OnetShareValueParser implements ShareValueParser {

    private static final Logger LOGGER = LoggerFactory.getLogger(OnetShareValueParser.class);
    public static final int ONET_TABEL_COLUMNS_NUMBER = 13;

    private String httpAddress = "http://biznes.onet.pl/gielda/notowania/gpw-rynek-glowny/indeksy-i-akcje,100,0,notowania-gpw-start.html";

    @Timed
    public List<ValueDTO> parse() {

        List<ValueDTO> result = new ArrayList<ValueDTO>();

        try {
            Document doc = Jsoup.connect(httpAddress).get();
            Elements tables = doc.getElementsByClass("idRatings");

            for (Element table : tables) {
                parseElementsToValues(table.getElementsByClass("Thover"), result);
                parseElementsToValues(table.getElementsByClass("marked Thover"), result);
            }

            LOGGER.info("Read address: " + httpAddress);
        } catch (IOException e) {
            LOGGER.error("Can't read the page: " + httpAddress, e);
        }

        return result;
    }

    private void parseElementsToValues(Elements rows, List<ValueDTO> result) {
        for (Element rowElement : rows) {
            Elements columns = rowElement.getElementsByTag("td");
            if (columns.size() == ONET_TABEL_COLUMNS_NUMBER) {
                result.add(new OnetShareValueBuilder(columns.listIterator()).buildValue());
            }
        }
    }

    private class OnetShareValueBuilder {

        private final ListIterator<Element> elementListIterator;

        public OnetShareValueBuilder(ListIterator<Element> elementListIterator) {
            this.elementListIterator = elementListIterator;
            skip();//min for 52 weeks
            skip();//max for 52 weeks
        }

        public ValueDTO buildValue() {
            ValueDTO result = new ValueDTO();
            result.setProviderTimestamp(DateUtil.todayAt(nextTextValue()));
            result.setName(nextTextValue());
            result.setStockRate(nextNumberValue());
            result.setStockRateDiff(nextNumberValue());
            result.setStockRateDiffPercent(nextNumberValue());
            skip();//open rate
            skip();//other rate
            result.setMinStockRate(nextNumberValue());
            result.setMaxStockRate(nextNumberValue());
            result.setTradingVolume(nextNumberValue());
            result.setTradingValue(nextNumberValue());

            LOGGER.trace("ValueDTO created: " + result);
            return result;
        }

        private Double nextNumberValue() {
            return NumberUtil.parse(nextTextValue());
        }

        private String nextTextValue() {
            return elementListIterator.next().text();
        }

        private void skip() {
            elementListIterator.next();
        }
    }
}

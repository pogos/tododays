package pl.pogos.stock.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.pogos.stock.dto.ValueDTO;
import pl.pogos.stock.parser.ShareValueParser;
import pl.pogos.stock.service.ParseService;
import pl.pogos.stock.service.ShareService;

import javax.inject.Inject;
import java.util.List;

@Component
public class ParserScheduler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ParserScheduler.class);
    public static final int SESSION_VALUE_DELAYED = 5 * 60 * 1000;

    @Inject
    private ShareValueParser shareValueParser;

    @Inject
    private ParseService parseService;


    @Scheduled(fixedDelay = SESSION_VALUE_DELAYED)
    public void scheduleShareValueParser() {
        LOGGER.info("Start Onet Parser");
        setProxy();
        List<ValueDTO> valueDTOs = shareValueParser.parse();
        parseService.saveShareValues(valueDTOs);
    }

    private void setProxy() {
        System.setProperty("http.proxyHost", "www-ad-proxy.sabre.com");
        System.setProperty("http.proxyPort", "80");
        System.setProperty("http.proxyUser", "");
        System.setProperty("http.proxyPassword", "");
    }

}

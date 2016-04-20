package pl.pogos.stock.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import pl.pogos.stock.model.Share;
import pl.pogos.stock.repository.ShareRepository;

import javax.inject.Inject;

@Component
public class SampleInitDataLoader extends InitDataLoader {

    private static final Logger LOGGER = LoggerFactory.getLogger(SampleInitDataLoader.class);

    @Inject
    private ShareRepository shareRepository;

    @Override
    protected void persistData() {
        LOGGER.info("persistData");
        Share share = new Share();
        share.setName("PKO BP");
        share.setSymbol("PKO BP");
        shareRepository.save(share);
    }
}

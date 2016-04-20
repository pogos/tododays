package pl.pogos.stock.service;

import org.springframework.stereotype.Service;
import pl.pogos.stock.model.Share;
import pl.pogos.stock.repository.ShareRepository;
import javax.inject.Inject;

@Service
public class ShareService {

    @Inject
    private ShareRepository shareRepository;

    public Share createShare(Share share) {
        return shareRepository.save(share);
    }
}

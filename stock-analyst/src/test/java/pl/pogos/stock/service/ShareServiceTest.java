package pl.pogos.stock.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import pl.pogos.stock.config.ServiceConfiguration;
import pl.pogos.stock.model.Share;
import pl.pogos.stock.repository.ShareRepository;

import javax.inject.Inject;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by SG0952928 on 2016-04-12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {ServiceConfiguration.class})
@WebAppConfiguration
public class ShareServiceTest {

    @Mock
    private ShareRepository shareRepository;

    @InjectMocks
    @Inject
    private ShareService shareService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldSaveShareData() {
        //GIVEN
        Share share = new Share();
        when(shareRepository.save(share)).thenReturn(share);

        //WHEN
        Share createdShare = shareService.createShare(share);

        //THEN
        assertThat(createdShare, notNullValue());
        assertThat(createdShare.getName(), equalTo(share.getName()));
        assertThat(createdShare.getSymbol(), equalTo(share.getSymbol()));

        verify(shareRepository, times(1)).save(share);
    }



}
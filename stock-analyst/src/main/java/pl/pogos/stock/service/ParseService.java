package pl.pogos.stock.service;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;
import pl.pogos.stock.dto.ValueDTO;
import pl.pogos.stock.model.SessionValue;
import pl.pogos.stock.repository.ValueRepository;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
public class ParseService {

//    private static final String SHARE_VALUES_URL = "http://www.money.pl/gielda/gpw/akcje/";

    @Inject
    private ValueRepository valueRepository;

    public void saveShareValues(List<ValueDTO> valueDTOs) {
        DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
        List<SessionValue> entities = new ArrayList<SessionValue>(valueDTOs.size());
        for (ValueDTO value : valueDTOs) {
            SessionValue entity = dozerBeanMapper.map(value, SessionValue.class);
            entities.add(entity);
        }
        valueRepository.save(entities);
    }
}

package pl.pogos.tododays.service;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
public class ConverterService {

    @Inject
    private Mapper mapper = new DozerBeanMapper();

    public <T> T convert(Object source, Class<T> clazz) {
        return mapper.map(source, clazz);
    }

    public <T> List<T> convert(List<? extends Object> sourceList, Class<T> clazz) {
        List<T> result = new ArrayList<>();
        sourceList.stream().forEach(o -> result.add(convert(o, clazz)));

        return result;
    }



}

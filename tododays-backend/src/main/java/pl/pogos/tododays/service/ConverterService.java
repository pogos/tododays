package pl.pogos.tododays.service;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class ConverterService {

    @Inject
    private Mapper mapper = new DozerBeanMapper();

    public <T> T convert(Object source, Class<T> clazz) {
        return mapper.map(source, clazz);
    }



}

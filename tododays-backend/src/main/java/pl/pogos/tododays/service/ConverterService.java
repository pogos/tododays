package pl.pogos.tododays.service;

import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.lang.reflect.ParameterizedType;

@Service
public class ConverterService {

    @Inject
    private Mapper mapper;

    public <T> T convert(Object source) {
        //Class<T> result = new Class<T>();
        //Class.forName();
        return mapper.map(source, new ClassTypeExtractor<T>().getClassType());
    }

    class ClassTypeExtractor<T> {

        private final Class<T> classType;

        public ClassTypeExtractor() {
            this.classType = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
                    .getActualTypeArguments()[0];
        }

        public Class<T> getClassType() {
            return classType;
        }
    }

}

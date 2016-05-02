package pl.pogos.tododays.converter;


import java.util.List;

public interface Converter<Source, Target> {

    Target convertTo(Source source);

    Source convertFrom(Target source);

    List<Target> convertTo(List<Source> sourceList);

    List<Source> convertFrom(List<Target> sourceList);

}

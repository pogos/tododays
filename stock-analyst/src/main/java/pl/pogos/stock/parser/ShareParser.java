package pl.pogos.stock.parser;

import com.codahale.metrics.annotation.Counted;
import com.codahale.metrics.annotation.Timed;

import java.util.List;

public interface ShareParser<T> {

//    @Timed
//    @Counted
    List<T> parse();

}

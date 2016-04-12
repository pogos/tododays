package pl.pogos.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import pl.pogos.stock.model.Share;
import pl.pogos.stock.model.Value;

import java.util.Date;
import java.util.List;

/**
 * Created by SG0952928 on 2016-04-12.
 */
@Repository
public interface ValueRepository extends JpaRepository<Value, Long>, JpaSpecificationExecutor<Value> {

    List<Value> findByShareAndTimestampBetween(Share share, Date startDate, Date endDate);

}

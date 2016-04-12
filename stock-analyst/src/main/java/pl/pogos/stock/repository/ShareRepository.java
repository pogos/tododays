package pl.pogos.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import pl.pogos.stock.model.Share;

/**
 * Created by SG0952928 on 2016-04-12.
 */
@Repository
public interface ShareRepository extends JpaRepository<Share, Long>, JpaSpecificationExecutor<Share> {

    Share findBySymbol(String symbol);
}

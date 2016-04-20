package pl.pogos.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import pl.pogos.stock.model.Share;

@Repository
public interface ShareRepository extends JpaRepository<Share, Long>, JpaSpecificationExecutor<Share> {

    Share findBySymbol(String symbol);
}

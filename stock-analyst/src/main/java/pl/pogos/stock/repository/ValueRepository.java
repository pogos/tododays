package pl.pogos.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import pl.pogos.stock.model.SessionValue;

@Repository
public interface ValueRepository extends JpaRepository<SessionValue, Long>, JpaSpecificationExecutor<SessionValue> {


}

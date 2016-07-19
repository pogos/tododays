package pl.pogos.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pogos.stock.model.Wallet;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {
}

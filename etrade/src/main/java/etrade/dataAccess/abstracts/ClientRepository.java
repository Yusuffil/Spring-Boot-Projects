package etrade.dataAccess.abstracts;

import etrade.Entities.concretes.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ClientRepository extends JpaRepository<Client, Integer> {

    boolean existsByIdentityNumber(String name);

}

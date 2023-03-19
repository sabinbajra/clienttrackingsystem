package cleint.tracking.system.client.tracking.system.repository;

import cleint.tracking.system.client.tracking.system.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface JPAClientRepository extends CrudRepository<Client, String> {

}

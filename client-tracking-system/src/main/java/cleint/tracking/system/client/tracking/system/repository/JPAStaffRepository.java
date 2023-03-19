package cleint.tracking.system.client.tracking.system.repository;

import cleint.tracking.system.client.tracking.system.model.Staff;
import org.springframework.data.repository.CrudRepository;

public interface JPAStaffRepository extends CrudRepository<Staff, String> {
}

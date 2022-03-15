package GitClass.BE;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import GitClass.BE.BEANS.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}

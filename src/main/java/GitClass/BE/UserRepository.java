package GitClass.BE;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import GitClass.BE.BEANS.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findByNameContaining(String name);


}

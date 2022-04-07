package GitClass.BE;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import GitClass.BE.BEANS.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findByNameContaining(String name);

	Optional<List<User>> findByIdCourse(int idCourse);
}

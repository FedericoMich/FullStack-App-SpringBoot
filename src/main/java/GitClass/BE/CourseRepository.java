package GitClass.BE;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import GitClass.BE.BEANS.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
	List<Course> findByNameContaining(String name);

}

package GitClass.BE;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import GitClass.BE.BEANS.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {

}

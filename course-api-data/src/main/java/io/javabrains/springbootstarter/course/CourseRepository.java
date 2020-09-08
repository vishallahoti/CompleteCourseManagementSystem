package io.javabrains.springbootstarter.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course, String> {

	List<Course> findByName(String name);

	List<Course> findByDescription(String description);

	List<Course> findByTopicId(String topicId);
}

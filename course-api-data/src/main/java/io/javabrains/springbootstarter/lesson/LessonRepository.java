package io.javabrains.springbootstarter.lesson;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends CrudRepository<Lesson, String> {

	List<Lesson> findByName(String name);

	List<Lesson> findByDescription(String description);

	List<Lesson> findByCourseId(String courseId);
}

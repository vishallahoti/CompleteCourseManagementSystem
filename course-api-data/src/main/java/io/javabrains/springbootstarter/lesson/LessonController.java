package io.javabrains.springbootstarter.lesson;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.course.Course;

@RestController
public class LessonController {
	@Autowired
	LessonService lessonService;

	@RequestMapping("/topics/{topicId}/courses/{courseId}/lessons")
	public List<Lesson> getAllLessons(@PathVariable String courseId) {
		return lessonService.getAllLessons(courseId);
	}

	@RequestMapping("/topics/{topicId}/courses/{courseId}/lessons/{lessonId}")
	public Lesson getLesson(@PathVariable String lessonId) {
		return lessonService.getLesson(lessonId);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses/{courseId}/lessons")
	public void addTopic(@RequestBody Lesson lesson,@PathVariable String topicId ,@PathVariable String courseId) {
		lesson.setCourse(new Course(courseId, "", "",topicId));
		lessonService.addLesson(lesson);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{courseId}/lessons/{lessonId}")
	public void updateTopic(@RequestBody Lesson lesson, @PathVariable String topicId,@PathVariable String lessonId,@PathVariable String courseId) {
		lesson.setCourse(new Course(courseId, "", "",topicId));
		lessonService.updateLesson(lesson);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}/lessons/{lessonId}")
	public void deleteTopic(@PathVariable String lessonId) {
		lessonService.deleteLesson(lessonId);
	}

}

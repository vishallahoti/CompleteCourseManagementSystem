package io.javabrains.springbootstarter.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.topic.Topic;


@RestController
public class CourseController {
	@Autowired
	CourseService topicService;

	@RequestMapping("/topics/{topicId}/courses")
	public List<Course> getAllTopics(@PathVariable String topicId) {
		return topicService.getAllCourses(topicId);
	}

	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Course getTopic(@PathVariable String id) {
		return topicService.getCourse(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
	public void addTopic(@RequestBody Course course,@PathVariable String topicId) {
		course.setTopic(new Topic(topicId,"",""));
		topicService.addCourse(course);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
	public void updateTopic(@RequestBody Course course, @PathVariable String topicId,@PathVariable String id) {
		course.setTopic(new Topic(topicId,"",""));
		topicService.updateCourse(course);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}")
	public void deleteTopic(@PathVariable String id) {
		topicService.deleteCourse(id);
	}

}

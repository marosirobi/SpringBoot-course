package com.example.cruddemo;

import com.example.cruddemo.dao.AppDAO;
import com.example.cruddemo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){

		return runner -> {
//			createCourseAndStudents(appDAO);
//			retrieveCourseAndStudents(appDAO);
//			retrieveStudentAndCourses(appDAO);
//			AddCoursesToStudent(appDAO);
//			deleteStudent(appDAO,2);
		};
	}

	private void AddCoursesToStudent(AppDAO appDAO) {

		int id = 2;
		Student s = appDAO.findStudentAndCoursesByStudentId(id);

		Course course1 = new Course("SpringBoot course");
		Course course2 = new Course("Game Development course");

		s.addCourse(course1);
		s.addCourse(course2);

		appDAO.update(s);

	}

	private void deleteStudent(AppDAO appDAO, int id) {

		System.out.println("Deleting course by id: " + id);
		appDAO.deleteStudentById(id);
		System.out.println("Done");
	}

	private void retrieveStudentAndCourses(AppDAO appDAO) {

		int id = 1;
		Student student = appDAO.findStudentAndCoursesByStudentId(id);

		System.out.println(student);
		System.out.println(student.getCourses());
	}

	private void retrieveCourseAndStudents(AppDAO appDAO) {

		int id = 10;
		Course course = appDAO.findCourseAndStudentsByCourseId(id);

		System.out.println(course);
		System.out.println(course.getStudents());
	}

	private void createCourseAndStudents(AppDAO appDAO) {

		Course course = new Course("Java MasterClass");

		Student student1 = new Student("Peter","Clein","peter@luv2code.com");
		Student student2 = new Student("Mary","Public","mary@luv2code.com");

		course.addStudent(student1);
		course.addStudent(student2);

		System.out.println("Saving the course : " + course);
		System.out.println("Saving the students : " + course.getStudents());

		appDAO.save(course);
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {

		int id = 10;

		appDAO.deleteCourseById(id);

		
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {

		Course course = appDAO.findCourseAndReviewsByCourseId(10);

		System.out.println(course.getTitle());
		System.out.println(course.getReviews());

	}

	private void createCourseAndReviews(AppDAO appDAO) {

		Course course1 = new Course("Java MasterClass");

		course1.addReview(new Review("Great course...loved it!"));
		course1.addReview(new Review("Best course...liked it!"));
		course1.addReview(new Review("bad course...hated it!"));

		appDAO.save(course1);

	}

	private void deleteCourse(AppDAO appDAO, int id) {

		System.out.println("Deleting course by id: " + id);
		appDAO.deleteCourseById(id);
		System.out.println("Done");
	}

	private void updateCourse(AppDAO appDAO, int id) {
		System.out.println("finding the course by id: " + id);

		Course course = appDAO.findCourseById(id);
		course.setTitle("Spring Boot Master Course");

		appDAO.update(course);
		System.out.println(course);
	}

	private void updateInstructor(AppDAO appDAO, int id) {

		Instructor instructor = appDAO.findInstructorById(id);

		instructor.setLastName("TESTER");
		System.out.println("Updating instructor:");

		appDAO.update(instructor);
		System.out.println(instructor);

		System.out.println("Done");
	}

	private void findInstructorByJoinFetch(AppDAO appDAO, int id) {

		System.out.println("Finding the instructor by id: " + id);

		Instructor instructor = appDAO.findInstructorByIdJoinFetch(id);

		System.out.println(instructor);
		System.out.println(instructor.getInstructorDetail());
		System.out.println(instructor.getCourses());
		System.out.println("Done!");
	}

	private void findInstructorWithCourses(AppDAO appDAO, int id) {

		Instructor instructor = appDAO.findInstructorById(id);
		List<Course> courses = appDAO.findCoursesByInstructorId(id);

		System.out.println("Found!");
		System.out.println(instructor);

		instructor.setCourses(courses);

		System.out.println(instructor.getCourses());
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor tempInstructor =
				new Instructor("Susan", "Public","susan@luv2code.com");

		InstructorDetail tempInstructorDetail =
				new InstructorDetail("http://www.youtube.com",
						"video games");

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
		Course tempCourse2 = new Course("The Pinball - The Umtimate Guide");
		Course tempCourse3 = new Course("Air Guitar - The Umtimate Guide");

		tempInstructor.add(List.of(tempCourse1,tempCourse2,tempCourse3));

		System.out.println("saving instructor: " + tempInstructor);
		System.out.println("Courses: " + tempInstructor.getCourses());

		appDAO.save(tempInstructor);
	}

	private void deleteInstructorDetail(AppDAO appDAO, int id) {

		System.out.println("deleting id: " + id);

		appDAO.deleteInstructorDetailById(id);
		System.out.println("Done!");
	}

	private void findInstructorDetail(AppDAO appDAO, int id) {

		System.out.println("Finding InstructorDetail by id: " + id);

		System.out.println(appDAO.findInstructorDetailById(id));

	}

	private void deleteInstructor(AppDAO appDAO, int id) {
		System.out.println("Finding and deleting id: " + id);

		appDAO.deleteInstructorById(id);

		System.out.println("Done!");
	}

	private void findInstructor(AppDAO appDAO, int id) {

		System.out.println("Finding the id: " + id);
		Instructor instructor = appDAO.findInstructorById(id);
		if(instructor != null){
			System.out.println("Found!");
			System.out.println(instructor);
		}else{
			System.out.println("Not found id: " + id);
		}


	}

	private void createInstructor(AppDAO appDAO){

//		Instructor tempInstructor = new Instructor("Chad", "Darby","darby@luv2code.com");
//
//		InstructorDetail tempInstructorDetail =
//				new InstructorDetail("http://www.luv2code.com/youtube",
//						"coding");

		Instructor tempInstructor = new Instructor("Madhu", "Patel","madhu@luv2code.com");

		InstructorDetail tempInstructorDetail =
				new InstructorDetail("http://www.luv2code.com/youtube",
						"guitar");

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done!");

	}

}

package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Comparator;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return runner -> {
//			createStudent(studentDAO);
			createMultipleStudents(studentDAO);
//			readStudent(studentDAO,1);
//			readAll(studentDAO);
//			readStudentByLastName(studentDAO);
//			updateStudent(studentDAO);
//			System.out.println("---------------------------");
//			deleteStudent(studentDAO);
//			deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting everything...");
		System.out.println(studentDAO.deleteAll());
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int id = 1;
		System.out.printf("Deleting id=%d student...%n",id);
		studentDAO.delete(1);

		System.out.println("New list of student:");
		readAll(studentDAO);
	}

	private void updateStudent(StudentDAO studentDAO) {
		System.out.println("Updating student id:1");
		Student tempStudent = studentDAO.findById(1);
		tempStudent.setLastName("Szabo");
		studentDAO.update(tempStudent);
		System.out.println(studentDAO.findById(1));
	}

	private void readStudentByLastName(StudentDAO studentDAO) {
		System.out.println("Reading by last name");
		Student tempStudent = studentDAO.findByLastName("Apple");
		System.out.println(tempStudent);
	}

	private void readAll(StudentDAO studentDAO) {
		System.out.println("reading all data...");
		List<Student> students = studentDAO.findAll();
//		students.sort(Comparator.comparing(Student::getLastName));
		students.forEach(System.out::println);
	}

	private void readStudent(StudentDAO studentDAO, int id) {
		System.out.println("Finding the student id=1...");
		System.out.println(studentDAO.findById(id));
	}


	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating 3 object");
		Student tempStudent1 = new Student("Elden","Ring","eldenring@gmail.com");
		Student tempStudent2 = new Student("Lara","Public","lara@gmail.com");
		Student tempStudent3 = new Student("Benita","Apple","benita@gmail.com");

		System.out.println("Saving the students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		System.out.println("Saved student's generated id: " + tempStudent1.getId());
		System.out.println("Saved student's generated id: " + tempStudent2.getId());
		System.out.println("Saved student's generated id: " + tempStudent3.getId());

	}

	public void createStudent(StudentDAO studentDAO){
		System.out.println("Creating new student object");
		Student tempStudent = new Student("Robi","Marosi","marosirobi@gmail.com");

		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		System.out.println("Saved student's generated id: " + tempStudent.getId());
	}
}

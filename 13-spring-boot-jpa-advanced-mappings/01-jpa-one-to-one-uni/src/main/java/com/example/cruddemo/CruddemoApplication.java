package com.example.cruddemo;

import com.example.cruddemo.dao.AppDAO;
import com.example.cruddemo.dao.AppDAOImpl;
import com.example.cruddemo.entity.Instructor;
import com.example.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){

		return runner -> {
//			createInstructor(appDAO);
//			findInstructor(appDAO, 2);
//			deleteInstructor(appDAO,4);
//			findInstructorDetail(appDAO,6);
			deleteInstructorDetail(appDAO,7);

		};
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


package com.shoyoo.cruddmo;

import com.shoyoo.cruddmo.dao.StudentDAO;
import com.shoyoo.cruddmo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddmoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddmoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			findStudentByLastName(studentDAO);
		};
	}

	private void findStudentByLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findByLastName("Diaf");
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void findAllStudents(StudentDAO studentDAO) {
		List<Student> studentList = studentDAO.findAll();
		for (Student student:studentList) {
			System.out.println(student);
		}
	}

	private void findStudent(StudentDAO studentDAO) {
		Student student = studentDAO.find(1);
		System.out.println(student);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// create multiple students
		System.out.println("Creating 3 student objects");
		Student student = new Student("Abderrahmane", "Diaf", "abdoudiaf30@gmail.com");
		Student student1 = new Student("Moussa", "Aouinane", "abdoudiaf30@gmail.com");
		Student student2 = new Student("Khaled", "Meddah", "abdoudiaf30@gmail.com");

		// save the created students
		System.out.println("Saving students");
		studentDAO.save(student);
		studentDAO.save(student1);
		studentDAO.save(student2);

	}

	private void createStudent(StudentDAO studentDAO) {
		// create student object
		System.out.println("Creating student");
		Student student = new Student("Abderrahmane", "Diaf", "abdoudiaf30@gmail.com");

		// save student object
		System.out.println("Saving student");
		studentDAO.save(student);

		// display if of the saved student
		System.out.println("Student saved. Generated id : " + student.getId());
	}

}

package edu.depaul.cdm.se452.group2.campusdisconnect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import edu.depaul.cdm.se452.group2.campusdisconnect.Courses.Course;
import edu.depaul.cdm.se452.group2.campusdisconnect.Courses.CourseNoSQL;
import edu.depaul.cdm.se452.group2.campusdisconnect.Courses.CourseNoSQLRepository;
import edu.depaul.cdm.se452.group2.campusdisconnect.Courses.CourseRepository;
import edu.depaul.cdm.se452.group2.campusdisconnect.Departments.Department;
import edu.depaul.cdm.se452.group2.campusdisconnect.Departments.DepartmentRepository;
import edu.depaul.cdm.se452.group2.campusdisconnect.Professors.*;
import edu.depaul.cdm.se452.group2.campusdisconnect.Tuitions.Tuition;
import edu.depaul.cdm.se452.group2.campusdisconnect.Tuitions.TuitionRepository;
import edu.depaul.cdm.se452.group2.campusdisconnect.Majors.*;


@SpringBootApplication
public class CampusdisconnectApplication {
	@Autowired
  	private DepartmentRepository departmentrepository;
  	@Autowired
  	private MajorRepository MajorRepository;
  	@Autowired
  	private ProfessorRepository ProfessorRepository;

	@Autowired
	private CourseRepository courseRepository;

    @Autowired
	private CourseNoSQLRepository courseNoSQLRepository;
	@Autowired
	private TuitionRepository tuitionRepository;



	public static void main(String[] args) {
		SpringApplication.run(CampusdisconnectApplication.class, args);
	}

	//Don't delete, initial data!.
	@Bean
	public CommandLineRunner initiateData(){
			return (args) -> {
				//Insert Department
				Department engineering = new Department();
				engineering.setDepartmentname("Engineering");
				departmentrepository.save(engineering);

				Department law = new Department();
				law.setDepartmentname("Law");
				departmentrepository.save(law);

				Department business = new Department();
				business.setDepartmentname("Business");
				departmentrepository.save(business);

				Department arts = new Department();
				arts.setDepartmentname("Arts");
				departmentrepository.save(arts);

				Department medical = new Department();
				medical.setDepartmentname("Medical");
				departmentrepository.save(medical);

				//Insert Major
				Major cs= new Major();
				cs.setMajorname("Computer Science");
				cs.setDepartment(engineering);
				cs.setRequiredCredit(150);
				MajorRepository.save(cs);

				Major ss = new Major();
				ss.setMajorname("Software Engineering");
				ss.setDepartment(engineering);
				ss.setRequiredCredit(160);
				MajorRepository.save(ss);

				Major accounting = new Major();
				accounting.setMajorname("Accounting");
				accounting.setDepartment(business);
				accounting.setRequiredCredit(140);
				MajorRepository.save(accounting);

				Major sculpture = new Major();
				sculpture.setMajorname("Sculpture");
				sculpture.setDepartment(arts);
				sculpture.setRequiredCredit(140);
				MajorRepository.save(sculpture);

				Major nursing = new Major();
				nursing.setMajorname("Nursing");
				nursing.setDepartment(medical);
				nursing.setRequiredCredit(140);
				MajorRepository.save(nursing);

				//Insert Course
				Course csc421 = new Course();
				csc421.setCourseName("Algorithm");
				csc421.setCourseid(421);
				csc421.setCredits(4);
				csc421.setMajor(cs);
				csc421.setQuarter("spring");
				csc421.setYear(2021);
				csc421.setStartTime("9:00AM");
				csc421.setEndTime("12:00PM");
				courseRepository.save(csc421);
				CourseNoSQL csc421NoSQL = new CourseNoSQL();
				csc421NoSQL.setCourseid(421);
				csc421NoSQL.setEnrolledcapacity(40);
				csc421NoSQL.setWaitlistCapacity(20);
				courseNoSQLRepository.save(csc421NoSQL);

				Course csc435 = new Course();
				csc435.setCourseName("Database");
				csc435.setCourseid(435);
				csc435.setCredits(4);
				csc435.setMajor(cs);
				csc435.setQuarter("spring");
				csc435.setYear(2021);
				csc435.setStartTime("9:00AM");
				csc435.setEndTime("12:00PM");
				courseRepository.save(csc435);
				CourseNoSQL csc435NoSQL = new CourseNoSQL();
				csc435NoSQL.setCourseid(435);
				csc435NoSQL.setEnrolledcapacity(40);
				csc435NoSQL.setWaitlistCapacity(20);
				courseNoSQLRepository.save(csc435NoSQL);

				Course csc432 = new Course();
				csc432.setCourseName("Networking");
				csc432.setCourseid(432);
				csc432.setCredits(4);
				csc432.setMajor(cs);
				csc432.setQuarter("spring");
				csc432.setYear(2021);
				csc432.setStartTime("9:00AM");
				csc432.setEndTime("12:00PM");
				courseRepository.save(csc432);
				CourseNoSQL csc432NoSQL = new CourseNoSQL();
				csc432NoSQL.setCourseid(432);
				csc432NoSQL.setEnrolledcapacity(40);
				csc432NoSQL.setWaitlistCapacity(20);
				courseNoSQLRepository.save(csc432NoSQL);

				//Insert Tuition
				Tuition csT = new Tuition();
				csT.setMajorname("Computer Science");
				csT.setCreditPrice(300);
				tuitionRepository.save(csT);

				Tuition ssT = new Tuition();
				ssT.setMajorname("Software Engineering");
				ssT.setCreditPrice(400);
				tuitionRepository.save(ssT);

				Tuition accountingT = new Tuition();
				accountingT.setMajorname("Accounting");
				accountingT.setCreditPrice(200);
				tuitionRepository.save(accountingT);

				Tuition sculptureT = new Tuition();
				sculptureT.setMajorname("Sculpture");
				sculptureT.setCreditPrice(200);
				tuitionRepository.save(sculptureT);

				Tuition nursingT = new Tuition();
				nursingT.setMajorname("Nursing");
				nursingT.setCreditPrice(200);
				tuitionRepository.save(nursingT);

				

				

				






						



			};
	}


}

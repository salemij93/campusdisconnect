package edu.depaul.cdm.se452.group2.campusdisconnect;

import edu.depaul.cdm.se452.group2.campusdisconnect.user.DisconnectUser;
import edu.depaul.cdm.se452.group2.campusdisconnect.user.UserRepository;
import edu.depaul.cdm.se452.group2.campusdisconnect.user.authority.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import edu.depaul.cdm.se452.group2.campusdisconnect.course.Course;
import edu.depaul.cdm.se452.group2.campusdisconnect.course.CourseNoSQL;
import edu.depaul.cdm.se452.group2.campusdisconnect.course.CourseNoSQLRepository;
import edu.depaul.cdm.se452.group2.campusdisconnect.course.CourseRepository;
import edu.depaul.cdm.se452.group2.campusdisconnect.department.Department;
import edu.depaul.cdm.se452.group2.campusdisconnect.department.DepartmentRepository;
import edu.depaul.cdm.se452.group2.campusdisconnect.professor.*;
import edu.depaul.cdm.se452.group2.campusdisconnect.scholarship.Scholarship;
import edu.depaul.cdm.se452.group2.campusdisconnect.scholarship.ScholarshipRepository;
import edu.depaul.cdm.se452.group2.campusdisconnect.student.Student;
import edu.depaul.cdm.se452.group2.campusdisconnect.student.StudentNoSQL;
import edu.depaul.cdm.se452.group2.campusdisconnect.student.StudentNoSQLRepository;
import edu.depaul.cdm.se452.group2.campusdisconnect.student.StudentRepository;
import edu.depaul.cdm.se452.group2.campusdisconnect.task.TaskNoSQL;
import edu.depaul.cdm.se452.group2.campusdisconnect.task.TaskNoSQLRepository;
import edu.depaul.cdm.se452.group2.campusdisconnect.tuition.Tuition;
import edu.depaul.cdm.se452.group2.campusdisconnect.tuition.TuitionRepository;
import edu.depaul.cdm.se452.group2.campusdisconnect.major.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Set;


@SpringBootApplication
public class CampusdisconnectApplication {
    @Autowired
    private DepartmentRepository departmentrepository;
    @Autowired
    private MajorRepository MajorRepository;
    @Autowired
    private ProfessorRepository ProfessorRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentNoSQLRepository studentNoSQLRepository;
    @Autowired
    private ScholarshipRepository scholarshipRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseNoSQLRepository courseNoSQLRepository;
    @Autowired
    private TuitionRepository tuitionRepository;

    @Autowired
    private TaskNoSQLRepository taskNoSQLRepository;

	@Autowired
	private UserRepository userRepository;
	
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

				Major acct = new Major();
				acct.setMajorname("Accounting");
				acct.setDepartment(business);
				acct.setRequiredCredit(140);
				MajorRepository.save(acct);

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


				String username = "user";
				Long id = userRepository.getDisconnectUserByStudentId(username).getId();
				
				//Insert Course
				Course csc421 = new Course();
				csc421.setCourseName("Algorithm");
				csc421.setCourseid(421);
				csc421.setCredits(4);
				csc421.setMajor(cs);
				csc421.setQuarter("spring");
				csc421.setYear(2021);
				csc421.setStartTime("1:00PM");
				csc421.setEndTime("3:00PM");
				courseRepository.save(csc421);
				CourseNoSQL csc421NoSQL = new CourseNoSQL();
				csc421NoSQL.setCourseid(421);
				csc421NoSQL.setEnrolledcapacity(40);
				csc421NoSQL.setWaitlistCapacity(20);
				csc421NoSQL.getEnrolledlist().add( id);
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
				csc435NoSQL.getEnrolledlist().add( id);
				courseNoSQLRepository.save(csc435NoSQL);

				Course csc432 = new Course();
				csc432.setCourseName("Networking");
				csc432.setCourseid(432);
				csc432.setCredits(4);
				csc432.setMajor(cs);
				csc432.setQuarter("spring");
				csc432.setYear(2021);
				csc432.setStartTime("4:00AM");
				csc432.setEndTime("6:00PM");
				courseRepository.save(csc432);
				CourseNoSQL csc432NoSQL = new CourseNoSQL();
				csc432NoSQL.setCourseid(432);
				csc432NoSQL.setEnrolledcapacity(40);
				csc432NoSQL.setWaitlistCapacity(20);
				csc432NoSQL.getEnrolledlist().add( id);
				courseNoSQLRepository.save(csc432NoSQL);

				Course ssc407 = new Course();
				ssc407.setCourseName("System Design");
				ssc407.setCourseid(407);
				ssc407.setCredits(4);
				ssc407.setMajor(ss);
				ssc407.setQuarter("spring");
				ssc407.setYear(2021);
				ssc407.setStartTime("9:00AM");
				ssc407.setEndTime("11:00PM");
				courseRepository.save(ssc407);
				CourseNoSQL ssc407NoSQL = new CourseNoSQL();
				ssc407NoSQL.setCourseid(407);
				ssc407NoSQL.setEnrolledcapacity(40);
				ssc407NoSQL.setWaitlistCapacity(20);
				ssc407NoSQL.getEnrolledlist().add( id);
				courseNoSQLRepository.save(ssc407NoSQL);

				Course ssc428 = new Course();
				ssc428.setCourseName("Android Development ");
				ssc428.setCourseid(428);
				ssc428.setCredits(4);
				ssc428.setMajor(ss);
				ssc428.setQuarter("Winter");
				ssc428.setYear(2021);
				ssc428.setStartTime("2:00AM");
				ssc428.setEndTime("4:00PM");
				courseRepository.save(ssc428);
				CourseNoSQL  ssc428NoSQL = new CourseNoSQL();
				ssc428NoSQL .setCourseid(407);
				ssc428NoSQL .setEnrolledcapacity(40);
				ssc428NoSQL .setWaitlistCapacity(20);
				ssc428NoSQL .getEnrolledlist().add( id);
				courseNoSQLRepository.save(ssc428NoSQL);




				
				Course acct300 = new Course();
				acct300.setCourseName("Business Law");
				acct300.setCourseid(300);
				acct300.setCredits(4);
				acct300.setMajor(acct);
				acct300.setQuarter("spring");
				acct300.setYear(2021);
				acct300.setStartTime("11:00AM");
				acct300.setEndTime("1:00PM");
				courseRepository.save(acct300);
				CourseNoSQL acct300NoSQL = new CourseNoSQL();
				acct300NoSQL.setCourseid(300);
				acct300NoSQL.setEnrolledcapacity(40);
				acct300NoSQL.setWaitlistCapacity(20);
				acct300NoSQL.getEnrolledlist().add( id);
				courseNoSQLRepository.save(acct300NoSQL);
				
				Course acct301 = new Course();
				acct301.setCourseName("Estate and Gift Taxation");
				acct301.setCourseid(301);
				acct301.setCredits(4);
				acct301.setMajor(acct);
				acct301.setQuarter("spring");
				acct301.setYear(2021);
				acct301.setStartTime("4:00pm");
				acct301.setEndTime("6:00PM");
				courseRepository.save(acct301);
				CourseNoSQL acct301NoSQL = new CourseNoSQL();
				acct301NoSQL.setCourseid(301);
				acct301NoSQL.setEnrolledcapacity(40);
				acct301NoSQL.setWaitlistCapacity(20);
				acct301NoSQL.getEnrolledlist().add( id);
				courseNoSQLRepository.save(acct301NoSQL);

				Course nursing100 = new Course();
				nursing100.setCourseName("Fundamental of Nursing");
				nursing100.setCourseid(100);
				nursing100.setCredits(4);
				nursing100.setMajor(nursing);
				nursing100.setQuarter("Winter");
				nursing100.setYear(2021);
				nursing100.setStartTime("6:00pm");
				nursing100.setEndTime("8:00PM");
				courseRepository.save(nursing100);
				CourseNoSQL nursing100NoSQL = new CourseNoSQL();
				nursing100NoSQL.setCourseid(100);
				nursing100NoSQL.setEnrolledcapacity(60);
				nursing100NoSQL.setWaitlistCapacity(30);
				nursing100NoSQL.getEnrolledlist().add( id);
				courseNoSQLRepository.save(nursing100NoSQL);

				Course nursing130 = new Course();
				nursing130.setCourseName("Mental Health Nursing");
				nursing130.setCourseid(130);
				nursing130.setCredits(4);
				nursing130.setMajor(nursing);
				nursing130.setQuarter("Fall");
				nursing130.setYear(2021);
				nursing130.setStartTime("4:00pm");
				nursing130.setEndTime("6:30PM");
				courseRepository.save(nursing130);
				CourseNoSQL nursing130NoSQL = new CourseNoSQL();
				nursing130NoSQL.setCourseid(130);
				nursing130NoSQL.setEnrolledcapacity(60);
				nursing130NoSQL.setWaitlistCapacity(30);
				nursing130NoSQL.getEnrolledlist().add( id);
				courseNoSQLRepository.save(nursing130NoSQL);
				
			

				Course CFA200 = new Course();
				CFA200.setCourseName("Foundation Sculpture");
				CFA200.setCourseid(200);
				CFA200.setCredits(4);
				CFA200.setMajor(sculpture);
				CFA200.setQuarter("Fall");
				CFA200.setYear(2021);
				CFA200.setStartTime("3:00pm");
				CFA200.setEndTime("5:30PM");
				courseRepository.save(CFA200);
				CourseNoSQL CFA200NoSQL = new CourseNoSQL();
				CFA200NoSQL.setCourseid(200);
				CFA200NoSQL.setEnrolledcapacity(60);
				CFA200NoSQL.setWaitlistCapacity(30);
				CFA200NoSQL.getEnrolledlist().add( id);
				courseNoSQLRepository.save(CFA200NoSQL);

				Course CFA227= new Course();
				CFA227.setCourseName("Sculpture Thesis Seminar");
				CFA227.setCourseid(227);
				CFA227.setCredits(4);
				CFA227.setMajor(sculpture);
				CFA227.setQuarter("Fall");
				CFA227.setYear(2021);
				CFA227.setStartTime("3:00pm");
				CFA227.setEndTime("5:30PM");
				courseRepository.save(CFA227);
				CourseNoSQL CFA227NoSQL = new CourseNoSQL();
				CFA227NoSQL.setCourseid(227);
				CFA227NoSQL.setEnrolledcapacity(60);
				CFA227NoSQL.setWaitlistCapacity(30);
				CFA227NoSQL.getEnrolledlist().add( id);
				courseNoSQLRepository.save(CFA227NoSQL);

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


				//Insert Student
				String username2 = "user2";
				//Insert Student
				Long studentid = userRepository.getDisconnectUserByStudentId(username2).getId();
				Student student1 = new Student();
				StudentNoSQL student1NoSQL = new StudentNoSQL();
				student1.setStudentid(studentid);
				student1.setFirstName("Jack");
				student1.setLastName("Michael");
				student1.setMajor("Nursing");
				student1.setStudentuserId(username2);
				student1.setEmail("jackzeng@depaul.edu");
				student1.setAddress("14 Irvine blvd,Irvine");
				student1.setCredit(20);


				student1NoSQL.setStudentid(studentid);

				studentRepository.save(student1);
				studentNoSQLRepository.save(student1NoSQL);


				
				Student student2 = new Student();
				StudentNoSQL student2NoSQL = new StudentNoSQL();
				student2NoSQL.setStudentid(id);
				student2.setFirstName("Joe");
				student2.setLastName("May");
				student2.setMajor("Computer Science");
				student2.setStudentid(id);
				student2.setStudentuserId(username);
				student2.setEmail("joemay@depaul.edu");
				student2.setAddress("17 Montain blvd,Sacramento");
				student2.setCredit(90);

				student2NoSQL.getCurrentRegistrated().add("432");
				student2NoSQL.getCurrentRegistrated().add("435");
				student2NoSQL.getCurrentRegistrated().add("421");
				studentRepository.save(student2);
				studentNoSQLRepository.save(student2NoSQL);


				String admin = "admin";

				Long adminid = userRepository.getDisconnectUserByStudentId(admin).getId();
				Student student3 = new Student();
				StudentNoSQL student3NoSQL = new StudentNoSQL();
				student3NoSQL.setStudentid(adminid);
				student3.setFirstName("Jess");
				student3.setLastName("Wilson");
				student3.setMajor("Math");
				student3.setStudentid(adminid);
				student3.setStudentuserId(admin);
				student3.setEmail("jwils@depaul.edu");
				student3.setAddress("1000 Montain blvd,Sacramento");
				student3.setCredit(50);
				studentRepository.save(student3);
				studentNoSQLRepository.save(student3NoSQL);
				
				TaskNoSQL task1NoSQL = new TaskNoSQL();
				task1NoSQL.setSid(studentid);
				task1NoSQL.setTaskid(9);
				task1NoSQL.getTaskList().add("Pay tuition");
				task1NoSQL.getTaskList().add("Pay more");
				taskNoSQLRepository.save(task1NoSQL);


				TaskNoSQL task2NoSQL = new TaskNoSQL();
				task2NoSQL.setSid(id);
				task2NoSQL.getTaskList().add("Register class");
				taskNoSQLRepository.save(task2NoSQL);

				// insert ScholarShip
				Scholarship scholarship = new Scholarship();
				scholarship.setStudentId(studentid);
				scholarship.setScholarshipAmount(1000);
				scholarshipRepository.save(scholarship);
				
				
			
				

				

	
						



			};
	}


}

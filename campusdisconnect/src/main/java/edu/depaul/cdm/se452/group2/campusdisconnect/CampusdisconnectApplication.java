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
    public CommandLineRunner initiateData() {
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
            Major cs = new Major();
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
            csc421NoSQL.getEnrolledlist().add((long) 2);
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
            csc435NoSQL.getEnrolledlist().add((long) 2);
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
            csc432NoSQL.getEnrolledlist().add((long) 2);
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

            String username = "user";

            Long id = userRepository.getDisconnectUserByStudentId(username).getId();
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
            task1NoSQL.setSid(id);
            task1NoSQL.setTaskid(9);
            task1NoSQL.getTaskList().add("Pay tuition");
            task1NoSQL.getTaskList().add("Pay more");
            taskNoSQLRepository.save(task1NoSQL);


            TaskNoSQL task2NoSQL = new TaskNoSQL();
            task2NoSQL.setSid(studentid);
            task2NoSQL.getTaskList().add("Register class");
            taskNoSQLRepository.save(task2NoSQL);

            // insert ScholarShip
            Scholarship scholarship = new Scholarship();
            scholarship.setStudentId(id);
            scholarship.setScholarshipAmount(1000);
            scholarshipRepository.save(scholarship);




        };
    }


}

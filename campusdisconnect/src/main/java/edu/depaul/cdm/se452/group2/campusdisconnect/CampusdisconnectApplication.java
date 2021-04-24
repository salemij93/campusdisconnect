package edu.depaul.cdm.se452.group2.campusdisconnect;
import edu.depaul.cdm.se452.group2.campusdisconnect.Major.MajorRepository;
import edu.depaul.cdm.se452.group2.campusdisconnect.Students.*;
import edu.depaul.cdm.se452.group2.campusdisconnect.Major.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SpringBootApplication
public class CampusdisconnectApplication {
	@Autowired
	StudentRepository repository;
	@Autowired
	StudentNoSQLRepository NoSQLrepository;
	@Autowired
	MajorRepository majorRepository;

	public static void main(String[] args) {
		SpringApplication.run(CampusdisconnectApplication.class, args);
	}
	private static final Logger log = LoggerFactory.getLogger(CampusdisconnectApplication.class);
	

	
	// @Bean
	// public CommandLineRunner addStudent(StudentRepository repository){
	// 	return (args) -> {
	// 		Student s1 = new Student();
	// 		s1.setStudentid(Long.valueOf("123"));
	// 		s1.setMajorid(123);
	// 		s1.setEmail("BYuan@gmail.com");
	// 		s1.setFirstName("Bo");
	// 		s1.setLasttName("Yuan");
	// 		repository.save(s1);
	// 	};
	// }
	// @Bean
	// public CommandLineRunner showAllStudent(StudentRepository repository){
	// 	return (args) -> {
	// 		log.info("Students found with findAll():");
           
    //         repository.findAll().forEach((student) -> {
    //             log.info(student.toString());
    //         });
    //         log.info("-------------------------------");
    //     };
		
	// }
	@Bean
	public CommandLineRunner addCourse(){
		return (args) -> {
			StudentNoSQL s1 = new StudentNoSQL();
			s1.setStudentid(123);
			s1.getCurrentRegistrated().add("SE452");
			
			StudentNoSQL s2 = new StudentNoSQL();
			s2.setStudentid(234);
			s2.getCurrentRegistrated().add("SE456");
			NoSQLrepository.save(s1);
			NoSQLrepository.save(s2);
		};
	}
	@Bean
	public CommandLineRunner showAllCourse(){
		return (args) -> {
			log.info("Students Course found with findAll():");
           
            log.info("-------------------------------");
			StudentNoSQL s= NoSQLrepository.findBystudentid((long)234);
			for (String cid : s.getCurrentRegistrated()) {
					log.info(cid);
			}
			s= NoSQLrepository.findBystudentid((long)123);
			for (String cid : s.getCurrentRegistrated()) {
					log.info(cid);
			}
        };
		
	}

	@Bean
	public CommandLineRunner showMajor(){
		return (args) -> {
			log.info("Major found with findAll():");
            log.info("-------------------------------");
			Major m1 = new Major();
			m1.setMajorid(987);
			m1.setMajorName("CS");
			m1.setDepartmentid(789);
			majorRepository.save(m1);
			log.info("Students found with findAll():");
           
            majorRepository.findAll().forEach((course) -> {
                log.info(course.toString());
            });
            log.info("-------------------------------");
        
        };
		
	}


}

package edu.depaul.cdm.se452.group2.campusdisconnect;
import edu.depaul.cdm.se452.group2.campusdisconnect.professor.*;

//import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class CampusdisconnectApplication {
	@Autowired
	ProfessorRepository repository;
	@Autowired
	ProfessorNoSQLRepository NoSQLrepository;

	public static void main(String[] args) {
		SpringApplication.run(CampusdisconnectApplication.class, args);
	}
	private static final Logger log = LoggerFactory.getLogger(CampusdisconnectApplication.class);

	@Bean
	public CommandLineRunner addProfessor(){
		return(args) ->{
			Professor p1 = new Professor();
			p1.setPid(Long.valueOf(123));
			p1.setDeptId(10);
			p1.setFistName("Jace");
			p1.setLastName("Mem");
			repository.save(p1);
		};

	}
	@Bean
	public CommandLineRunner showAllProfessor(ProfessorRepository repository){
		return (args) -> {
			   log.info("Professor found with findAll():");
			
				repository.findAll().forEach((professor) -> {
					log.info(professor.toString());
				});
				log.info("-------------------------------");
		};
	
 	}

	 @Bean
	 public CommandLineRunner addCourse(){
		 return(args) ->{
			 ProfessorNoSQL p1 = new ProfessorNoSQL();
			 p1.setPid(2021);
			 p1.getCourselist().add("SE452");
			 p1.getCourselist().add("CSC452");
			 
			 NoSQLrepository.save(p1);
		 };
 
	 }

	 @Bean
	public CommandLineRunner showCourseList(){
		return (args) -> {
			   log.info("Professor Course found with findAll():");
			   log.info("-------------------------------");
				
			   ProfessorNoSQL p = NoSQLrepository.findBypid((long)2021);

			   for(String courseid:p.getCourselist()){
				   log.info(courseid);
			   }
			   repository.findAll().forEach((professor) -> {
					log.info(professor.toString());
				});
				
		};
	
 	}



}

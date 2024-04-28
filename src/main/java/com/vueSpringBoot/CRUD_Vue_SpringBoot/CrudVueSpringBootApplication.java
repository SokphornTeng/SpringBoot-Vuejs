package com.vueSpringBoot.CRUD_Vue_SpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vueSpringBoot.CRUD_Vue_SpringBoot.Model.Entity.Enums;
import com.vueSpringBoot.CRUD_Vue_SpringBoot.Model.Entity.Information;
import com.vueSpringBoot.CRUD_Vue_SpringBoot.Model.Response.InforResponse;

@SpringBootApplication
public class CrudVueSpringBootApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CrudVueSpringBootApplication.class, args);
		
		
		
	
		
		
	}
//    @Autowired
//	private InforResponse info_repo;
    @Override
    public void run(String... args) throws Exception {
    	
//    	Information newInfo_1 = new Information();
//		newInfo_1.setFirstName("Sokphorn");
//		newInfo_1.setLastName("Teng");
//		newInfo_1.setAge(26);
//		newInfo_1.setGender(Enums.FEMAIL);
//		newInfo_1.setAddress("BKK");
//		newInfo_1.setEmail("sokphorn.teng@gmail.com");
//		newInfo_1.setStatus("Single");
//		
//		Information newInfo_2 = new Information();
//		newInfo_2.setFirstName("Sokphorn");
//		newInfo_2.setLastName("Teng");
//		newInfo_2.setAge(26);
//		newInfo_2.setGender(Enums.FEMAIL);
//		newInfo_2.setAddress("BKK");
//		newInfo_2.setEmail("sokphorn.teng@gmail.com");
//		newInfo_2.setStatus("Single");
    	
    }
}

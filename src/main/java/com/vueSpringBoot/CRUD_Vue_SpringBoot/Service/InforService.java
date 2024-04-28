package com.vueSpringBoot.CRUD_Vue_SpringBoot.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vueSpringBoot.CRUD_Vue_SpringBoot.Model.Entity.Information;
import com.vueSpringBoot.CRUD_Vue_SpringBoot.Model.Request.InforRequest;
import com.vueSpringBoot.CRUD_Vue_SpringBoot.Repo.InforRepo;

@Service
public class InforService {
	
	private final InforRepo _inforRepo;
	
    @Autowired
	public InforService(InforRepo _inforRepo) {
		super();
		this._inforRepo = _inforRepo;
	}

    public Information createData(InforRequest infoReq) throws Exception {
    	
    	Information newInfo = new Information();
    	
    	
   	if(this._inforRepo.existsByEmail(newInfo.getEmail())) {
   		
   		try {
   			throw new Exception("Email already exist"); 
		} catch (Exception e) {
			throw new Exception(e);
		}
   	
   	}
//   	newInfo.setAddress(infoReq.getAddress());
	newInfo.setFirstName(infoReq.getFirstName());
	newInfo.setLastName(infoReq.getLastName());
	newInfo.setAge(infoReq.getAge());
	newInfo.setGender(infoReq.getGender());
	newInfo.setEmail(infoReq.getEmail());
	newInfo.setAddress(infoReq.getAddress());
	newInfo.setStatus(infoReq.getStatus());
	return this._inforRepo.save(newInfo);	
	
    }
    
    public List<Information> getInfoList() throws Exception {
    
    	List<Information> info = this._inforRepo.findAll();
    	return info;
    }
	
    public Information updateInfo(Long id, InforRequest infoReq) throws Exception {
    	
    	Information newInfo = this._inforRepo.findById(id).orElseThrow(() -> new Exception());
    	
    	newInfo.setFirstName(infoReq.getFirstName());
    	newInfo.setLastName(infoReq.getLastName());
    	newInfo.setAge(infoReq.getAge());
    	newInfo.setGender(infoReq.getGender());
    	newInfo.setEmail(infoReq.getEmail());
    	newInfo.setAddress(infoReq.getAddress());
    	newInfo.setStatus(infoReq.getStatus());
    	
    	return this._inforRepo.save(newInfo);
    }
    
    public Information getById(Long id) throws Exception {
    	Information info = this._inforRepo.findById(id).orElseThrow(() -> new Exception("ID already exist"));
    	return info;
    }
    
    public Information deleteInfo(Long id) throws Exception {
    	Information removeInfo = this._inforRepo.findById(id).orElseThrow(() -> new Exception("Info already delete"));
    	this._inforRepo.deleteById(removeInfo.getId());
    	return removeInfo;
   
    }
    
}

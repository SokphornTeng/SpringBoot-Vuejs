package com.vueSpringBoot.CRUD_Vue_SpringBoot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vueSpringBoot.CRUD_Vue_SpringBoot.Model.Entity.Information;
import com.vueSpringBoot.CRUD_Vue_SpringBoot.Model.Request.InforRequest;
import com.vueSpringBoot.CRUD_Vue_SpringBoot.Model.Response.InforResponse;
import com.vueSpringBoot.CRUD_Vue_SpringBoot.Service.InforService;

@RestController
@RequestMapping("api/info")
//@CrossOrigin("http://localhost:8080")
@CrossOrigin
public class InfoController {

	private final InforService _inforService;
	@Autowired
	public InfoController(InforService _inforService) {
		super();
		this._inforService = _inforService;
	}

	@PostMapping
	public ResponseEntity<InforResponse> getInfor(@RequestBody InforRequest req) throws Exception {
		Information info = this._inforService.createData(req);
		return ResponseEntity.ok(InforResponse.infoResponse(info));
	}
	
	@GetMapping
	public ResponseEntity<List<InforResponse>> getListing() throws Exception{
		List<InforResponse> newInfo = this._inforService.getInfoList().stream().map(InforResponse::infoResponse).toList();
		return ResponseEntity.ok(newInfo);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<InforResponse> updateInfor(@PathVariable("id") Long id, @RequestBody InforRequest req) throws Exception{
		Information info = this._inforService.updateInfo(id, req);
		return ResponseEntity.ok(InforResponse.infoResponse(info));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<InforResponse> getByOne(@PathVariable("id") Long id) throws Exception {
		Information info = this._inforService.getById(id);
		return ResponseEntity.ok(InforResponse.infoResponse(info));
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<InforResponse> deleteInfo(@PathVariable("id") Long id) throws Exception{
		Information delete = this._inforService.deleteInfo(id);
		return ResponseEntity.ok(InforResponse.infoResponse(delete));
	}
}

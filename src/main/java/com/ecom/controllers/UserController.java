package com.ecom.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.payload.ApiResponse;
import com.ecom.payload.UserDto;
import com.ecom.services.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService  userService;
	
	//7201-create 
	@PostMapping("/")
	public ResponseEntity<UserDto> create(@RequestBody UserDto userDto) {
		UserDto createdUser = this.userService.create(userDto);
		return new ResponseEntity<UserDto>(createdUser,HttpStatus.CREATED);
		
	}
	//update
	@PutMapping("/{userId}")
	public ResponseEntity <UserDto> updateUser(@RequestBody UserDto userDto) {
		UserDto updatedUser = this.userService.update(userDto, 0);
		return new ResponseEntity<UserDto>(updatedUser,HttpStatus.OK);
		
	}
	//delete
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable int userId) {
		this.userService.delete(userId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("user is deleted successfully !!",true),HttpStatus.OK);

	}
	//get
	@GetMapping("/{userId}")
	public ResponseEntity <UserDto> getById(@PathVariable int userId){
		UserDto userDto = this.userService.getByUserId(userId);
		
		return new ResponseEntity<UserDto>(userDto,HttpStatus.OK);
		
	}
	
	//getAll
	@GetMapping("/")
	public ResponseEntity <List<UserDto>>getAll(){
		List<UserDto> all = this.userService.getAll();
		
		return new ResponseEntity<List<UserDto>>(all,HttpStatus.OK);
		
	}
	//get by email
	@GetMapping("/{userEmail}")
	public ResponseEntity<UserDto> getByEmail(@PathVariable String userEmail) {
		UserDto userDto = this.userService.getByEmail(userEmail);
		return new ResponseEntity<UserDto>(userDto,HttpStatus.OK);
		
	}

	
	
	
	
	
	

}

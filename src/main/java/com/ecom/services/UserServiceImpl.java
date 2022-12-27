package com.ecom.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.ecom.exception.ResourceNotFoundException;
import com.ecom.models.User;
import com.ecom.payload.UserDto;
import com.ecom.repository.UserRepository;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDto create(UserDto userDto) {
		//Dto to Entity
		User user = this.ToEntity( userDto);
		//Entity to Dto
		User createdUser = this.userRepository.save(user);
		
		return this.toDto(createdUser);
	}

	@Override
	public UserDto update(UserDto t, int userId) {
		User u = this.userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User not found "+userId));
		u.setUserId(t.getUserId());
		u.setName(t.getName());
		u.setEmail(t.getEmail());
		u.setPassword(t.getPassword());
		u.setAbout(t.getAbout());
		u.setAddress(t.getAddress());
		u.setActive(t.isActive());
		u.setGender(t.getGender());
		u.setCreateAt(t.getCreateAt());
		u.setPhone(t.getPhone());
		
		User save = this.userRepository.save(u);
		
		return this.toDto(save);
	}

	@Override
	public void delete(int userId) {
		User u = this.userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User not found "+userId));
         this.userRepository.delete(u);

	}

	@Override
	public List<UserDto> getAll() {
		List<User> allUser = this.userRepository.findAll();
		allUser.stream().map(user ->this.toDto(user)).collect(Collectors.toList());
		return null;
	}

	@Override
	public UserDto getByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto getByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public UserDto toDto(User user) {
		UserDto dto =new UserDto();
		dto.setUserId(user.getUserId());
		dto.setName(user.getName());
		dto.setEmail(user.getEmail());
		dto.setPassword(user.getPassword());
		dto.setAbout(user.getAbout());
		dto.setAddress(user.getAddress());
		dto.setActive(user.isActive());
		dto.setGender(user.getGender());
		dto.setCreateAt(user.getCreateAt());
		dto.setPhone(user.getPhone());
		
		return dto;
		
	}
	public User ToEntity(UserDto t) {
		User u= new User();
		u.setUserId(t.getUserId());
		u.setName(t.getName());
		u.setEmail(t.getEmail());
		u.setPassword(t.getPassword());
		u.setAbout(t.getAbout());
		u.setAddress(t.getAddress());
		u.setActive(t.isActive());
		u.setGender(t.getGender());
		u.setCreateAt(t.getCreateAt());
		u.setPhone(t.getPhone());
		return u;
		
	}

}

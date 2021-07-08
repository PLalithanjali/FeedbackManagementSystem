package com.feedbackmanagement.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.feedbackmanagement.entity.EmployeeEntity;
import com.feedbackmanagement.pojo.EmployeePojo;
import com.feedbackmanagement.repository.IParticipantRepository;


@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private IParticipantRepository iParticipantRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("username: " + username);
		EmployeeEntity user = iParticipantRepository.findByUserName(username);
		System.out.println("DAO USER :" + user);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getEmployeeName(), user.getEmployeePassword(),
				new ArrayList<>());
	}
	
	public EmployeeEntity save(EmployeeEntity user) {
		EmployeeEntity newUser = new EmployeeEntity();
		newUser.setEmployeeName(user.getEmployeeName());
		newUser.setEmployeePassword(bcryptEncoder.encode(user.getEmployeePassword()));
		return iParticipantRepository.save(newUser);
	}
}
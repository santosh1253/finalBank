package com.springboot.banking.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.banking.entity.Admin;
import com.springboot.banking.exception.AdminNotFoundException;
import com.springboot.banking.repository.AdminRepository;

@Service
public class AdminService {
	@Autowired
	private AdminRepository arepo;

	public AdminService(AdminRepository arepo) {
		this.arepo = arepo;
	}

	// Creating admin
	public Admin createAdmin(Admin admin) {
		Admin saved = arepo.save(admin);
		return saved;
	}

	// updating admin
	public Admin updateAdmin(Admin updateAdmin, int id) {
		Admin admin = fetchAdmin(id);
		Admin updated = null;
		if (admin != null) {
			admin.setUname(updateAdmin.getUname());
			admin.setPassword(updateAdmin.getPassword());
			System.out.println(updateAdmin);
			updated = arepo.save(admin);
		}

		return updated;
	}

	// Reading admin
	public Admin fetchAdmin(int id) {
		Optional<Admin> admin = arepo.findById(id);
		if (admin.isPresent()) {
			return admin.get();
		}
		return null;

	}

	// Delete a admin record
	public String deleteAdmin(int id) {
		arepo.deleteById(id);
		return "Admin with id " + id + " delted";
	}
	
	//Validating Admin
	public String validateAdmin(Admin admin,int id) throws AdminNotFoundException {
		Admin fetched = fetchAdmin(id);
		String uname = admin.getUname();
		String password = admin.getPassword();
		if (fetched.getUname().equals(uname)) {
			if (fetched.getPassword().equals(password))
				return "Success";
			else
				return "Enter the Correct Password";
		}
		return "Wrong Credentials";

	}

}

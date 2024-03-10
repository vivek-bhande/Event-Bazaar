package com.service;

import java.util.List;

import com.model.Admin;

public interface AdminService {

    public Admin addAdmin(Admin a);
	
	public void deleteCus(long cid);
	
	public void deleteAd(long id);
	
	public Admin updateAdmin(Admin ad);
	
	public List<Admin> getAll();
	
//	public List<Admin> findByEmail(String email);
	
	public Admin registerAdmin(Admin admin);
    
	public Admin loginAdmin(String email, String password);

	public Admin authenticateAdmin(String email, String password);

}

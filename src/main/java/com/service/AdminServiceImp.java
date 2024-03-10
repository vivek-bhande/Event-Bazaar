package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.AdminRepository;
import com.dao.CustomerRepository;
import com.model.Admin;

@Service
public class AdminServiceImp implements AdminService {
	
	@Autowired
	AdminRepository adRepo;
	
	@Autowired
	CustomerRepository cusRepo;

	@Override
	public Admin addAdmin(Admin a) {
		// TODO Auto-generated method stub
		return adRepo.save(a);
	}

	@Override
	public void deleteCus(long cid) {
		cusRepo.deleteById(cid);
	}

	@Override
	public void deleteAd(long id) {
		adRepo.deleteById(id);

	}

	@Override
	public Admin updateAdmin(Admin ad) {
		Admin am=adRepo.findById(ad.getId()).orElse(null);
		am.setName(am.getName());
		am.setPassword(am.getPassword());
		return adRepo.save(am);
	}

	@Override
	public List<Admin> getAll() {
		return adRepo.findAll();
	}

//	@Override
//	public List<Admin> findByEmail(String email) {
//		return adRepo.findByEmail(email);
//	}
	 public Admin authenticateAdmin(String email, String password) {
	        return adRepo.findByEmailAndPassword(email, password);
	    }

	@Override
	public Admin registerAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adRepo.save(admin);
	}

	@Override
	public Admin loginAdmin(String email, String password) {
		// TODO Auto-generated method stub
		return adRepo.findByEmailAndPassword(email, password);
	}

//	@Override
//	public List<Admin> findByAdminEmail(String email) {
//		// TODO Auto-generated method stub
//		return adRepo.findByAdminEmail(email);
//	}

}

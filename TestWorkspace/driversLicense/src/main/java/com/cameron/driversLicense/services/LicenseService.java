package com.cameron.driversLicense.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cameron.driversLicense.models.License;
import com.cameron.driversLicense.repositories.LicenseRepo;

@Service
public class LicenseService {
	@Autowired
	private LicenseRepo lRepo;
	
	public List<License> getAll(){
		return this.lRepo.findAll();
	}
	public License createLicense(License newEntry) { 
		return this.lRepo.save(newEntry);
	}
	public License getById(Long id) {
		return this.lRepo.findById(id).orElse(null);
	}
	public License updateEntry(License toUpdate) {
		return this.lRepo.save(toUpdate);
	}
	public void deleteById(Long id) {
		this.lRepo.deleteById(id);
	}
	public String createLicenseNumber(Long personID) {
		if (personID < 10){
			System.out.println("00000"+personID);
			return "00000"+personID;
		}
		else if(personID < 100 && personID >= 10) {
			return "0000"+personID;
		}
		else if(personID < 1000 && personID >= 100) {
			return "000"+personID;
		}
		else if(personID < 10000 && personID >= 1000) {
			return "00"+personID;
		}
		else if(personID < 100000 && personID >= 10000) {
			return "0"+personID;
		}
		
		return "Person Object Required";
	}
}

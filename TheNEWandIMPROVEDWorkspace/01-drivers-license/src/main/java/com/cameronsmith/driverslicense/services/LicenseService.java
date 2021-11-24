package com.cameronsmith.driverslicense.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cameronsmith.driverslicense.models.License;
import com.cameronsmith.driverslicense.repositories.LicenseRepo;

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
	public void generateLicenseNum(License newL) {
		String thisNum = newL.getLicenseNumber();
		Long thisId = newL.getId();
		if(thisId <= 9 && thisId > 0) {
			thisNum = "00000"+thisId;
			newL.setLicenseNumber(thisNum);
			this.lRepo.save(newL);
		}
		if(thisId <= 99 && thisId > 9) {
			thisNum = "0000"+thisId;
			newL.setLicenseNumber(thisNum);
		}
		if(thisId <= 999 && thisId > 99) {
			thisNum = "000"+thisId;
			newL.setLicenseNumber(thisNum);
		}
		if(thisId <= 9999 && thisId > 999) {
			thisNum = "00"+thisId;
			newL.setLicenseNumber(thisNum);
		}
		if(thisId <= 99999 && thisId > 9999) {
			thisNum = "0"+thisId;
			newL.setLicenseNumber(thisNum);
		}
		if(thisId <= 999999 && thisId > 99999) {
			thisNum = "thisId";
			newL.setLicenseNumber(thisNum);
		}
		this.lRepo.save(newL);
	}
}

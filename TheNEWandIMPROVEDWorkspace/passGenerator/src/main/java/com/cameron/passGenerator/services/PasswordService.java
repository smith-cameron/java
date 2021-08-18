package com.cameron.passGenerator.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cameron.passGenerator.models.Password;
import com.cameron.passGenerator.repositories.PasswordRepo;

@Service
public class PasswordService {
	@Autowired
	public PasswordRepo pRepo;
	
	public Password create(Password newEntry) {
//		String hash = BCrypt.hashpw(newEntry.getPassWord(), BCrypt.gensalt());
//		newEntry.setPassWord(hash);
		return this.pRepo.save(newEntry);
	}
	public Password create(String newEntry) {
		return this.pRepo.save(newEntry);
	}
	public Password updateEntry(Password toUpdate) {
		return this.pRepo.save(toUpdate);
	}
	public List<Password> getAll(){
		return this.pRepo.findAll();
	}
	public Password getById(Long id) {
		return this.pRepo.findById(id).orElse(null);
	}
	public void deleteById(Long id) {
		this.pRepo.deleteById(id);
	}
	public ArrayList<Character> letters(){
		ArrayList<Character> output = new ArrayList<Character>();
        for(char alph = 'a'; alph <= 'z'; ++alph){
        	output.add(alph);
        }
        Collections.shuffle(output);
        return output;
	}
	public ArrayList<Integer> numbers(){
		ArrayList<Integer> output = new ArrayList<Integer>();
        for(int i = 0; i < 10; i++){
        	output.add(i);
        }
        Collections.shuffle(output);
        return output;
	}
	public ArrayList<Character> symbols(){
		ArrayList<Character> output = new ArrayList<Character>();
		char[] symbols = {'!','@','#','$','&','*','_'};
		for(int i = 0; i < symbols.length; i++){
        	output.add(symbols[i]);
        }
		Collections.shuffle(output);
		return output;
	}
	public String randomString(int max){
        ArrayList<Character> alphabet = this.letters();
        ArrayList<Integer> numbers = this.numbers();
        ArrayList<Character> symbols = this.symbols();
        String output = "";
        Random randValue = new Random();
        for(int i = 0; i < max-1; i++){
        	if(i % 2 == 0 ) {
        		output += numbers.get(randValue.nextInt(numbers.size()));
        	}
        	else if(i % 3 == 0) {
        		output += alphabet.get(randValue.nextInt(alphabet.size()));
        	}
        	else if(i % 5 == 0) {
        		output += symbols.get(randValue.nextInt(symbols.size()));
        	}
        	else {
        		String capitalized = "";
        		capitalized += alphabet.get(randValue.nextInt(alphabet.size()));
        		output += capitalized.toUpperCase();
        	}
        }
        output += symbols.get(randValue.nextInt(symbols.size()));
        return output;
    }
	
}

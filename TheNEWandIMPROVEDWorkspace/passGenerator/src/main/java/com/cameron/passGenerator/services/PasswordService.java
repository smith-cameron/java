package com.cameron.passGenerator.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cameron.passGenerator.models.Password;
import com.cameron.passGenerator.repositories.PasswordRepo;

@Service
public class PasswordService {
	@Autowired
	public PasswordRepo pRepo;
	
	public Password create(String newEntry) {
		Password output = new Password();
		String hash = BCrypt.hashpw(newEntry, BCrypt.gensalt());
		output.setPassWord(hash);
		return this.pRepo.save(output);
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
	public ArrayList<Character> lettersCAP(){
		ArrayList<Character> output = new ArrayList<Character>();
        for(char alph = 'A'; alph <= 'Z'; ++alph){
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
        ArrayList<Character> alphCap = this.lettersCAP();
        ArrayList<Character> output = this.lettersCAP();
        String output = "";
        Random randValue = new Random();
        System.out.println("num: "+randValue.nextInt(9));
        System.out.println("alph: "+randValue.nextInt(25));
        System.out.println("sym: "+randValue.nextInt(6));
        System.out.println("cap: "+randValue.nextInt(25));
        System.out.println("----------------------");
//        for(int i = 1; i < max-1; i++){
//        	
//        }
//        	if(i % 2 == 0 ) {
//        		output += numbers.get(randValue.nextInt(i));
//        	}
//        	else if(i % 3 == 0) {
//        		output += alphabet.get(randValue.nextInt(i));
//        		
//        	}
//        	else if(i % 5 == 0) {
//        		output += symbols.get(randValue.nextInt(i));
//        	}
//        	else {
//        		String capitalized = "";
//        		capitalized += alphabet.get(randValue.nextInt(i));
//        		output += capitalized.toUpperCase();
//        	}
//        }
//        output += symbols.get(randValue.nextInt(symbols.size()));
//        System.out.println("Service: "+output);
        
		return output;
    }
	
}

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
	Random randValue = new Random();
	
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
	public ArrayList<Character> allLetters(){
		ArrayList<Character> output = new ArrayList<Character>();
		ArrayList<Character> alphabet = this.letters();
		ArrayList<Character> alphaCap = this.lettersCAP();
		for(int i = 0; i < alphabet.size(); i++) {
			output.add(alphabet.get(i));
			output.add(alphaCap.get(i));
		}
        Collections.shuffle(output);
        return output;
	}
	public ArrayList<Character> numbers(){
		ArrayList<Character> output = new ArrayList<Character>();
		char[] numbers = {'0','1','2','3','4','5','6','7','8','9'};
		for(int i = 0; i < numbers.length; i++){
        	output.add(numbers[i]);
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
		if(max > 5) {
			ArrayList<Character> numbers = this.numbers();
			ArrayList<Character> letters = this.letters();
			ArrayList<Character> letterCAPS = this.lettersCAP();
			ArrayList<Character> symbols = this.symbols();
			ArrayList<Character> alphabetMix = this.allLetters();
			ArrayList<Character> preOutput = new ArrayList<Character>();
			String output = "";
//		System.out.println("alphabetMix Size: "+alphabetMix.size());
//        System.out.println("alphabetMix: "+alphabetMix);
//		System.out.println("symbols Size: "+symbols.size());
//        System.out.println("symbols: "+symbols);
//		System.out.println("numbers Size: "+numbers.size());
//        System.out.println("numbers: "+numbers);
//        System.out.println("----------------------");
			for(int i = 0; i < max; i++) {
				System.out.println("building... "+preOutput);
				if( i == 0) {
					preOutput.add(symbols.get(randValue.nextInt(6)));
					continue;
				}
				if( i == 1) {
					preOutput.add(letterCAPS.get(randValue.nextInt(25)));
					continue;
				}
				if( i == 2) {
					preOutput.add(numbers.get(randValue.nextInt(9)));
					continue;
				}
				if( i == 3) {
					preOutput.add(letters.get(randValue.nextInt(25)));
					continue;
				}
				else{
					preOutput.add(alphabetMix.get(randValue.nextInt(52)));
				}
			}
			for(int i = 0;i < max;i++) {
				output += preOutput.get(i);
			}
			System.out.println("----------------------");
//        output += numbers.get(randValue.nextInt(i));
//        output += alphabetMix.get(randValue.nextInt(i));
//        output += symbols.get(randValue.nextInt(i));
			System.out.println("Service: "+preOutput);
			System.out.println("Output length: "+preOutput.size());
			Collections.shuffle(preOutput);
			System.out.println("Service: "+preOutput);
			return output;
		}
		return null;
    }
	
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package slowkouk.models;

/**
 *
 * @author Administrator
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import slowkouk.database.Database;
import slowkouk.exceptions.DatabaseException;

public class Exam {
	
	private Language language;
	private List<Word> words;
	private List<Answer> answers;
	private Category category;
	private Iterator<Word> wordIterator;
	private List<String> results;
	
	
	private Word currentWord;
	
	/**
	 * 
	 * @param language z ktorego jest egzamin
	 * @param category zestaw slowek
	 */
	public Exam(Language language, WordSet wordSet){
		//todo tworzenie okienka do wyboru language i tematu, ktore ustawi language i category
            this.language = language;
            generateWords(wordSet);
            results = new ArrayList();
            answers = new ArrayList();
	}
	
	/**
	 * 
	 * @return 
	 */
	public Word getNextWord(){
		if(wordIterator.hasNext()){
			return wordIterator.next();
		}else{
			return null;
		}
		
	}
	
	public void repeatExam(){
		Collections.shuffle(words);
		wordIterator = words.iterator();
		answers.clear();
		
	}
	
	/**
	 * Generowanie listy slowek z bazy na podstawie zestawu i jezyka
	 */
	private void generateWords(WordSet wordSet){
            try {
                //todo pobranie bazy slowek na podstawie zestawu i jezyka
                words = Database.getInstance().selectWordsWithWordSet(wordSet);
            } catch (DatabaseException ex) {
                Logger.getLogger(Exam.class.getName()).log(Level.SEVERE, null, ex);
            }
		Collections.shuffle(words);
		wordIterator = words.iterator();
	}
	
	public void addAnswer(Answer answer){
		
		results.add(this.checkAnswer(answer));
	}
	
	/**
	 * wyswietlanie wynikow answers w oknie
	 */
	public List<String> getResults(){
		return results;
	}
	
	public String checkAnswer(Answer answer){
		if(answer.isTranslationCorrect(language)){
			return String.format("%s - %s - ok \n",answer.getWord().toString(), answer.getAnswer()  );
		}else{
			return String.format("%s - %s - źle \n",answer.getWord().toString(), answer.getAnswer() );
		}
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public List<Word> getWords() {
		return words;
	}

	public void setWords(List<Word> words) {
		this.words = words;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Word getCurrentWord() {
		return currentWord;
	}

	public void setCurrentWord(Word currentWord) {
		this.currentWord = currentWord;
	}
	
	
	
}
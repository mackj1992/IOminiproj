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
	public Exam(){
		//todo tworzenie okienka do wyboru language i tematu, ktore ustawi language i category
		
		generateWords();
		
		showExamWindow();
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
	
	private void repeatExam(){
		Collections.shuffle(words);
		wordIterator = words.iterator();
		answers.clear();
		
	}
	
	/**
	 * Generowanie listy slowek z bazy na podstawie zestawu i jezyka
	 */
	public void generateWords(){
		//todo pobranie bazy slowek na podstawie zestawu i jezyka
		words = new ArrayList<>();
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
	
	/**
	 * wyswietla pytanie i pobiera odpowiedz
	 */
	public void showExamWindow(){
		
		
		Word w = getNextWord();
		//okienko wyswietlenie slowka w
	}
	
	public String checkAnswer(Answer answer){
		if(answer.isTranslationCorrect(language)){
			return String.format("%s - %s - ok \n",answer.getWord(), answer.getAnswer()  );
		}else{
			return String.format("%s - %s - źle \n",answer.getWord(), answer.getAnswer() );
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
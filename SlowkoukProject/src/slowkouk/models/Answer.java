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
public class Answer {
	
	
	private String answer;
	private Word word;
	
	public Answer(String answer, Word word) {
		super();
		this.answer = answer;
		this.word = word;
	}
	
	public String getAnswer() {
		return answer;
	}
	
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public Word getWord() {
		return word;
	}
	
	public void setWord(Word word) {
		this.word = word;
	}

	
	public boolean isTranslationCorrect(Language language) {
		// TODO Auto-generated method stub
			if(answer.compareTo(word.getTranslation(language))==0)
				return true;
			else
				return false;
	}
	
	
}

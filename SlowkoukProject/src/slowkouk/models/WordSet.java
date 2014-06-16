/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slowkouk.models;

import java.util.ArrayList;

/**
 *
 * @author inf106614
 */
public class WordSet {
    private ArrayList<Word> words;
    private String name;
    private String mainLang;
    private String destinationLang;
    
    public WordSet(ArrayList<Word> words, String name, String mainLang, String destinationLang){
        this.words = words;
        this.name = name;
        this.mainLang = mainLang;
        this.destinationLang = destinationLang;
    }
    
    public WordSet(){
    }
    
    public String toString(){
        return getName();
    }

    /**
     * @return the words
     */
    public ArrayList<Word> getWords() {
        return words;
    }

    /**
     * @param words the words to set
     */
    public void setWords(ArrayList<Word> words) {
        this.words = words;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the mainLang
     */
    public String getMainLang() {
        return mainLang;
    }

    /**
     * @param mainLang the mainLang to set
     */
    public void setMainLang(String mainLang) {
        this.mainLang = mainLang;
    }

    /**
     * @return the destinationLang
     */
    public String getDestinationLang() {
        return destinationLang;
    }

    /**
     * @param destinationLang the destinationLang to set
     */
    public void setDestinationLang(String destinationLang) {
        this.destinationLang = destinationLang;
    }
    
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slowkouk.models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author inf106614
 */
public class Word {

    private String caption;
    private Language lang;
    private int id;
    private List<Category> categories;
    private List<Word> translationsList;
    
    public Word(String caption, Language language){
        this.caption = caption;
        this.lang = language;
        translationsList = new ArrayList();
        categories = new ArrayList();
    }
    
    public String toString() {
        return caption;
    }

    public String getCaption() {
        return caption;
    }

    public void setWord(String caption) {
        this.caption = caption;
    }

    public String getTranslation(Language translationLang) {
        for(Word w: translationsList){
            if(w.getLang().getLanguageName().equals(translationLang.getLanguageName())){
                return w.getCaption();
            }
        }
        return "Error";
    }

    public void addTranslation(Word w) {
        this.translationsList.add(w);
    }

    /**
     * @return the lang
     */
    public Language getLang() {
        return lang;
    }

    /**
     * @param lang the lang to set
     */
    public void setLang(Language lang) {
        this.lang = lang;
    }
}

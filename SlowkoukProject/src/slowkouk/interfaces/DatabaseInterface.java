/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slowkouk.interfaces;

import slowkouk.models.Word;
import slowkouk.models.WordSet;

/**
 *
 * @author inf106614
 */
public interface DatabaseInterface {
    
    public void insertWord(Word w);
    public void insertWordSet (WordSet ws);
    
    public void deleteWord(Word w);
    public void deleteWordSet(WordSet ws);
    
    public void updateWord(Word w);
    public void updateWordSet(WordSet ws);
    
    public void selectWordsWithLang(String lang);
    public void selectWordSetWithLang(String lang);
    
    public void selectWord(int id);
    public void selectWordWithCategory(String category);
    
}

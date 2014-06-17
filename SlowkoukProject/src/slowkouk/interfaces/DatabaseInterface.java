/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slowkouk.interfaces;

import java.util.ArrayList;
import java.util.List;
import slowkouk.models.Language;
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
    
    public ArrayList<Word> selectWordsWithLang(String lang);
    public ArrayList<Word> selectWordSetWithLang(String lang);
    public ArrayList<Word> selectWords();
    
    public Word selectWord(int id);
    public Word selectWord(String caption);
    public ArrayList<Word> selectWordsWithCategory(String category);
    public List<Word> selectWordsWithWordSet(WordSet wordSet);
    public WordSet selectWordSet(String name);
    
    public List<WordSet> selectWordSets();
    public List<Language> selectLanguages();
}

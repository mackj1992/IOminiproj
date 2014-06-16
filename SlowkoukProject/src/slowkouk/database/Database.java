/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slowkouk.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import slowkouk.exceptions.DatabaseException;
import slowkouk.interfaces.DatabaseInterface;
import slowkouk.models.Language;
import slowkouk.models.Word;
import slowkouk.models.WordSet;

/**
 *
 * @author inf106614
 */

//JEŚLI GDZIEKOLWIEK SĄ TU NAPISANE JAKOŚ CIAŁA METOD, OGARNIJ JE BY DZIAŁAŁY Z BAZY

public class Database implements DatabaseInterface{
    
    private static Database instance= null;
    
    Connection connection = null;
   
    private Database() throws DatabaseException {
            
        try {
            connect();         
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseException();
        }
    }
   
    public static Database getInstance() throws DatabaseException {
        
        if(instance==null){
            return new Database();
        }else{
            return instance;
        }
    }
    
    
    private void connect() throws ClassNotFoundException, SQLException{
          // load the sqlite-JDBC driver using the current class loader
        Class.forName("org.sqlite.JDBC"); 
        connection = DriverManager.getConnection("jdbc:sqlite:slowkoukdb.sqlite");    
    }
    
  /*  
    public void testMethod() throws ClassNotFoundException{
            // load the sqlite-JDBC driver using the current class loader
        Class.forName("org.sqlite.JDBC");
        
        Connection connection = null;
    try
    {
      // create a database connection
      connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
      Statement statement = connection.createStatement();
      statement.setQueryTimeout(30);  // set timeout to 30 sec.

      statement.executeUpdate("drop table if exists person");
      statement.executeUpdate("create table person (id integer, name string)");
      statement.executeUpdate("insert into person values(1, 'leo')");
      statement.executeUpdate("insert into person values(2, 'yui')");
      ResultSet rs = statement.executeQuery("select * from person");
      while(rs.next())
      {
        // read the result set
        System.out.println("name = " + rs.getString("name"));
        System.out.println("id = " + rs.getInt("id"));
      }
    }
    catch(SQLException e)
    {
      // if the error message is "out of memory", 
      // it probably means no database file is found
      System.err.println(e.getMessage());
    }
    finally
    {
      try
      {
        if(connection != null)
          connection.close();
      }
      catch(SQLException e)
      {
        // connection close failed.
        System.err.println(e);
      }
    }
    }
*/
    @Override
    public void insertWord(Word w) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into words (caption, lang_id) "
                    + " values ('"+w.getCaption()+"', "
                    +" (select _id from languages where name='"+w.getLang().getLanguageName()
                    +" ')"+" )");
            
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }

    @Override
    public void insertWordSet(WordSet ws) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteWord(Word w) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteWordSet(WordSet ws) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateWord(Word w) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateWordSet(WordSet ws) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Word> selectWordsWithLang(String lang) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Word> selectWordSetWithLang(String lang) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 
     * @param id
     * @return word without translation list
     */
    private Word getBaseWord(int id) {
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(
                    "select w._id as id, w.caption as caption , l.name as lang "
                    + " from words w JOIN languages l "
                    + "ON lang_id=l._id where w._id=" + id);
            //if (rs.first()) {
                Word w = new Word(rs.getString("caption"), new Language(rs.getString("lang")));
                return w;
            //}
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
    
    @Override
    public Word selectWord(int id) {
        try {
            {
                Word w = getBaseWord(id);
                if (w == null) {
                    return null;
                }

                Statement statement = connection.createStatement();
                ResultSet translationsList = statement.executeQuery(
                        "select * from words_translationsList  w_tl where w_tl.word_id=" + id);

                while (translationsList.next()) {
                    w.addTranslation(getBaseWord(translationsList.getInt("word_id")));
                }
                return w;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Word selectWord(String caption) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Word> selectWordsWithCategory(String category) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Language> selectLanguages() {
        try {
            ArrayList<Language> test = new ArrayList<Language>();

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from languages");
            while (rs.next()) {          
                test.add(new Language(rs.getString("name")));
            }
            return test;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public WordSet selectWordSet(String name) {
         try {
            WordSet set = new WordSet();
            
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(
                    " select dst.name as dstName, src.name as srcName,  ws.name as setName "
                    + " from wordSets ws LEFT OUTER JOIN languages src ON mainLang_id=src._id "
                    + " LEFT OUTER JOIN languages dst ON destinationLang_id=dst._id "
                    + " where ws.name='" + name + "' ");
            
              set.setDestinationLang(rs.getString("dstName"));
              set.setMainLang(rs.getString("srcName"));
              set.setName(rs.getString("setName"));
            
            ArrayList<Word> words = new ArrayList<>();
            words.addAll(selectWordsWithWordSet(set));
            set.setWords(words);
            
            return set;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<WordSet> selectWordSets() {
        try {
            List<WordSet> setList = new ArrayList<WordSet>();

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(
                    " select dst.name as dstName, src.name as srcName,  ws.name as setName "
                    + " from wordSets ws LEFT OUTER JOIN languages src ON mainLang_id=src._id "
                    + " LEFT OUTER JOIN languages dst ON destinationLang_id=dst._id ");
            while (rs.next()) {
                WordSet set = new WordSet();
                set.setDestinationLang(rs.getString("dstName"));
                set.setMainLang(rs.getString("srcName"));
                set.setName(rs.getString("setName"));

                ArrayList<Word> words = new ArrayList<>();
                words.addAll(selectWordsWithWordSet(set));
                set.setWords(words);

                setList.add(set);
            }
            return setList;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<Word> selectWordsWithWordSet(WordSet wordSet) {
       try {
            ArrayList<Word> test = new ArrayList<Word>();

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(
                    " select * from words_wordSets where wordSet_id= "
                    + " (select _id from wordSets where name='"+wordSet.getName()+"')");
            while (rs.next()) {          
                test.add(selectWord(rs.getInt("word_id")));
            }
            return test;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }


    
}

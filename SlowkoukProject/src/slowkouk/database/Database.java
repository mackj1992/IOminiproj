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
import java.util.logging.Level;
import java.util.logging.Logger;
import slowkouk.exceptions.DatabaseException;
import slowkouk.interfaces.DatabaseInterface;
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
        //RAFIKSIE ODKOMENTUJ TO POTEM, KOMENTŁEM SE DO TESTÓW
            
        /**try {
            connect();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseException();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseException();
        }*/
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
        connection = DriverManager.getConnection("jdbc:sqlite:sample.db");    
    }
    
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

    @Override
    public void insertWord(Word w) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    @Override
    public Word selectWord(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public ArrayList<String> selectLanguages() {
        ArrayList test = new ArrayList<String>();
        test.add("xD");
        return test;
    }

    @Override
    public WordSet selectWordSet(String name) {
        return new WordSet();
    }

    @Override
    public ArrayList<String> selectWordSetsNames() {
        ArrayList test = new ArrayList<String>();
        test.add("xB");
        test.add("xP");
        return test;
    }


    
}

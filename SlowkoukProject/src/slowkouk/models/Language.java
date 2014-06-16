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
public class Language {
   private String languageName;
   
   public Language(){
       
   }
   
   public Language(String languageName){
       this.languageName = languageName;
   }
   
   public String toString(){
       return getLanguageName();
   }

    /**
     * @return the languageName
     */
    public String getLanguageName() {
        return languageName;
    }

    /**
     * @param languageName the languageName to set
     */
    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }
   
   
}

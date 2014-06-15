/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slowkouk.okienka;

/*
 * JFRAME SIZES: 640 x 480
 */

/**
 *
 * @author inf106634
 */
public class Exam extends javax.swing.JFrame {

    private static Exam exam;
    private static ExamSettingsPanel set;
    private static ExamPanel quest;
    private static ExamResultsPanel res;
    
    /**
     * Creates new form Exam
     */
    public Exam() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Exam Main Frame");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(266, 266, 266)
                .addComponent(jLabel1)
                .addContainerGap(266, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(452, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Exam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Exam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Exam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Exam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Exam examFrame = new Exam();
                exam = examFrame;
                ExamSettingsPanel Settings = new ExamSettingsPanel(exam);
                set=Settings;
                //Settings.setAlignmentX(10);
                //Settings.setAlignmentY(35);
                
                Settings.setBounds(10, 35, 620, 435);
                Settings.setVisible(true);
                
                examFrame.setVisible(true);
                examFrame.add(Settings);
                
                
            }
            
        });
    }
    //ten run coś nawalał jak puszczałem z pozycji menu, to dodałem start
    public static void start(){
        Exam examFrame = new Exam();
        exam = examFrame;
        ExamSettingsPanel Settings = new ExamSettingsPanel(exam);
        set=Settings;
                //Settings.setAlignmentX(10);
                //Settings.setAlignmentY(35);
                
                set.setBounds(10, 35, 620, 435);
                set.setVisible(true);
                
                exam.setVisible(true);
                exam.add(set);
    
    }
    
    public static void startQuestions(){
        //todo: przyjęcie jako parametr języka i zestawu słówek.
        
        ExamPanel question = new ExamPanel(exam);
        if(quest!=null)exam.remove(quest);
        quest=question;
        quest.setBounds(10, 35, 620, 435);
        quest.setVisible(true);
        //chowam poprzedni panel
        set.setVisible(false);
        exam.setVisible(true);
        exam.add(quest);
        
        
    }
    
    public static void showResults(){
        //todo: wyciągnięcie z quest Stringów na pytania (może być osobna metoda).
        
        //todo: podanie do results parametru z wynikami z quest
        ExamResultsPanel result = new ExamResultsPanel(exam);
        if(res!=null)exam.remove(res);
        res=result;
        res.setBounds(10, 35, 620, 435);
        res.setVisible(true);
        //chowam poprzedni panel
        quest.setVisible(false);
        exam.setVisible(true);
        exam.add(res);
        
        
    }
    
     public static void repeat(){
                
                res.setVisible(false);
                set.setVisible(true);
                
                exam.setVisible(true);
                exam.repaint();
    
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
    //private javax.swing.JPanel jPanel1; <- niepotrzebn panel, ktory bedzie zastepowany Panelami Exam... .
}

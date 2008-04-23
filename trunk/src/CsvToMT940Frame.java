import java.awt.Dimension;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import mt940.MT940File;
/*
 * Created on 21.09.2004
 */

/**
 * @author Joscha Feth
 */
public class CsvToMT940Frame extends JFrame {

	final static long serialVersionUID = 0;
	
	private javax.swing.JPanel jContentPane = null;

	private JTextField jTextField 		= null;
	private JPanel jPanel 				= null;
	private JButton jButton 			= null;
	private JButton jButtonSave 		= null;
	private JFileChooser jFileChooser 	= new JFileChooser();
	private JFileChooser jFileChooser2 	= new JFileChooser();
	private CsvToMT940 c2m 				= new CsvToMT940(this);
	private JPanel jPanel1 				= null;
	private JTextArea jTextArea 		= null;
	private JScrollPane jScrollPane 	= null;
	private CsvFilter cf				= new CsvFilter();
	private MT940Filter mf				= new MT940Filter();
	
	   /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        //Create and set up the window.
        JFrame frame = new CsvToMT940Frame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Display the window.
        //frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
	
	/**
	 * This is the default constructor
	 */
	public CsvToMT940Frame() {		
		super();
		initialize();		
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(320, 194);
		this.setContentPane(getJContentPane());
		this.setTitle("CSV zu MT940 Konverter");
		this.setResizable(false);
	    this.jFileChooser.setFileFilter(this.cf);
	    this.jFileChooser2.setFileFilter(this.mf);
	}
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private javax.swing.JPanel getJContentPane() {
		if(jContentPane == null) {
			jContentPane = new javax.swing.JPanel();
			jContentPane.setLayout(new java.awt.BorderLayout());
			jContentPane.add(getJTextField(), java.awt.BorderLayout.NORTH);
			jContentPane.add(getJPanel(), java.awt.BorderLayout.CENTER);
			jContentPane.add(getJPanel1(), java.awt.BorderLayout.SOUTH);
		}
		return jContentPane;
	}
	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setEditable(false);
			jTextField.setText("Joscha Feth, www.feth.com, use at own risk");
		}
		return jTextField;
	}
	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			jPanel.add(getJButton(), null);
			jPanel.add(getJButtonSave(), null);
		}
		return jPanel;
	}
	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setText("CSV Datei öffnen");
			jButton.addActionListener(new java.awt.event.ActionListener() {   
				public void actionPerformed(java.awt.event.ActionEvent e) {    
				    int returnVal = CsvToMT940Frame.this.jFileChooser.showOpenDialog(jContentPane);
				    if(returnVal == JFileChooser.APPROVE_OPTION) {
				    	File f = CsvToMT940Frame.this.jFileChooser.getSelectedFile();
				    	CsvToMT940Frame.this.jTextField.setText(f.getAbsolutePath());
				    	CsvToMT940Frame.this.jFileChooser.setCurrentDirectory(f);
				    	CsvToMT940Frame.this.jButtonSave.setEnabled(true);
				    	CsvToMT940Frame.this.c2m.loadCSV(f);
				    	CsvToMT940Frame.this.addInfo("\""+f.getName()+"\" geladen.");
				    	CsvToMT940Frame.this.addInfo(CsvToMT940Frame.this.c2m.getCount()+" Datensätze.");
				    	CsvToMT940Frame.this.addInfo("Die Konvertierung kann einige Min. dauern!");
				    }							
				} 
			
			});
		}
		return jButton;
	}
	public void addInfo(String info) {
		this.jTextArea.append("\n"+info);
	}
	/**
	 * This method initializes jButtonSave	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getJButtonSave() {
		if (jButtonSave == null) {
			jButtonSave = new JButton();
			jButtonSave.setText("MT940 Datei speichern");
			jButtonSave.setEnabled(false);
			jButtonSave.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {
//					CsvToMT940Frame.this.addInfo("Konvertierung gestartet, einen Moment...");
//					CsvToMT940Frame.this.repaint();
					MT940File f = CsvToMT940Frame.this.c2m.createMT940();
					if(f != null) {
						
						
					    int returnVal = CsvToMT940Frame.this.jFileChooser2.showSaveDialog(jContentPane);
//					    CsvToMT940Frame.this.jFileChooser2.
					    if(returnVal == JFileChooser.APPROVE_OPTION) {
					    	CsvToMT940Frame.this.addInfo("Erfolgreich konvertiert.");
					    	File sf = CsvToMT940Frame.this.jFileChooser2.getSelectedFile();
					    	CsvToMT940Frame.this.jFileChooser2.setCurrentDirectory(sf);
//					        FileOutputStream fout = null;
					        
					        FileWriter fw = null;
							try {
								fw = new FileWriter(sf);
								fw.write(f.toString());
						        fw.close();								
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

//							try {
//								fout = new FileOutputStream();
//							} catch (FileNotFoundException e1) {
//								e1.printStackTrace();
//							}
//							PrintStream myOutput = new PrintStream(fout);			
//							myOutput.print(f);
					    } else {
					    	CsvToMT940Frame.this.addInfo("Konvertierung vom Benutzer abgebrochen!");
					    }
					}
				}
			});
		}
		return jButtonSave;
	}
	/**
	 * This method initializes jPanel1	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			jPanel1 = new JPanel();
			jPanel1.add(getJScrollPane(), null);
		}
		return jPanel1;
	}
	/**
	 * This method initializes jTextArea	
	 * 	
	 * @return javax.swing.JTextArea	
	 */    
	private JTextArea getJTextArea() {
		if (jTextArea == null) {
			jTextArea = new JTextArea();
			jTextArea.setText("Verson 0.X von 200X-XX-XX\nBitte öffnen Sie eine Datei!");
			jTextArea.setAutoscrolls(true);
			jTextArea.setEditable(false);
			jTextArea.setLineWrap(true);
//			jTextArea.setMargin(new Insets(5,5,5,5));
		}
		return jTextArea;
	}
	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */    
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getJTextArea());
			jScrollPane.setPreferredSize(new Dimension(300,100));
//			jScrollPane.setAutoscrolls(true);
		}
		return jScrollPane;
	}
  }  //  @jve:decl-index=0:visual-constraint="10,10"

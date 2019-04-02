import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
class Term {
	
	private String word;
	private String type;
	private String origin;
	
	public Term(String word, String type, String origin) {
		this.word = word;
		this.type = type;
		this.origin = origin;
	}

}

public class Analyser extends JFrame implements ActionListener{
	
	private static String word1;
	private static String word2;
	private static String word3;
	private static List<Term> dict;

    static JTextField example; 
    static JFrame f;  
    static JButton b; 
    static JLabel l; 
    
    static JFrame search;
    static JButton searchButton;
    static JLabel searchResult;
    static JComboBox input1;
    static JComboBox input2;
    static JComboBox input3;
	
    public Analyser() {
    	
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setSize(100, 100);
//        setLocation(100, 100);
//
//        JButton button1 = new JButton("Run");
//        button1.addActionListener(this);
//        add(button1);
    	
	        f = new JFrame("textfield");
	        l = new JLabel("nothing entered"); 
	        searchResult = new JLabel(" ");
	        b = new JButton("Add example");
	        searchButton = new JButton("Search");
	        b.addActionListener(this);
	        searchButton.addActionListener(this);
	        example = new JTextField(16);
	        String types[]={"PRO:PER","NOM","PREP","DET:ART","ADJ","ADV"};        
	        input1=new JComboBox(types);    
	        input1.setBounds(50, 50,90,20);
	        input1.setEditable(true);
	        
	        input2=new JComboBox(types);    
	        input2.setBounds(50, 50,90,20);
	        input2.setEditable(true);
	        
	        input3=new JComboBox(types);    
	        input3.setBounds(50, 50,90,20);
	        input3.setEditable(true);
	        JPanel p = new JPanel();
	        p.add(example); 
	        p.add(b); 
	        p.add(l);
	        p.add(input1);
	        p.add(input2);
	        p.add(input3);
//	        p.add(search);
	        p.add(searchButton);
	        p.add(searchResult);



	        f.add(p); 
	        f.setSize(300, 300); 
	  
	        f.show(); 


        
    }
	
	private static void analysing() throws IOException, InterruptedException {

//		Process p = Runtime.getRuntime().exec("cmd /c start cmd.exe /k \"cd c:\\TreeTagger && tag-french examples.txt > dict.txt");
//		Thread.sleep(4000);
//		Runtime.getRuntime().exec("taskkill /f /im cmd.exe") ;
		 
		File file = new File("C:\\TreeTagger\\dict.txt"); 
		BufferedReader br = new BufferedReader(new FileReader(file));
	    String []parts;
	    String st;
	    Term line;
	    dict = new ArrayList<Term>();
		while ((st = br.readLine()) != null){
	    	parts = st.split("\t");
	    	// we dont need to add  the point at the end of each line
	    	if(!parts[1].equals("SENT")) {
		    	line = new Term(parts[0],parts[1],parts[2]);
		    	dict.add(line);
	    	}
	    }
	}
	
	public static void addExample(String ex) throws IOException {
	    String filename= "C:\\TreeTagger\\examples.txt";
	    FileWriter fw = new FileWriter(filename,true); 
	    fw.write(ex);//appends the string to the file
	    fw.close();
	}
	
	
	public void phrasing(String inupt1,String input2,String input3) {
		
		
		
	}
	
	
	public static void main(String args []) throws IOException, InterruptedException {
		
		analysing(); 
        Analyser te = new Analyser(); 
  
        	//	new Analyser();
//		addExample("instancier");

//		addExample("il le sait bien lui.");
////		Scanner input = new Scanner (System.in);
//		word1 = input.nextLine();
//		input = new Scanner (System.in);
//		word2 = input.nextLine();
//		input = new Scanner (System.in);
//		word3 = input.nextLine();
		
		
//		System.out.println("wr1: "+ word1+" wr2: "+word2);
		
	}
	
	@Override
    public void actionPerformed(ActionEvent e) {
       
		String s = e.getActionCommand(); 
        if (s.equals("Add example")) { 
        	try {
				addExample("\n"+example.getText()+".");
				l.setText("Example was successfully added");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
            // set the text of field to blank 
            example.setText("  "); 
        } else if(s.equals("Search")){
        	phrasing(input1.getSelectedItem().toString(),
        			input2.getSelectedItem().toString(),
        			input1.getSelectedItem().toString());
        }
		
/*		String command = e.getActionCommand();

        if (command.equals("button1")) {
            try {
				runExe();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
*/    }

}

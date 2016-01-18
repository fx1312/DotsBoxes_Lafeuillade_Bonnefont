import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class Fenetre extends JFrame{
	
   
  
  CardLayout cl = new CardLayout();
  GridLayout gl = new GridLayout(2,2);
  JPanel content = new JPanel();
  
  String[] listContent = {"CARD_1", "CARD_2"};
  int indice = 0;
  static boolean b = false;
  

  public Fenetre(){
	
    this.setTitle("Dots and Boxes");
    this.setSize(600, 600);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    
    JPanel card1 = new JPanel();
    card1.setBackground(Color.gray);			
    
    JPanel card2 = new JPanel();
    card2.setBackground(Color.gray);
    
    JButton b1 = new JButton("4");
    JButton b2 = new JButton("9");		
    JButton b3 = new JButton("16");
    JButton b4 = new JButton("25");
    JButton b5 = new JButton("Humain");
    JButton b6 = new JButton("Ordinateur"); 
    JLabel label1 = new JLabel("Choix du numbre de case:");
    JLabel label2 = new JLabel("Choix du deuxième joueur:");
    
    
    card1.setLayout(gl);
    gl.setHgap(5);
    gl.setVgap(5);
    card1.add(b1);
    card1.add(b2);
    card1.add(b3);
    card1.add(b4);
    
    card2.setLayout(gl);
    card2.add(b5);
    card2.add(b6);
    
    content.setLayout(cl);

    content.add(card1, listContent[0]);
    content.add(card2, listContent[1]);

    this.getContentPane().add(content, BorderLayout.CENTER);
    this.setVisible(true);
    

    b1.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){
    	Test1.c=3;
    	Test1.l=3;
        cl.next(content);
      }
    });
	
    
    b2.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent event){
        	Test1.c=4;
        	Test1.l=4;
          cl.next(content);
        }
      });
    
    b3.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent event){
        	Test1.c=5;
        	Test1.l=5;
      	  cl.next(content);
        }
      });
    
    b4.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent event){
        	Test1.c=6;
        	Test1.l=6;
          cl.next(content);
        }
      });
    
    b5.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent event){
    		Test1.typeJeu=0;
    		b = true;
    		dispose();
    		
    	}
    });
    
    b6.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent event){
    		Test1.typeJeu=1;
    		b = true;
    		dispose();
    		
    	}
    });
    
    
    
	
}
  public void affichageGrille(int horizontale[][], int verticale[][]){
	  StdDraw.clear();
	  
	  for(int i=0; i<Test1.l; i++){
	    	for(int j=0; j<Test1.c; j++){
	    		StdDraw.filledCircle(20+j*40, 20+i*40, 1);
	    	}
	    }
	    StdDraw.show();	
	  
	  for(int i=0; i<Test1.l; i++){
		  for(int j=0; j<Test1.c-1; j++){
			  if(horizontale[i][j]==1){
				  StdDraw.filledRectangle(40+j*40, 20+i*40, 18, 1);
			  }
		  }
		  
	  }
	  for(int i=0; i<Test1.l-1; i++){
		  for(int j=0; j<Test1.c; j++){
			  if(verticale[i][j]==1){
				  StdDraw.filledRectangle(20+j*40, 40+i*40, 1, 18);
			  }
		  }
  }
	  StdDraw.text(20, +0.98, "Points Joueur A: "+Test1.pointsA);
	  StdDraw.text(100, +0.98, "Points Joueur B: "+Test1.pointsB);
}



}





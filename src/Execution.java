import java.util.Scanner;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.ThreadLocalRandom;
public class Execution {
	static int pointsA=0;
	static int pointsB=0;
	static int joueur=1;
	static int typeJeu=0;
	static int points=0;
	static int c=0;
	static int l=0;
	static int graphique=1;
	static double mouseX = 0;
	static double mouseY = 0;
	static boolean b = false;
	
	public static void main (String[] args){
		
		System.out.println("Si vous voulez jouer en graphique, tapez 1, sinon 0.");
		Scanner lecture = new Scanner(System.in);
		graphique = lecture.nextInt();
		
		
		
		if(graphique==0){
			System.out.println("Avec combien de carrés voulez-vous jouer?");
			Scanner scan = new Scanner(System.in);
			int nbcarres=scan.nextInt();

			
			if(nbcarres==4){
				c=3;
				l=3;
			}
			
			if(nbcarres==9){
				c=4;
				l=4;
			}
			
			if(nbcarres==16){
				c=5;
				l=5;
			}
			
			if(nbcarres==25){
				c=6;
				l=6;
			}
			
			//Choix du type de jeu
			Scanner scn = new Scanner(System.in);
			System.out.println("Voulez-vous jouer contre un humain(0), ou un ordinateur(1)?");
			typeJeu=scn.nextInt();
			
			//Affichage du plateau de jeu
			Environement tab1 = new Environement(c, l);
			System.out.println();
			tab1.initTab();
			System.out.println();
			System.out.println();
			System.out.println();
			
			
			
			
			while(true){
				Execution.joueur=1;
				System.out.println("Joueur A, horizontale(h) ou verticale(v)?");
				Scanner dir = new Scanner(System.in);
				String str = dir.nextLine();
				System.out.println("ligne: ");
				int coox=dir.nextInt();
				System.out.println("colonne: ");
				int cooy=dir.nextInt();

				if(str.charAt(0)=='h'){
					Environement.horizontale[coox-1][cooy-1]=1;
				}
				
				if(str.charAt(0)=='v'){
					Environement.verticale[coox-1][cooy-1]=1;
				}
			
				tab1.updateTab();
				checkWin(Environement.horizontale, Environement.verticale);
				System.out.println("Points A: "+Execution.pointsA);
				System.out.println("Points B: "+Execution.pointsB);
				System.out.println("__________________________________________________");
				System.out.println();
				if(checkEnd(Environement.horizontale, Environement.verticale)==true){
					System.out.println("La partie est finie!");
					break;
				}
				
				
				if(typeJeu==0){
				
				Execution.joueur=2;
				System.out.println("Joueur B, horizontale(h) ou verticale(v)?");
				Scanner dire = new Scanner(System.in);
				String strg = dire.nextLine();
				System.out.println("ligne: ");
				coox=dire.nextInt();
				System.out.println("colonne: ");
				cooy=dire.nextInt();

					if(strg.charAt(0)=='h'){
						Environement.horizontale[coox-1][cooy-1]=1;
					}
				
					if(strg.charAt(0)=='v'){
						Environement.verticale[coox-1][cooy-1]=1;
					}
			
					tab1.updateTab();
					checkWin(Environement.horizontale, Environement.verticale);
					System.out.println("Points A: "+Execution.pointsA);
					System.out.println("Points B: "+Execution.pointsB);
					System.out.println("__________________________________________________");
					if(checkEnd(Environement.horizontale, Environement.verticale)==true){
						System.out.println("La partie est finie!");
						break;
					}
					}
				
				if(typeJeu==1){
					Execution.joueur=2;
					IA();
					tab1.updateTab();
					checkWin(Environement.horizontale, Environement.verticale);
					System.out.println("Points A: "+Execution.pointsA);
					System.out.println("Points B: "+Execution.pointsB);
					System.out.println("__________________________________________________");
					if(checkEnd(Environement.horizontale, Environement.verticale)==true){
						System.out.println("La partie est finie!");
						break;
					}	
					
				}
		}
	}

	if(graphique==1){
		
		
		Fenetre fen = new Fenetre();
		while(Fenetre.b==false){
			System.out.println("");
		}
		Environement tabg = new Environement(c,l);
		StdDraw.setXscale(0, 40+(Execution.c-1)*40);
		StdDraw.setYscale(0, 40+(Execution.c-1)*40);
	    
		fen.affichageGrille(Environement.horizontale, Environement.verticale);		
	   
			
		while(!(checkEnd(Environement.horizontale, Environement.verticale))){
			Execution.joueur = 1;
			System.out.println("Joueur A");
			System.out.println(Execution.b);
			while(Execution.b==false){
				clicSouris();
			}
			
			System.out.println("J1");
			checkWin(Environement.horizontale, Environement.verticale);
			fen.affichageGrille(Environement.horizontale, Environement.verticale);
			Execution.b=false;
			
			if(Execution.typeJeu==0){
				Execution.joueur = 2;
				System.out.println("Joueur B");
				
				while(Execution.b==false){
					clicSouris();
				}
				System.out.println("J2");
				checkWin(Environement.horizontale, Environement.verticale);
				fen.affichageGrille(Environement.horizontale, Environement.verticale);
				Execution.b=false;
			
			}else{
				
				Execution.joueur=2;
				IA();
				System.out.println("TOP");
				checkWin(Environement.horizontale, Environement.verticale);
				fen.affichageGrille(Environement.horizontale, Environement.verticale);
				Execution.b=false;
			}
			
		}
		
		StdDraw.clear();
		StdDraw.text(50, 80, "La partie est finie!");
		if(Execution.pointsA>Execution.pointsB){
			StdDraw.text(50, 70, "Le joueur A remporte la partie!");
		}
		if(Execution.pointsA<Execution.pointsB){
			StdDraw.text(50, 70, "Le joueur B remporte la partie!");
		}
		if(Execution.pointsA==Execution.pointsB){
			StdDraw.text(50, 70, "Match Nul!");
		}

		
		
		
		
	}
			
}

		

		

	public static void checkWin(int [][] hTab,int [][] vTab){
		int carresRemplis=0;
		Execution.points=Execution.pointsA+Execution.pointsB;
		for(int i=0; i<hTab.length-1; i++){
			for(int j=0; j<hTab[0].length; j++){
				if(hTab[i][j]==1 && hTab[i+1][j]==1 && vTab[i][j]==1 && vTab[i][j+1]==1){
					carresRemplis=carresRemplis+1;
					
				}				
			}
		}
		if(carresRemplis!=Execution.points){
			if(Execution.joueur==1){
				Execution.pointsA=Execution.pointsA+1;
			}
			if(Execution.joueur==2){
				Execution.pointsB=Execution.pointsB+1;
			}
			
		}
		
	}
	
	public void mouseReleased(MouseEvent e) {
	    Execution.mouseX = e.getX();
	    Execution.mouseY = e.getY();
	    System.out.println("X: "+Execution.mouseX);
	    System.out.println("Y: "+Execution.mouseY);
	}
	
	public static boolean checkEnd(int [][] hTab,int [][] vTab){
		boolean h=true;
		for(int i=0; i<hTab.length; i++){
			for(int j=0; j<hTab[0].length; j++){
				if(hTab[i][j]==0){
					h=false;
				}
			}
		}
		for(int i=0; i<vTab.length; i++){
			for(int j=0; j<vTab[0].length; j++){
				if(vTab[i][j]==0){
					h=false;
				}
			}
		}
		return(h);
}
	
public static void IA(){
	while(true){
		if(!(remplis(Environement.horizontale))){
			System.out.println("IA H");

			int cooxH = ThreadLocalRandom.current().nextInt(0, l);
			int cooyH = ThreadLocalRandom.current().nextInt(0, c-1);
			
			while(Environement.horizontale[cooxH][cooyH]==1){
				cooxH = ThreadLocalRandom.current().nextInt(0, l);
				cooyH = ThreadLocalRandom.current().nextInt(0, c-1);
			}
			Environement.horizontale[cooxH][cooyH]=1;
			Execution.b=true;
			break;
			
		}
	
	

	if(!(remplis(Environement.verticale))){
		System.out.println("IA V");
		int cooxV = ThreadLocalRandom.current().nextInt(0, l-1);
		int cooyV = ThreadLocalRandom.current().nextInt(0, c);
		
		while(Environement.verticale[cooxV][cooyV]==1){
			cooxV = ThreadLocalRandom.current().nextInt(0, l-1);
			cooyV = ThreadLocalRandom.current().nextInt(0, c);
		}
		Environement.verticale[cooxV][cooyV]=1;
		Execution.b=true;
		break;
	}
	}
	
}
	
public static void clicSouris(){
	int cooxV=0;
	int cooyV=0;
	int cooxH=0;
	int cooyH=0;
	double mouseX=0;
	double mouseY=0;
	if(StdDraw.mousePressed()){
		mouseX = StdDraw.mouseX();
		mouseY = StdDraw.mouseY();
		if((10<mouseX && mouseX<30)||(50<mouseX && mouseX<70)||(90<mouseX && mouseX<110)||(130<mouseX && mouseX<150)||(170<mouseX && mouseX<190)||(210<mouseX && mouseX<230)){
			Execution.b=true;
			if((10<mouseX && mouseX<30)){
				cooxV=0;
			}
			
			if((50<mouseX && mouseX<70)){
				cooxV=1;
			}
			
			if((90<mouseX && mouseX<110)){
				cooxV=2;
			}
			
			if((130<mouseX && mouseX<150)){
				cooxV=3;
			}
			
			if((170<mouseX && mouseX<190)){
				cooxV=4;
			}
			
			if((210<mouseX && mouseX<230)){
				cooxV=5;
			}
			
			
			
			if((20<mouseY && mouseY<60)){
				cooyV=0;
			}
			
			if((60<mouseY && mouseY<100)){
				cooyV=1;
			}
			
			if((100<mouseY && mouseY<140)){
				cooyV=2;
			}
			
			if((140<mouseY && mouseY<180)){
				cooyV=3;
			}
			
			if((180<mouseY && mouseY<220)){
				cooyV=4;
			}
			if((220<mouseY && mouseY<260)){
				cooyV=5;
			}
			Environement.verticale[cooyV][cooxV]=1;

		}else{
			Execution.b=true;
			if((30<mouseX && mouseX<50)){
				cooxH=0;
			}
			
			if((70<mouseX && mouseX<90)){
				cooxH=1;
			}
			
			if((110<mouseX && mouseX<130)){
				cooxH=2;
			}
			
			if((150<mouseX && mouseX<170)){
				cooxH=3;
			}
			
			if((190<mouseX && mouseX<210)){
				cooxH=4;
			}
			
			
			
			
			if((0<mouseY && mouseY<40)){
				cooyH=0;
			}
			
			if((40<mouseY && mouseY<80)){
				cooyH=1;
			}
			
			if((80<mouseY && mouseY<120)){
				cooyH=2;
			}
			
			if((120<mouseY && mouseY<160)){
				cooyH=3;
			}
			
			if((160<mouseY && mouseY<200)){
				cooyH=4;
			}
			if((200<mouseY && mouseY<240)){
				cooyH=5;
			}
			Environement.horizontale[cooyH][cooxH]=1;

		}
	}
	
}

public static boolean remplis(int [][] tableau){
	boolean b=true;
	for(int i=0; i<tableau.length; i++){
		for(int j=0; j<tableau[0].length; j++){
			if(tableau[i][j]==0){
				b=false;
			}
		}
	}
	return(b);
}
	
	
	
	
}
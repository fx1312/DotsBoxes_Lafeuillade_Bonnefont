public class Environement {
	static int colonnes;
	static int lignes;
	static int [][] horizontale;
	static int [][] verticale;

	
	public Environement (int colonnes, int lignes){
		Environement.colonnes=colonnes;
		Environement.lignes=lignes;
		creatHorizontale();
		creatVerticale();
		
		}
	
	public static void creatHorizontale(){
		horizontale= new int [lignes][colonnes-1];
		for(int i=0; i<lignes; i++){
			for(int j=0; j<colonnes-1; j++){
				horizontale[i][j]=0;
				
			}
		}
	}
	
	public static void creatVerticale(){
		verticale = new int [lignes-1][colonnes];
		for(int i=0; i<lignes-1; i++){
			for(int j=0; j<colonnes; j++){
				verticale[i][j]=0;
				
			}
		}

	}
	
	public void initTab(){

		for(int i=0; i<lignes; i++){
			
			for(int j=0; j<horizontale[0].length; j++){
				if(j<colonnes && horizontale[i][j]==1){
					System.out.print(".__");
				}
				else{
					System.out.print(".  ");
				}
			}
			System.out.print(".");
			System.out.println();
			
			
			for(int k=0; k<colonnes; k++){
				if(i<lignes-1  && verticale[i][k]==1){
					System.out.print("|  ");
				}
				else{
					System.out.print("   ");
				}
			}
			System.out.println();
		}
	}
	
	
	public void updateTab(){
		for(int i=0; i<lignes; i++){
			
			for(int j=0; j<horizontale[0].length; j++){
				if(j<colonnes && horizontale[i][j]==1){
					System.out.print(".__");
				}
				else{
					System.out.print(".  ");
				}
			}
			System.out.print(".");
			System.out.println();
			
			
			for(int k=0; k<colonnes; k++){
				if(i<lignes-1  && verticale[i][k]==1){
					System.out.print("|  ");
				}
				else{
					System.out.print("   ");
				}
			}
			System.out.println();
		}
	}

}

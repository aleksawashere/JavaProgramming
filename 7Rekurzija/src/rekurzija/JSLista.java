package rekurzija;

public class JSLista {

	Cvor prvi;
	
	// Ispis liste
	
	void printListaR(){
		
		printLista(prvi);
		System.out.println();
		printListaUnazad(prvi);
		
	}
	
	void printLista(Cvor cvor){
		
		if(cvor == null){
			return;
		}
		
		
		System.out.print(cvor.podatak + " ");
		printLista(cvor.sledeci);
		
	}
	
void printListaUnazad(Cvor cvor){
		
		if(cvor == null){
			return;
		}
		
		printLista(cvor.sledeci);
		System.out.print(cvor.podatak + " ");
		
		
	}
	
}

package liste;

public class DSLista {
	DSCvor prvi;
	
	public DSLista(int... niz){
		for(int i=0; i<niz.length; i++){
			ubaciNaKrajDS(niz[i]);
		}
	}
	
	//Normalno stampanje, uz pomoc sledeceg elementa liste
	void printNormalno(){
		
		if(prvi == null){
			System.out.println("Lista je prazna!");
			return;
		}
		
		DSCvor pom = prvi;
		
		System.out.println("Lista je:");
		
		while(pom!=null){
			
			System.out.print(pom.podatak + " ");
			pom = pom.sledeci;
			
		}
		
		System.out.println();
	}
	//Naopako stampanje, uz pomoc prethodnog elementa liste
	void printNaopacke(){
	
		if(prvi == null){
			System.out.println("Lista je prazna!");
			return;
		}
		
		DSCvor pom = prvi;
		
		while(pom.sledeci != null){
			
			pom = pom.sledeci;
			
		}
		
		System.out.println("Lista unazad: ");
		
		while(pom!=null){
			
			System.out.print(pom.podatak + " ");
			pom = pom.prethodni;
			
		}
		
		System.out.println();
		
	}

	//Ubaci na pocetak DS
	void ubaciNaPocDS(int noviBroj){
		
		
		DSCvor novi = new DSCvor();
		novi.podatak = noviBroj;
		
			
		if(prvi == null){
			prvi = novi;
			return;
		}
		
		
		novi.sledeci = prvi;
		prvi.prethodni = novi;
		
		prvi = novi;
		
	}
	
	//Ubaci na kraj DS
	// 1 2 3 4 5
	void ubaciNaKrajDS(int noviBroj){
	
		DSCvor novi = new DSCvor();
		novi.podatak = noviBroj;
		
		if(prvi == null){
			prvi = novi;
			return;
		}
		
		DSCvor pom = prvi;
		
		while(pom.sledeci!=null){
			pom = pom.sledeci;
		}
		
		pom.sledeci = novi;
		novi.prethodni = pom;
		
	}
	
}

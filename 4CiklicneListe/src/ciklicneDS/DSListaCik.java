package ciklicneDS;

public class DSListaCik {
	DSCvor prvi;
	//Stampanje uz pomoc sledeceg
	void print(){
		if(prvi == null){
			System.out.println("Lista je prazna!");
			return;
		}
		System.out.println("Lista je: ");
		
		
		
		DSCvor pom = prvi;
		
		do{
			System.out.print(pom.podatak + " ");
			pom = pom.sledeci;
		} while (pom != prvi);
		
		
		System.out.println("");
		
	}
	
	//Stampanje unazad uz pomoc prethodnog
	void naopako(){
		
		if(prvi == null){
			System.out.println("Lista je prazna!");
			return;
		}
		
		System.out.println("Lista je: ");
		
		
		
		DSCvor pom = prvi;
		
		do{
			pom = pom.sledeci;
		} while(pom.sledeci!=prvi);
		
		DSCvor pom2 = pom;
		
		do{
			if(pom == null){
				System.out.println("Greska!");
				return;
			}
			System.out.print(pom.podatak + " ");
			pom = pom.prethodni;
		} while(pom != pom2);
		
		
		System.out.println();
		
		
	}
	
	//Ubaci na pocetak DS ciklicne liste
	//  6  
	void ubaciNaPocetakDSCikListe(int noviBroj){
		
		
		DSCvor novi = new DSCvor();
		novi.podatak = noviBroj;
		
		if(prvi == null){
			prvi = novi;
			
			novi.sledeci = novi;
			novi.prethodni = novi;
			
			return;
		}
		
		DSCvor poslednji = prvi.prethodni;
		
		novi.sledeci = prvi;
		prvi.prethodni = novi;
		
		poslednji.sledeci = novi;
		novi.prethodni = poslednji;
		
		prvi = novi;
		
	}
	
}


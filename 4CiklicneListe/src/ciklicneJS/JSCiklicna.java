package ciklicneJS;

public class JSCiklicna {
	Cvor prvi;
	
	//Stampanje JS ciklicne liste
	void print(){
		
		if(prvi==null){
			System.out.println("Lista je prazna!");
			return;
		}
		
		System.out.println("Lista je: ");
		
		Cvor pom = prvi;
	
		do{
			System.out.print(pom.podatak + " ");
			pom = pom.sledeci;
		} while(pom != prvi);
		
	}

	//Zaustavljanje petlje pre poslednjeg (najbitniji deo petlje za razne funkcije)
	void petlja(){
		
		Cvor pom = prvi;
		
		do{
			System.out.print(pom.podatak + " ");
			pom = pom.sledeci;
		} while (pom.sledeci != prvi);
		
		System.out.println("Vrednost: " +  pom.podatak);
		
	}
	
	//Ubaci na pocetak
	void ubaciNaPocetakJSCik(int noviBroj){
		
		Cvor novi = new Cvor();
		novi.podatak = noviBroj;
		
		if(prvi == null){
			prvi = novi;
			novi.sledeci = novi;
		}
		
		Cvor pom = prvi;
		
		do{
			pom = pom.sledeci;
		}while(pom.sledeci!=prvi);
			
		novi.sledeci = prvi;
		pom.sledeci = novi;
		
		prvi = novi;
		
	}

	//Ubaci na kraj
	void ubaciNaKrajJSCik(int noviBroj){
		
		Cvor novi = new Cvor();
		novi.podatak = noviBroj;
		
		if(prvi == null){
			prvi = novi;
			novi.sledeci = novi;
			return;
		}
		
		Cvor pom = prvi;
		
		do{
			pom = pom.sledeci;
		} while(pom.sledeci!=prvi);
		
		pom.sledeci = novi;
		novi.sledeci = prvi;
		
	}
}



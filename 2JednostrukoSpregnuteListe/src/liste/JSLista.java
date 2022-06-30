package liste;

public class JSLista {
	Cvor prvi = null;
	
	//public JSLista(){ }
	
	//konstruktor koji prima proizvoljan niz elemenata u listu
	public JSLista(int... niz){
		for(int i = 0; i<niz.length; i++){
			ubaciNaKraj(niz[i]);
		}
	}
	
	//Print liste
	//Print liste
	void printLista(){
		
		Cvor pom = prvi;
		
		System.out.print("Lista je: ");
		
		while(pom != null){
			System.out.print(pom.podatak + " ");
			pom = pom.sledeci;
		}
		
		System.out.println("");
		
	}

	//Ubaci na pocetak
	//Ubaci element noviBroj na pocetak liste
	void ubaciNaPocetak(int noviBroj){
		
		Cvor novi = new Cvor();
		
		novi.podatak = noviBroj;
		novi.sledeci = prvi;
		
		prvi = novi;
		
	}
	
	//Ubaci na kraj
	//Ubaci element noviBroj na kraj liste
	void ubaciNaKraj(int noviBroj){
		
		Cvor novi = new Cvor();
		novi.podatak = noviBroj;
		//novi.sledeci = null;
		
		if(prvi == null){
			prvi = novi;
			return;
		}
		
		Cvor pom = prvi;
		
		while(pom.sledeci != null){
			pom = pom.sledeci;
		}
	
		pom.sledeci = novi;
}


	//Izbaci element sa pocetka liste, void povratna vrednost
	void izbaciSaPocetka(){
		if(prvi == null){
			return;
		}
		
		prvi = prvi.sledeci;
	}
	//Izbaci element sa pocetka liste, int povratna vrednost
	int izbaciSaPocetkaPov(){
		
		if(prvi == null){
			throw new RuntimeException("Lista je prazna vec!");
		}
		
		int pom = prvi.podatak;
		prvi = prvi.sledeci;
		
		return pom;
	}
	//Izbaci element sa kraja liste, void povratna vrednost
	void izbaciSaKraja(){
		
		if(prvi == null){
			return;
		}
		
		if(prvi.sledeci == null){
			prvi = null;
			return;
		}
		
		Cvor pom = prvi;
		
		while(pom.sledeci.sledeci != null){
			pom = pom.sledeci;
		}
		
		//dosli do pretposlednjeg, trenutno
		
		pom.sledeci = null;
		
	}
	//Izbaci element sa kraja liste, int povratna vrednost
	int izbaciSaKrajaPov(){
		
		if(prvi == null){
			throw new RuntimeException("Lista je prazna!");
		}
		
		if(prvi.sledeci == null){
			int pomoc = prvi.podatak;
			prvi = null;
			return pomoc;
		}
		
		Cvor pom = prvi;
		
		while(pom.sledeci.sledeci != null){
			pom = pom.sledeci;
		}
		
		int pomoc = pom.sledeci.podatak;
		pom.sledeci = null;
		
		return pomoc;
	}
	
	
	//Vrati broj elemenata liste
	int brElemenata(){
		
		int brojac = 0;
		
		Cvor pom = prvi;
		
		while(pom != null){ 
			brojac++;
			pom = pom.sledeci;
		}
		
		return brojac;
		
	}
	
	//Vrati podatak sa odredjenog indeksa (get, kao kod nizova)
	int vratiPodatakGet(int indeks){
		
		if(indeks < 0){
			throw new RuntimeException("Indeks ne sme biti negativan!");
		}
		
		if(indeks >= brElemenata()){
			throw new RuntimeException("Indeks ne sme biti jednak ili veci od broja elemenata!");
		}
		
		Cvor pom = prvi;
		
		for(int i = 0; i<indeks; i++){
			pom = pom.sledeci;
		}
		
		return pom.podatak;
		
	}
	
	//Postavi novi podatak na odredjeni indeks (set, kao kod nizova)
	void postaviPodatakSet(int noviBroj, int indeks){
		
		if(indeks < 0 || indeks >= brElemenata()){
			return;
		}
		
		Cvor pom = prvi;
		
		for(int i = 0; i<indeks; i++){
			pom = pom.sledeci;
		}
		
		pom.podatak = noviBroj;
		
	}
	
	//Da li je neki element sadrzan u listi
	boolean sadrziElement(int broj){
		
		Cvor pom = prvi;
		
		while(pom!=null){
			if(pom.podatak == broj){
				return true;
			}
			
			pom = pom.sledeci;
		}
		return false;	
	}
	
	//Ubacivanje novog elementa na odredjeni indeks
	void ubaciElNaIndeks(int noviBroj, int indeks){
		
		if(indeks < 0 || indeks > brElemenata()){
			return;
		}
		
		Cvor novi = new Cvor();
		novi.podatak = noviBroj;
		
		if(indeks == 0){
			novi.sledeci = prvi;
			prvi = novi;
			return;
		}
		
		Cvor pom = prvi;
		
		for(int i=0; i<indeks-1; i++){
			pom = pom.sledeci;
		}
		
		novi.sledeci = pom.sledeci;
		pom.sledeci = novi;
		
	}
	
	//Izbaci element sa odredjenog indeksa
	int izbaciELSaIndeksa(int indeks){
		
		if(indeks == 0){
			int pomoc = prvi.podatak;
			prvi = prvi.sledeci;
			return pomoc;
		}
		
		if(indeks < 0 || indeks > brElemenata()){
			throw new RuntimeException("Los indeks unesen.");
		}
		
		Cvor pom = prvi;
		
		for(int i = 0; i < indeks - 1; i++){
			pom = pom.sledeci;
		}
		
		int pomoc = pom.sledeci.podatak;
		pom.sledeci = pom.sledeci.sledeci;
		
		return pomoc;
	}
	
	
	//Sortiranje liste => SELECTION SORT
	void sortiranje(){
		
		Cvor spori = prvi;
		Cvor brzi = prvi.sledeci;
		
		while(spori.sledeci!=null){
			while(brzi!=null){
				if(spori.podatak > brzi.podatak){
					int tmp = spori.podatak;
					spori.podatak = brzi.podatak;
					brzi.podatak = tmp;
				}
				brzi = brzi.sledeci;
			}
			
			spori = spori.sledeci;
			brzi = spori.sledeci;
		}
		
	}
	
	//Ubacivanje sortirano (ne sortiranje svakog puta!) // pretpostavljamo da radimo sa sortiranim listom
	void ubaciSort(int noviBroj){
		
		Cvor novi = new Cvor();
		novi.podatak = noviBroj;
		
		//ako je lista = null (prvi = null)
		if(prvi == null){
			prvi = novi;
			return;
		}
		
		
		//ubaci na pocetak
		if(noviBroj <= prvi.podatak){
			novi.sledeci = prvi;
			prvi = novi;
			return;
		}
		
		//ubacivanje u sredinu

		Cvor pom = prvi;
		
		while(pom.sledeci != null)
		{
			if(pom.sledeci.podatak > noviBroj){
				novi.sledeci = pom.sledeci;
				pom.sledeci = novi;
				return;
			}
			pom = pom.sledeci;
		}
		
		//ubacivanje na kraj
		pom.sledeci = novi;
		
	}
	
	//Izbacivanje zadatog broja
	void izbaci(int broj){
		
		//lista prazna
		if(prvi == null){
			return;
		}
		
		
		//izbaci sve elemente koji se poklapaju sa brojem na pocetku
		while(prvi.podatak == broj){
			prvi = prvi.sledeci;

			if(prvi == null){
				return;
			}
		}
		
		Cvor pom = prvi;
		
		//izbaci sve elemente koji se poklapaju sa brojem u sredini
		while(pom.sledeci != null){
			if(pom.sledeci.podatak == broj){
				pom.sledeci = pom.sledeci.sledeci;
			}
			else{
				pom = pom.sledeci;
			}
		}
		
	}
	
	
}

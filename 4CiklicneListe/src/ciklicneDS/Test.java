package ciklicneDS;

public class Test {

	public static void main(String[] args) {
		
		DSListaCik lista = new DSListaCik();
		
		lista.print();
		lista.naopako();
		
		lista.ubaciNaPocetakDSCikListe(6);
		lista.ubaciNaPocetakDSCikListe(2);
		lista.ubaciNaPocetakDSCikListe(7);
		lista.ubaciNaPocetakDSCikListe(1);
		
		lista.print();
		lista.naopako();
	}

}

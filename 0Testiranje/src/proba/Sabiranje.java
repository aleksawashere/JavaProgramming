package proba;

public class Sabiranje {

	private int sabirak1;
	private int sabirak2;
	
	public Sabiranje(int sabirak1, int sabirak2) {
		super();
		this.sabirak1 = sabirak1;
		this.sabirak2 = sabirak2;
	}

	public int getSabirak1() {
		return sabirak1;
	}

	public void setSabirak1(int sabirak1) {
		this.sabirak1 = sabirak1;
	}

	public int getSabirak2() {
		return sabirak2;
	}

	public void setSabirak2(int sabirak2) {
		this.sabirak2 = sabirak2;
	}
	
	//Nestaticka metoda
	public int Sabirac(){
		return this.sabirak1 + this.sabirak2;
	}
	
	//Staticka metoda
	public static int SabiracStat(int sabirak1, int sabirak2){
		return sabirak1 + sabirak2;
	}
	
	public void Print(){
		System.out.println("Sab1:" + sabirak1 + " " + "Sab2:" + sabirak2);
	}
	
}

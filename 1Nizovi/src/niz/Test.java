package niz;

public class Test {

	public static void main(String[] args) {
		
		Niz niz = new Niz(10);
	
		niz.ubacivanjeKraj(5,10,9,6,11);
		
		System.out.println(niz.zbirNaj3());
		System.out.println(niz.zbirNaj3Prolaz());
	
	}

}

package proba;

public class Test {

	public static void main(String[] args) {
		
		//Vrednosni tipovi
		//STACK
		int a = 5;
		char b = 'c';
		double c = 5.234234;
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		
		//Referentni tipovi
		//STACK + HEAP
		
		int[] niz = {1,2,3,4,5};
		System.out.println(niz[0]);
		
		String naziv = "Predmet";
		System.out.println(naziv);
		
		Sabiranje s = new Sabiranje(5,4);
		System.out.println(s.getSabirak1());
		
		s.setSabirak1(a);
		System.out.println(s.getSabirak1());
		
		//int[] niz2 = new int[3];
		String s3 = new String("String");
		System.out.println(s3);
		
		int x = 3;
		int y = 5;
		
		Sabiranje sab = new Sabiranje(10,10);
		
		int rez = sab.Sabirac();
		System.out.println(rez);
		
		int rez2 = Sabiranje.SabiracStat(x, y);
		System.out.println(rez2);

		s.Print();
		
	}

}

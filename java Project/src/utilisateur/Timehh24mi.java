package utilisateur;

public class Timehh24mi {
	private String hhmi;
	 

	public String getTimehh24mi() {return hhmi;}
	public void setTimehh24mi(String a) {hhmi=a;}
	//methodes de Manipulation du l'heure sous Format hh24:
	public String getMinute() {		
		String b[]=hhmi.split("\\:");
		return b[1];}
	public String getHour() {
		String b[]=hhmi.split("\\:");
		return b[0];}
	public void setMinute(String a) {
		String b[]=hhmi.split("\\:");
	hhmi=b[0]+":"+a;}
	public void setHour(String a) {
		String b[]=hhmi.split("\\:");
	hhmi=a+":"+b[1];}
	//constructeur + setters & getters
	public Timehh24mi(){
		 System.out.println("construction ..");
		hhmi="00:00";
	}
	 public Timehh24mi(String a){
		 System.out.println("construction ..");
		hhmi=a;
	}
	//la fonction la plus Importante !!
	public String SommeTime(String a,String b) {
		String b1[]=a.split("\\:");
		String b2[]=b.split("\\:");
		int min=Integer.parseInt(b1[1])+Integer.parseInt(b2[1]);;
		System.out.println(min);
		//System.out.println("after0\n");
		int h=Integer.parseInt(b1[0])+Integer.parseInt(b2[0]);;
		if (min>=60) {
			min=min%60;
			h++;
			if (h>=24){
				h=h%24;
				return String.valueOf(h)+":"+String.valueOf(min);
				}
			else  return String.valueOf(h)+":"+String.valueOf(min);
				
		}
		else return String.valueOf(h)+":"+String.valueOf(min);
	}


}

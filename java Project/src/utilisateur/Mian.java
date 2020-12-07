package utilisateur;

public class Mian {
	/*
	 * les differents tests pour bien assimiler la manipulation du temps  
	 */
	public static void main(String[] args) {
		String a="13:22";
		String b[]=a.split("\\:");
		System.out.println(b[0]);
		System.out.println(b[1].charAt(0));
		System.out.println(a.charAt(1));
		System.out.println(119%60);
		System.out.println("test time\n");
		String h="10:10";
		Timehh24mi test =new Timehh24mi();
		String c=test.getTimehh24mi();
		System.out.println(c);
		//System.out.println(test.getMinute());
		//test.SommeTime(h, "23:40");
	 c=test.getTimehh24mi();
		System.out.println(test.SommeTime(h, "3:40"));
		
	}
}

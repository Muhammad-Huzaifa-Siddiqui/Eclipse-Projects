package emailapp;

public class EmailApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Email em1 = new Email("huzaifa","siddiqui");
//		em1.setAlternateEmail("husid96@gmail.com");
//		System.out.println("Your Alternate Email is "+em1.getAlternateEmail());
		//System.out.println(em1.showInfo());
		em1.changePassword("123");	
		em1.getChangedPassword();
	}

}

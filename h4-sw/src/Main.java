
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner Scan = new Scanner(System.in);
		Playgroundowner owner = new Playgroundowner();
		Player p1 = new Player();
		int choice = -1;
		do {

			System.out.println("Please Enter:");
			System.out.println();
			System.out.println("(1) If you're Player.");
			System.out.println("(2) If you're Playground Owner.");
			System.out.println("(3) If you want to exit.");
			System.out.println();
			choice = Scan.nextInt();
			if (choice == 1) {

				System.out.println("Enter your name, email, password, phone number, minimum amount of money "
						+ "separated by enter");
				// To enter the information of the player

				System.out.println();
				p1.setUserName(Scan.next());
				p1.setemail(Scan.next());
				p1.setpassword(Scan.next());
				p1.setphonenumber(Scan.next());
				eWallet e1 = new eWallet();
				e1.deposit(Scan.nextInt());
				p1.ewallet = e1;
				System.out.println("[1]Add request \n [2]ListOfplayground \n[3]Exit Player");
				int key = Scan.nextInt();
				if (key == 1) {
					System.out.println("********************************************");
					System.out.println("\n This All playground  \n");
					System.out.println("********************************************\n");
					p1.getplayground();
					System.out.println("Enter playground  slot you want to book at");
					int playgroundid = Scan.nextInt();
					System.out.println("Enter slot id you want to book at");
					int Slotid = Scan.nextInt();
					p1.addrequest(playgroundid, Slotid);
				} else if (key == 2) {
					p1.getplayground();
				} else if (key == 3) {
					break;
				}

			} else if (choice == 2) {

				System.out.println("Enter your name, email, password, phone number, minimum amount of money "
						+ "separated by enter");
				// To enter the information of the playgroundOwner
				System.out.println();
				owner.setUserName(Scan.next());
				owner.setemail(Scan.next());
				owner.setpassword(Scan.next());
				owner.setphonenumber(Scan.next());
				eWallet e2 = new eWallet();
				e2.deposit(Scan.nextInt());
				owner.ewallet = e2;
				System.out.println("[1]Add playground \n [2]Add playground slot \n"
						+ "[3]ListOfplayground \n[4]Exit Playergroundowner");
				int key = Scan.nextInt();
				if (key == 1) {
					
					owner.playground.AddPlayground("Maadi play ground", "This is a playground", 75);
					owner.playground.AddPlayground("esrr", "This is a playground", 1000);
				} else if (key == 2) {
					System.out.println("Enter playground id  you want to slot at");
					int playgroundid = Scan.nextInt();
					owner.playground.AddSlotToPlayground(playgroundid);
				} else if (key == 3) {
					owner.getplaygroundlist();
				} else if (key == 4)
					break;

			} else {
				System.exit(0);
			}
		} while (true);
	}
}
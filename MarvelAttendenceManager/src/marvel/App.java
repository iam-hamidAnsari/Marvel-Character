package marvel;

import java.util.Scanner;

import marvel.service.AttendenceService;
import marvel.service.MarvelService;

public class App {
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		MarvelService ms = new MarvelService();
		AttendenceService as = new AttendenceService();
		while(true) {
			System.out.println("Type to 'add' to Character");
			System.out.println("Type to 'marvels' to get Character Name");
			System.out.println("Type to 'start' to take attendence");
			System.out.println("Type to 'show' to see attendence");
			System.out.println("Type to 'exit' to leave the application");
			String input = sc.nextLine();
			if("add".equals(input)) {
				ms.addCharacter();
			}else if("start".equals(input)) {
				as.startAttendence();
			}else if("show".equals(input)) {
				as.showAttendence();
			}else if("marvels".equals(input)) {
				ms.getAllCharacter();
			}else if("exit".equals(input)) {
				System.out.println("Byeeee see you again");
				break;
			}
			
		}
	}

}

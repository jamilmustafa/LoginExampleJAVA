import java.util.Scanner;

import services.AuthenticationService;
import services.UsersService;
import services.impl.AuthenticationServiceImpl;
import services.impl.UsersServiceImpl;


public class Controller {
	
	private static AuthenticationService authService = new AuthenticationServiceImpl();
	private static UsersService usersService = new UsersServiceImpl();

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("Welcome!!");
			System.out.println("1 - Login");
			System.out.println("2 - Esci");
			int firstOperation = Integer.parseInt(scanner.nextLine());
			if(firstOperation == 1) {
				executeLogin(scanner);
				executeLoggedOperations(scanner);
			} else {
				System.out.println("Thank you!!");
				break;
			}
		}
	}
	
	private static void executeLogin(Scanner scanner) {
		while(!authService.isOpenSession()) {
			System.out.println("Insert Username:");
			String username = scanner.nextLine();
			System.out.println("Insert Password:");
			String password = scanner.nextLine();
			if(!authService.login(username, password)) {
				System.out.println("Password or Email is not correct. Retry!");
				System.out.println("1 - Retry");
				System.out.println("2 - Esc");
				int secondOperation = Integer.parseInt(scanner.nextLine());
				if(secondOperation == 1) {
					continue;
				} else {
					break;
				}
			}
		}
	}
	
	private static void executeLoggedOperations(Scanner scanner) {
		if(authService.isOpenSession()) {
			System.out.println("Welcome to your session");
			while(authService.isOpenSession()) {
				System.out.println("What do you want to do?");
				System.out.println("1 - Change Username");
				System.out.println("2 - Change Password");
				System.out.println("3 - Logout");
				int thirdOperation = Integer.parseInt(scanner.nextLine());
				if(thirdOperation == 1) {
					executeUpdateUsername(scanner);
				} else if(thirdOperation == 2){
					executeUpdatePassword(scanner);
				} else {
					authService.logout();
				}
			}
		}
	}
	
	private static void executeUpdateUsername(Scanner scanner) {
		while(true) {
			System.out.println("Enter the Currect username:");
			String username = scanner.nextLine();
			System.out.println("Enter new username:");
			String newUsername = scanner.nextLine();
			if(usersService.updateUsername(username, newUsername)) {
				System.out.println("Username modified Correctly!");
				break;
			} else {
				System.out.println("Username Does not exist!");
				System.out.println("1 - Retry");
				System.out.println("2 - Esc");
				int secondOperation = Integer.parseInt(scanner.nextLine());
				if(secondOperation == 1) {
					continue;
				} else {
					break;
				}
			}
		}
	}
	
	private static void executeUpdatePassword(Scanner scanner) {
		while(true) {
			System.out.println("Insert Currect Username");
			String username = scanner.nextLine();
			System.out.println("Insert New password:");
			String newPassword = scanner.nextLine();
			if(usersService.updatePassword(username, newPassword)) {
				System.out.println("Password modified Correctly!");
				break;
			} else {
				System.out.println("Username Does not exist!");
				System.out.println("1 - Retry");
				System.out.println("2 - Esc");
				int secondOperation = Integer.parseInt(scanner.nextLine());
				if(secondOperation == 1) {
					continue;
				} else {
					break;
				}
			}
		}
	}
	
}

package main;

import java.util.ArrayList;
import java.util.Scanner;

import org.simplejavamail.api.email.Email;
import org.simplejavamail.api.mailer.Mailer;
import org.simplejavamail.api.mailer.config.TransportStrategy;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;

import domain.Human;

//Text User Interface
public class TUI {
	private static Scanner in = new Scanner(System.in);
	public static int printMenu() {
		int option;
		
		System.err.println(
				"########### OPTION ###########\n"
			  + " 1. Show Subscribers\n"
			  + " 2. Add Subscriber\n"
			  + " 3. Edit Subscriber\n"
			  + " 4. Delete Subscriber\n"
			  + " 5. Send Email\n"
			  + " 0. Exit\n"
			  + "##############################\n"
			  + "Choose OPTION"
				);
		
		option = in.nextInt();
		return option;
		
	}
	
	public static void printThanks() {
		System.out.println("Thank you for using our SOFTWARE!!!");
	}
	
	public static ArrayList<Human> printHumanData(ArrayList<Human> human) {
		for (Human h : human) {
			System.out.println( h );
		}
		return human;
	}
	
	public static Human editHumanData() {
		Human h = null;
		System.out.println("Enter Full Name of person to change email: ");
		String fullName = in.next();
		System.out.println("Edit email address: ");
		String email = in.next();
		h = new Human(fullName,email);
		return h;
	}
	
	public static Human readHumanData() {
		Human h = null;
		System.out.println("New Subscriber Full Name: ");
		String fullName = in.next();
		System.out.println("New Subscriber email address: ");
		String email = in.next();
		h = new Human(fullName,email);
		return h;
	}
	public static String deleteHuman() {
		System.out.println("Delete subscriber by email address: ");
		String email = in.next();
		return email;
	}
	
	public static void sendEmail( Human human) {
		//The object of the EMAIL MESSAGE!!!!
		Email email = EmailBuilder.startingBlank()
			    .from("Seto K.", "kaibaman94@fmail.com")
			    .to("danny do.","danny.do.arama@gmail.com")
//			    .cc("C. Bo <chocobo@candyshop.org>")
			    .withSubject("Testing the subscribers app")
			    .withPlainText("Hello There :)")
			    .buildEmail();

		//THE MAILER object
		Mailer mailer = MailerBuilder
		  .withSMTPServer("smtp.gmail.com",587,"kaibaman94@gmail.com","kaibaman178")
		  .withTransportStrategy(TransportStrategy.SMTP_TLS)
		  .withDebugLogging(true)   //debugging 
		  .buildMailer();
		
		  mailer.sendMail(email);
	}
	public static void readEmail() {
		
	}

}

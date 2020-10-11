package main;

import java.sql.SQLException;

import domain.HumanRepository;

public class Application {

	private static HumanRepository hr;
	
	public static void main(String[] args) throws SQLException {
		
		hr = new HumanRepository();
		
		stop:
		while( true ) {
			//JDK 12 :D HW:1 switch - rewrite - MODERN JDK
			  switch(TUI.printMenu() ) {
			  case 1: 
			  TUI.printHumanData(hr.all());
			  break;
			  case 2: 
			  hr.create( TUI.readHumanData() );	  
			  break;
			  case 3:
			  hr.update( TUI.editHumanData());
			  break;
			  case 4:
			  hr.delete( TUI.deleteHuman() );  
			  break;
			  case 5:
			  TUI.sendEmail(null);	  
			  break;
			  case 0: 
				  TUI.printThanks();
				  break stop; //HW2: change RETURN - 0
				                 //BREAK outer loop
			}
		}
	}

}

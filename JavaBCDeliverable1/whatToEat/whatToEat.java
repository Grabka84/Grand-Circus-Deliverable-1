package whatToEat;
import java.util.Scanner; // import scanner utility to get user input

public class whatToEat {

	public static void main(String[] args) {
		String eventType; // string variable - 1 of 3 options
		int partySize; // integer variable - number of people can't be decimal 
		String result; // concatenated sentence at end
		String mealType; // suggested meal type based on event type
		String prepSugg; // suggested preparation based on party size
		
		Scanner userInput = new Scanner(System.in); // user input variable "userInput"
		
		// selecting event type and making meal suggestion
		// user inputs 1 of 3 options for event type, and system suggests a meal based on event
		System.out.println("Select the event type from the list below:"); // instructions to user for what input the console is expecting
		System.out.println("1. Casual"); 			// limited to 3 options, make it easy to not make a mistake 
		System.out.println("2. Semi-formal");		
		System.out.println("3. Formal");
		System.out.print("(Enter 1, 2, or 3): ");
		
		int eventChar; // integer variable to store the user input for event type  
		eventChar = userInput.nextInt();
		
		Boolean validResponse = false; 
		// to test that user input 1, 2, or 3, check if the input matches any options, then make true and end the loop
		while(validResponse == false) {
			if(eventChar == 1) {
				validResponse = true;
			} else if (eventChar == 2) {
				validResponse = true;
			} else if (eventChar == 3) {
				validResponse = true;
			} else {
				System.out.println("You have input an invalid option, please select from the list: ");
				eventChar = userInput.nextInt();
			}
		}
		
		if(eventChar == 1) { // if casual then sandwiches
			eventType = "casual";
			mealType = "sandwiches";
		} else if (eventChar == 2){ // if semi formal then fried chicken
			eventType = "semi-formal";
			mealType = "fried chicken";
		} else { // if formal then chicken parmesan, only remaining option
			eventType = "formal";
			mealType = "chicken parmesan";
		}
		System.out.println(); // empty line to avoid crowding
		
		// Party size and preparation suggestion
		System.out.print("How many people will be in the party?: "); // requests user input 
		partySize = userInput.nextInt(); // places user input into an integer variable (number of people)
		
		while(partySize <= 0) { // while user input is 0 or negative, application attempts to get a valid response
			System.out.print("Please enter a positive value greater than 0: ");
			partySize = userInput.nextInt(); // tries again if given a negative number or 0
		}
		
		if(partySize >= 13) {
			prepSugg = "by a caterer.";
		} else if (partySize >= 2) {
			prepSugg = "in your kitchen.";
		} else { 
			prepSugg = "in the microwave.";
		}
		
		// if partySize is 1, use the singular, if more than 1 then use plural, declare and initiate variable partPlural on the same line
		String partPlural = (partySize == 1) ? "participant" : "participants"; 
		
		System.out.println(); // empty line to avoid crowding  
		
		// printing the result 
		result = ("Since you're hosting a " + eventType + " event for " + partySize + " " + partPlural + ", you should serve " + mealType + " prepared " + prepSugg);
		System.out.println(result);
		userInput.close();
	}

}

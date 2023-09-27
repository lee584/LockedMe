import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class LockedMe {
	private static final String APPLICATION_NAME = "LockMe.com";
    private static final String DEVELOPER_NAME = "Lerato Pitso ";
    static File  ROOT_DIRECTORY =new File( "C:\\Users\\LERATO PITSO\\Desktop\\LockedMe");
	public static void main(String[] args) {
		// TODO Auto-generated method stub
          displayWelcomeScreen();
          
          Scanner scanner = new Scanner(System.in);

          while (true) {
             
              int choice = scanner.nextInt();
              scanner.nextLine(); // Consume newline

              switch (choice) {
                  case 1:
                       listFiles();
                      break;
                  case 2:
                      addFile(scanner);
                      break;
                  case 3:
                	  deleteFile(scanner);
                	  break;
                  case 4:
                	  searchFile(scanner);  
                	  break;
                  case 5:
                      System.out.println("Exiting the application. Goodbye!");
                      scanner.close();
                      System.exit(0);
            
                  default:
                  System.out.println("Invalid choice. Please try again.");
              
          }
      }


}
	private static void displayWelcomeScreen() {
		
        System.out.println("Welcome to " + APPLICATION_NAME + "!");
        System.out.println("Developed by " + DEVELOPER_NAME);
        System.out.println();
        System.out.println("Options:");
        System.out.println("1. List files");
        System.out.println("2. Add a file");
        System.out.println("3. Delete a file");
        System.out.println("4. Search for a file");
        System.out.println("5. Close application");
        System.out.println();
        System.out.print("Enter your choice: ");
        
    }
	private static void listFiles() {
        File[] files = new File(".").listFiles();
        if (files == null || files.length == 0) {
            System.out.println("No files found.");
        } else {
            Arrays.sort(files);
            for (File file : files) {
                System.out.println(file.getName());
            }
        }
        displayWelcomeScreen();
    }
	private static void addFile(Scanner scanner) {
	    System.out.println("Enter the file name to add:");
	    String fileName = scanner.nextLine();
	    File file = new File(ROOT_DIRECTORY +"\\"+ fileName);

	    try {
	        if (file.createNewFile()) {
	            System.out.println(fileName + " added successfully.");
	        } else {
	            System.out.println("File already exists.");
	        }
	    } catch (Exception e) {
	        System.out.println("An error occurred while adding the file.");
	    }
	    displayWelcomeScreen();
	}
	private static void deleteFile(Scanner scanner) {
        System.out.println("Enter the file name to delete:");
        String fileName = scanner.nextLine();
        File file = new File(ROOT_DIRECTORY +"\\"+ fileName);

        if (file.delete()) {
            System.out.println(fileName + " deleted successfully.");
        } else {
            System.out.println("File not found.");
        }
        displayWelcomeScreen();
    }
	private static void searchFile(Scanner scanner) {
        System.out.println("Enter the file name to search:");
        String fileName = scanner.nextLine();
        File file = new File(ROOT_DIRECTORY +"\\" +fileName);

        if (file.exists()) {
            System.out.println(fileName + " found in the directory.");
        } else {
            System.out.println("File not found.");
        }
        displayWelcomeScreen();
    }

}


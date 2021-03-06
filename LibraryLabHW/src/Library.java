import java.util.ArrayList;

public class Library {
	
	private String address;
	ArrayList<Book> bookArray = new ArrayList<>();

	// Add the missing implementation to this class
	public Library(String address) {
		this.address = address;
	}
	
	public void addBook(Book newBook) {
	 	this.bookArray.add(newBook);
	}
	
	public static void printOpeningHours() {
		System.out.println("Libraries are open daily from 9am to 5pm.");
	}
	
	public void printAddress() {
		System.out.println(address);
	}
	
	public void borrowBook( String bookTitle) {
		boolean found = false;
		boolean success = false;
		
		for (Book singleBook : this.bookArray) {
			if(singleBook.title.equals(bookTitle)) {
				found = true;
				if(!singleBook.isBorrowed()) {
					singleBook.rented();
					System.out.println("You successfully borrowed " + bookTitle);
					success = true;
					break;
				}
			}
		}
		if (!found) {
			System.out.println("Sorry, this book is not in our catalog");
		}
		else if (!success) {
			System.out.println("Sorry, this book is already borrowed");
		}
	}
	
	public void printAvailableBooks() {
		boolean available = false;
		for (Book singleBook : this.bookArray) {
			if (!singleBook.isBorrowed()) {
				available = true;
				System.out.println(singleBook.title);
			}
		}
		if (!available) {
			System.out.println("No book in catalog");
		}
	}
	
	public void returnBook(String bookTitle) {
		boolean found = false;
		boolean success = false;
		for (Book singleBook : this.bookArray){
		    if (singleBook.title.equals(bookTitle)){
			found = true;
			if (singleBook.isBorrowed()){
			    singleBook.returned();
			    System.out.println("You successfully returned " + bookTitle);
			    success = true;
			    break;
			}
		    }
		}
		if (!found){
		    System.out.println("Sorry, this book is not in our catalog");
		}
		else if (!success){
		    System.out.println("Please check whether this book is borrowed from our library");
		}
	}

    public static void main(String[] args) {
    
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));
        

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
} 
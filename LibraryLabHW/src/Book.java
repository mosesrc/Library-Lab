public class Book {

    String title;
	boolean borrowed;
	
    // Creates a new Book
    public Book() {
    	
    }
    
    public Book(String bookTitle) {
        this.title = bookTitle;
    }
   
    // Marks the book as rented
    public void rented() {
        borrowed = true;
    }
   
    // Marks the book as not rented
    public void returned() {
        borrowed = false;
    }
   
    // Returns true if the book is rented, false otherwise
    public boolean isBorrowed() {
    	return (borrowed) ? true : false;
    }
   

    public static void main(String[] arguments) {
        // Small test of the Book class
        Book example = new Book("The Da Vinci Code");
        System.out.println("Title: " + example.title);
        System.out.println("Rented? " + example.isBorrowed());
        example.rented();
        System.out.println("Rented? " + example.isBorrowed());
        example.returned();
        System.out.println("Rented? " + example.isBorrowed());
    }
} 
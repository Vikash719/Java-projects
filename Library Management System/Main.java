import pojo.Book;
import pojo.Member;
import repository.BookRepository;
import repository.MemberRepository;
import service.BookService;
import service.MemberService;

public class Main {

    public static void main(String[] args) {

        // Step 1: Initialize Repositories
        BookRepository bookRepo = new BookRepository();
        MemberRepository memberRepo = new MemberRepository();

        // Step 2: Create Service Layer Instances
        BookService bookService = new BookService(bookRepo);
        MemberService memberService = new MemberService(memberRepo);

        // Step 3: Add Books
        System.out.println("Adding Books...");
        bookService.addBook("1", "Effective Java", "Joshua Bloch", "978-0134685991", 2018, true);
        bookService.addBook("2", "Clean Code", "Robert C. Martin", "978-0132350884", 2008, true);
        bookService.addBook("3", "Design Patterns", "Erich Gamma", "978-0201633610", 1994, false);

        // Step 4: Add Members
        System.out.println("\nAdding Members...");
        memberService.addMember("1", "John Doe", "johndoe@gmail.com");
        memberService.addMember("2", "Jane Smith", "janesmith@yahoo.com");
        memberService.addMember("3", "Emily Davis", "emilydavis@outlook.com");

        // Step 5: Get Book and Member Details
        System.out.println("\nFetching Book Details...");
        System.out.println(bookService.getBookDetails("1"));
        System.out.println(bookService.getBookDetails("2"));
        System.out.println(bookService.getBookDetails("3"));

        System.out.println("\nFetching Member Details...");
        System.out.println(memberService.getMemberDetails("1"));
        System.out.println(memberService.getMemberDetails("2"));
        System.out.println(memberService.getMemberDetails("3"));

        // Step 6: Update Availability of a Book (Mock operation to simulate changes)
        System.out.println("\nUpdating Availability of Book ID 3...");
        bookService.removeBook("3"); // Simulating removal of unavailable book
        bookService.addBook("3", "Design Patterns", "Erich Gamma", "978-0201633610", 1994, true); // Re-adding as available

        // Step 7: Remove Book and Member
        System.out.println("\nRemoving a Book...");
        bookService.removeBook("2");

        System.out.println("\nRemoving a Member...");
        memberService.removeMember("1");

        // Step 8: Trying to Fetch Removed Book and Member
        System.out.println("\nFetching Removed Book and Member...");
        System.out.println(bookService.getBookDetails("2")); // Should print "Book not found"
        System.out.println(memberService.getMemberDetails("1")); // Should print "Member not found"

        // Step 9: Print All Available Books and Members
        System.out.println("\nDisplaying All Available Books...");
        System.out.println(bookService.getBookDetails("1")); // Should be available
        System.out.println(bookService.getBookDetails("3")); // Should be available

        System.out.println("\nDisplaying All Available Members...");
        System.out.println(memberService.getMemberDetails("2")); // Should be available
        System.out.println(memberService.getMemberDetails("3")); // Should be available

        // Step 10: Final System State
        System.out.println("\nSystem State after all operations:");
        System.out.println("Books:");
        System.out.println(bookService.getBookDetails("1"));
        System.out.println(bookService.getBookDetails("3"));

        System.out.println("\nMembers:");
        System.out.println(memberService.getMemberDetails("2"));
        System.out.println(memberService.getMemberDetails("3"));
    }
}

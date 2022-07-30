import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class Main {
    public static void main(String[]args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> studentDB = new ArrayList<String>(); // Create an ArrayList object
        Student student1 = new Student("adam", "ant", "adamant");
        Student student2 = new Student("blue", "blazer", "blueblazer");

        studentDB.add(student1.userN());
        studentDB.add(student2.userN());

        Book book1 = new Book("title1", "john", "doe", 1234);
        Book book2 = new Book("title2", "jane", "doe", 5678);

        Hashtable<Integer, String> isbnLookup = new Hashtable<Integer, String>();
        Hashtable<Integer, Boolean> isbnBorrow = new Hashtable<Integer, Boolean>();

        isbnLookup.put(book1.getISBN(),book1.getTitle());
        isbnLookup.put(book2.getISBN(),book2.getTitle());

        //true means borrowed; false means available
        isbnBorrow.put(book1.getISBN(),true);
        isbnBorrow.put(book2.getISBN(),false);

        System.out.println("Welcome to the library");
        System.out.println("Menu options");
        System.out.println("Add a new account: Press (1)");
        System.out.println("Add a new book: Press (2)");
        System.out.println("Borrow a book: Press (3)");
        System.out.println("Return a book: Press (4)");

        int searchChoice = scanner.nextInt();

        switch (searchChoice) {
            case 1 -> {
                System.out.println("Enter first name");
                String firstName = scanner.next();
                System.out.println("Enter last name");
                String lastName = scanner.next();
                System.out.println("Create a user name");
                String userName = scanner.next();
                Student student = new Student(firstName, lastName, userName);
                student.confirmation();
                studentDB.add(student.userN());
            }
            case 2 -> {
                System.out.println("Enter name of book");
                String title = scanner.next();
                System.out.println("Enter author first name");
                String authorfName = scanner.next();
                System.out.println("Enter author last name");
                String authorlName = scanner.next();
                System.out.println("Enter ISBN number");
                int isbn = scanner.nextInt();
                Book book = new Book(title, authorfName, authorlName, isbn);
                book.confirmation();
                isbnLookup.put(book.getISBN(), book.getTitle());
                isbnBorrow.put(book.getISBN(), false);
                System.out.println("borrowed: " + isbnBorrow);
                System.out.println("title: " + isbnLookup);
            }
            case 3 -> {
                System.out.println("Enter UserName: ");
                String uName = scanner.next();
                if(studentDB.contains(uName)) {
                    System.out.println("Please list the ISBN of the book");
                    int bookISBN = scanner.nextInt();
                    if (isbnBorrow.containsKey(bookISBN) && (isbnBorrow.get(bookISBN) == false)) {
                        isbnBorrow.put(bookISBN, true);
                        System.out.println("book is now borrowed");
                    } else if (isbnBorrow.containsKey(bookISBN) && (isbnBorrow.get(bookISBN) == true)) {
                        System.out.println("book is currently being borrowed");
                    } else {
                        System.out.println("ISBN number does");
                    }
                }else {
                    System.out.println("UserName does not exist");
                }
            }
            case 4 -> {
                System.out.println("Enter UserName: ");
                String uName = scanner.next();
                if(studentDB.contains(uName)) {
                    System.out.println("Please list the ISBN of the book");
                    int bookISBN = scanner.nextInt();
                    if (isbnBorrow.containsKey(bookISBN) && (isbnBorrow.get(bookISBN) == true)) {
                        isbnBorrow.put(bookISBN, true);
                        System.out.println("book is now returned");
                    } else if (isbnBorrow.containsKey(bookISBN) && (isbnBorrow.get(bookISBN) == false)) {
                        System.out.println("book is not being borrowed");
                    } else {
                        System.out.println("ISBN number does not exist");
                    }
                }
            }
            default ->

                    System.out.println("ENTER A NUMBER BETWEEN 1 TO 4.");
        }

    }

}

//Add students
//Add books
//rent books
//put books back


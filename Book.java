class Book {
    private String title;
    private String authorFname;
    private String authorLname;
    private int isbn;//primary key
    protected static boolean rented = false;

    protected Book(String name, String aFname, String aLname, int num) {
        title = name;
        authorFname = aFname;
        authorLname = aLname;
        isbn = num;
    }

    protected Boolean currentStatus() {
        return rented;
    }
    protected void isActive(){
        rented = true;
    }

    protected void isNotActive(){
        rented = false;
    }

    protected void currentRental() {
        if(Book.rented == true) {
            System.out.println("book is currently being borrowed");
        }else {
            System.out.println("book is available");
        }
    }

    protected int getISBN() {
        return isbn;
    }

    protected String getTitle() {
        return title;
    }

    protected void confirmation() {
        System.out.println("title: "+ title +" authorFname: " + authorFname+ " authorLname: " +authorLname +" ISBN: "+isbn);
    }
}

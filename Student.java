
class Student {
    private String firstName;
    private String lastName;
    private String userName;//primary key

    protected Student(String fname, String lname, String uname){

        firstName = fname;
        lastName = lname;
        userName = uname;
    }


    protected String firstN() {
        return firstName;
    }

    protected String lastN() {
        return lastName;
    }

    protected String userN() {
        return userName;
    }

    protected void confirmation() {
        System.out.println("firstName: "+ firstName+" lastName: " + lastName+ " userName: " +userName);
    }
}


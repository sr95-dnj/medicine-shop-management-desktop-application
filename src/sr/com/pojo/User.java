package sr.com.pojo;

public class User {

    private int id;
    private String name;
    private String username;
    private String password;
    private String email;
    private String address;
    private String gender;
    private String note;

    public User() {
    }

    public User(int id, String name, String username, String password,  String email, String address, String gender, String note) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
        this.gender = gender;
        this.note = note;
    }

    public User(String name, String username, String password,  String email, String address, String gender, String note) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
        this.gender = gender;
        this.note = note;
    }

    

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    

    public String getGender() {
        return gender;
    }

    public String getNote() {
        return note;
    }

  
}

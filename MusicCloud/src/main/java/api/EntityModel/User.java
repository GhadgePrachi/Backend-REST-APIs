package api.EntityModel;

public class User {
    Integer userId;
    String firstName;
    String lastName;
    String emailId;
    Integer status;

    /**Constructor**/
    public User(){
        firstName = "";
        lastName = "";
    }

    public User(String fname , String lname , String genToken , String email){
        firstName = fname;
        lastName = lname;
        emailId = email;
    }

    public User(User u){
        userId = u.getUserId();
        firstName = u.getFirstName();
        lastName = u.getLastName();
        status= u.getStatus();
    }

    /**Getter and Setter**/
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}

package cinemav.pkg2;

public class Customer {
    private long personId;
    private String firstname;
    private String lastname;
    private String location;
    private long phone;

    public Customer(long personId, String firstname, String lastname, String location, long phone) {
        this.personId = personId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.location = location;
        this.phone = phone;
    }

    public long getPersonId() {
        return personId;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getLocation() {
        return location;
    }

    public long getPhone() {
        return phone;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }
    
    public String printCustomer(){
        StringBuilder sb = new StringBuilder();
        sb.append("Name : "+firstname);
        sb.append("\n");
        sb.append("Lastname : "+lastname);
        sb.append("\n");
        sb.append("Tel. "+phone+ "\tLocation : "+location);
        return sb.toString();
    }
}

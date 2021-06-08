package softeng.aueb.restaurant.domain;



/**
 * A class that implements the owner(s) in our system
 * @author team23
 */
public class Owner {
    private String username;
    private String email;
    private String password;
    private int numberofTables;

    /**
     * Class constructor
     * @param username Owner's username
     * @param email Owner's email
     * @param password Owner's password
     * @param numberofTables Restaurant's number of tables
     */
    public Owner(String username, String email, String password, int numberofTables) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.numberofTables = numberofTables;
    }

    /**
     * Getter
     * @return gets Owner's username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter
     * @param username sets Owner's username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Getter
     * @return Owner's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *Getter
     * @return Owner's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * SEtter
     * @param password Sets Owner's password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Geter
     * @return restaurants total Ttables
     */
    public int getNumberofTables() {
        return numberofTables;
    }

    /**
     * Setter
     * @param numberofTables restarant's total number of tables
     */
    public void setNumberofTables(int numberofTables) {
        this.numberofTables = numberofTables;
    }


}

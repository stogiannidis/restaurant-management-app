package softeng.aueb.restaurant.domain;

/**
 * A class that implements an employee in our system
 * @author team23
 */
public class Employee {
    private String username;
    private String email;
    private String password;
    private String job;

    /**
     * Class constructor
     * @param email employee's email
     * @param password employee's password
     * @param username employee's username
     * @param job employee's job
     */
    public Employee(String email, String password,String username,String job) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.job = job;
    }

    /**
     * Getter
     * @return Employee's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter
     * @param email sets employee's email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * Getter
     * @return Employee's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter
     * @param password sets employee's password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * Getter
     * @return Employee's username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter
     * @param username sets employee's username
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * Getter
     * @return Employee's job
     */
    public String getJob() {
        return job;
    }

}

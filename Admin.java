package studentManagement;

public class Admin {
	 private String username;
	    private String password;

	    public Admin(String username, String password) {
	        this.username = username;
	        this.password = password;
	    }

	    // getters
	    public String getUsername() { return username; }
	    public String getPassword() { return password; }
}

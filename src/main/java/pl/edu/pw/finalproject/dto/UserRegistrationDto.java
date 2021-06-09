package pl.edu.pw.finalproject.dto;




/**
 * The type User registration dto.
 * @author Matylda Wawrzak-Rajtar
 */
public class UserRegistrationDto {

	/**
	 * the first name of a new User
	 */
	private String firstName;
	/**
	 * the last name of a new User
	 */

	private String lastName;

	/**
	 * the password name of a new User
	 */
	private String password;

	/**
	 * the email name of a new User. The email is a login to the account.
	 */
	private String email;


	/**
	 * Instantiates a new User registration dto.
	 *
	 * @param firstName the first name
	 * @param lastName  the last name
	 * @param password  the password
	 * @param email     the email
	 */
	public UserRegistrationDto(String firstName, String lastName, String password, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
	}


	/**
	 * Instantiates a new User registration dto.
	 */
	public UserRegistrationDto() {

	}

	/**
	 * Gets first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}


	/**
	 * Sets first name.
	 *
	 * @param firstName the first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	/**
	 * Gets last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}


	/**
	 * Sets last name.
	 *
	 * @param lastName the last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	/**
	 * Gets password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * Sets password.
	 *
	 * @param password the password
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * Gets email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * Sets email.
	 *
	 * @param email the email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}
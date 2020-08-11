package model.user;
import model.interfaces.user.User;
import javax.persistence.*;

@Entity
@Table(name="user")
public class UserImpl implements User{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int userId;
	@Column(name="email", nullable = false, length=255, unique=true)
	private String email;
	@Column(name="password_hash", nullable = false, length=65)
	private String passwordHash;
	@Column(name="first_name", nullable = false, length=50)
	private String firstName;
	@Column(name="last_name", nullable = false, length=100)
	private String lastName;
	@Column(name="role", nullable=false)
	private UserRole role;
	
	
	/**
	 * Default constructor required for Hibernate to work.
	 * Unclear why.
	 */
	public UserImpl(){}
	
	/**
	 * Creates a new User object. No validation is performed in this method.
	 * @param userID ID for the customer in the DB
	 * @param email customer Email.
	 * @param passwordHash customer's hashed password
	 * @param firstName Customer's first name.
	 * @param lastName Customer's last name.
	 * @param role Customer's role, as the UserRole enumerator.
	 */
	public UserImpl(String email, String passwordHash, String firstName, String lastName, UserRole role){
		this.email = email;
		this.passwordHash = passwordHash;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
	}
	
	
	/**
	 * Overload of {@link UserImpl#UserImpl(int,String,String,String,String,UserRole)}, accept an index for the user role.
	 * @param userRole Index of the user role.
	 * @see UserRole
	 */
	public UserImpl(String email, String passwordHash, String firstName, String lastName, int userRole){
		this.email = email;
		this.passwordHash = passwordHash;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = UserRole.values()[userRole];
	}

	@Override
	public int getUserId() {
		return this.userId;
	}

	@Override
	public String getUserEmail() {
		return this.email;
	}

	@Override
	public String getUserPasswordHash() {
		return this.getUserPasswordHash();
	}

	@Override
	public String getUserFirstName() {
		return this.firstName;
	}

	@Override
	public String getUserLastName() {
		return this.lastName;
	}

	@Override
	public String getUserFullName() {
		return String.join(" ", this.firstName, this.lastName);
	}

	@Override
	public UserRole getUserRole() {
		return this.role;
	}


}

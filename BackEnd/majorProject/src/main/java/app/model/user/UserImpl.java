//package app.model.user;
//import app.model.interfaces.user.User;
//import javax.persistence.*;
//
//
////@Entity
////@Table(name="STANDARD_USER")
////@Inheritance
//public class UserImpl implements User{
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE)
//	@Column(name="USER_ID", nullable = false, length=255, unique=true)
//	protected int userId;
//	@Column(name="EMAIL", nullable = false, length=255, unique=true)
//	protected String email;
//	@Column(name="PASSWORD_HASH", nullable = false, length=65)
//	protected String passwordHash;
//	@Column(name="FIRST_NAME", nullable = false, length=50)
//	protected String firstName;
//	@Column(name="LAST_NAME", nullable = false, length=100)
//	protected String lastName;
//	@Column(name="ROLE", nullable=false)
//	protected UserRole role;
//
//
//	/**
//	 * Default constructor required for Hibernate to work.
//	 * Unclear why.
//	 */
//	public UserImpl(){}
//
//	/**
//	 * Creates a new User object. No validation is performed in this method.
//	 * @param email customer Email.
//	 * @param passwordHash customer's hashed password
//	 * @param firstName Customer's first name.
//	 * @param lastName Customer's last name.
//	 * @param role Customer's role, as the UserRole enumerator.
//	 */
//	public UserImpl(String email, String passwordHash, String firstName, String lastName, UserRole role){
//		this.email = email;
//		this.passwordHash = passwordHash;
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.role = role;
//	}
//
//
//	/**
//	 * Overload of {@link UserImpl#UserImpl(int,String,String,String,String,UserRole)}, accept an index for the user role.
//	 * @param userRole Index of the user role.
//	 * @see UserRole
//	 */
//	public UserImpl(String email, String passwordHash, String firstName, String lastName, int userRole){
//		this.email = email;
//		this.passwordHash = passwordHash;
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.role = UserRole.values()[userRole];
//		System.out.println(this.userId);
//	}
//
//	@Override
//	public int getUserId() {
//		return this.userId;
//	}
//
//	@Override
//	public String getUserEmail() {
//		return this.email;
//	}
//
//	@Override
//	public String getUserPasswordHash() {
//		return this.passwordHash;
//	}
//
//	@Override
//	public String getUserFirstName() {
//		return this.firstName;
//	}
//
//	@Override
//	public String getUserLastName() {
//		return this.lastName;
//	}
//
//	@Override
//	public String getUserFullName() {
//		return String.join(" ", this.firstName, this.lastName);
//	}
//
//	@Override
//	public UserRole getUserRole() {
//		return this.role;
//	}
//
//
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}
//
//	public void setUserEmail(String email) {
//		this.email = email;
//	}
//
//	public void setUserPasswordHash(String passwordHash) {
//		this.passwordHash = passwordHash;
//	}
//
//	public void setUserFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//
//	public void setUserLastName(String lastName) {
//		this.lastName = lastName;
//	}
//
//	public void setUserRole(UserRole role) {
//		this.role = role;
//	}
//}

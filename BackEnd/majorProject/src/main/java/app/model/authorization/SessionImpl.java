/*
 * package app.model.authorization;
 * 
 * import java.sql.Time; import java.time.LocalDateTime; import
 * java.time.LocalTime; import java.util.Date;
 * 
 * import javax.persistence.Entity; import javax.persistence.GeneratedValue;
 * import javax.persistence.GenerationType; import javax.persistence.Id;
 * 
 * import org.hibernate.query.criteria.internal.expression.function.
 * CurrentTimeFunction;
 * 
 * @Entity public class SessionImpl {
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.IDENTITY) private int sessionId;
 * private double randomValue; private int userId; private String sourceIp;
 * private LocalDateTime creationDateTime; private LocalDateTime
 * expirationDateTime; private String checkHash;
 * 
 * //Default constructor needed for autowire. Do not use. public SessionImpl(){}
 * 
 * public SessionImpl(int userId, String sourceIp, long secondsToExpire) {
 * this.userId = userId; this.sourceIp = sourceIp; this.creationDateTime =
 * LocalDateTime.now(); this.expirationDateTime =
 * this.creationDateTime.plusSeconds(secondsToExpire); this.randomValue =
 * Math.random(); this.checkHash = this.getHashForSession(); }
 * 
 * private String getHashForSession() { StringBuilder objectString = new
 * StringBuilder(); objectString.append(Double.toString(this.randomValue));
 * objectString.append(Integer.toString(this.userId));
 * objectString.append(this.sourceIp);
 * objectString.append(this.creationDateTime.toString()); return
 * dbtools.PasswordHash.createHash(objectString.toString()); }
 * 
 *//**
	 * @return The session Id for this session.
	 */
/*
 * public int getSessionId() { return this.sessionId; }
 * 
 *//**
	 * @return The check hash for this session token.
	 *//*
		 * public String getCheckHash() { return this.checkHash; } }
		 */
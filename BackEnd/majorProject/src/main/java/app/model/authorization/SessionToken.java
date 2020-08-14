package app.model.authorization;

public class SessionToken {

	private int sessionId;
	private String checkHash;
	
	public SessionToken(SessionImpl original){
		this.sessionId = original.getSessionId();
		this.checkHash = original.getCheckHash();
	}
	
}

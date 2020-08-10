package dbtools;

import java.sql.Connection;
import java.sql.SQLException;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.doThrow;
import org.junit.jupiter.api.Test;

import dbtools.DBConnection;

class DBConnectionTest {

	@Test
	void getNewDBConnection_ConnectionNotNull_NormalConditions() {
		assert(DBConnection.getNewDBConnection()!=null);
	}

	@Test
	void closeDBConnection_TrueOnClosedConnection_NormalClosure() {
		try {
			Connection mockConnection = mock(Connection.class);
			when(mockConnection.isClosed()).thenReturn(false);
			assert(DBConnection.closeDBConnection(mockConnection));
		} catch(Exception e) {
			fail("Unexpected error with mockito");
		}
	}
	
	@Test
	void closeDBConnection_TrueOnClosedConnection_ConnectionAlreadyClosed(){
		try {
			Connection mockConnection = mock(Connection.class);
			when(mockConnection.isClosed()).thenReturn(true);
			assert(DBConnection.closeDBConnection(mockConnection)==true);
		} catch(Exception e) {
			fail("Unexpected Error with mockito");
		}
	}
	
	@Test
	void closeDBConnection_FalseOnSQLExcpetion_CloseMethodThrowsSQLException() {
		try {
			Connection mockConnection = mock(Connection.class);
			when(mockConnection.isClosed()).thenReturn(false);
			doThrow(new SQLException("")).when(mockConnection).close();
			assert(DBConnection.closeDBConnection(mockConnection)==false);
		} catch(Exception e) {
			fail("Unexpected error with mockito");
		}
	}
	

}

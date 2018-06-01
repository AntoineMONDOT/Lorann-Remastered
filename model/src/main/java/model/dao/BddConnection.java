package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BddConnection {
/** The instance. */
private static BddConnection INSTANCE = null;

/** The connection. */
private Connection connection;

public BddConnection() {
this.open();
}

public static synchronized BddConnection getInstance() {
if (BddConnection.INSTANCE == null) {
	BddConnection.INSTANCE = new BddConnection();
}
return BddConnection.INSTANCE;
}

private Boolean open() {
final BddProperties bddProperties = new BddProperties();
try {
Class.forName("com.mysql.jdbc.Driver");
this.connection = DriverManager.getConnection(bddProperties.getUrl(), bddProperties.getLogin(), bddProperties.getPassword());
} catch (final ClassNotFoundException e) {
e.printStackTrace();
} catch (final SQLException e) {
e.printStackTrace();
}
return true;
}

public Connection getConnection() {
return this.connection;
}

}

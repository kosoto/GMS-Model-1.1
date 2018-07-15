package enums;

public enum DBDriver {
	ORACLE_DRIVER,MYSQL_DRIVER,MARIADB_DRIVER,MSSQL_DRIVER;
	
	@Override
	public String toString() {
		String driver = "";
		switch(this) {
		case ORACLE_DRIVER: 
			driver = "oracle.jdbc.driver.OracleDriver";
			break;
		case MYSQL_DRIVER:
			break;
		case MARIADB_DRIVER: 
			break;
		case MSSQL_DRIVER:
			break;
		default : break;
		}
		return driver;
	}
}

package factory;

import java.sql.*;

import enums.DBDriver;
import enums.Vendor;
import pool.DBConstant;

public class DatabaseFactory {
	public static Database createDatabase(Vendor v,
			String id, String pass) {
		Database db = null;
		switch(v) {
		case ORACLE :
			db = new Oracle(DBDriver.ORACLE_DRIVER.toString(),
					DBConstant.CONNECTION_URL,
					id,pass);
			break;
		case MARIADB : 
			db = new MariaDB();
			break;
		default : break;
		}		
		return db;		
	}
}

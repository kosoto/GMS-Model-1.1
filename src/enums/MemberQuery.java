package enums;

public enum MemberQuery {
	LOGIN,INSERT_MEMBER,FIND_BY_ID;
	
	@Override
	public String toString() {
		String sql = "";
		switch(this) {
		case LOGIN:
			sql = "SELECT MEM_ID MEMID, "
					+" TEAM_ID TEAMID, "
					+" MEM_NAME, "
					+" MEM_AGE, "
					+" ROLL, "
					+" PASSWORD "
					+" FROM MEMBER "
					+" WHERE MEM_ID LIKE '%s' "
					+" AND PASSWORD LIKE '%s' ";
			break;
		case INSERT_MEMBER: 
			sql = "INSERT INTO MEMBER "
				+ "(MEM_ID, MEM_NAME, SSN, PASSWORD, MEM_AGE) "
				+ "VALUES "
				+ "('%s','%s','%s','%s','%d')";
			break;
		case FIND_BY_ID: 
			sql = "SELECT * FROM MEMBER "
					+ "WHERE MEM_ID LIKE '%s'";
			break;
		default : break;
		}
		return sql;
	}
}

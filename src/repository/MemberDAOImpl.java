package repository;

import java.sql.*;
import java.util.*;
import domain.*;
import enums.MemberQuery;
import enums.Vendor;
import factory.DatabaseFactory;
import pool.DBConstant;
import service.MemberServiceImpl;

public class MemberDAOImpl implements MemberDAO{
	private static MemberDAO instance = new MemberDAOImpl();
	public static MemberDAO getInstance() {return instance;}
	private MemberDAOImpl() {}
	@Override
	public MemberBean insertMember(MemberBean member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberBean> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberBean> readSome(String word) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberBean readOne(String word) {
		MemberBean member = null;
		try {
			ResultSet rs = DatabaseFactory.createDatabase(
					Vendor.ORACLE,
					DBConstant.USER_NAME, DBConstant.PASSWORD)
			.getConnection()
			.createStatement()
			.executeQuery(
					String.format(
							MemberQuery.FIND_BY_ID.toString(), 
							word)					
					);	
			if(rs.next()) {
				member = new MemberBean();
				member.getMemberId();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return member;
	}

	@Override
	public void updateMember(MemberBean member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMember(MemberBean member) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public MemberBean login(MemberBean member) {
		MemberBean mem = null;
		try {			
			ResultSet rs = DatabaseFactory.createDatabase(
					Vendor.ORACLE,
					DBConstant.USER_NAME,
					DBConstant.PASSWORD)
					.getConnection()
					.createStatement().executeQuery(String.format(
					MemberQuery.LOGIN.toString()
							,member.getMemberId(),member.getPass()));
			
			while(rs.next()) {
				mem = new MemberBean();
				mem.setMemberId(rs.getString("MEMID"));
				mem.setTeamId(rs.getString("TEAMID"));
				mem.setName(rs.getString("MEM_NAME"));
				mem.setAge(rs.getString("MEM_AGE"));
				mem.setRoll(rs.getString("ROLL"));
			}	
			
		} catch (Exception e) {			
			e.printStackTrace();
		}
		return mem;
	}
	@Override
	public String join(MemberBean member) {
		String result = "";
		String id = member.getMemberId();
		MemberBean mem = MemberServiceImpl.getInstance().readOne(id);
		if(mem == null) {
			try {
				DatabaseFactory.createDatabase(
						Vendor.ORACLE, 
						DBConstant.USER_NAME, DBConstant.PASSWORD)
				.getConnection()
				.createStatement()
				.executeUpdate(
						String.format(
							MemberQuery.INSERT_MEMBER.toString(),
							member.getMemberId(),
							member.getName(),
							member.getSsn(),
							member.getPass(),
							119-Integer.parseInt(member.getSsn().substring(0, 2))
							)						
				);
			} catch (Exception e) {
				e.printStackTrace();
			}
			 result = "등록 성공";
		}else {
			result = "아이디가 이미 있습니다.";
		}
		
		return result;
	}

}

package mms.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mms.member.db.JdbcUtil;
import mms.member.vo.Member;

//Oracle DB로 필요한 SQL구문을 전송하는 클래스 구현
public class MemberDAO {

	Connection con;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public MemberDAO(Connection con) {
		this.con = con;
	}

	public int insertNewMember(Member newMember) {

		String sql = "insert into mms_member(id,name,addr,nation,email,age) values(member_id_seq.nextval,?,?,?,?,?)";
		int insertCount = 0;
		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, newMember.getName());
			pstmt.setString(2, newMember.getAddr());
			pstmt.setString(3, newMember.getNation());
			pstmt.setString(4, newMember.getEmail());
			pstmt.setInt(5, newMember.getAge());

			insertCount = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			JdbcUtil.close(con);
		}

	

		return insertCount;
	}

	public ArrayList<Member> selectMemberList() {

		return null;		

	}

	public Member selectOldMember(String name) {

		return null;
		
	}

	public int updateMember(Member updateMember) {

		
		return 0;
	}

	public int deleteMember(String name) {

		return 0;
		
	}

}

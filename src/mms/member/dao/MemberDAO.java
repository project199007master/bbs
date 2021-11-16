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

	public MemberDAO(Connection con) {
		this.con = con;
	}

	// 1. 회원 정보 추가
	public int insertNewMember(Member newMember) {

		PreparedStatement pstmt = null;
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
		} finally {

			JdbcUtil.close(pstmt);
		}
		return insertCount;
	}

	// 2. 회원 목록 보기
	public ArrayList<Member> selectMemberList() {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Member> memberList = new ArrayList<Member>();
		String sql = "select * from mms_member";
		Member member = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				String name = rs.getString("name");
				String addr = rs.getString("addr");
				String nation = rs.getString("nation");
				String email = rs.getString("email");
				int age = rs.getInt("age");
				member = new Member(name, addr, nation, email, age);

				memberList.add(member);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {

			JdbcUtil.close(pstmt);
		}

		return memberList;

	}

	// 3. update할 때 특정 회원정보 보기
	public Member selectOldMember(String name) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from mms_member where name=?";
		Member member = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if (rs.next()) {

				String name2 = rs.getString("name");
				String addr = rs.getString("addr");
				String nation = rs.getString("nation");
				String email = rs.getString("email");
				int age = rs.getInt("age");
				member = new Member(name2, addr, nation, email, age);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {

			JdbcUtil.close(pstmt);
		}
		return member;
	}

	// 4. 회원 정보 수정
	public int updateMember(Member updateMember) {

		int updateCount = 0;
		PreparedStatement pstmt = null;
		String sql = "update mms_member set addr=?, nation=?, email=?, age=? where name=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, updateMember.getAddr());
			pstmt.setString(2, updateMember.getNation());
			pstmt.setString(3, updateMember.getEmail());
			pstmt.setInt(4, updateMember.getAge());
			pstmt.setString(5, updateMember.getName());

			updateCount = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(pstmt);
		}

		return updateCount;
	}

	// 4. 회원 정보 삭제
	public int deleteMember(String name) {

		int deleteCount = 0;
		PreparedStatement pstmt = null;
		String sql = "delete from mms_member where name=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			deleteCount = pstmt.executeUpdate();

			return deleteCount;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(pstmt);
		}
		return deleteCount;

	}

}

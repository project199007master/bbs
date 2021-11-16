package mms.member.svc;

import java.sql.Connection;
import java.util.ArrayList;

import mms.member.dao.MemberDAO;
import mms.member.db.JdbcUtil;
import mms.member.vo.Member;

public class MemberListService {
	
	Connection conn = null;
	
	public ArrayList<Member> getMemberList() {
		
		Connection conn = JdbcUtil.getConnection();
		MemberDAO memberDAO = new MemberDAO(conn);
		ArrayList<Member> memberList = memberDAO.selectMemberList();
		
		JdbcUtil.close(conn);
		
		return memberList;
	}

}

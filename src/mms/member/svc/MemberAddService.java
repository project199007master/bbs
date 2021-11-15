package mms.member.svc;

import java.sql.Connection;

import mms.member.dao.MemberDAO;
import mms.member.db.JdbcUtil;
import mms.member.vo.Member;

public class MemberAddService {

	Connection conn = null;
	
	public boolean addMember(Member newMember) throws Exception {

		conn = JdbcUtil.getConnection();
		MemberDAO dao = new MemberDAO(conn);
		
		if(dao.insertNewMember(newMember) > 0)
			return true;
		return false;
	}

}

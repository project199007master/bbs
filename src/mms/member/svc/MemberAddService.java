package mms.member.svc;

import java.net.InetSocketAddress;
import java.sql.Connection;

import mms.member.dao.MemberDAO;
import mms.member.db.JdbcUtil;
import mms.member.vo.Member;

public class MemberAddService {	

	public boolean addMember(Member newMember) throws Exception {

		Connection conn = JdbcUtil.getConnection();
		MemberDAO memberDAO = new MemberDAO(conn);
		boolean isAddSuccess = false;

		if (memberDAO.insertNewMember(newMember) > 0) {
			isAddSuccess = true;
			JdbcUtil.commit(conn);
			return true;
		} else {
			JdbcUtil.rollback(conn);
					
		}
		JdbcUtil.close(conn);
		return isAddSuccess;
		

	}

}

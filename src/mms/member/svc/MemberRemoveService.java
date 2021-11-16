package mms.member.svc;

import java.sql.Connection;

import mms.member.dao.MemberDAO;
import mms.member.db.JdbcUtil;
import mms.member.vo.Member;

public class MemberRemoveService {

	Connection conn = null;

	public boolean removeMember(String name) {

		boolean isDeleteSuccess = false;
		Connection conn = JdbcUtil.getConnection();
		MemberDAO memberDAO = new MemberDAO(conn);
		int deleteCount = memberDAO.deleteMember(name);
		if (deleteCount > 0) {
			isDeleteSuccess = true;
			JdbcUtil.commit(conn);
		} else {
			JdbcUtil.rollback(conn);
		}
		JdbcUtil.close(conn);
		return isDeleteSuccess;

	}

}

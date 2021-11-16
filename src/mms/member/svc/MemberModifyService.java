package mms.member.svc;

import java.sql.Connection;

import mms.member.dao.MemberDAO;
import mms.member.db.JdbcUtil;
import mms.member.vo.Member;

public class MemberModifyService {

	Connection conn = null;

	
	public boolean modifyMember(Member updateMember) {

		boolean isModifySuccess = false;
		Connection conn = JdbcUtil.getConnection();
		MemberDAO memberDAO = new MemberDAO(conn);
		int updateCount = memberDAO.updateMember(updateMember);
		if (updateCount > 0) {
			isModifySuccess = true;
			JdbcUtil.commit(conn);
			
		} else {
			JdbcUtil.rollback(conn);
			
		}
		JdbcUtil.close(conn);
		return isModifySuccess;
	}
	
	// 수정할 이름을 불러올 떄 정보 가져오기
	public Member getOldMember(String name) {
		
		Connection conn = JdbcUtil.getConnection();
		MemberDAO memberDAO = new MemberDAO(conn);
		Member member = memberDAO.selectOldMember(name);
		
		JdbcUtil.close(conn);
		return member;
	}

}

package mms.member.action;

import java.util.Scanner;

import mms.member.svc.MemberModifyService;
import mms.member.svc.MemberRemoveService;
import mms.member.util.ConsoleUtil;
import mms.member.vo.Member;

public class MemberRemoveAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {

		ConsoleUtil cu = new ConsoleUtil();
		String name = cu.getName("삭제할", sc);
		MemberRemoveService memberRemoveService = new MemberRemoveService();

		boolean isRemoveSuccess = memberRemoveService.removeMember(name);

		if (isRemoveSuccess) {
			cu.printRemoveSuccessMessage(name);
		} else {
			cu.printRemoveFailMessage(name);
		}

	}
}

package mms.member.util;

import java.util.ArrayList;
import java.util.Scanner;

import mms.member.vo.Member;

// 사용자로부터의 입력을 콘솔에서 읽어 들이거나 콘솔로 메시지를 출력하는 역할을 하는 클래스 구현
public class ConsoleUtil {

	public Member getNewMember(Scanner sc) {

		Member member = new Member();

		System.out.print("이름 : ");
		String name = sc.nextLine();

		System.out.print("주소 : ");
		String addr = sc.nextLine();

		System.out.print("국가 : ");
		String nation = sc.nextLine();

		System.out.print("이메일 : ");
		String email = sc.nextLine();
		int age = -1;
		boolean isRight = false;
		do {
			try {
				System.out.print("나이 : ");
				age = Integer.parseInt(sc.nextLine());
				isRight = true;
			} catch (NumberFormatException e) {
				System.out.println("문자열 입력됨. 다시 입력하세요");
			}
		} while (!isRight);
		member.setName(name);
		member.setAddr(addr);
		member.setNation(nation);
		member.setEmail(email);
		member.setAge(age);

		return member;
	}

	public void printAddSuccessMessage(Member newMember) {
		System.out.println(newMember.getName() + " 회원 정보 추가 성공\n");
	}

	public void printAddFailMessage(Member newMember) {
		System.out.println(newMember.getName() + " 회원 정보 추가 실패\n");
	}

	public void printMemberList(ArrayList<Member> memberList) {
		// size() : 컬렉션에 저장되어 있는 요소의 개수를 리턴하는 메소드
		for (int i = 0; i < memberList.size(); i++) {
			Member m = memberList.get(i);
			System.out.println("name = " + m.getName() + ", addr = " + m.getAddr() + ", email = " + m.getEmail()
					+ ", nation = " + m.getNation() + ", age = " + m.getAge());
		}
		System.out.println();
	}

	public String getName(String msgKind, Scanner sc) {

		System.out.println(msgKind);
		System.out.print("회원이름 : ");
		String name = sc.nextLine();

		return name;
	}

	public Member getUpdateMember(Scanner sc, Member oldMember) {

		System.out.println("수정할 회원 정보를 입력하세요.");
		System.out.print("이전 국가 : " + oldMember.getNation() + "/수정할 국가 : ");
		String nation = sc.nextLine();

		System.out.print("이전 주소 : " + oldMember.getAddr() + "/수정할 주소 : ");
		String addr = sc.nextLine();

		System.out.print("이전 이메일 : " + oldMember.getEmail() + "/수정할 이메일 : ");
		String email = sc.nextLine();

		int age = -1;
		boolean isRight = false;
		do {
			try {
				System.out.print("이전 나이 : " + oldMember.getAge() + "/수정할 나이 : ");
				age = Integer.parseInt(sc.nextLine());
				isRight = true;
			} catch (NumberFormatException e) {
				System.out.println("문자입력됨. 다시 입력하세요.");
			}
		} while (!isRight);

		Member updateMember = new Member();
		//updateMember.setId(oldMember.getId());
		updateMember.setName(oldMember.getName());
		updateMember.setNation(nation);
		updateMember.setAddr(addr);
		updateMember.setEmail(email);
		updateMember.setAge(age);

		return updateMember;

	}

	public void printModifySuccessMessage(Member updateMember) {
		System.out.println(updateMember.getName() + " 회원 정보 수정 성공.\n");
	}

	public void printModifyFailMessage(Member updateMember) {
		System.out.println(updateMember.getName() + " 회원 정보 수정 실패.\n");
	}

	public void printRemoveSuccessMessage(String name) {
		System.out.println(name + " 회원의 정보 삭제 성공.\n");
	}

	public void printRemoveFailMessage(String name) {
		System.out.println(name + " 회원의 정보 삭제 실패.\n");
	}

	public void printSelectZeroMessage() {
		System.out.println("등록된 회원 없음.");
		System.out.println();
	}

}

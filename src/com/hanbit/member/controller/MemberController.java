package com.hanbit.member.controller;

import java.util.List;

import javax.swing.JOptionPane;

import com.hanbit.member.constants.Butt;
import com.hanbit.member.domain.MemberBean;
import com.hanbit.member.serviceImpl.MemberServiceImp;

import javafx.print.PrinterJob.JobStatus;

public class MemberController {
	public static void main(String[] args){
		MemberServiceImp service=new MemberServiceImp();
		MemberBean member=null; //declaration	
		 Butt[] buttons={Butt.EXIT,Butt.ADD,Butt.LIST,Butt.FIND_NAME,Butt.FIND_ID,Butt.COUNT,Butt.UPDATE,Butt.DEL};
		
		 /*Butt key=(Butt) JOptionPane.showInputDialog(
				 null,//frame
				 "MEMBER ADMIN",
				 "SELECT MENU",
				 JOptionPane.QUESTION_MESSAGE,
				 null,
				 buttons,
				 buttons[1]
				 );
	*/
		do{
			flag:
			switch((Butt) JOptionPane.showInputDialog(
					 null,//frame
					 "MEMBER ADMIN",
					 "SELECT MENU",
					 JOptionPane.QUESTION_MESSAGE,
					 null,
					 buttons,
					 buttons[1]
					 )){
			case EXIT:return;
	
			case ADD:
				member=new MemberBean(); //초기화
				String[] arr=(JOptionPane.showInputDialog("이름/ID/Password/SSN")).split("/");
				member.setName(arr[0]);
				member.setId(arr[1]);
				member.setPassword(arr[2]);
				member.setSsn(arr[3]);
				service.addMember(member);
				JOptionPane.showMessageDialog(null, "회원가입 성공");
				break flag;
			case LIST:							
				JOptionPane.showMessageDialog(null,service.countMembers());
				break flag;
			case FIND_NAME:
				JOptionPane.showMessageDialog(null, service.getMembers());
				break flag;
			case FIND_ID:
				JOptionPane.showMessageDialog(null, service.findById((JOptionPane.showInputDialog(null, "조회하려는 ID를 입력하세요"))).toString());
				break flag;
				
			case COUNT:
				JOptionPane.showMessageDialog(null, service.findByName((JOptionPane.showInputDialog(null, "찾으려는 이름을 입력하세요"))));
				break flag;
				
			case UPDATE:
				String updateId=JOptionPane.showInputDialog("ID를 입력하세요.");
				MemberBean mem=new MemberBean();
				mem.setId(updateId);
				String newPass=JOptionPane.showInputDialog("바꿀 비밀번호를 입력하세요");
				mem.setPassword(newPass);
				String newSsn=JOptionPane.showInputDialog("바꿀 주민등록 번호를 입력하세요");
				mem.setSsn(newSsn);
				service.updatePass(mem);
				JOptionPane.showMessageDialog(null, "비밀번호 변경 성공");
				break flag;
			
			case DEL:
				String deleteId=JOptionPane.showInputDialog("지울 회원 ID를 입력하세요");
				service.deleteMember(deleteId);
				JOptionPane.showMessageDialog(null, "삭제 완료");
			break flag;
				}	 
			}while (true);
	}
}
	


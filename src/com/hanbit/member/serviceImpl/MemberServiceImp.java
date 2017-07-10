package com.hanbit.member.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.hanbit.member.domain.MemberBean;
import com.hanbit.member.service.MemberService;

public class MemberServiceImp implements MemberService {
	MemberBean member;
	List<MemberBean> list;
	int count;
	public MemberServiceImp() {
		member = new MemberBean();
		list = new ArrayList<>();
		count = 0;

	}

	@Override
	public void addMember(MemberBean member) {
		list.add(member);

	}

	@Override
	public List<MemberBean> getMembers() {
		return list;

	}

	@Override
	public int countMembers() {
		return list.size();
	}

	@Override
	public MemberBean findById(String id) {
		MemberBean member = new MemberBean();
		for (int i = 0; i < list.size(); i++) {
			if (id.equals(list.get(i).getId())) {
				member = list.get(i);
			}
		}
		return member;
	}

	@Override
	public List<MemberBean> findByName(String name) {
		List<MemberBean> temp = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (name.equals(list.get(i).getName())) {
				temp.add(list.get(i));
			}
		}
		return temp;
	}

	@Override
	public void updatePass(MemberBean bean) {
		// 아이디 패스워드 주민등록번호까지 바꿔봐라~
		for(MemberBean m: list){
		if(bean.getId().equals(m.getId())){
			if(!bean.getId().equals("")){
				m.setId(bean.getId());
		}
		if(!bean.getPassword().equals("")){
			m.setPassword(bean.getPassword());
		}
		if(!bean.getSsn().equals("")){
			m.setSsn(bean.getSsn());
		}
		}
		}
		/*MemberBean member = new MemberBean();
		member = findById(bean.getId());
		member.setPassword(bean.getPassword());
		member.setSsn(bean.getSsn());
	}*/
	}
	@Override
	public void deleteMember(String id) {
		for (int i = 0; i < list.size(); i++) {
			if (id.equals(list.get(i).getId())) {
				list.remove(i);
			}
		}
	}
}

package com.hanbit.member.serviceImpl;


import java.util.ArrayList;
import java.util.List;

import com.hanbit.member.domain.MemberBean;
import com.hanbit.member.service.MemberService;

public class MemberServiceImpl implements MemberService {
	MemberBean member;
	List<MemberBean> list;
	public MemberServiceImpl(){
		member = new MemberBean();
		list = new ArrayList<MemberBean>();
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
		member=new MemberBean();
		for(MemberBean m:list){
			if(id.equals(m.getId())){
				member=m;
				break;
			}
		}
		return member;
	}

	@Override
	public List<MemberBean> findByName(String name) {
		List<MemberBean>temp = new ArrayList<MemberBean>();
		int count = 0;
		for(MemberBean m:list){
			if(name.equals(m.getName())){
				count++;
			}
		}
		
		for(MemberBean m:list){
			if(name.equals(m.getName())){
				temp.add(m);
				if(count == temp.size()){
					break;	
				}
			}
		}
		return temp;
	}

	@Override
	public void updatePass(MemberBean member) {
		member = new MemberBean();
		member.setName(member.getName());
		member.setSNN(member.getSSN());
		member.setPassword(member.getPassword());
		
		for(MemberBean m:list){
			if(m.getId().equals(member.getId())){
				if(m.getName() == null){
					m.setName(m.getName());
				}	
				else{
					m.setName(member.getName());
				}
				if(member.getSSN() == null){
					m.setSNN(m.getSSN());
				}	
				else{
					m.setSNN(member.getSSN());
				}
				if(member.getPassword() == null){
					m.setPassword(m.getPassword());
				}	
				else{
					m.setPassword(member.getPassword());
				}	
			}
			
		}
	}
	
	@Override
	public void delete(String id) {
		for(MemberBean m:list){
			if(id.equals(m.getId())){
				list.remove(m);
			}
		}
	}
}

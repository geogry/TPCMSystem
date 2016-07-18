package com.techpark.cm.domain;

import java.util.Set;

public class User {

	//�û����
	private String id;
	
	//�û��ǳ�
	private String username;
	
	//�û�����
	private String password;
	
	//�û���ʵ����
	private String relname;
	
	//ְλ
	private Post post;
	
	//��������
	private String email;
	
	//�绰
	private String tel;
	
	//ע������
	private String regtime;

	//�Ƿ��Ѿ�ͨ�����
	private int checked;
	
	//�༶
	private String clazz;
	
	//qq
	private String qq;
	
	//�ҵ���Ϣ
	private Set<Message> messages;
	
	//�ȴ���˵Ľ��ü�¼
	private Set<TempBorrow> tempBorrows;
	
	//��ͨ���Ľ��ü�¼
	private Set<PassBorrow> passBorrows;
	
	//δͨ���Ľ��ü�¼
	private Set<RefuseBorrow> refuseBorrows;
	
	//�ȴ���˵��깺��¼
	private Set<TempPor> tempPors;
	
	//��ͨ�����깺��¼
	private Set<PassPor> passPors;
	
	//δͨ�����깺��¼
	private Set<RefusePor> refusePors;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRelname() {
		return relname;
	}

	public void setRelname(String relname) {
		this.relname = relname;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getRegtime() {
		return regtime;
	}

	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public Set<Message> getMessages() {
		return messages;
	}

	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}

	public Set<TempBorrow> getTempBorrows() {
		return tempBorrows;
	}

	public void setTempBorrows(Set<TempBorrow> tempBorrows) {
		this.tempBorrows = tempBorrows;
	}

	public Set<PassBorrow> getPassBorrows() {
		return passBorrows;
	}

	public void setPassBorrows(Set<PassBorrow> passBorrows) {
		this.passBorrows = passBorrows;
	}

	public Set<RefuseBorrow> getRefuseBorrows() {
		return refuseBorrows;
	}

	public void setRefuseBorrows(Set<RefuseBorrow> refuseBorrows) {
		this.refuseBorrows = refuseBorrows;
	}

	public Set<TempPor> getTempPors() {
		return tempPors;
	}

	public void setTempPors(Set<TempPor> tempPors) {
		this.tempPors = tempPors;
	}

	public Set<PassPor> getPassPors() {
		return passPors;
	}

	public void setPassPors(Set<PassPor> passPors) {
		this.passPors = passPors;
	}

	public Set<RefusePor> getRefusePors() {
		return refusePors;
	}

	public void setRefusePors(Set<RefusePor> refusePors) {
		this.refusePors = refusePors;
	}

	public int getChecked() {
		return checked;
	}

	public void setChecked(int checked) {
		this.checked = checked;
	}
}

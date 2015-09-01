package demo.service;

import demo.entity.IlJugMember;

public interface IIlJugMemberService {
	
	public IlJugMember createIlJugMember(String lastName, String firstName);
	public IlJugMember getIlJugMember(Long id);
	public Iterable<IlJugMember> getAllIlJugMembers();
	public Iterable<IlJugMember> findIlJugMemberByLastName(String lastName);
	public void deleteIlJugMember(Long id);
	public void updateIlJugMember(Long id, String lastName, String firstName);

}

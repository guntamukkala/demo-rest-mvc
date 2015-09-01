package demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.entity.IlJugMember;
import demo.repository.IIlJugMemberRepository;
import demo.service.IIlJugMemberService;

@Service
@Transactional
public class IlJugMemberServiceImpl implements IIlJugMemberService {

	@Autowired
	private IIlJugMemberRepository ilJugMemberRepository;
	
	@Override
	public IlJugMember createIlJugMember(String lastName, String firstName) {
		return ilJugMemberRepository.save(new IlJugMember(lastName, firstName));
	}

	@Override
	public IlJugMember getIlJugMember(Long id) {
		return ilJugMemberRepository.findOne(id);
	}

	@Override
	public Iterable<IlJugMember> getAllIlJugMembers() {
		return ilJugMemberRepository.findAll();
	}

	@Override
	public Iterable<IlJugMember> findIlJugMemberByLastName(String lastName) {
		return ilJugMemberRepository.findByLastName(lastName);
	}

	@Override
	public void deleteIlJugMember(Long id) {
		ilJugMemberRepository.delete(id);
	}

	@Override
	public void updateIlJugMember(Long id, String lastName, String firstName) {
		ilJugMemberRepository.save(new IlJugMember(id, lastName, firstName));
	}

}

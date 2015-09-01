package demo.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import demo.entity.IlJugMember;

public interface IIlJugMemberRepository extends
		CrudRepository<IlJugMember, Serializable> {

	Iterable<IlJugMember> findByLastName(String lastName);

}

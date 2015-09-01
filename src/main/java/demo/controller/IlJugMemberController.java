package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import demo.entity.IlJugMember;
import demo.service.IIlJugMemberService;

@RestController
@RequestMapping("/iljugmembers")
public class IlJugMemberController {

	@Autowired
	IIlJugMemberService ilJugMemberService;

	@RequestMapping(value = "/", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<IlJugMember> post(
			@RequestParam(value = "last", required = true) String lastName,
			@RequestParam(value = "first", required = true) String firstName) {
		IlJugMember ilJugMember = ilJugMemberService.createIlJugMember(
				lastName, firstName);
		return new ResponseEntity<IlJugMember>(ilJugMember, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void put(@PathVariable("id") Long id,
			@RequestParam(value = "last", required = true) String lastName,
			@RequestParam(value = "first", required = true) String firstName) {
		ilJugMemberService.updateIlJugMember(id, lastName, firstName);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { "application/json" })
	public IlJugMember getIJugMemberById(@PathVariable("id") Long id) {
		return ilJugMemberService.getIlJugMember(id);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = { "application/json" })
	public Iterable<IlJugMember> getAllIJugMembers() {
		return ilJugMemberService.getAllIlJugMembers();
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET, produces = { "application/json" })
	public Iterable<IlJugMember> searchIJugMembersByLastName(
			@RequestParam("last") String lastName) {
		return ilJugMemberService.findIlJugMemberByLastName(lastName);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		ilJugMemberService.deleteIlJugMember(id);
	}

}

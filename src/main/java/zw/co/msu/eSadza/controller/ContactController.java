package zw.co.msu.eSadza.controller;

import zw.co.msu.eSadza.service.ContactService;
import zw.co.msu.eSadza.service.ContactServiceImpl;
import zw.co.msu.eSadza.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ContactController {

	@Autowired
	ContactServiceImpl contactDao;

	private final ContactService contactService;

	@Autowired
	public ContactController(ContactService contactService) {

		this.contactService = contactService;
	}

	@PostMapping("/contact")
	public boolean contactUs(@RequestBody Contact contact, Model model) {

		return contactDao.saveMessage(contact);
	}
}

package zw.co.msu.eSadza.service;

import zw.co.msu.eSadza.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zw.co.msu.eSadza.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	private final ContactRepository contactRepository;

	@Autowired
	public ContactServiceImpl(ContactRepository contactRepository) {

		this.contactRepository = contactRepository;
	}

	public boolean saveMessage(Contact contact) {

		contactRepository.save(contact);
		return true;
	}
}

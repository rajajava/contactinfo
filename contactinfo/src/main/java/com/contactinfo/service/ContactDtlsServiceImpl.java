package com.contactinfo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contactinfo.dao.ContactDtlsRepository;
import com.contactinfo.dto.Contact;
import com.contactinfo.entity.ContactDetailsEntity;

@Service
public class ContactDtlsServiceImpl implements ContactDtlsService{

	@Autowired
	private ContactDtlsRepository contactDtlsRepository;
	@Override
	public boolean saveContact(Contact contact) {
		ContactDetailsEntity contactDetailsEntity=new ContactDetailsEntity();
		BeanUtils.copyProperties(contact, contactDetailsEntity);
		ContactDetailsEntity savedEntity =contactDtlsRepository.save(contactDetailsEntity);
		return savedEntity.getContactId()!=null;
	}

	@Override
	public List<Contact> getAllContacts() {
		List<ContactDetailsEntity> entiyties=contactDtlsRepository.findAll();
		List<Contact> contacts=new ArrayList<Contact>();
		for(ContactDetailsEntity entity:entiyties) {
			Contact contact=new Contact();
			BeanUtils.copyProperties(entity, contact);
			contacts.add(contact);
		}
		return contacts;
		
	}

	@Override
	public Contact getContactById(Integer contactId) {
		Optional<ContactDetailsEntity> findById=contactDtlsRepository.findById(contactId);
		if(findById.isPresent()) {
			ContactDetailsEntity contactEntity=findById.get();
			Contact c=new Contact();
			BeanUtils.copyProperties(contactEntity,c);
			return c;
		}
		return null;
	}

	@Override
	public boolean updateContact(Contact contactDtls) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteContact(Integer contactId) {
		contactDtlsRepository.deleteById(contactId);
		return true;
	}

}

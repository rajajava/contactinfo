package com.contactinfo.service;

import java.util.List;



import com.contactinfo.dto.Contact;

 
public interface ContactDtlsService {
	
	boolean saveContact(Contact contactDtls);
	List<Contact> getAllContacts();
	Contact getContactById(Integer cid);
	boolean updateContact(Contact contactDtls);
	boolean deleteContact(Integer cid);

}

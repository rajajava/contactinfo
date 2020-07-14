package com.contactinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.contactinfo.dto.Contact;
import com.contactinfo.service.ContactDtlsService;

@Controller
public class ContactInfoController {
	
	@Autowired
	private ContactDtlsService contactDtlsService;
	
	 
	 @GetMapping(value = {"/","/getindex"})
	public String loadFrom(Model model) {
		 Contact con=new Contact();
		 model.addAttribute("contact",con);
		 System.out.println(con);
		return "index";
	}
	 @PostMapping(value="/saveContact")
	public String handleSubmitBtn(@ModelAttribute("contact") Contact contact,Model model) {
		boolean isSaved=contactDtlsService.saveContact(contact);
		 if(isSaved) {
			 model.addAttribute("succmsg","Contact Saved");
		 }
		 else {
			 model.addAttribute("errmsg","Faild to Saved Contact");
		 }
		 return "redirect:/getallcontacts";
	}
	 @GetMapping(value="/getallcontacts")
	 public String viewallContactDtls(Model model) {
		 List<Contact> contactList= contactDtlsService.getAllContacts();
		 model.addAttribute("contactList",contactList);
		 return "allcontacts";
	 }
	 @GetMapping(value="/editcontact")
	 public String editContact(@RequestParam("contactId") Integer contactId, Model model) {
		 Contact c=contactDtlsService.getContactById(contactId);
		 model.addAttribute("contact",c);
		 return "index";
	 }
	 
	 @GetMapping(value="/deletecontact")
	 public String deleteContact(@RequestParam("contactId") Integer contactId, Model model) {
		 boolean isDelete=contactDtlsService.deleteContact(contactId);
		 if(isDelete) {
			 return "redirect:/getallcontacts";
		 }
		 return "index";
	 }

}

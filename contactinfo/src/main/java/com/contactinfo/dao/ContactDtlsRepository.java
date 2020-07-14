package com.contactinfo.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contactinfo.entity.ContactDetailsEntity;

public interface ContactDtlsRepository extends JpaRepository<ContactDetailsEntity,Serializable> {

}

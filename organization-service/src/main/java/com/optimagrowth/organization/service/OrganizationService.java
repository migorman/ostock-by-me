package com.optimagrowth.organization.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.optimagrowth.organization.events.source.SimpleSourceBean;
import com.optimagrowth.organization.model.Organization;
import com.optimagrowth.organization.repository.OrganizationRepository;

@Service
public class OrganizationService {
	
    @Autowired
    private OrganizationRepository repository;
    
    @Autowired
    SimpleSourceBean simpleSourceBean;

    public Organization findById(String organizationId) {
    	Optional<Organization> opt = repository.findById(organizationId);
        return (opt.isPresent()) ? opt.get() : null;
    }

    public Organization create(Organization organization){
    	organization.setId( UUID.randomUUID().toString());
        organization = repository.save(organization);
        simpleSourceBean.publishOrganizationChange("SAVE", organization.getId());
        return organization;

    }

    public void update(Organization organization){
    	repository.save(organization);
    	simpleSourceBean.publishOrganizationChange("UPDATE", organization.getId());
    }

    public void delete(Organization organization){
    	repository.deleteById(organization.getId());
    	simpleSourceBean.publishOrganizationChange("DELETE", organization.getId());
    }

	public List<Organization> findAll() {
		return (List<Organization>) repository.findAll();
	}
}
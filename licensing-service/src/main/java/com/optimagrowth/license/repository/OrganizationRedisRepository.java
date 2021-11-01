package com.optimagrowth.license.repository;

import org.springframework.data.repository.CrudRepository;

import com.optimagrowth.license.model.Organization;

public interface OrganizationRedisRepository  extends CrudRepository<Organization,String>{

}

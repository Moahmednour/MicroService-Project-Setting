package com.iteam.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.iteam.Entity.Societe;

@RepositoryRestResource
public interface SocieteRepository  extends JpaRepository<Societe,Long> {
    @SuppressWarnings("hiding")
    @RestResource(path = "name")
    <Societe> void findByName(@Param("name") String name);
}

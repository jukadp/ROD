package com.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.OdczytLicznika;
import org.springframework.data.repository.CrudRepository;

@Repository("AdminLicznikiRepo")
public interface AdminLicznikiRepo extends CrudRepository<OdczytLicznika, Long>{

}

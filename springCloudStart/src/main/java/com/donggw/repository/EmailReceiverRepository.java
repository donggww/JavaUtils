package com.donggw.repository;

import com.donggw.entity.EmailReceiver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EmailReceiverRepository extends JpaRepository<EmailReceiver, Integer> {

	@Query("SELECT e FROM EmailReceiver e WHERE e.id = :id AND e.name=:name and e.tel=:tel and  e.email = :email AND e.status = :status")
	Optional<EmailReceiver> findEmailByAny(@Param("id") Integer id, @Param("name") String name, @Param("tel") String tel, @Param("email") String email, @Param("status") String status);


}

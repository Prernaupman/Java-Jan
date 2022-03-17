package com.sapient.repository;
import com.sapient.entity.User ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/* this will communicate with databse and perform all types of CRUD Operation   */
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

}

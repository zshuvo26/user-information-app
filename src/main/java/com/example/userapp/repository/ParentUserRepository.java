package com.example.userapp.repository;

import com.example.userapp.domain.ParentUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParentUserRepository extends JpaRepository<ParentUser, Long> {

    Optional<ParentUser> findParentUserByUserEmail(String email);

    @Query("select p from ParentUser p where p.user.id = :id")
    ParentUser findParentUserByUserId(@Param("id") Long id);


}

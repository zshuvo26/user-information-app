package com.example.userapp.repository;

import com.example.userapp.domain.ChildUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChildUserRepository extends JpaRepository<ChildUser, Long> {
    Optional<ChildUser> findChildUserByUserEmail(String email);

    @Query("select childUser from ChildUser childUser where childUser.user.id = :id")
    ChildUser findByUserId(@Param("id") Long id);

    @Query(value = "SELECT count(childUser) FROM ChildUser childUser where childUser.parentUser.id=:id")
    Long checkParent(@Param("id") Long id);
}

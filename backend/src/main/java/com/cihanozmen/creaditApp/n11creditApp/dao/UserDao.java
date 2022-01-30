package com.cihanozmen.creaditApp.n11creditApp.dao;

import com.cihanozmen.creaditApp.n11creditApp.dto.UserCreditResponseDto;
import com.cihanozmen.creaditApp.n11creditApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface UserDao extends JpaRepository<User,Long> {

    @Query(
            " select usrUser from User usrUser " +
                    "where usrUser.identityNumber = :identityNumber AND usrUser.birthDate =:birthdate"
    )
    User getCreditInfo(@Param("identityNumber") Long identifyNumber, @Param("birthdate") LocalDate birthdate);
}

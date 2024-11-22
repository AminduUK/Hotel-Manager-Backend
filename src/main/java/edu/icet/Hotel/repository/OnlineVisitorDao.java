package edu.icet.Hotel.repository;

import edu.icet.Hotel.entity.OnlineVisitorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OnlineVisitorDao extends JpaRepository<OnlineVisitorEntity, Long> {

    OnlineVisitorEntity findByFullNameOnl(String fullName);

    Optional<Object> findByEmailAddressOnlAndIdNumberOnl(String emailAddressOnl, String idNumberOnl);

    @Query("SELECT v.visitorIdOnl FROM OnlineVisitorEntity v WHERE v.emailAddressOnl = :emailAddressOnl AND v.idNumberOnl = :idNumberOnl")
    Optional<Long> findVisitorIdByEmailAndIdNumber(@Param("emailAddressOnl") String emailAddressOnl, @Param("idNumberOnl") String idNumberOnl);
}

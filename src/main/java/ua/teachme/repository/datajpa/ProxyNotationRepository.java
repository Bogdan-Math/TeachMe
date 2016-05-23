package ua.teachme.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ua.teachme.model.Notation;

import java.time.LocalDateTime;
import java.util.List;

@Transactional
public interface ProxyNotationRepository extends JpaRepository<Notation, Integer>{

    @Modifying//should be here to show to Spring Data JPA, that this method can modify DB, NOT only read.
    void delete(Integer id);

    @Modifying//should be here to show to Spring Data JPA, that this method can modify DB, NOT only read.
    Notation save(Notation notation);

    Notation findOne(Integer id);

    List<Notation> findAll();

    @Query(name = Notation.GET_BETWEEN)
    List<Notation> findBetween(@Param("startDateAndTime")LocalDateTime startDate, @Param("endDateAndTime")LocalDateTime endDate);
}

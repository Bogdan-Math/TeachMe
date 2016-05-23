package ua.teachme.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ua.teachme.model.User;

import java.util.List;

@Transactional
public interface ProxyUserRepository extends JpaRepository<User, Integer> {

    @Modifying//should be here to show to Spring Data JPA, that this method can modify DB, NOT only read.
//    @Query(name = User.DELETE)
    void delete(/*@Param("id")*/Integer id);

    @Modifying//should be here to show to Spring Data JPA, that this method can modify DB, NOT only read.
    User save(User user);

    User findOne(Integer id);

    User findByEmail(String email);

    List<User> findAll();
}

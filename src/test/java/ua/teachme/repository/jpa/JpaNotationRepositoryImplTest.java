package ua.teachme.repository.jpa;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import ua.teachme.profiles.db.ConnectTo;
import ua.teachme.profiles.db.PopulateDB;
import ua.teachme.profiles.db.WorkBy;
import ua.teachme.repository.AbstractNotationRepositoryTest;

@ActiveProfiles({ConnectTo.POSTGRESQL, WorkBy.JPA})
@Sql(scripts = PopulateDB.POSTGRESQL) //execute before every test in this class
public class JpaNotationRepositoryImplTest extends AbstractNotationRepositoryTest {

}
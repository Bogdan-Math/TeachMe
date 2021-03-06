package ua.teachme.repository.datajpa;

import org.junit.Ignore;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import ua.teachme.profiles.db.ConnectTo;
import ua.teachme.profiles.db.PopulateDB;
import ua.teachme.profiles.db.WorkBy;
import ua.teachme.repository.AbstractNotationRepositoryTest;

@ActiveProfiles({ConnectTo.POSTGRESQL, WorkBy.DATAJPA})
@Sql(scripts = PopulateDB.POSTGRESQL) //execute before every test in this class
@Ignore
public class DataJpaNotationRepositoryPseudoImplTest extends AbstractNotationRepositoryTest {

}
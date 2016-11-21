package ua.teachme.repository.jdbc;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import ua.teachme.profiles.db.ConnectTo;
import ua.teachme.profiles.db.PopulateDB;
import ua.teachme.profiles.db.WorkBy;
import ua.teachme.repository.AbstractNotationRepositoryTest;

@ActiveProfiles({ConnectTo.HSQLDB, WorkBy.JDBC})
@Sql(scripts = PopulateDB.HSQLDB) //execute before every test in this class
public class JdbcNotationRepositoryImplTest extends AbstractNotationRepositoryTest {

}
package com.me.testproject.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:WEB-INF/test-context.xml" })
public abstract class AbstractTestCase  extends AbstractTransactionalJUnit4SpringContextTests {

	public AbstractTestCase() {
		System.setProperty("db.username", "sa");
		System.setProperty("db.password", "");
		System.setProperty("db.driver", "org.hsqldb.jdbcDriver");
		System.setProperty("db.dialect", "org.hibernate.dialect.HSQLDialect");
		System.setProperty("db.url", "jdbc:hsqldb:mem:test");
		System.setProperty("db.persistenceUnit", "test");
		System.setProperty("db.poolsize.min", "1");
		System.setProperty("db.poolsize.max", "2");
		System.setProperty("db.showSql", "true");
	}
}

package com.me.testproject.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:WEB-INF/test-context.xml" })
public abstract class AbstractTestCase  extends AbstractTransactionalJUnit4SpringContextTests {

}
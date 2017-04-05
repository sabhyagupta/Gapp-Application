package gapp.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

@Test(groups = "ContestantTest")
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ContestantTest extends AbstractTransactionalTestNGSpringContextTests {
	
	  

	    @Autowired
	    ContestantDao ContestantDao;

	    

	   /* @Test
	    public void getContestant()
	    {
	    	assert  ContestantDao.getContestant("Accounting","Fall 2016").size()== 1;
	    }
	    
	    
	    @Test
	    public void getContestant1()
	    {
	    	assert  ContestantDao.getContestant("student1@localhost.localdomain").size()== 1;
	    }*/
	}



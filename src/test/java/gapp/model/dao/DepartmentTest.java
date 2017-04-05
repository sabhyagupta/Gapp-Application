package gapp.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

@Test(groups = "ApplicationTest")
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class DepartmentTest extends AbstractTransactionalTestNGSpringContextTests {
	
	  

	    @Autowired
	    DepartmentDao userDao;

	    

	   /* @Test
	    public void getDepartment()
	    {
	        assert userDao.getDepartment().size() == 2;
	    }*/
	    
	}



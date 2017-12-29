package com.niit.SNAPBackEnd.config;
import java.util.Date;
import java.util.Properties;
import javax.sql.DataSource;

 import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.SNAPBackEnd.dao.Blogcommentdao;
import com.niit.SNAPBackEnd.dao.Blogcommentdaoimpl;
import com.niit.SNAPBackEnd.dao.Blogdao;
import com.niit.SNAPBackEnd.dao.Blogdaoimpl;
import com.niit.SNAPBackEnd.dao.Forumcommentdao;
import com.niit.SNAPBackEnd.dao.Forumcommentdaoimpl;
import com.niit.SNAPBackEnd.dao.Forumdao;
import com.niit.SNAPBackEnd.dao.Forumdaoimpl;
import com.niit.SNAPBackEnd.dao.Jobdao;
import com.niit.SNAPBackEnd.dao.Jobdaoimpl;
import com.niit.SNAPBackEnd.dao.Userdao;
import com.niit.SNAPBackEnd.dao.Userdaoimpl;
import com.niit.SNAPBackEnd.models.Blog;
import com.niit.SNAPBackEnd.models.Blogcomments;
import com.niit.SNAPBackEnd.models.Forum;
import com.niit.SNAPBackEnd.models.Forumcomments;
import com.niit.SNAPBackEnd.models.Friend;
import com.niit.SNAPBackEnd.models.Job;
import com.niit.SNAPBackEnd.models.Users;

 
@Configuration
@ComponentScan("com.niit.SNAPBackeEnd")
@EnableTransactionManagement
public class Hibernateconfig{
 
 
    @Autowired
    @Bean(name="dataSource")
    public SessionFactory sF(DataSource dataSource) {
        LocalSessionFactoryBuilder sessionBuilder  = new LocalSessionFactoryBuilder(dataSource);
        /*sessionBuilder.setProperty("hibernate.show_sql", "true");*/
        
    //   sessionBuilder.addProperties(getHibernateProperties());
        sessionBuilder.addAnnotatedClass(Users.class);
        sessionBuilder.addAnnotatedClass(Blog.class);
       sessionBuilder.addAnnotatedClass(Blogcomments.class);
        sessionBuilder.addAnnotatedClass(Forum.class);
        sessionBuilder.addAnnotatedClass(Forumcomments.class);
        sessionBuilder.addAnnotatedClass(Friend.class);
        sessionBuilder.addAnnotatedClass(Job.class); 
    
       
       
        
        return sessionBuilder.buildSessionFactory();
    }
    @Autowired
    @Bean(name = "datasource") 
    public DataSource dataSource() {
    	DriverManagerDataSource driverManagerDataSource=new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		driverManagerDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		driverManagerDataSource.setUsername("mycoll");
		driverManagerDataSource.setPassword("mycoll");
		return driverManagerDataSource;
    }
 
    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
        properties.put("hibernate.format_sql", "true");
        
  properties.put("hibernate.default_schema", "hrishi");
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.connection.autocommit", true);
        return properties;
    }
    @Autowired
    @Bean(name="transactionmanager")
        public HibernateTransactionManager txManager(SessionFactory sF) {
                return new HibernateTransactionManager(sF);
        }
  /*  @Autowired
    @Bean(name="blogDao")
    public Blogdao getBlogDAO(SessionFactory sf )
    {
     System.out.println("BlogDao object created");
     return new Blogdaoimpl(sf);
    }
    
    @Autowired    
    @Bean(name="forumdao")
	public Forumdao getForumDAO(SessionFactory sessionFactory)
	{
		System.out.println("Forum DAO object Created");
		return new Forumdaoimpl(sessionFactory);
	}*/
  /* @Autowired    
    @Bean(name="userdao")
	public Userdao getUserDAO(SessionFactory sessionFactory)
	{
		System.out.println("User DAO object Created");
		return new Userdaoimpl(sessionFactory);
	}*/
   /* @Autowired    
    @Bean(name="jobdao")
	public Jobdao getJobDAO(SessionFactory sessionFactory)
	{
		System.out.println("Job DAO object Created");
		return new Jobdaoimpl(sessionFactory);
	}*/
  /*  @Autowired    
    @Bean(name="forumCommentDAO")
	public Forumcommentdao getForumCommentDAO(SessionFactory sessionFactory)
	{
		System.out.println("ForumComment DAO object Created");
		return new Forumcommentdaoimpl(sessionFactory);
	}
    
    @Autowired    
    @Bean(name="blogCommentDAO")
    public Blogcommentdao getBlogCommentDAO(SessionFactory sessionFactory)
	{
		System.out.println("BlogComment DAO object Created");
		return new Blogcommentdaoimpl(sessionFactory);
	}*/
 
 public static void main(String[] args) {
	new Hibernateconfig().sF(new Hibernateconfig().dataSource());
}
}
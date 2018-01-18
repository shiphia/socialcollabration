
package com.niit.SNAPBackEnd.config;



import java.util.Properties;


import javax.sql.DataSource;

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
import com.niit.SNAPBackEnd.dao.Blogdao;
import com.niit.SNAPBackEnd.dao.Blogdaoimpl;
import com.niit.SNAPBackEnd.dao.Forumcommentdao;
import com.niit.SNAPBackEnd.dao.Forumcommentdaoimpl;
import com.niit.SNAPBackEnd.dao.Forumdao;
import com.niit.SNAPBackEnd.dao.Forumdaoimpl;
import com.niit.SNAPBackEnd.dao.Friendaoimpl;
import com.niit.SNAPBackEnd.dao.Frienddao;
import com.niit.SNAPBackEnd.dao.Jobdao;
import com.niit.SNAPBackEnd.dao.Jobdaoimpl;
import com.niit.SNAPBackEnd.dao.Notificationdaoimpl;
import com.niit.SNAPBackEnd.dao.Notificationsdao;
import com.niit.SNAPBackEnd.dao.Userdao;
import com.niit.SNAPBackEnd.dao.Userdaoimpl;
import com.niit.SNAPBackEnd.models.Blog;
import com.niit.SNAPBackEnd.models.Blogcomments;
import com.niit.SNAPBackEnd.models.Forum;
import com.niit.SNAPBackEnd.models.Forumcomments;
import com.niit.SNAPBackEnd.models.Forumrequests;
import com.niit.SNAPBackEnd.models.Friend;
import com.niit.SNAPBackEnd.models.Job;
import com.niit.SNAPBackEnd.models.JobApplications;
import com.niit.SNAPBackEnd.models.Message;
import com.niit.SNAPBackEnd.models.Notifications;
import com.niit.SNAPBackEnd.models.Outputmessage;
import com.niit.SNAPBackEnd.models.Users;





@Configuration
@ComponentScan("com.niit.SNAPBackeEnd")
@EnableTransactionManagement
public class Hibernateconfig 
{
	@Autowired
	    @Bean(name="sessionFactory")
	    public SessionFactory sessionFactory(DataSource dataSource)  {
	        LocalSessionFactoryBuilder sessionBuilder  = new LocalSessionFactoryBuilder(dataSource);

	        /*sessionBuilder.setProperty("hibernate.show_sql", "true");*/
	        
	        sessionBuilder.addProperties(getHibernateProperties());
	     
	       sessionBuilder.addAnnotatedClass(Users.class);
	        sessionBuilder.addAnnotatedClass(Blog.class);
	       sessionBuilder.addAnnotatedClass(Blogcomments.class);
	        sessionBuilder.addAnnotatedClass(Forum.class);
	        sessionBuilder.addAnnotatedClass(Forumcomments.class);
	        sessionBuilder.addAnnotatedClass(Friend.class);
	        sessionBuilder.addAnnotatedClass(Job.class);
	        sessionBuilder.addAnnotatedClass(Forumrequests.class);
	        sessionBuilder.addAnnotatedClass(JobApplications.class);
	       
	        sessionBuilder.addAnnotatedClass(Notifications.class);
	        
	       
	        
	       
	        
	        return sessionBuilder.buildSessionFactory();
	    }
	 @Autowired
	    @Bean(name = "datasource") 
	    public DataSource dataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("org.h2.Driver");
	        dataSource.setUrl("jdbc:h2:tcp://localhost/~/colab");

	        dataSource.setUsername("sa");
	        dataSource.setPassword("");
	        System.out.println("Data Source Created.....");
	        return dataSource;

	       
	        }

	    private Properties getHibernateProperties() {
	        Properties properties = new Properties();
	        properties.put("hibernate.show_sql", "true");
	        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	  
	        properties.put("hibernate.format_sql", "true");
	        properties.put("hibernate.hbm2ddl.auto", "update");
	        properties.put("hibernate.connection.autocommit", true);
	        return properties;
	    }

	    
	    
	    @Autowired
	    @Bean(name="transactionManager")
	     
	        public HibernateTransactionManager txManager(SessionFactory sessionFactory) {
	                return new HibernateTransactionManager(sessionFactory);
	        }
	        
	   @Autowired    
	    @Bean(name="blogDAO")
		public Blogdao getBlogDAO(SessionFactory sessionFactory)
		{
			System.out.println("Blog DAO object Created");
			return new Blogdaoimpl(sessionFactory);
		}
	    
	    @Autowired    
	    @Bean(name="userDAO")
		public Userdao getUserDAO(SessionFactory sessionFactory)
		{
			System.out.println("User DAO object Created");
			return new Userdaoimpl(sessionFactory);
		}
	    @Autowired    
	    @Bean(name="jobDAO")
		public Jobdao getJobDAO(SessionFactory sessionFactory)
		{
			System.out.println("Job DAO object Created");
			return new Jobdaoimpl(sessionFactory);
		}
	    @Autowired    
	    @Bean(name="forumDAO")
		public Forumdao getForumDAO(SessionFactory sessionFactory)
		{
			System.out.println("Forum DAO object Created");
			return new Forumdaoimpl(sessionFactory);
		}
	    
	    
	    
	    @Autowired    
	    @Bean(name="friendDAO")
	    public Frienddao getFriendDAO(SessionFactory sessionFactory)
		{
			System.out.println("BlogComment DAO object Created");
			return new Friendaoimpl(sessionFactory);
		}
	    
	    @Autowired    
	    @Bean(name="NotificationsDAO")
	    public Notificationsdao getNotificationsDAO(SessionFactory sessionFactory)
		{
			System.out.println("Events DAO object Created");
			return new Notificationdaoimpl(sessionFactory);
		}
	 	 
	 

}

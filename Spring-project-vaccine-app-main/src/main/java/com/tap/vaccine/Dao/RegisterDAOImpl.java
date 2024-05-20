package com.tap.vaccine.Dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.tap.vaccine.RegisterEntity.RegisterEntity;


@Component

public class RegisterDAOImpl implements RegisterDAO{
	
	public RegisterDAOImpl() {
		System.out.println("inside of the register dao");
		
		
	}

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private JavaMailSenderImpl javaMailSender;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Override
	public boolean saveData(RegisterEntity entity) {
		System.out.println("inside the savedata ()");
		Session session=null;
		Transaction transaction=null;
		boolean isDataSaved=false;
		
		String m="your are successfully register into the vaccineApp";
		String l="Welcome to the vaccinePortal"+"\n"
				+ "Dear user "+entity.getUsername()+"\n"
				+"you are successfully registered into this portal"+"\n"
				+"Here is your Email:"+entity.getEmail()+"\n"
				+"password:"+entity.getPassword()+"\n"
				+"Note:use these credentials login into the vaccineportal";
		

		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(entity.getEmail());
		simpleMailMessage.setSubject(m);
		simpleMailMessage.setText(l);
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();			
			session.persist(entity);
			
			javaMailSender.send(simpleMailMessage);
			transaction.commit();
			System.out.println("saved the data....");
			isDataSaved=true;	
		}catch(HibernateException hibernateException){
			transaction.rollback();
			System.out.println("Transaction has been rooled back"+hibernateException.getMessage());
			isDataSaved=false;	
			
		}
		catch(MailException e){
			isDataSaved=false;	
			System.out.println(e.getMessage());
		}
		finally {
			if(session!=null)
			{
				session.close();
			}
			System.out.println("session is closed");
			
		}
		return isDataSaved;

	}

	

}

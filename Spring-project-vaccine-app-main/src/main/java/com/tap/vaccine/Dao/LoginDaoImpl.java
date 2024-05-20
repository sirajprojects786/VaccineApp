package com.tap.vaccine.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.tap.vaccine.RegisterEntity.RegisterEntity;

@Component
public class LoginDaoImpl implements LoginDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private JavaMailSenderImpl javaMailSender;

	@Override
	public RegisterEntity getRegisterEntityByEmail(String email) {

		System.out.println("invoked getRegisterEntityByEmail()");
		Session session = null;
		RegisterEntity entity = null;
		String hql = " from RegisterEntity where email='" + email + "'";
		try {
			session = sessionFactory.openSession();
			Query query = session.createQuery(hql);
			entity = (RegisterEntity) query.uniqueResult();
			System.out.println(entity);
			return entity;

		} finally {
			if (session != null)
				session.close();
			System.out.println("session is closed.");

		}

	}

	@Override
	public boolean emailExist(String email) {
		System.out.println("inside of emailExist()of dao");
		boolean recordExists=false;
		Session session = null;
		RegisterEntity entity = null;
		String hql = " from RegisterEntity where email='" + email + "'";
		try {	
	        session = sessionFactory.openSession();
	        Query query = session.createQuery(hql);
	        entity = (RegisterEntity) query.uniqueResult();
	        recordExists = (entity != null);
	        return recordExists;
	    } finally {
	        if (session != null)
	            session.close();
	        System.out.println("session is closed.");
	    }
		
		
		
	}

	public void  updateLoginAttempt(RegisterEntity entity) {
		System.out.println("inside of updateLOginAttempt()");
		Session session = null;
		String hql = "update RegisterEntity set loginAttempt = :attempt where email = :email";
		try {
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter("attempt", entity.getLoginAttempt());
			query.setParameter("email", entity.getEmail());
			int updatedRows = query.executeUpdate();
			transaction.commit();
			System.out.println("no.of.rows been updated ="+updatedRows);
			
		}finally {
		if (session != null)
            session.close();
        System.out.println("session is closed.");
		
			
		}
	}

	public void sendBlockedEmail(String email, String username) {
		System.out.println("inside of sendBlockedEmail()");
		Session session=null;
		Transaction transaction=null;
		
		
		String m="your account is blocked";
		String l=" dear "+username+"\n"+"your account is blocked due to more number of wrong Password."+"\n"
				+ "To get back your account reset the password.";
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(email);
		simpleMailMessage.setSubject(m);
		simpleMailMessage.setText(l);
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();	
			javaMailSender.send(simpleMailMessage);
			transaction.commit();
			
		}
		catch(MailException e){
			
			System.out.println(e.getMessage());
		}
		finally {
			if(session!=null)
			{
				session.close();
			}
			System.out.println("session is closed");
			
		}
		
		
		
	}

	

}

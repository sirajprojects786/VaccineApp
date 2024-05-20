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
public class ForgetPasswordDaoImpl implements ForgetPasswordDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private LoginDaoImpl login;
	
	@Autowired
	private JavaMailSenderImpl javaMailSender;

	@Override
	public boolean resetPasswordByEmail(String email, String password) {
		boolean reset=false;
		boolean exist = login.emailExist(email);
		int AttemptValue = 0;
		if (exist) {
			Session session = null;
			String hql = "update RegisterEntity set loginAttempt = :attempt, password = :newPassword where email = :email";
			try {
				session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				Query query = session.createQuery(hql);
				query.setParameter("attempt", AttemptValue);
				query.setParameter("email", email);
				query.setParameter("newPassword", password);
				int updatedRows = query.executeUpdate();
				transaction.commit();
				reset=true;
				System.out.println("no.of.rows been updated =" + updatedRows);

			} finally {
				if (session != null)
					session.close();
				System.out.println("session is closed.");

			}
		}
		
			return reset;
			
		
	}
	public void sendEmail(String email,String password)
	{
		String m="successfully  changed your password";
		String l="your password is updated in the vaccine portal and your  credentails:"+"\n "
				+"Email: "+email+"\n"
				+"new password : "+password+"\n"
				+"note:donot share your Credentails to anyone";
		Session session=null;
		Transaction transaction=null;

		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(email);
		simpleMailMessage.setSubject(m);
		simpleMailMessage.setText(l);
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();	
			javaMailSender.send(simpleMailMessage);
			transaction.commit();
			System.out.println("mail sent successfully.....");
			
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



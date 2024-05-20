package com.tap.vaccine.Dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tap.vaccine.RegisterEntity.MemberEntity;
import com.tap.vaccine.RegisterEntity.RegisterEntity;

@Component
public class MemberDaoImpl implements MemberDao {
	@Autowired
	private SessionFactory sessionFactory;

	Session session = null;
	Transaction transaction = null;

	@Override
	public boolean saveMember(MemberEntity entity) {
		System.out.println("inside the saveMember ()");
		boolean isDataSaved = false;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(entity);
			transaction.commit();
			System.out.println("saved the data....");
			isDataSaved = true;
		} catch (HibernateException hibernateException) {
			transaction.rollback();
			System.out.println("Transaction has been rooled back" + hibernateException.getMessage());
			isDataSaved = false;

		} catch (Exception e) {
			transaction.rollback();
			System.out.println("Transaction has been rooled back" + e.getMessage());
			isDataSaved = false;
		}
		finally {
			if (session != null) {
				session.close();
			}
			System.out.println("session is closed");

		}
		return isDataSaved;

	}

	@Override

	public List<MemberEntity> getAllDetails() {
		System.out.println("invoked getAllDetails()");
		Session session = null;

		String hql = "from MemberEntity";

		try {
			session = sessionFactory.openSession();
			
			Query query = session.createQuery(hql);
			List<MemberEntity> resultList = query.getResultList();
			
			return resultList;

		} finally {
			if (session != null)
				session.close();
			System.out.println("session is closed.");
		}

	}

	public List<MemberEntity> getAllDetailsByEmail(String fk_email) {
		System.out.println("invoked getAllDetails()");
		Session session = null;

		String hql = "from MemberEntity where fk_email = :fk_email";

		try {
			session = sessionFactory.openSession();
		
			Query query = session.createQuery(hql);
			query.setParameter("fk_email", fk_email);
			List<MemberEntity> resultList = query.getResultList();
			
			return resultList;

		} finally {
			if (session != null)
				session.close();
			System.out.println("session is closed.");
		}

	}

	public void updateMemberCount(RegisterEntity entity) {
		System.out.println("inside of updateMemberCount()");
		Session session = null;
		String hql = "update RegisterEntity set memberCount = :count where email = :email";
		try {
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Query  query = session.createQuery(hql);
			query.setParameter("count", entity.getMemberCount());
			query.setParameter("email", entity.getEmail());
			int updatedRows = query.executeUpdate();
			transaction.commit();
			System.out.println("no.of.rows been updated =" + updatedRows);

		} finally {
			if (session != null)
				session.close();
			System.out.println("session is closed.");

		}
	}

	@Override
	public int getMemberCount(String email) {
		System.out.println("inside of getMemberCount()");
		Session session = null;
		int memberCount = 0;
		String hql = "SELECT r.memberCount FROM RegisterEntity r WHERE r.email = :email";
		try {
			session = sessionFactory.openSession();
			
			Query query = session.createQuery(hql);
			query.setParameter("email", email);
			Object result = query.uniqueResult();
			if (result != null) {
				memberCount = (Integer) result;
			}
			
		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
				System.out.println("session is closed.");
			}
		}
		return memberCount;
	}

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
	public boolean deleteData(String idProofNo) {
		System.out.println("invoked delete()");
		Session session = null;
		boolean isDeleted = false;
		String hql = "DELETE FROM MemberEntity WHERE idProofNo = :idProofNo";
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter("idProofNo", idProofNo);
			int rowCount = query.executeUpdate();
			session.getTransaction().commit();
			isDeleted = rowCount > 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
			System.out.println("session is closed.");

		}
		return isDeleted;
	}

	@Override
	public MemberEntity getRegisterEntityById(int memberId) {
		System.out.println("invoked get registerentitybyid()");
		Session session = null;
		MemberEntity entity = null;
		String hql = " from MemberEntity where memberId='" + memberId + "'";
		try {
			session = sessionFactory.openSession();
			Query  query = session.createQuery(hql);
			entity = (MemberEntity) query.uniqueResult();
			System.out.println(entity);
			return entity;

		} finally {
			if (session != null)
				session.close();
			System.out.println("session is closed.");

		}
	}

	@Override
	public boolean saveData(MemberEntity entity) {
		System.out.println("inside the saveData ()");
		boolean isDataSaved = false;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.update(entity);
			transaction.commit();
			System.out.println("entity has been updated ");
			isDataSaved = true;
		} catch (HibernateException hibernateException) {
			transaction.rollback();
			System.out.println("Transaction has been rooled back" + hibernateException.getMessage());
			isDataSaved = false;

		} finally {
			if (session != null) {
				session.close();
			}
			System.out.println("session is closed");

		}
		return isDataSaved;

	}
}

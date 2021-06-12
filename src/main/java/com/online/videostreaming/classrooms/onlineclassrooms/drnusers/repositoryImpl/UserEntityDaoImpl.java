package com.online.videostreaming.classrooms.onlineclassrooms.drnusers.repositoryImpl;

import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.online.videostreaming.classrooms.onlineclassrooms.drnusers.repository.UserEntityDao;
import com.online.videostreaming.classrooms.onlineclassrooms.entity.UsersEntity;
import com.online.videostreaming.classrooms.onlineclassrooms.entity.UsersRole;
import com.online.videostreaming.classrooms.onlineclassrooms.utils.HibernateSessionUtils;
@Repository
@Transactional
public class UserEntityDaoImpl extends HibernateSessionUtils implements UserEntityDao {

	@Override
	public Optional<UsersEntity> findUserByUserName(String username) throws Exception {
		return null;
	}

	@Override
	public List<UsersEntity> findAllUsers() throws Exception {
		return null;
	}

	@Override
	public void increaseFailedAttempts(UsersEntity user) throws Exception {
		
	}

	@Override
	public void resetFailedAttempts(String username) throws Exception {
		
	}

	@Override
	public void lock(UsersEntity user) throws Exception {
		
	}

	@Override
	public boolean unlockWhenTimeExpired(UsersEntity user) throws Exception {
		return false;
	}

	@Override
	public List<UsersRole> findAllUserRoles() throws Exception {
		try{
			Session session = currentSession();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<UsersRole> criteria = builder.createQuery(UsersRole.class);
			Root<UsersRole> root = criteria.from(UsersRole.class);
			return session.createQuery(
	                 criteria.select(root).orderBy(builder.asc(root.get("roleId"))))
			           .getResultList();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		finally
		{
			closeSession();
		}
	}

	@Override
	public int uploadUsersInformation(UsersEntity usersEntity) throws Exception {
		
		int saveCount=0;
		
		try
		{
			Session session = currentSession();
			beginTransaction();
			session.save(usersEntity);
			
			commitTransaction();
		}
		catch(Exception e){
			rollbackTransaction();
			saveCount=1;
		}
		finally{
			closeSession();
		}
		return saveCount;
	}

	@Override
	public List<UsersEntity> findAllUserDetails() throws Exception {
		try{
			
			Session session = currentSession();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<UsersEntity> criteria = builder.createQuery(UsersEntity.class);
			Root<UsersEntity> root = criteria.from(UsersEntity.class);
			return session.createQuery(
	                 criteria.select(root).orderBy(builder.asc(root.get("userId"))))
			           .getResultList();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		finally
		{
			closeSession();
		}
	}

}

package com.online.videostreaming.classrooms.onlineclassrooms.drnusers.repositoryImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.online.videostreaming.classrooms.onlineclassrooms.drnusers.repository.UserEntityDao;
import com.online.videostreaming.classrooms.onlineclassrooms.entity.UsersEntity;
import com.online.videostreaming.classrooms.onlineclassrooms.entity.UsersRole;
import com.online.videostreaming.classrooms.onlineclassrooms.utils.HibernateSessionUtils;
import com.online.videostreaming.classrooms.onlineclassrooms.utils.WebConstant;
@Repository
@Transactional
public class UserEntityDaoImpl extends HibernateSessionUtils implements UserEntityDao {

	@Override
	public Optional<UsersEntity> findUserByUserName(String username) throws Exception {
		
		try {
			Session session = currentSession();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<UsersEntity> criteria = builder.createQuery(UsersEntity.class);
			Root<UsersEntity> root = criteria.from(UsersEntity.class);
			return Optional.ofNullable(session.createQuery(
	                 criteria.select(root).where(builder.equal(root.get("email"), username))
	                 )
			           .getSingleResult());
			
		} catch (Exception e) {
			
			return null;
		}finally
		{
			closeSession();
		}
		
	}

	@Override
	public List<UsersEntity> findAllUsers() throws Exception {
		try {
			Session session = currentSession();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<UsersEntity> criteria = builder.createQuery(UsersEntity.class);
			Root<UsersEntity> root = criteria.from(UsersEntity.class);
			return session.createQuery(
	                 criteria.select(root).orderBy(builder.asc(root.get("userId"))))
			           .getResultList();
		} catch (Exception e) {
			return null;
		}finally
		{
			closeSession();
		}
		
	}

	@Override
	public void increaseFailedAttempts(UsersEntity user) throws Exception {
		
		try {
			int newFailAttempts = user.getFailedAttempt() + 1;
			Session session = currentSession();
			beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaUpdate<UsersEntity> criteria = builder.createCriteriaUpdate(UsersEntity.class);
			Root<UsersEntity> root = criteria.from(UsersEntity.class);
			criteria.set("failedAttempt", newFailAttempts);
			criteria.where(builder.equal(root.get("userId"), user.getUserId()));
			session.createQuery(criteria).executeUpdate();
			commitTransaction();
		} catch (Exception e) {
			rollbackTransaction();
			throw e;
		}finally
		{
			closeSession();
		}
		
	}

	@Override
	public void resetFailedAttempts(String username) throws Exception {
		try {
			Session session = currentSession();
			beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaUpdate<UsersEntity> criteria = builder.createCriteriaUpdate(UsersEntity.class);
			Root<UsersEntity> root = criteria.from(UsersEntity.class);
			criteria.set("failedAttempt", 0);
			criteria.where(builder.equal(root.get("userId"), username));
			session.createQuery(criteria).executeUpdate();
			commitTransaction();
		} catch (Exception e) {
			rollbackTransaction();
			throw e;
		}finally
		{
			closeSession();
		}
		
		
	}

	@Override
	public void lock(UsersEntity user) throws Exception {
	        try {
	        	Session session = currentSession();
		        beginTransaction();
				CriteriaBuilder builder = session.getCriteriaBuilder();
				CriteriaUpdate<UsersEntity> criteria = builder.createCriteriaUpdate(UsersEntity.class);
				Root<UsersEntity> root = criteria.from(UsersEntity.class);
				criteria.set("isAccountNonLocked", false);
				criteria.set("lockTime", new Date());
				criteria.where(builder.equal(root.get("userId"), user.getUserId()));  
				session.createQuery(criteria).executeUpdate();
				commitTransaction();
			} catch (Exception e) {
				rollbackTransaction();
				throw e;
			}finally
			{
				closeSession();
			}
	        
		
	}

	@Override
	public boolean unlockWhenTimeExpired(UsersEntity user) throws Exception {
		long lockTimeInMillis = user.getLockTime().getTime();
        long currentTimeInMillis = System.currentTimeMillis();
         
        if (lockTimeInMillis + WebConstant.LOCK_TIME_DURATION < currentTimeInMillis) {
           try {
        	   Session session = currentSession();
               beginTransaction();
               
   			CriteriaBuilder builder = session.getCriteriaBuilder();
   			CriteriaUpdate<UsersEntity> criteria = builder.createCriteriaUpdate(UsersEntity.class);
   			Root<UsersEntity> root = criteria.from(UsersEntity.class);
   			criteria.set("isAccountNonLocked", true);
   			criteria.set("lockTime", null);
   			criteria.set("failedAttempt", 0);
   			criteria.where(builder.equal(root.get("userId"), user.getUserId()));
   			commitTransaction();
   		 return true;
		} catch (Exception e) {
			rollbackTransaction();
			return false;
			
		}finally
		{
			closeSession();
		}
              
             
           
        }
         
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
			return null;
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
			return null;
		}
		finally
		{
			closeSession();
		}
	}

	@Override
	public String deleteOrDeactivateUserById(Integer idToDelete, String action) throws Exception {
		
		
		if(action.equals("DELETE")) {
			
			try
			{
				Session session = currentSession();
				beginTransaction();
				
				session.delete(session.get(UsersEntity.class, idToDelete));
				commitTransaction();
				return "true";
			}
			catch(Exception e){
				rollbackTransaction();
				return "false";
			}
			finally{
				closeSession();
			}
			
			
		}else if(action.equals("DACTIVE")) {
			
			
			try
			{
				Session session = currentSession();
				beginTransaction();
				CriteriaBuilder builder = session.getCriteriaBuilder();
				CriteriaUpdate<UsersEntity> criteria = builder.createCriteriaUpdate(UsersEntity.class);
				Root<UsersEntity> root = criteria.from(UsersEntity.class);
				criteria.set("enabled", false);
				criteria.where(builder.equal(root.get("userId"), idToDelete));
				session.createQuery(criteria).executeUpdate();
				commitTransaction();
				return "true";
			}
			catch(Exception e){
				rollbackTransaction();
				return "false";
			}
			finally{
				closeSession();
			}
			
			
		}else if(action.equals("ACTIVE")) {
			
			
			try
			{
				Session session = currentSession();
				beginTransaction();
				CriteriaBuilder builder = session.getCriteriaBuilder();
				CriteriaUpdate<UsersEntity> criteria = builder.createCriteriaUpdate(UsersEntity.class);
				Root<UsersEntity> root = criteria.from(UsersEntity.class);
				criteria.set("enabled", true);
				criteria.where(builder.equal(root.get("userId"), idToDelete));
				session.createQuery(criteria).executeUpdate();
				commitTransaction();
				return "true";
			}
			catch(Exception e){
				rollbackTransaction();
				return "false";
			}
			finally{
				closeSession();
			}
			
			
		}
		return null;
	}

}

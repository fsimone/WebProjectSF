package com.fsimone.hibernate.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.hibernate.SessionFactory;

public class JobWorker implements Job
{

	private static final Logger LOG = LoggerFactory.getLogger(JobWorker.class);

	@Autowired
	private SessionFactory sessionFactory;


	@SuppressWarnings({ })
	public void execute(JobExecutionContext context) throws JobExecutionException {

		try {
			Scheduler scheduler = context.getScheduler();
			LOG.debug("quartz Job in exec now ...");

/*
			TestEntity te = new TestEntity("Test");
	        Transaction transaction = null;
	        try (Session session = sessionFactory.openSession()) {
	            transaction = session.beginTransaction();
	            session.save(te);
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }

	        try (Session session = sessionFactory.openSession()) {
	            List<TestEntity> students = session.createQuery("from testentity", TestEntity.class).list();
	            students.forEach(s -> System.out.println(s.getDescription()));
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
*/

			scheduler.shutdown();
			System.out.println("quartz Job STOP !!!");
		} catch (Exception e) {
			System.out.println("ERROR: "+e.getMessage());
			e.printStackTrace();
		}

	}

}
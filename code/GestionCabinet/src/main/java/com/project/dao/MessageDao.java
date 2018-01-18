package com.project.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.project.entities.Message;


@SuppressWarnings({ "deprecation", "rawtypes","unchecked" })
public class MessageDao {

	/************************ ADD Message*********************/
	public void addMessage(Message message) {
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Message.class)
				.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		session.save(message);
		session.getTransaction().commit();
		session.close();
	}
	/**************************delete Messega******************/
	public void DeleteMessage(Message message){
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Message.class)
				.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();	
		session.delete(message);
		session.getTransaction().commit();
		session.close();
	}
	/******************************get all ************************/
	public List<Message> displayMessage(Long id){
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Message.class)
				.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();		
		Query query=session.createQuery("from Message where idUtilisateur= :id");
        query.setParameter("id",id);
		List<Message>list=query.list();
        session.getTransaction().commit();
        session.close();
        if(list.isEmpty()){
        	return null;
	    }
        return list;        
	}
	/*****************************get one***********************/
	public Message getone(Long id){
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Message.class)
				.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();		
		Query query=session.createQuery("from Message where idMessage= :id");
        query.setParameter("id",id);
		List<Message>list=query.list();
        session.getTransaction().commit();
        session.close();
        if(list.isEmpty()){
        	return null;
	    }
        return list.get(0);        
	}
}

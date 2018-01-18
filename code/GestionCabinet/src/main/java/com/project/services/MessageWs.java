package com.project.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.project.dao.MessageDao;
import com.project.entities.Message;

@Path("message")
public class MessageWs {
	
private MessageDao nouveau = new MessageDao();
	
	@Path("savemessage")
	@POST
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public void addMessagews(Message message)
	{  
		nouveau.addMessage(message);
	}

	@Path("delete")
	@DELETE
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public void deletebilanws(Message message)
	{  
		nouveau.DeleteMessage(message);
	}
	
	@Path("getall")
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Message> displayMessagews(@QueryParam("id") Long id){
		return nouveau.displayMessage(id);
	} 
	
	@Path("getone")
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Message getonews(@QueryParam("id") Long id){
		return nouveau.getone(id);
	} 
}

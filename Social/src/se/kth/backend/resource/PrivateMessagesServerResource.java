package se.kth.backend.resource;

import java.util.List;

import org.hibernate.Transaction;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import se.kth.backend.model.dao.PrivateMessageDao;
import se.kth.backend.model.dao.UserDao;
import se.kth.common.PrivateMessagesResource;
import se.kth.common.model.bo.PrivateMessage;
import se.kth.common.model.bo.User;

public class PrivateMessagesServerResource extends ServerResource implements PrivateMessagesResource
{
	String id;
	
	@Override
    public void doInit() throws ResourceException 
    {
        this.id = (String) getRequestAttributes().get("userid");
    }

	@Override
	@Get
	public Representation getMessages()
	{
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		List<PrivateMessage> messages = null;
		Transaction trans = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
		User user = new UserDao().getUser(Integer.parseInt(id));
		
		if (user != null) {
			messages = new PrivateMessageDao().getPrivateMessagesTo(user);
		}
    	trans.commit();
    	
    	String jsonString = gson.toJson(messages);
    	Representation jsonRep = new JsonRepresentation(jsonString);
    	
    	
    	
    	return jsonRep;
	}
}
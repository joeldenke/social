package se.kth.backend.resource;

import java.io.IOException;

import org.hibernate.Transaction;
import org.json.simple.JSONArray;
import org.restlet.data.Form;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.EmptyRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Post;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import se.kth.backend.model.dao.UserDao;
import se.kth.common.AuthResource;
import se.kth.common.Converter;
import se.kth.common.model.bo.User;

/**
 * @author Mats Maatson and Joel Denke
 * @description ServerResource taking care of login requests
 */
public class AuthServerResource extends ServerResource implements AuthResource {
	
	UserDao ud;
	
	@Override
    public void doInit() throws ResourceException 
    {
        this.ud = new UserDao();
    }
	
	@Override
	public Representation login(Representation entity) throws IOException
	{
		JsonRepresentation jsonRep = new JsonRepresentation(entity);
		
		JSONArray jsonArray = Converter.fromJson(jsonRep.getText(), JSONArray.class);
		
		User tmp = new User();
		tmp.setUsername((String) jsonArray.get(0));
		//tmp.setPassword(SecurityUtils.getHash(password));
		
		Transaction trans = null;
				
		try {
			trans = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			
			User user = new UserDao().getUser(tmp);
			trans.commit();
		
			// Funkar inte med Hibernate att skicka med password, den lyckas inte matcha SHA256 av någon anledning
			if (user != null && user.getPassword().equals(SecurityUtils.getHash((String) jsonArray.get(1)))) {
				String jsonString = Converter.toJson(user);
				return new JsonRepresentation(jsonString);
			} else {
				return new EmptyRepresentation();
			}
		} catch (RuntimeException e) {
			 return new EmptyRepresentation();
		}
	}
}

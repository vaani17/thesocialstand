package database;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;

public class ofyService {
	
	static{
		factory().register(EntityUser.class);
	}
	public static Objectify ofy()
	{
		return ObjectifyService.ofy();
	}
	public static ObjectifyFactory factory()
	{
		return ObjectifyService.factory();
	}

}

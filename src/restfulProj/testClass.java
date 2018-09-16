package restfulProj;

import java.util.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@SuppressWarnings("unused")
@Path("/Parent")
public class testClass {
	
	ArrayList<customer> cObjLst = new ArrayList<customer>();
	
	@GET
	@Path("/hello")
	public String welcome(){
		return("Hello Subrato");
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/SetCustomer")
	public customer getCustomer(){
		customer cObj = new customer();
		cObj.setAcNo("32357257771");
		cObj.setId(420);
		cObjLst.add(cObj);
		return cObj;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML )
	@Path("/getObj/{cID}")
	public customer getCustomer( @PathParam("cID") String id){
		customer c = null;
		System.out.println(id + cObjLst.size());
		
		customer cObj = new customer();
		cObj.setAcNo("32357257771");
		cObj.setId(420);
		cObjLst.add(cObj);
		
		for(customer cOb : cObjLst ){
			if( cOb.getId() == Integer.parseInt(id) ){
				c = cOb;
				break;
			}
		}
		return c;
	}
}

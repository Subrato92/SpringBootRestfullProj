package restfulProj;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class customerService {
	
	@GET
	@Path("/cust")
	public String getmsg(){
		return "hello";
	}
	
	@POST
	@Path("/custAdd")
	@Produces({"application/xml","application/json"})
	@Consumes(MediaType.APPLICATION_XML)
	public List<customer> addCustomer(customer c){
		List<customer> lst = new ArrayList<customer>();
		System.out.println("In ADD:"+ c.getId());
		customer c1 = new customer();
		customer c2 = new customer();
		
		c1.setId(10);
		c1.setAcNo("Acc01");
		
		c2.setId(20);
		c2.setAcNo("Acc02");
	
		lst.add(c1);
		lst.add(c2);
		
		return lst;		
	}
}

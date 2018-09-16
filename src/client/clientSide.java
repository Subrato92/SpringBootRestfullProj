package client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import restfulProj.customer;

/**
 * Servlet implementation class clientSide
 */
@WebServlet("/clientSide")
public class clientSide extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public clientSide() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Client client = ClientBuilder.newClient();
        /*WebTarget webTarget = client.target("http://localhost:8080/restfulProj/cust");
        Invocation.Builder invocationBuilder = webTarget.request(); //Building Req
         */        
		
		WebTarget webTarget = client.target("http://localhost:8080/restfulProj/custAdd");
        Invocation.Builder invocationBuilder = webTarget.request(); //building invocation.Builder
        
        /** Uncomment to work with PATH Parameter in the service 
        WebTarget webTarget = client.target("http://localhost:8080/FirstProject/SwaggerService/custList");
        Invocation.Builder invocationBuilder = webTarget.path("1001").request(MediaType.APPLICATION_XML);
        **/
        customer cObj = new customer();
        cObj.setAcNo("newAccount");
        cObj.setId(420);
        
        //final String resp = invocationBuilder.build("POST").invoke().readEntity(cObj.class); //Invoking req
        Response resp = invocationBuilder.accept(MediaType.APPLICATION_JSON).post(Entity.entity(cObj, MediaType.APPLICATION_XML)); // Receiving Response
        PrintWriter out=response.getWriter();
        out.println(resp.readEntity(String.class)); //readEntity(customer.class)
        
        //Customer c1 = invocationBuilder.get(Customer.class);
        
        //PrintWriter out=response.getWriter();
        //out.println(c1.getName()+"<br>");
        //out.println(c1.getPhno());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

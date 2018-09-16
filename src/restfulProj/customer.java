package restfulProj;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "customer" )
public class customer implements Serializable {
	private int id;
	private String acNo;
	public int getId() {
		return id;
	}
	@XmlElement
	public void setId(int id) {
		this.id = id;
	}
	public String getAcNo() {
		return acNo;
	}
	@XmlElement
	public void setAcNo(String acNo) {
		this.acNo = acNo;
	}

}

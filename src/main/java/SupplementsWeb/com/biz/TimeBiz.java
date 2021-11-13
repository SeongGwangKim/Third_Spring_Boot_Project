package SupplementsWeb.com.biz;

import SupplementsWeb.com.dao.TimeDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class TimeBiz {
	
	@Autowired
	private TimeDaoImpl timeDaoImpl;
	
	public String getTime() {
		String res= timeDaoImpl.getTime();
		return res;
	}
	
}

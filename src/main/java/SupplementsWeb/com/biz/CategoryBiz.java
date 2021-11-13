package SupplementsWeb.com.biz;

import SupplementsWeb.com.dao.CategoryDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CategoryBiz {
	
	@Autowired
	private CategoryDaoImpl categoryDaoImpl;

	public String getCategory(int categoryNum){
		String res= categoryDaoImpl.getCategory(categoryNum);
		return res;
	}
}

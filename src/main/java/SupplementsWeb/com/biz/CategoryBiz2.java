package SupplementsWeb.com.biz;

import SupplementsWeb.com.dao.CategoryDaoImpl2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategoryBiz2 {
	
	@Autowired
	private CategoryDaoImpl2 categoryDaoImpl2;

	public String getCategory(int categoryNum){
		String res= categoryDaoImpl2.getCategory(categoryNum);
		return res;
	}
	
}

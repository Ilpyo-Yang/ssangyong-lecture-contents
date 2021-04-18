package common.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myshop.model.*;

public class HomeAction extends AbstractController {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		InterProductDAO dao = new ProductDAO();
		List<ImageVO> imgList = dao.imageSelectAll();
		
		request.setAttribute("imgList", imgList);
		
	//	super.setRedirect(false);
		super.setViewPage("/WEB-INF/home.jsp");
	}

}

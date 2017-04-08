package com.ProjectPhh.www;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController{
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		return "main/index";
	}
	
	@RequestMapping(value = "/board_list.do", method = RequestMethod.GET)
	public String generic(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
			Connection conn = null; // null로 초기화 한다.
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			boardBean bean = null ;
		try{

			String url = "jdbc:mysql://175.210.54.233/phh";        // 사용하려는 데이터베이스명을 포함한 URL 기술
			String id = "root";                                                    // 사용자 계정
			String pw = "root1234";                                                // 사용자 계정의 패스워드
		
			Class.forName("com.mysql.jdbc.Driver");                       // 데이터베이스와 연동하기 위해 DriverManager에 등록한다.
			conn=DriverManager.getConnection(url,id,pw);              // DriverManager 객체로부터 Connection 객체를 얻어온다.
			
			String sql = "select b_no , b_title , b_name , b_pass from b_board";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
		List<boardBean> b_list = new ArrayList<boardBean>();
			
			while (rs.next()) {
				bean = new boardBean();
				int num = rs.getInt("b_no");
				String b_title = rs.getString("b_title");
				String b_name = rs.getString("b_name");
				bean.setNum(num);
				bean.setB_title(b_title);
				bean.setB_name(b_name);
				b_list.add(bean);
			}
				
		    model.addAttribute("b_list",b_list);
		    
			}catch(Exception e){                                                    // 예외가 발생하면 예외 상황을 처리한다.
						e.printStackTrace();
			}
		
		 return "board/board_list";
	}

}
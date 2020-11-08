package com.iiht.evaluation.eloan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iiht.evaluation.eloan.dao.ConnectionDao;
import com.iiht.evaluation.eloan.dto.UserDetailsDto;
import com.iiht.evaluation.eloan.model.LoanInfo;
import com.iiht.evaluation.eloan.model.User;
import com.mysql.cj.protocol.Resultset;

@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConnectionDao connDao;

	public void setConnDao(ConnectionDao connDao) {
		this.connDao = connDao;
	}

	public void init(ServletConfig config) {
		String driver = config.getServletContext().getInitParameter("jdbcDriver");
		String jdbcURL = config.getServletContext().getInitParameter("jdbcUrl");
		String jdbcUsername = config.getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = config.getServletContext().getInitParameter("jdbcPassword");
		// System.out.println(jdbcURL + jdbcUsername + jdbcPassword);
		this.connDao = new ConnectionDao(driver, jdbcURL, jdbcUsername, jdbcPassword);
		try {
			connDao.connect();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		String viewName = "";
		try {
			switch (action) {
			case "registernewuser":
				viewName = registernewuser(request, response);
				break;
			case "validate":
				viewName = validate(request, response);
				break;
			case "placeloan":
				viewName = placeloan(request, response);
				break;
			case "application1":
				viewName = application1(request, response);
				break;
			case "editLoanProcess":
				viewName = editLoanProcess(request, response);
				break;
			case "registeruser":
				viewName = registerUser(request, response);
				break;
			case "register":
				viewName = register(request, response);
				break;
			case "application":
				viewName = application(request, response);
				break;
			case "trackloan":
				viewName = trackloan(request, response);
				break;
			case "editloan":
				viewName = editloan(request, response);
				break;
			case "displaystatus":
				viewName = displaystatus(request, response);
				break;
			default:
				viewName = "notfound.jsp";
				break;
			}
		} catch (Exception ex) {

			throw new ServletException(ex.getMessage());
		}
		RequestDispatcher dispatch = request.getRequestDispatcher(viewName);
		dispatch.forward(request, response);
	}

	private String validate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/* write the code to validate the user */
		String UserName = request.getParameter("username");
		String password = request.getParameter("password");
		String AdminUserName = request.getParameter("Adminusername");
		String Adminpassword = request.getParameter("Adminpassword");
		// HttpSession session=request.getSession();
		// request.setAttribute("userName", UserName) ;
		HttpSession session = request.getSession();
		session.setAttribute("userName", UserName);
		// session.setAttribute("UserName",User1);
		User User = new User(UserName, password);

		request.setAttribute("User", User);
		
		if (connDao.validate(User)) {
			return "userhome1.jsp";
		}
			else if (AdminUserName != null && Adminpassword != null && AdminUserName=="admin" && Adminpassword=="admin") {
				return "adminhome1.jsp";
			}
		else {
			throw new Exception("Invalid username or password");
		}
		
		
	}

	private String placeloan(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		/* write the code to place the loan information */
		HttpSession session = request.getSession();
		String UserName=session.getAttribute("userName").toString(); 
	    //String UserName = request.getParameter("userName");
		String applno = request.getParameter("applno");
		String purpose = request.getParameter("purpose");
		int amtrequest = Integer.parseInt(request.getParameter("amtrequest"));
		String doa = request.getParameter("doa");
		String bstructure = request.getParameter("bstructure");
		String bindicator = request.getParameter("bindicator");
		String TaxIndicator = request.getParameter("TaxIndicator");
		String address = request.getParameter("address");
		String PinCode = request.getParameter("PinCode");
		String email = request.getParameter("email");
		long mobile = Long.parseLong(request.getParameter("mobile"));
		String status = "Pending";
		LoanInfo LoanInfo=new LoanInfo(UserName, applno, purpose, amtrequest, doa, bstructure, bindicator, TaxIndicator, address, PinCode, email, mobile, status);
		request.setAttribute("LoanInfo", LoanInfo);

		connDao.InsertLoanDetails(LoanInfo);
		
		
		return "userhome1.jsp";
	}

	private String application1(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		/* write the code to display the loan application page */

		return null;
	}

	private String editLoanProcess(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		/* write the code to edit the loan info */
		/*String applno= request.getParameter("applno");
		LoanInfo LoanInfo = new LoanInfo(applno);
		request.setAttribute("LoanInfo", LoanInfo);
		HttpSession session = request.getSession();
		session.getAttribute(applno);
		System.out.println(applno);*/
		String applno = request.getParameter("applno");
		String purpose = request.getParameter("purpose");
		int amtrequest = Integer.parseInt(request.getParameter("amtrequest"));
		String doa = request.getParameter("doa");
		String bstructure = request.getParameter("bstructure");
		String bindicator = request.getParameter("bindicator");
		String TaxIndicator = request.getParameter("TaxIndicator");
		String address = request.getParameter("address");
		String PinCode = request.getParameter("PinCode");
		String email = request.getParameter("email");
		long mobile = Long.parseLong(request.getParameter("mobile"));
		LoanInfo LoanInfo1=new LoanInfo(applno,purpose,amtrequest, doa, bstructure, bindicator, TaxIndicator, address, PinCode, email, mobile);
		request.setAttribute("LoanInfo", LoanInfo1);
		connDao.UpdateLoanDetails(LoanInfo1);
		return "userhome1.jsp";
	}

	private String registerUser(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		/* write the code to redirect page to read the user details */
		return "newuserui.jsp";
	}

	private String registernewuser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		/*
		 * write the code to create the new user account read from user and return to
		 * index page
		 */
		String FirstName = request.getParameter("Firstname");
		String LastName = request.getParameter("Lastname");
		String UserName = request.getParameter("username");
		Long MobileNumber = Long.parseLong(request.getParameter("MobileNumber"));
		String password = request.getParameter("password");
		String Email = request.getParameter("Email");
		String birthday = request.getParameter("birthday");
		/*
		 * Date birthday = null; try { birthday = (Date) new
		 * SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthday")); }
		 * catch (ParseException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

		UserDetailsDto UserDetailsDto = new UserDetailsDto(FirstName, LastName, UserName, birthday, MobileNumber,
				password, Email);
		request.setAttribute("UserDetailsDto", UserDetailsDto);

		try {

			connDao.InsertUserDetails(UserDetailsDto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "index.jsp";
	}

	private String register(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		/* write the code to redirect to register page */

		return null;
	}

	private String displaystatus(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		/*
		 * write the code the display the loan status based on the given application
		 * number
		 */
		String applno= request.getParameter("applno");
		LoanInfo LoanInfo = new LoanInfo(applno);
		request.setAttribute("LoanInfo", LoanInfo);
		String status= connDao.GetLoanStatus(LoanInfo);
		LoanInfo.setStatus(status);
		HttpSession session = request.getSession();
		session.setAttribute("status", status);
		
		//Used loanDetails.jsp for displaying status
		
		return "loanDetails.jsp";
	}

	private String editloan(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		/* write a code to return to editloan page */
		String applno= request.getParameter("applno");
		
		LoanInfo LoanInfo = new LoanInfo(applno);
		LoanInfo.setApplno(applno);
		request.setAttribute("LoanInfo", LoanInfo);
		ResultSet rs= connDao.EditLoanDetails(LoanInfo);
		String purpose=rs.getString(3);
		int amtrequest=rs.getInt(4); 
		String doa=rs.getString(5);
		String bstructure=rs.getString(6);
		String bindicator= rs.getString(7); 
		String TaxIndicator=rs.getString(8); 
		Long mobile= rs.getLong(12);
		String email= rs.getString(11);
		String address= rs.getString(9);
		Long PinCode= rs.getLong(10);

		HttpSession session = request.getSession();
		session.setAttribute("applno", applno);
		session.setAttribute("purpose", purpose);
		session.setAttribute("amtrequest", amtrequest);
		session.setAttribute("doa", doa);
		session.setAttribute("bstructure", bstructure);
		session.setAttribute("bindicator", bindicator);
		session.setAttribute("TaxIndicator", TaxIndicator); 
		session.setAttribute("mobile", mobile);
		session.setAttribute("email", email);
		session.setAttribute("address", address);
		session.setAttribute("PinCode", PinCode);
		
		return "editloanui.jsp";
		
		
		
	}

	private String trackloan(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		/* write a code to return to trackloan page */
		
		return null;
	}

	private String application(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		/* write a code to return to trackloan page */
		return null;
	}
}
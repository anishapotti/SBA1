package com.iiht.evaluation.eloan.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.lang.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iiht.evaluation.eloan.dao.ConnectionDao;
import com.iiht.evaluation.eloan.dto.LoanDto;
import com.iiht.evaluation.eloan.model.ApprovedLoan;
import com.iiht.evaluation.eloan.model.LoanInfo;

@WebServlet("/admin")
public class AdminController extends HttpServlet {
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
		System.out.println(jdbcURL + jdbcUsername + jdbcPassword);
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
		System.out.println(action);
		String viewName = "";
		try {
			switch (action) {
			case "listall":
				viewName = listall(request, response);
				break;
			case "process":
				viewName = process(request, response);
				break;
			case "callemi":
				viewName = calemi(request, response);
				break;
			case "updatestatus":
				viewName = updatestatus(request, response);
				break;
			case "logout":
				viewName = adminLogout(request, response);
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

	private String updatestatus(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		/* write the code for updatestatus of loan and return to admin home page */

		return null;
	}

	private String calemi(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		/* write the code to calculate emi for given applno and display the details */
		
		String applno = request.getParameter("applno");		
		int amotsanctioned = Integer.parseInt(request.getParameter("amotsanctioned"));
		int loanterm = Integer.parseInt(request.getParameter("loanterm"));
		//int emi = Integer.parseInt(request.getParameter("emi"));
		String psd = request.getParameter("psd");
		String lcd = request.getParameter("lcd");
		String status= request.getParameter("status");
		//int termpaymentamount = Integer.parseInt(request.getParameter("termpaymentamount"));
		float interestRate = Float.parseFloat(request.getParameter("interestRate"));
		int termpaymentamount=(int)(amotsanctioned*Math.pow(((1+interestRate)/100),loanterm));
		int emi = termpaymentamount/loanterm;
		ApprovedLoan ApprovedLoan1=new ApprovedLoan(applno,amotsanctioned, loanterm, psd, lcd, emi, termpaymentamount,interestRate,status);
		System.out.println(ApprovedLoan1);
		request.setAttribute("ApprovedLoan", ApprovedLoan1);
		connDao.ApproveLoanDetails(ApprovedLoan1);
		
		return "adminhome1.jsp";

		
	}

	private String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		/* return to process page */
		String applno = request.getParameter("applno");

		LoanInfo LoanInfo = new LoanInfo(applno);
		LoanInfo.setApplno(applno);
		request.setAttribute("LoanInfo", LoanInfo);
		ResultSet rs = connDao.EditLoanDetails(LoanInfo);
		String purpose = rs.getString(3);
		int amtrequest = rs.getInt(4);
		String doa = rs.getString(5);
		String bstructure = rs.getString(6);
		String bindicator = rs.getString(7);
		String TaxIndicator = rs.getString(8);
		Long mobile = rs.getLong(12);
		String email = rs.getString(11);
		String address = rs.getString(9);
		Long PinCode = rs.getLong(10);
		String status = rs.getString(13);
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
		session.setAttribute("status", status);
		return "calemi.jsp";
	}

	private String adminLogout(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		/* write code to return index page */
		return null;
	}

	private String listall(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		/* write the code to display all the loans */

		List<LoanInfo> ListLoan = connDao.ListLoanDetails();
		request.setAttribute("ListLoan", ListLoan);
		/*
		 * while(ListLoan.next()) { loaninfo.setUserName(ListLoan.getString(1));
		 * loaninfo.setApplno(ListLoan.getString(2));
		 * loaninfo.setPurpose(rs.getString(3)); loaninfo.setAmtrequest(rs.getInt(4));
		 * loaninfo.setDoa(rs.getString(5)); loaninfo.setBstructure(rs.getString(6));
		 * loaninfo.setBindicator(rs.getString(7));
		 * loaninfo.setTaxIndicator(rs.getString(8));
		 * loaninfo.setAddress(rs.getString(9)); loaninfo.setPinCode(rs.getString(10));
		 * loaninfo.setEmail(rs.getString(11)); loaninfo.setMobile(rs.getLong(12));
		 * loaninfo.setStatus(rs.getString(13));
		 */

		return "listall.jsp";
	}

}
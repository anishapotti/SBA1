package com.iiht.evaluation.eloan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import com.iiht.evaluation.eloan.dto.LoanDto;
import com.iiht.evaluation.eloan.model.ApprovedLoan;
import com.iiht.evaluation.eloan.model.LoanInfo;
import com.iiht.evaluation.eloan.model.User;
import com.iiht.evaluation.eloan.dto.UserDetailsDto;

public class ConnectionDao {
	private static final long serialVersionUID = 1L;
	private String driverName;
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private static Connection jdbcConnection;

	public ConnectionDao(String driverName, String jdbcURL, String jdbcUsername, String jdbcPassword) {
		this.driverName = driverName;
		this.jdbcURL = jdbcURL;
		this.jdbcUsername = jdbcUsername;
		this.jdbcPassword = jdbcPassword;
	}

	public Connection connect() throws SQLException, ClassNotFoundException {
		if (jdbcConnection == null || jdbcConnection.isClosed()) {
			Class.forName(this.driverName);
			jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			System.out.println("Connected");
		}
		return jdbcConnection;
	}

	public void disconnect() throws SQLException {
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}

	// put the relevant DAO methods here..

	public int InsertUserDetails(UserDetailsDto UserDetailsDto) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		// ConnectionDao.connect();
		int result = 0;
		try {
			this.connect();

			String SQL = "insert into eLoan.CustDetails (FirstName,LastName,UserName,birthday,MobileNumber,Email,Password) values (?,?,?,?,?,?,?)";
			PreparedStatement pstmt = jdbcConnection.prepareStatement(SQL);
			pstmt.setString(1, UserDetailsDto.getFirstname());
			pstmt.setString(2, UserDetailsDto.getLastname());
			pstmt.setString(3, UserDetailsDto.getUsername());
			pstmt.setString(4, UserDetailsDto.getBirthday());
			pstmt.setLong(5, UserDetailsDto.getMobileNumber());
			pstmt.setString(6, UserDetailsDto.getEmail());
			pstmt.setString(7, UserDetailsDto.getPassword());
			result = pstmt.executeUpdate();
			System.out.println("Dao...");
			// jdbcConnection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public boolean validate(User User) {
		boolean status = false;
		try {

			String LoginSQL = "select * from eLoan.CustDetails where UserName=? and Password=?";
			PreparedStatement pstmt = jdbcConnection.prepareStatement(LoginSQL);
			pstmt.setString(1, User.getUsername());
			pstmt.setString(2, User.getPassword());

			ResultSet rs = pstmt.executeQuery();
			status = rs.next();

		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public int InsertLoanDetails(LoanInfo LoanInfo) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		// ConnectionDao.connect();
		int result = 0;
		try {
			this.connect();

			String SQL = "insert into eLoan.LoanDetails (UserName,applno,purpose,amtrequest,doa,bstructure,bindicator,TaxIndicator,address\r\n"
					+ ",PinCode,email,mobile,status" + ") values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = jdbcConnection.prepareStatement(SQL);
			pstmt.setString(1, LoanInfo.getUserName());
			pstmt.setString(2, LoanInfo.getApplno());
			pstmt.setString(3, LoanInfo.getPurpose());
			pstmt.setInt(4, LoanInfo.getAmtrequest());
			pstmt.setString(5, LoanInfo.getDoa());
			pstmt.setString(6, LoanInfo.getBstructure());
			pstmt.setString(7, LoanInfo.getBindicator());
			pstmt.setString(8, LoanInfo.getTaxIndicator());
			pstmt.setString(9, LoanInfo.getAddress());
			pstmt.setString(10, LoanInfo.getPinCode());
			pstmt.setString(11, LoanInfo.getEmail());
			pstmt.setLong(12, LoanInfo.getMobile());
			pstmt.setString(13, LoanInfo.getStatus());
			result = pstmt.executeUpdate();
			System.out.println("Dao...");
			// jdbcConnection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public String GetLoanStatus(LoanInfo loanInfo) throws SQLException {
		// TODO Auto-generated method stub
		ResultSet rs;

		String LoanstatusSQL = "select * from eLoan.LoanDetails where applno=?";
		PreparedStatement pstmt = jdbcConnection.prepareStatement(LoanstatusSQL);
		pstmt.setString(1, loanInfo.getApplno());
		rs = pstmt.executeQuery();
		// List<LoanInfo> LoanInfolist = new ArrayList<LoanInfo>();
		String loanInfo1 = null;
		while (rs.next()) {
			loanInfo1 = rs.getString(13);
			// LoanInfolist.add(loanInfo1);

			return loanInfo1;

		}

		rs.close();
		pstmt.close();
		return loanInfo1;

	}

	public ResultSet EditLoanDetails(LoanInfo LoanInfo) throws Exception {
		// TODO Auto-generated method stub
		ResultSet rs;
		

		String EditLoanSQL = "select * from eLoan.LoanDetails where applno=?";
		PreparedStatement pstmt = jdbcConnection.prepareStatement(EditLoanSQL);
		pstmt.setString(1, LoanInfo.getApplno());
		rs = pstmt.executeQuery();
		// System.out.println(rs.getString("status"));
		// List<LoanInfo> LoanInfolist = new ArrayList<LoanInfo>();
		while (rs.next()) {
			String status = rs.getString(13);
			// System.out.println(rs.getString(5));
			if (status.equals("Pending") ||status.equals("OnHold")) {
				/*
				 * System.out.println(rs.getString(13)); LoanInfo Loaninfo = new
				 * LoanInfo(rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6),
				 * rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
				 * rs.getString(11), rs.getLong(12)); System.out.println(Loaninfo);
				 */

				return rs;
			}
			else {
				throw new Exception("Cannot Edit Approved Loans");
		}
		}
		/*
		 * else { System.out.println("Application is not in pending status");
		 * 
		 * }
		 */
		return rs;

		

	}

	public void UpdateLoanDetails(LoanInfo LoanInfo) throws SQLException {
		// TODO Auto-generated method stub
		
		String SQL = "UPDATE eLoan.LoanDetails  SET purpose=?,amtrequest=?,doa=?,bstructure=?,bindicator=?,TaxIndicator=?,address=?"
				+ ",PinCode=?,email=?,mobile=?" + " where applno=?";

		PreparedStatement pstmt = jdbcConnection.prepareStatement(SQL);
		
		pstmt.setString(1, LoanInfo.getPurpose());
		pstmt.setInt(2, LoanInfo.getAmtrequest());
		pstmt.setString(3, LoanInfo.getDoa());
		pstmt.setString(4, LoanInfo.getBstructure());
		pstmt.setString(5, LoanInfo.getBindicator());
		pstmt.setString(6, LoanInfo.getTaxIndicator());
		pstmt.setString(7, LoanInfo.getAddress());
		pstmt.setString(8, LoanInfo.getPinCode());
		pstmt.setString(9, LoanInfo.getEmail());
		pstmt.setLong(10, LoanInfo.getMobile());
		pstmt.setString(11, LoanInfo.getApplno());
		System.out.println(pstmt);
		pstmt.executeUpdate();
	}

	public List<LoanInfo> ListLoanDetails() throws SQLException {
		// TODO Auto-generated method stub
		ResultSet rs;
		//LoanInfo loaninfo=new LoanInfo();

		String EditLoanSQL = "select * from eLoan.LoanDetails";
		PreparedStatement pstmt = jdbcConnection.prepareStatement(EditLoanSQL);

		rs = pstmt.executeQuery();
		/*
		while (rs.next()) {
			/*LoanInfo Loaninfo = new LoanInfo(rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6),
					  rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
					  rs.getString(11), rs.getLong(12),rs.getString(13)); 
			loaninfo.setUserName(rs.getString(1));
			loaninfo.setApplno(rs.getString(2));
			loaninfo.setPurpose(rs.getString(3));
			loaninfo.setAmtrequest(rs.getInt(4));
			loaninfo.setDoa(rs.getString(5));
			loaninfo.setBstructure(rs.getString(6));
			loaninfo.setBindicator(rs.getString(7));
			loaninfo.setTaxIndicator(rs.getString(8));
			loaninfo.setAddress(rs.getString(9));
			loaninfo.setPinCode(rs.getString(10));
			loaninfo.setEmail(rs.getString(11));
			loaninfo.setMobile(rs.getLong(12));
			loaninfo.setStatus(rs.getString(13));
			System.out.println(loaninfo.getStatus());

			*/
		List<LoanInfo> LoanDetails = new ArrayList<LoanInfo>();
		while(rs.next()) {
			LoanInfo LoanDetail = new LoanInfo(rs.getString(1),rs.getString(2),rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6),
					  rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
					  rs.getString(11), rs.getLong(12),rs.getString(13));
			LoanDetails.add(LoanDetail);
		}
		System.out.println(LoanDetails);

		
		return LoanDetails;
		
	}

	public ResultSet AdminProcessLoandetails(LoanInfo LoanInfo) throws SQLException {
		// TODO Auto-generated method stub
		ResultSet rs;
		

		String EditLoanSQL = "select * from eLoan.LoanDetails where applno=?";
		PreparedStatement pstmt = jdbcConnection.prepareStatement(EditLoanSQL);
		pstmt.setString(1, LoanInfo.getApplno());
		rs = pstmt.executeQuery();
		// System.out.println(rs.getString("status"));
		// List<LoanInfo> LoanInfolist = new ArrayList<LoanInfo>();
		while (rs.next()) {
			
				return rs;
			}
		return rs;
			
		}

			
	

	public void ApproveLoanDetails(ApprovedLoan ApprovedLoan) throws SQLException {
		// TODO Auto-generated method stub
		String SQL = "UPDATE eLoan.LoanDetails  SET amotsanctioned=?,loanterm=?,psd=?,lcd=?,emi=?,termpaymentamount=?,interestRate=?,status=?"
				 + " where applno=?";
		
		PreparedStatement pstmt = jdbcConnection.prepareStatement(SQL);
		
		pstmt.setInt(1, ApprovedLoan.getAmotsanctioned());
		pstmt.setInt(2, ApprovedLoan.getLoanterm());
		pstmt.setString(3, ApprovedLoan.getPsd());
		pstmt.setString(4, ApprovedLoan.getLcd());
		pstmt.setInt(5, ApprovedLoan.getEmi());
		pstmt.setInt(6, ApprovedLoan.getTermpaymentamount());	
		pstmt.setFloat(7, ApprovedLoan.getInterestRate());		
		pstmt.setString(8, ApprovedLoan.getStatus());
		pstmt.setString(9, ApprovedLoan.getApplno());	
		System.out.println(pstmt);
		pstmt.executeUpdate();
		
		
	}

}

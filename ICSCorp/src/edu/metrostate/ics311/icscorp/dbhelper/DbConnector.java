package edu.metrostate.ics311.icscorp.dbhelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import edu.metrostate.ics311.icscorp.Record;

public class DbConnector {

	private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	final private String host = "127.0.0.1";
	final private String user = "root";
	final private String passwd = "Superman_4";
	final private String database = "icscorp";

	public DbConnector() {
	}

	public Object[] getTable(String tableName) throws SQLException, ClassNotFoundException {
		Record record = null;
		Object[] infoArr = null;
		String[][] tableInfo;
		String[] actual;
		String[] var;
		Class.forName("com.mysql.jdbc.Driver");
		connect = DriverManager.getConnection(
				"jdbc:mysql://" + host + "/" + database + "?" + "user=" + user + "&password=" + passwd);
		try (Statement stmnt = connect.createStatement(); ResultSet rs = stmnt.executeQuery(String.format("select * from %s", tableName));) {
			List<Record> recordList = new ArrayList<>();
			
			switch (tableName) {
			case "employee_info":
				tableInfo = new Record().getEmployeeInfoTable();
				actual = tableInfo[2];
				var = tableInfo[1];
				while (rs.next()) {
					record = new Record();
					
					String empNum = rs.getString("employee_num");
					record.setEmpNum(empNum);
					String name = rs.getString("name");
					record.setName(name);
					String depNum = rs.getString("department_no");
					record.setDeptNo(depNum);
					String managerName = rs.getString("manager_name");
					record.setManagerName(managerName);
					String empStatus = rs.getString("employee_status");
					record.setEmpStatus(empStatus);
					String startDate = rs.getString("start_date");
					record.setStartDate(startDate);
					recordList.add(record);
				}
				infoArr = new Object[] {recordList, record.getEmployeeInfoTable()};
				break;
				
				case "managers":
					while (rs.next()) {
						
					}
			}
			
			return infoArr;
		}
	}

	public void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {

		}
	}
}

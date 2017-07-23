package edu.metrostate.ics311.icscorp;
import javafx.beans.property.StringProperty ;
import javafx.beans.property.SimpleStringProperty ;

public class Record {
	
	private String address;
	private String serviceArea;
	private String deptNo;
	private String deptName;
	private String empNum;
	private String managerName;
	private String phoneNum; 
	private String name;
	private String empStatus;
	private String startDate;
	private String title;
	private String from_date;
	
	public Record() {
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	public void setServiceArea(String serviceArea) {
		this.serviceArea = serviceArea;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public void setEmpNum(String empNum) {
		this.empNum = empNum;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmpStatus(String empStatus) {
		this.empStatus = empStatus;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setFrom_date(String from_date) {
		this.from_date = from_date;
	}
	
	///////////////////////////////////////////////////////////////
	
	public String getAddress() {
		return address;
	}
	public String getServiceArea() {
		return serviceArea;
	}
	public String getDeptNo() {
		return deptNo;
	}
	public String getDeptName() {
		return deptName;
	}
	public String getEmpNum() {
		return empNum;
	}
	public String getManagerName() {
		return managerName;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public String getName() {
		return name;
	}
	public String getEmpStatus() {
		return empStatus;
	}
	public String getStartDate() {
		return startDate;
	}
	public String getTitle() {
		return title;
	}
	public String getFrom_date() {
		return from_date;
	}
	
	public String[][] getEmployeeInfoTable(){
		
		String[] colNames = new String[]{
				"Employee Number", //0
				"Name",            //1
				"Department Number", //2
				"Manager Name",     //3
				"Employee Status",  //4
				"Start Date"        //5
		};
		String[] varNames = new String[]{
				"empNum", 		   //0
				"name",            //1
				"depNum",          //2
				"managerName",     //3
				"empStatus",       //4
				"startDate"        //5
		};
		String[] colActual = new String[]{
				"employee_num", //0
				"name",            //1
				"department_num", //2
				"manager_name",     //3
				"employee_status",  //4
				"start_date"        //5
		};
		return new String[][] {colNames, varNames, colActual};
	}
}
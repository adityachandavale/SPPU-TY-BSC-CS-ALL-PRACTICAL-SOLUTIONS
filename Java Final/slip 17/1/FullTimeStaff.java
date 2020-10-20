class FullTimeStaff extends Staff{
	private String dept;
	private float salary;
	
	public FullTimeStaff(){
	
	}
	
	public FullTimeStaff(String name,String address,String dept,float salary){
		super(name,address);
		this.dept=dept;
		this.salary=salary;
	}
	public void display(){
		super.display();
		System.out.println("Department is "+dept);
		System.out.println("Salary is "+salary);
	}
}
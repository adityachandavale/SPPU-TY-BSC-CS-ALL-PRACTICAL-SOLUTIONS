class PartTimeStaff extends Staff{
	private int nhrs;
	private int rate;
	
	public PartTimeStaff(){
	
	}
	public PartTimeStaff(String name,String address,int nhrs,int rate){
		super(name,address);
		this.nhrs=nhrs;
		this.rate=rate;
	}
	public void display(){
		super.display();
		System.out.println("Number of hours worked is "+nhrs);
		System.out.println("Rate per hour is "+rate);
		System.out.println("total salary is "+(nhrs*rate));
	}
}
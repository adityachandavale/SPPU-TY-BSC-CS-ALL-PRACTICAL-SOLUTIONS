abstract class Staff{
	protected String name;
	protected String address;
	
	public Staff(){
	
	}
	public Staff(String name,String addr){
		this.name=name;
		address=addr;
	}
	public void display(){
		System.out.println("Name is "+name);
		System.out.println("Address is "+address);
	}
}
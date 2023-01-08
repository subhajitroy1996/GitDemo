package practisewithMaven;

public class MethodsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MethodsDemo m= new MethodsDemo();
		m.Welcome(null);//Method belongs to a class, so to access we need to create an object of the class.
		Exit();
		
		MethodsDemo2 Dm2= new MethodsDemo2(); //creating object of class so that we can use its method
		System.out.println(Dm2.Dem());
	}
 public void Welcome(String s) // we cannot create a Method inside main.
 {
System.out.println("Method inside Class");
		 
 }
 public static void Exit() 
 {
	System.out.println("We exit, static method doesnt belong to any class, so to call it we dont need to create an object of the class"); 
 }
}

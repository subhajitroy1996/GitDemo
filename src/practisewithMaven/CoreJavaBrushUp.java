package practisewithMaven;

import java.util.ArrayList;

public class CoreJavaBrushUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name="Raj";
		System.out.println("The name is :"+name);
		int[] arr= new int[3];
		arr[0]=1;
		arr[1]=2;
		arr[2]=10;
		int[] arr2= {1,3,45,62,10};
		System.out.println(arr2[4]);
		for(int i=0;i<arr2.length;i++)
		{
			System.out.println(arr2[i]);
		}
		String[] str= {"Kumir","Hippo","Elephant"};
//		for(int i=0;i<str.length;i++) //Normal For Loop
//		{
//			System.out.println(str[i]);
//		}
		for(String s:str) // Advanced For Loop
		{
			System.out.println(s);
		}
		for(int j:arr2)
		{
			if(j%2==0)
			{
				System.out.println(j);
			}
		}
		ArrayList<String> alist= new ArrayList<String>();//it is used to store elements(String in this case) and has dynamic size.
		alist.add("Noden");
		alist.add("Nimai");
		System.out.println(alist.get(1));
		alist.remove(1);
		System.out.println(alist);
		//string in Java is an Object that represents a sequence of characters
		String s1="Nirmala"; // if we create an object like this and 2 of them have same values then it will only make the other variable point to this location, wouldnt create a new space for this.
		String s2="Nirmala";
		
		String s3= new String("Nirmala Pandit");//this is string literal.
		String s4= new String("Nirmala Pandit"); //this way of creating the object will create both the objects even if they contain the same value.
		
		String[] s5=s3.split(" ");
		System.out.println(s5[1]);
		for(int i=0;i<s3.length();i++)
		{
		System.out.println(s3.charAt(s3.length()-i-1));	
		}
		
		
	}

}

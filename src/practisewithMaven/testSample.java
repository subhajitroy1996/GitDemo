package practisewithMaven;

import java.io.IOException;
import java.util.ArrayList;

public class testSample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		DataDriven d=new DataDriven();
		ArrayList data=d.getdata("delete profile");
		int l=data.size(); 
		for(int i=0;i<l;i++)
		{
			System.out.println(data.get(i));
		}
		
	}

}

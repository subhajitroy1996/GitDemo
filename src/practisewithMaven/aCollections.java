package practisewithMaven;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;



public class aCollections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//ArrayList<String> a=["Pandit","Nirmala"];
//System.out.println(a[0]);
HashMap<Integer,String> hm=new HashMap<Integer,String>();
hm.put(0, "UK");
hm.get(0);
Set s=hm.entrySet();
Iterator it=s.iterator();
while(it.hasNext())
{
	Map.Entry mp=(Map.Entry)it.next();
	System.out.println(mp.getKey());
	System.out.println(mp.getValue());
	
	}
	}

}

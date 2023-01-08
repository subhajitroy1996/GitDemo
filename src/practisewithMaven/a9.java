package practisewithMaven;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class a9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ArrayList<String> a=new ArrayList<String>();
a.add("Abhi");
a.add("Teja");
a.add("Ajay");
Long size=a.stream().filter(b->b.startsWith("A")).count();
System.out.println(size);
Stream.of("Pandit","Mandi","Hizra","Mota").filter(c->c.length()>4).map(c->c.toUpperCase()).forEach(c->System.out.println(c));

List<String> name=Arrays.asList("Hippo","Truck","Elephant","Bus");
name.stream().sorted().map(b->b.toUpperCase()).forEach(b->System.out.println(b));

Stream<String> newst=Stream.concat(a.stream(), name.stream());
System.out.println(newst.anyMatch(c->c.equalsIgnoreCase("bus")));

List<Integer> un=Arrays.asList(3,2,2,7,1,9,7);
System.out.println(un.stream().distinct().sorted());

//System.out.println(un.stream().sorted().collect(Collectors.toSet()));
	}

}

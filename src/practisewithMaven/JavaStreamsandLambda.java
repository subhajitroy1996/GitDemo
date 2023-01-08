package practisewithMaven;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaStreamsandLambda {
	public static void main(String[] args) {
	StreamFilter();
//	convert();
	}
	@Test
	public static void StreamFilter()
	{ArrayList<String> s=new ArrayList<String>();
	s.add("Abhi");
	s.add("Teja");
	s.add("Adam");
	s.add("Ramesh");
	s.add("Ankur");
//	There is no life for intermediate operation if there is no terminal operation
//	terminal op will execute only if intermediate op(filter) returns true
	
	Long c=s.stream().filter(a->a.startsWith("A")).count();
	//deriving from ArrayList to Stream and using Lambda function.
	System.out.println(c);
	long d=Stream.of("Nirmala","Nimai","Rinku","Noice").filter(b->//creating a stream
	{b.startsWith("N");
	return false;
		
	}).count();
	System.out.println(d);	
	s.stream().filter(fil->fil.length()>4).limit(1).forEach(fil->System.out.println(fil));//limit and count are the terminal ops
	Stream.of("Manish","Anirudh","Phani","Dumba").filter(a->a.endsWith("h")).map(a->a.toUpperCase()).forEach(a->System.out.println(a));
	Stream.of("Manish","Anirudh","Phani","Dumba").sorted().map(a->a.toUpperCase()).forEach(a->System.out.println(a));
	String[] name= {"Rohit","Virat","Bumrah","Zahir"};
	List<String> n1=Arrays.asList(name);
	Stream<String> namelist=Stream.concat(s.stream(), n1.stream());
//	namelist.sorted().forEach(a->System.out.println(a));//once a stream is modified we cannot again write on the stream.
	boolean m=namelist.anyMatch(a->a.equalsIgnoreCase("TEJA"));
	System.out.println(m);
	Assert.assertTrue(m);
	}
	@Test
	public static void convert()
	{
		List<String> b=Stream.of("Manish","Anirudh","Phani","Dumba").map(a->a.toUpperCase()).collect(Collectors.toList());
		System.out.println(b.get(0));
		List<Integer> a=Arrays.asList(1,2,4,5,2,1,3,8);
		List<Integer> it=a.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(it.get(2));
	}
}


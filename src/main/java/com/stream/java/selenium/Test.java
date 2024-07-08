package com.stream.java.selenium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// task :- count the number of names starting from A in the list
		/*List<String> names = new ArrayList<String>();
		names.add("Abhijith");
		names.add("Akash");
		names.add("Rajesh");
		names.add("Akshith");
		names.add("Suresh");
		int count =0;
		// Step:1 iterate though the list(regular java style)
		for(int i=0;i<names.size();i++) {
			String actual = names.get(i);
			
			if(actual.startsWith("A")) {
				count++;
			}
		}
		System.out.println(count);*/
		//streamFilter();
		//mapStreamTest();
		streamCollect();

	}
	
	public static void streamFilter() {
		// task :- count the number of names starting from A in the list using java 8 stream
		
		// Option 1 for creating data 
		List<String> names = new ArrayList<String>();
		names.add("Abhijith");
		names.add("Ak");
		names.add("Raj");
		names.add("Akshith");
		names.add("Suresh");
		
		// option 2 (to make it stream compatiable)
		// intermediate varibale have very short life span
		// there is no life intermediate operation if there is no terminal operation
		// terminal opertaion will excute only if intermediate returns true
		// we can stteam with stteam package
		long co = Stream.of("Abhijith","Akash","Rajesh","Akshith","Suresh").filter(a->a.startsWith("A")).count();
		
		// option 3(if the action is more then one line we can follow below method)
		long te = Stream.of("Abhijith","Akash","Rajesh","Akshith","Suresh").filter(b->
		{
			b.startsWith("A");
			return true;
		}).count();
		
		
		// 1. assign arraylist to streams first(make it stream compatiable)
		// 2. apllay filter based on condition.
		// 'scan' parametr will scan the whole array everytime.
		// left side decaring the parameter
		// right side :- speifying parametr action
		// scan paramter will scan the array paralley (saves time)
		
		
		//Long co = names.stream().filter(scan->scan.startsWith("A")).count();
		//(convert arraylist into stream, applay filter based on condition to the newly created stream and after filtering we will get new stream (stream 2)
		//, on that steam2 u will applay count())
		// intermideidtae operation :- filter 
		// terminal operation :- count
		// datatype count() is long
		System.out.println(co);
		System.out.println(te);
		
		// print all the names in the list(greater then 4 character in the names in list)
		// foreach will take lambda expression  
		names.stream().filter(b->b.length()>4).forEach(a->System.out.println(a));
		
		//only wants to see the smaple of one result
		// foreach will help us scan the second stream created from intermediate operation 
		names.stream().filter(b->b.length()>4).limit(1).forEach(d->System.out.println(d));
		
	}
	
	public static void mapStreamTest() {
		// print the names whihc have last letter 'a' with uppercase
		// to manipulate a steream we can use 'map' / any modification needs to be done on stream
		//Stream.of("Abhijith","Aka","Raja","Akshith","Mah").filter(g->g.endsWith("a")).map(t->t.toUpperCase()).forEach(u->System.out.println(u));
		
		// print names which have first letter 'A' with uppercase and sorted(terminal operation (sorted()))
		//Stream.of("Azgar","Abhijith","Aka","Raja","Akshith","Mah").filter(t->t.startsWith("A")).map(u->u.toUpperCase()).sorted().forEach(o->System.out.println(o));
		
		// array to arraylist
		//List<String> name = Arrays.asList("Azgar","Abhijith","Aka","Raja","Akshith","Mah");
		
		// marge two arraylist
		List<String> name1 = new ArrayList<String>();
		name1.add("Rakshith");
		name1.add("Amogh");
		name1.add("Sneha");
		name1.add("Vibha");
		name1.add("Archana");
		List<String> name2 = Arrays.asList("Azgar","Abhijith","Aka","Raja","Akshith","Mah");
		// first convert these two lists into streams
		Stream<String> newStream  = Stream.concat(name1.stream(), name2.stream());
		//newStream.map(t->t.toUpperCase()).sorted().forEach(y->System.out.println(y));
		
		
		// print true if the given name is present in the new strwma
		boolean tes = newStream.anyMatch(p->p.equalsIgnoreCase("raja"));
		Assert.assertTrue(tes);
		System.out.println(tes);
		
	}
	
	public static void streamCollect()
	{
		// collect your result and convert back into any list or set .
		List<String> newListArray =  Stream.of("Abhijith","Aka","Raja","Akshith","Mah").filter(g->g.endsWith("a")).map(t->t.toUpperCase()).collect(Collectors.toList());
		
		// print first element in the element
		// option 1
		System.out.println(newListArray.get(0));
		
		// option 2
		// using limit 1
		
		// print unique numbers from array and sort that uniue elements
		List<Integer> thy = Arrays.asList(1,6,7,7,9,7,4,7,89,45,77,99,9,99,65);
	 //	thy.stream().distinct().sorted().forEach(u->System.out.println(u));
		
		List<Integer> yu = thy.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(yu.get(3));
		

		
	}

}

package com.lambda.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestLambda {

	
	/*implement eligibility criteria in method*/
	public static void eligibleCandidates(List<Person> pList, int eligibleAge) {
		
		for(Person p : pList) {
			if(p.age > eligibleAge) {
				System.out.println(p.name);
			}
		}
	}
	
	/*implement eligibility criteria in local class*/
	interface SelectEligible{
		public boolean test(Person p);
	}
	
	
	/*print all the eligible candidates*/
	public static void printEligibleCanditateNames(List<Person> pList, SelectEligible tester) {
		for(Person p : pList) {
			if(tester.test(p)) {
				System.out.println(p.name);
			}
		}
	}
	
	public static void main(String[] args) {
		
		
		List<Person> personList = new ArrayList<>(Arrays.asList(
				new Person("Swami", 14),
				new Person("Deepak", 15),
				new Person("Laxmi", 17),
				new Person("Sarala", 18),
				new Person("Mridul", 22),
				new Person("Thanappa", 31),
				new Person("Ramanujan", 21)
				));
		
		//eligibleCandidates(personList, 18);
		
		/*test eligibility by passing a tester implementation using a anonymous class*/
		printEligibleCanditateNames(personList, new SelectEligible() {
			@Override
			public boolean test(Person p) {
				if(p.age >= 18 && p.age < 23) {
					return true;
				}
				return false;
			}
		});
		
		
		System.out.println();
		
		/*The above anonymous inner class expression can be expresses as a lambda expression as below*/
		printEligibleCanditateNames(personList, p -> p.age >= 18 && p.age < 23);
		
		
		
	}
}

package com.example.hospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class Student implements Comparable<Student> {
	String name;
	int marks;

	public Student(String name, int marks) {
		this.name = name;
		this.marks = marks;
	}

	@Override
	public int compareTo(Student o) {
		return o.marks - this.marks;
	}

	@Override
	public String toString() {
		return name + " " + marks;
	}
}

class Box<T> {
	private T item;

	public Box(T item) {
		this.item = item;
	}

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return item.toString();
	}
}

class Pair<T, V> {
	private T first;
	private V second;

	public Pair(T first, V second) {
		this.first = first;
		this.second = second;
	}

	public T getFirst() {
		return first;
	}

	public void setFirst(T first) {
		this.first = first;
	}

	public V getSecond() {
		return second;
	}

	public void setSecond(V second) {
		this.second = second;
	}

	@Override
	public String toString() {
		return first.toString() + " " + second.toString();
	}
}

@SpringBootApplication
public class HospitalApplication {
	/**
	 * Collection Framework is a set of classes and  interfaces that implement commonly reusable data structures like list, sets, queues, maps etc
	 *
	 * 1. List
	 * 	- ArrayList
	 * 	- LinkedList
	 * 	- Vector
	 * 	- Stack
	 * 2. Set
	 * 	- HashSet
	 * 	- TreeSet
	 * 3. Queue
	 * 4. Map
	 * Interators
	 * Comparable
	 */

	public static void main(String[] args) {
		List<String> fruits = new ArrayList<>();
		fruits.add("Orange");
		fruits.add("Banana");
		fruits.add("Apple");
		fruits.add("apple");

		// System.out.println(fruits.get(1));

		// fruits.sort(String::compareTo);

		// Collections.sort(fruits);

		// for (String fruit : fruits) {
		// 	System.out.println(fruit);
		// }

		// Iterator<String> iterator = fruits.iterator();

		// while (iterator.hasNext()) {
		// 	String fruit = iterator.next();
		//  System.out.println(fruit);
		// }

//		ArrayList<Student> students = new ArrayList<>();
//		students.add(new Student("Jimmy", 91));
//		students.add(new Student("Tom", 85));
//		students.add(new Student("Jack", 75));
//		students.add(new Student("Jill", 88));
//
//		Collections.sort(students);
//
//		for (Student student : students) {
//			System.out.println(student);
//		}

//		Box<Integer> integerBox = new Box<>(1234);
//		System.out.println(integerBox.getItem());
//
//		Box<String> stringBox = new Box<>("Hello world");
//		System.out.println(stringBox.getItem());
//
//		List<String> names = new ArrayList<>();

		Pair<String, Integer> pair = new Pair<>("Omraj", 10);
		System.out.println(pair);

		Pair<String, Double> pair1 = new Pair<>("Omraj Sharma", 5.0);
		System.out.println(pair1);


		SpringApplication.run(HospitalApplication.class, args);
	}

}

package Bai10.tuan45;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class QuanLy implements IQuanLy {
	
 private List<Person> dscanbo;
 
 public QuanLy(List<Person> dscanbo) {
	this.dscanbo = new ArrayList<Person>();
}

 public int getsoluong() {
	 return dscanbo.size();
 }
 
 public List<Person> getlist(){
	 return dscanbo;
 }

 @Override
 public Person them(Person person) {
	 for (Person ps : dscanbo) {
		if(ps.getHoten().equals(person.getHoten())) {
		return null;
		}
	}
	dscanbo.add(person);
	return person;
 }

 @Override
 public Person xoa(String ten) {
	for (Person person : dscanbo) {
		if(person.getHoten().equals(ten));
		dscanbo.remove(person);
		return person;
	}
	return null;
 }

 @Override
 public int tong() {
	return dscanbo.size();
 }

 @Override
 public List<Person> Sapxeptheoten() {
	return dscanbo.stream().sorted(Comparator.comparing(Person::getHoten))
			       .collect(Collectors.toCollection(ArrayList::new))
			;
 }
 
 
}

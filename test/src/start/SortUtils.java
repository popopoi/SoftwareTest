package start;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;


import model.Student;
import model.Teacher;




public class SortUtils {
	
	
	private static final class Link<ET> {
	    ET data;

	    Link<ET> previous, next;

	    Link(ET o, Link<ET> p, Link<ET> n) {
	        data = o;
	        previous = p;
	        next = n;
	    }
	}
	
	public static boolean contain(int t,Link list) {
		Link<String> dt = list;
		if(dt.data == null&&dt.next == null) {
			return true;
		}
		dt = dt.next;
		while(dt.data != null) {
			if(String.valueOf(t).equals(dt.data)==true) {
				return false;
			}
			if(dt.next == null) {
				break;
			}
			dt = dt.next;
		}
		
		return true;
		
	}

	public static boolean add(Link list) {
		Link<String> previous = list.previous; 
		int num = 0;
		Random rand = new Random();
		for(int i=0;i<20;i++) {
			num = rand.nextInt(50);
			boolean t = contain(num,list);
			if(!t) {
				i--;
				continue;
			}
			Link<String> dt = new Link<String>(String.valueOf(num), previous, null);
			previous.next = dt;
			previous = dt;
		}
		previous.next = list;
		
		return true;
		
	}
	
	public static Link number(Link list) {
		Link cu = null,cur = null, tail = null;
		cu = list;
		cu = cu.next;
		cur = cu;
		while(cur.next!=tail) {
			while(cur.next!=tail) {
				if(cur.next.data == tail) {
					break;
				}
				int n1 = Integer.parseInt((String) cur.data);
				int n2 = Integer.parseInt((String) cur.next.data);
				
				if(n1>n2) {
					String tmp = (String) cur.data;
					cur.data = cur.next.data;
					cur.next.data = tmp;
					
				}
				cur = cur.next;
			}
			tail = cur;
			cur = cu;
		}
		
		
		return list;
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student student = new Student();
		Teacher teacher = new Teacher();
		Link<String> stu = new Link<String>(null, null, null);
		stu.previous = stu;
		stu.next = stu;
		boolean f = add(stu);
		if(f) {
			Link<String> t = number(stu);
			System.out.print("学生编号：");
			for(int i=0;i<20;i++) {
				System.out.print(t.next.data+" ");
				t = t.next;
			}
			System.out.println("");
		}
		
		
		Link<String> tec = new Link<String>(null, null, null);
		tec.previous = tec;
		tec.next = tec;
		f = add(tec);
		if(f) {
			Link<String> t = number(tec);
			System.out.print("教师编号：");
			for(int i=0;i<20;i++) {
				System.out.print(t.next.data+" ");
				t = t.next;
			}
		}
		
		
		

	}


}

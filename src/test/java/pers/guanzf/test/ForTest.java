package pers.guanzf.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ForTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("guanzf");
		list.add("zhen");
		list.add("feng");
//		1
		for (String string : list) {
			
		}
//		2
		for (int i = 0; i < args.length; i++) {
			
		}
//		3
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			String s = it.next();
		}
//		4
		list.forEach(new Consumer<String>() {

			@Override
			public void accept(String t) {
				System.out.println(t);
			}
			
		});
//		5
		
	}
}

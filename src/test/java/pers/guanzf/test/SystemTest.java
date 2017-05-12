package pers.guanzf.test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class SystemTest {

	public static void main(String[] args) {
		try {
			System.out.println(InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException ex) {
			ex.printStackTrace();
		}
	}
}

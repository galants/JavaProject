package com.ve;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Project {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();

		HashMap<String, TreeMap> orders = new HashMap<String, TreeMap>();

		for (int i = 0; i < n; i++) {
			
			String customer = scn.next();
			int amount = scn.nextInt();
			String product = scn.nextLine();

			if (orders.containsKey(product)) {
				TreeMap<String, Integer> name = orders.get(product);
				
				if (name.containsKey(customer)) {
					name.put(customer, name.get(customer) + amount);
				} else {
					name.put(customer, amount);
				}
			} else {
				TreeMap<String, Integer> name = new TreeMap<>();
				
				name.put(customer, amount);
				orders.put(product, name);
			}
		}
		for (Map.Entry<String, TreeMap> order : orders.entrySet()) {
			System.out.print(order.getKey() + ": ");

			for (Iterator entries = ((TreeMap<String, Integer>) order
					.getValue()).entrySet().iterator(); entries.hasNext();) {
				
				Entry entry = (Entry) entries.next();
				
				System.out.print(entry.getKey() + " " + entry.getValue());
				
				if (entries.hasNext())
					System.out.print(", ");
			}
			System.out.println();
		}
	}
}

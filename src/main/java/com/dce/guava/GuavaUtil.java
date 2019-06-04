package com.dce.guava;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.base.Joiner;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Table;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.primitives.Ints;

/**
 * desc google gua
 * 
 * @author wu
 * @date Create in 2019/05/31 19:30:44
 *
 */
public class GuavaUtil {

	/**
	 * desc 比较 两个int 值 . a > b 返回正整数 . a == b 返回0 . a < b 返回负整数
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static int conpareInt(int a, int b) {
		return Ints.compare(a, b);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int a = 9;
		int b = 5;

		int compare = conpareInt(a, b);

		System.out.println(compare);

		// joiner 按照指定的字符拼接数组、集合等
		String[] subdirs = { "usr", "local", "lib" };
		String join = Joiner.on("/").join(subdirs);
		System.out.println(join);

		int[] numbers = { 1, 2, 3, 4, 5 };
		String numbersAsString = Joiner.on("-").join(Ints.asList(numbers));
		System.out.println(numbersAsString);

		String numbersAsStringDirectly = Ints.join(";", numbers);
		System.out.println(numbersAsStringDirectly);

//		List<String> list = new ArrayList<String>();
//		list.add("a");
//		list.add("b");
//		list.add("c");
//		list.add("d");
		// list 添加元素也可以使用下面的这个简单方式
		ImmutableList<String> list = ImmutableList.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j");
		String join2 = Joiner.on("--").join(list);
		System.out.println(join2);

		// 创造hashmap
		ImmutableMap<String, String> map2 = ImmutableMap.of("key1", "value1", "key2", "value2");
		System.out.println(map2);

		UnmodifiableIterator<String> iterator = map2.keySet().iterator();
		UnmodifiableIterator<String> iterator1 = map2.values().iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		while (iterator1.hasNext()) {
			System.out.println(iterator1.next());
		}

		// 双向map 可以根据key找value 也可以根据value找key

		BiMap<String, String> bmap = HashBiMap.create();
		bmap.putAll(map2);

		System.out.println(bmap.inverse().get("value1"));

		// table
		Table<Integer, Integer, String> table = HashBasedTable.create();
		for (int row = 0; row < 10; row++) {
			for (int column = 0; column < 5; column++) {
				table.put(row, column, "value of cell (" + row + "," + column + ")");
			}
		}
		for (int row = 0; row < table.rowMap().size(); row++) {
			Map<Integer, String> rowData = table.row(row);
			for (int column = 0; column < rowData.size(); column++) {
				System.out.println("cell(" + row + "," + column + ") value is:" + rowData.get(column));
			}
		}

		// 简化 Iterator

		Map<Integer, String> HOSTING = new HashMap<>();
		HOSTING.put(1, "linode.com");
		HOSTING.put(2, "heroku.com");
		HOSTING.put(3, "digitalocean.com");
		HOSTING.put(4, "aws.amazon.com");

		// Before Java 8
		String result = "";
		for (Map.Entry<Integer, String> entry : HOSTING.entrySet()) {
			if ("heroku.com".equals(entry.getValue())) {
				result = entry.getValue();
			}
		}
		System.out.println("Before Java 8: " + result);

		// Map -> Stream -> Filter -> String
		result = HOSTING.entrySet().stream().filter(map -> "linode.com".equals(map.getValue()))
				.map(map -> map.getValue()).collect(Collectors.joining());
		System.out.println("With Java 8:" + result);

		// filter more values
		result = HOSTING.entrySet().stream().filter(x -> {
			if (!x.getValue().contains("amazon") && !x.getValue().contains("digital")) {
				return true;
			}
			return false;
		}).map(map -> map.getValue()).collect(Collectors.joining(","));

		System.out.println("With Java 8 : " + result);

		System.exit(0);
	}
}

package com.assigment.GOJEK;

import java.util.Comparator;

public class SlotComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		return o1.compareTo(o2);
	}

}

package com.assigment.GOJEK.parkinglot;

import java.util.Comparator;

public class SlotComparator implements Comparator<Slot> {

	@Override
	public int compare(Slot s1, Slot s2) {
		return s1.getSlotId().compareTo(s2.getSlotId());
	}

}

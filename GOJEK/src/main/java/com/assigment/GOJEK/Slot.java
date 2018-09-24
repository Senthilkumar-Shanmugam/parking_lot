package com.assigment.GOJEK;


public class Slot{
	private int slotId;//asuming id is the nearest to entrance
	private int level;
	
	public int getSlotId() {
		return slotId;
	}
	public void setSlotId(int slotId) {
		this.slotId = slotId;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + level;
		result = prime * result + slotId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Slot other = (Slot) obj;
		if (level != other.level)
			return false;
		if (slotId != other.slotId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Slot [slotId=" + slotId + ", level=" + level + "]";
	}

}

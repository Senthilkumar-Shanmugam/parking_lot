package com.assigment.GOJEK.parkinglot;


public class Slot{
	private Integer slotId;//asuming id is the nearest to entrance
	private Integer level;
	
	public Integer getSlotId() {
		return slotId;
	}
	public Slot(Integer slotId, Integer level) {
		super();
		this.slotId = slotId;
		this.level = level;
	}
	public void setSlotId(Integer slotId) {
		this.slotId = slotId;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	@Override
	public int hashCode() {
		final Integer prime = 31;
		Integer result = 1;
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

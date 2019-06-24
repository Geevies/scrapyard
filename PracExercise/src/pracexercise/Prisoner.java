package pracexercise;

public class Prisoner {
	private String name;
	private Privileges groupPrivileges;
	private int usedMonth;
	private char block;
	private int cellNo;

	public Prisoner(String n, Privileges g, int um, char b, int c) {
		this.name = name;
		this.groupPrivileges = groupPrivileges;
		this.usedMonth = usedMonth;
		this.block = block;
		this.cellNo = cellNo;
	}

	public String getName() {
		return name;
	}

	public Privileges getGroupPrivileges() {
		return groupPrivileges;
	}

	public char getBlock() {
		return block;
	}

	public int getCellNo() {
		return cellNo;
	}

	public void setBlock(char block) {
		this.block = block;
	}

	public void setCellNo(int cellNo) {
		this.cellNo = cellNo;
	}

	@Override
	public String toString() {
		return block + " " + cellNo + "\t" + name + "\t(" + groupPrivileges.getGroup() + ")\t" + usedMonth + "\t" + (groupPrivileges.getVisitsMonth() - usedMonth) + "\t" + ((groupPrivileges.getDuration() * groupPrivileges.getVisitsMonth()) - (groupPrivileges.getDuration() * usedMonth));
	}
	
	public boolean sameBlock(char b) {
		if (block == b) return true;
		else return false;
	}
}
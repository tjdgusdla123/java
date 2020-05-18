package javaapp0518;

public class Covid {

	private int num;
	private String region;
	private String notion;
	private int pop;
	private int confirmcount;
	private int deathcount;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getNotion() {
		return notion;
	}

	public void setNotion(String notion) {
		this.notion = notion;
	}

	public int getPop() {
		return pop;
	}

	public void setPop(int pop) {
		this.pop = pop;
	}

	public int getConfirmcount() {
		return confirmcount;
	}

	public void setConfirmcount(int confirmcount) {
		this.confirmcount = confirmcount;
	}

	public int getDeathcount() {
		return deathcount;
	}

	public void setDeathcount(int deathcount) {
		this.deathcount = deathcount;
	}

	@Override
	public String toString() {
		return "Covid19 [num=" + num + ", region=" + region + ", notion=" + notion + ", pop=" + pop + ", confirmcount="
				+ confirmcount + ", deathcount=" + deathcount + "]";
	}

}

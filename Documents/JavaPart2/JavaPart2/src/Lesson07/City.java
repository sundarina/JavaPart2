package Lesson07;

public class City {
	private int code;
	private String name;
	private boolean isCap;
	private int count;
	private Country country;

	public City(int code, String name, boolean isCap, int count, Country country) {
		super();
		this.code = code;
		this.name = name;
		this.isCap = isCap;
		this.count = count;
		this.country = country;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isCap() {
		return isCap;
	}

	public void setCap(boolean isCap) {
		this.isCap = isCap;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "City [code=" + code + ", name=" + name + ", isCap=" + isCap + ", count=" + count + ", country="
				+ country + "]";
	}

}

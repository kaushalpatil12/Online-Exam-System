package com.oes.pojos;

public class Option {
	String name;
	String value;
	
	public Option(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public boolean equals(Option option) {
		return this.getName().trim().equalsIgnoreCase(option.getName().trim());
	}

	@Override
	public String toString() {
		return "Option [name=" + name + ", value=" + value + "]";
	}	

}

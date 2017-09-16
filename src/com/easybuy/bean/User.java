package com.easybuy.bean;


public class User {
    private Integer id;

    private String loginname;

    private String username;

    private String password;

    private String sex;

    private String identitycode;

    private String email;

    private String mobile;

    private Integer type;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIdentitycode() {
		return identitycode;
	}

	public void setIdentitycode(String identitycode) {
		this.identitycode = identitycode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Integer id, String loginname, String username, String password, String sex, String identitycode,
			String email, String mobile, Integer type) {
		super();
		this.id = id;
		this.loginname = loginname;
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.identitycode = identitycode;
		this.email = email;
		this.mobile = mobile;
		this.type = type;
	}

    
}
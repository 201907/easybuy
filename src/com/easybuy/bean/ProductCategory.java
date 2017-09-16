package com.easybuy.bean;

public class ProductCategory {
    private Integer id;

    private String name;

    private Integer parentid;

    private Integer type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    @Override
	public String toString() {
		return "ProductCategory [id=" + id + ", name=" + name + ", parentid=" + parentid + ", type=" + type + "]";
	}

	public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
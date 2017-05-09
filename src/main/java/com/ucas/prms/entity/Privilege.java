package com.ucas.prms.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @Description:privilege entity
 * @author:Chen Peng
 * @time:2017年5月7日 下午4:50:55
*/
@Entity
@Table(name="privileges")
public class Privilege { 
	
	@Id
	@Column(name="privilege_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="name")
	private String name;	//权限名称
	
	@Column(name="url")
	private String url;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
			name="role_privilege",
			joinColumns=@JoinColumn(name="privilege_id"),
			inverseJoinColumns=@JoinColumn(name="role_id"))
	private Set<Role> roles= new HashSet<Role>();
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="parent_id")
	private Privilege parent;	//上级权限
	
	@OneToMany(targetEntity=Privilege.class,cascade=CascadeType.ALL,mappedBy="parent")
	private Set<Privilege> children = new HashSet<Privilege>();	//下级权限

	public Privilege(){		
	}
	
	public Privilege(String name, String url, Privilege parent) {
		this.name = name;
		this.url = url;
		this.parent = parent;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Privilege getParent() {
		return parent;
	}

	public void setParent(Privilege parent) {
		this.parent = parent;
	}

	public Set<Privilege> getChildren() {
		return children;
	}

	public void setChildren(Set<Privilege> children) {
		this.children = children;
	}
	
	
}

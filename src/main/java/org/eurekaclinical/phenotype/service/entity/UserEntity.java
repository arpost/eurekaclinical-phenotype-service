package org.eurekaclinical.phenotype.service.entity;

/*-
 * #%L
 * eurekaclinical-phenotype-service
 * %%
 * Copyright (C) 2018 Emory University
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "users")
public class UserEntity implements org.eurekaclinical.standardapis.entity.UserEntity<RoleEntity> {

	/**
	 * The user's unique identifier.
	 */
	@Id
	@SequenceGenerator(name = "USER_SEQ_GENERATOR", sequenceName = "USER_SEQ",
			allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
			generator = "USER_SEQ_GENERATOR")
	private Long id;
        
	/**
	 * The login name of the user.
	 */
	@Column(unique = true, nullable = false)
	private String username;
	
	/**
	 * A list of roles assigned to the user.
	 */
	@ManyToMany(cascade = {CascadeType.REFRESH, CascadeType.MERGE},
			targetEntity = RoleEntity.class)
	@JoinTable(name = "users_roles",
			joinColumns = {
				@JoinColumn(name = "user_id")},
			inverseJoinColumns = {
				@JoinColumn(name = "role_id")})
	private List<RoleEntity> roles = new ArrayList<>();

	/**
	 * Get the user's unique identifier.
	 *
	 * @return A {@link Long} representing the user's unique identifier.
	 */
	@Override
	public Long getId() {
		return this.id;
	}

	/**
	 * Set the user's unique identifier.
	 *
	 * @param inId A {@link Long} representing the user's unique identifier.
	 */
	@Override
	public void setId(final Long inId) {
		this.id = inId;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public void setUsername(String username) {
		this.username = username;
	}
        
	@Override
	public List<RoleEntity> getRoles() {
		return this.roles;
	}

	/**
	 * Set the roles assigned to the current user.
	 *
	 * @param inRoles A Set of roles to be assigned to the user.
	 */
	@Override
	public void setRoles(final List<RoleEntity> inRoles) {
		this.roles = inRoles;
	}
	
        
	@Override
	public void addRole(RoleEntity role) {
		this.roles.add(role);
	}

	@Override
	public void removeRole(RoleEntity role) {
		this.roles.remove(role);
	}
        
	@Override
	public String toString() {
		return "UserEntity{" + "id=" + id + ", username=" + username + ", roles=" + roles + '}';
	}    
}

/*
 * #%L
 * Eureka Common
 * %%
 * Copyright (C) 2012 - 2013 Emory University
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
package org.eurekaclinical.phenotype.service.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * @author hrathod
 */
@Entity
@Table(name = "categories")
public class CategoryEntity extends PhenotypeEntity {

	public enum CategoryType {
		CONSTANT, EVENT, PRIMITIVE_PARAMETER, LOW_LEVEL_ABSTRACTION, 
		COMPOUND_LOW_LEVEL_ABSTRACTION, HIGH_LEVEL_ABSTRACTION, SLICE_ABSTRACTION,
		VALUE_THRESHOLD, SEQUENTIAL_TEMPORAL_PATTERN_ABSTRACTION, CONTEXT
	}

	/**
	 * The "children" of of this proposition.
	 */
	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.REFRESH,
	        CascadeType.PERSIST })
	@JoinTable(name = "category_members", 
			joinColumns = { @JoinColumn(name = "category_id")},
			inverseJoinColumns = { @JoinColumn(name = "member_id")})
	private List<PhenotypeEntity> members;
	
	public CategoryEntity() {
		super(CategoryType.EVENT);
	}

	public List<PhenotypeEntity> getMembers() {
		return members;
	}

	public void setMembers(List<PhenotypeEntity> members) {
		this.members = members;
	}
	
	public void setCategoryType(CategoryType categoryType) {
		setCatType(categoryType);
	}

	@Override
	public void accept(PhenotypeEntityVisitor visitor) {
		visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.reflectionToString(this);
	}

}

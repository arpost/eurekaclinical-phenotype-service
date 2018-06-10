/*
 * #%L
 * Eureka Services
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
package org.eurekaclinical.phenotype.service.dao;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eurekaclinical.phenotype.client.comm.ValueComparator_;
import org.eurekaclinical.phenotype.client.comm.ValueComparator;

import java.util.List;

import javax.persistence.EntityManager;
import org.eurekaclinical.standardapis.dao.GenericDao;

public class JpaValueComparatorDao extends GenericDao<ValueComparator, Long> implements
        ValueComparatorDao {

	@Inject
	protected JpaValueComparatorDao(Provider<EntityManager> inManagerProvider) {
		super(ValueComparator.class, inManagerProvider);
	}

	@Override
	public ValueComparator getByName(String inName) {
		return getUniqueByAttribute(ValueComparator_.name, inName);
	}

	@Override
	public List<ValueComparator> getAllAsc() {
		return getListAsc(ValueComparator_.rank);
	}
	
	
}

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
import org.eurekaclinical.phenotype.client.comm.ThresholdsOperator_;
import org.eurekaclinical.phenotype.client.comm.ThresholdsOperator;

import javax.persistence.EntityManager;
import org.eurekaclinical.standardapis.dao.GenericDao;

/**
 *
 */
public class JpaThresholdsOperatorDao extends
		GenericDao<ThresholdsOperator, Long> implements ThresholdsOperatorDao {

	@Inject
	protected JpaThresholdsOperatorDao(Provider<EntityManager>
															 inManagerProvider) {
		super(ThresholdsOperator.class, inManagerProvider);
	}

	@Override
	public ThresholdsOperator getByName(String inName) {
		return this.getUniqueByAttribute(ThresholdsOperator_.name, inName);
	}
}

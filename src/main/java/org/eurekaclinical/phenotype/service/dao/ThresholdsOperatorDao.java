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

//import edu.emory.cci.aiw.cvrg.eureka.common.entity.ThresholdsOperator;
import org.eurekaclinical.standardapis.dao.Dao;

import org.eurekaclinical.phenotype.client.comm.ThresholdsOperator;

/**
 *
 */
public interface ThresholdsOperatorDao  extends
		Dao<ThresholdsOperator, Long> {
	/**
	 * Gets a value definition match operator based on the name attribute.
	 * @param inName the name to search for in the database
	 * @return a {@link ThresholdsOperator} with the given name if
	 * found, null otherwise
	 */
	public ThresholdsOperator getByName(String inName);
}

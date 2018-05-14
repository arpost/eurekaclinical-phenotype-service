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
package org.eurekaclinical.phenotype.service.resource;

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;
import org.eurekaclinical.phenotype.client.comm.ValueComparator;
import org.eurekaclinical.phenotype.service.dao.ValueComparatorDao;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;
import org.eurekaclinical.standardapis.exception.HttpStatusException;

/**
 *
 * @author Andrew Post
 */
@Transactional
@Path("/protected/valuecomps")
@Produces(MediaType.APPLICATION_JSON)
public class ValueComparatorResource {
	
	private ValueComparatorDao valueCompDao;
	
	@Inject
	public ValueComparatorResource(ValueComparatorDao valueCompDao) {
		this.valueCompDao = valueCompDao;
	}
	
	@GET
	public List<ValueComparator> getAllAsc () {
		return this.valueCompDao.getAllAsc();
	}

	@GET
	@Path("/{id}")
	public ValueComparator get (@PathParam("id") Long inId) {
		ValueComparator result = this.valueCompDao.retrieve(inId);
		if (result == null) {
			throw new HttpStatusException(Status.NOT_FOUND,
					"No value comparator with id " + inId);
		}
		return result;
	}

	@GET
	@Path("/byname/{name}")
	public ValueComparator getByName (@PathParam("name") String inName) {
		ValueComparator result = this.valueCompDao.getByName(inName);
		if (result == null) {
			throw new HttpStatusException(Status.NOT_FOUND,
					"No value comparator with name " + inName);
		}
		return result;
	}
}

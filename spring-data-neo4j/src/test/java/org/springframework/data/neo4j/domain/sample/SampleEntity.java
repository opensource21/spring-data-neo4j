/*
 * Copyright (c)  [2011-2017] "Pivotal Software, Inc." / "Neo Technology" / "Graph Aware Ltd."
 *
 * This product is licensed to you under the Apache License, Version 2.0 (the "License").
 * You may not use this product except in compliance with the License.
 *
 * This product may include a number of subcomponents with
 * separate copyright notices and license terms. Your use of the source
 * code for these subcomponents is subject to the terms and
 * conditions of the subcomponent's license, as noted in the LICENSE file.
 *
 */
package org.springframework.data.neo4j.domain.sample;

import java.util.Collection;
import java.util.HashSet;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.data.neo4j.examples.movies.domain.User;
import org.springframework.util.Assert;

/**
 * @author Mark Angrish
 * @author Mark Paluch
 */
@NodeEntity
public class SampleEntity {

	@GraphId
	protected Long id;
	private String first;
	private String second;

	@Relationship(type = "RELATED_TO", direction = Relationship.UNDIRECTED)
    private Collection<SampleEntity> relations = new HashSet<>();

	public Collection<SampleEntity> getRelations() {
		return relations;
	}

	public void setRelations(Collection<SampleEntity> relations) {
		this.relations = relations;
	}

	protected SampleEntity() {

	}

	public SampleEntity(String first, String second) {
		Assert.notNull(first, "First must not be null!");
		Assert.notNull(second, "Second mot be null!");
		this.first = first;
		this.second = second;
	}



	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SampleEntity other = (SampleEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SampleEntity [id=" + id + ", first=" + first + ", second=" + second + "]";
	}


}

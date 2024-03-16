package com.ids.patienthub.commons.jpa.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.domain.Persistable;
import org.springframework.data.util.ProxyUtils;
import org.springframework.lang.Nullable;

/**
 * Abstract base class for entities. Allows parameterization of id type, chooses auto-generation and implements
 * {@link #equals(Object)} and {@link #hashCode()} based on that id.
 *
 * @param <I> the type of the identifier.
 */
@MappedSuperclass
@SuperBuilder
@Getter @Setter
@ToString
@RequiredArgsConstructor @AllArgsConstructor
public abstract class CustomAbstractPersistable<I extends Serializable> implements Persistable<I> {

	@jakarta.persistence.Id
    @GeneratedValue protected @Nullable I id;

	/**
	 * Must be {@link Transient} in order to ensure that no JPA provider complains because of a missing setter.
	 *
	 * @see org.springframework.data.domain.Persistable#isNew()
	 */
	@Transient // DATAJPA-622
	@Override
	public boolean isNew() {
		return null == getId();
	}

	@Override
	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (!getClass().equals(ProxyUtils.getUserClass(obj))) {
			return false;
		}
		CustomAbstractPersistable<?> that = (CustomAbstractPersistable<?>) obj;
		return Objects.equals(that.id, this.id);
	}

	@Override
	public int hashCode() {
		return 17 + Objects.hashCode(id) * 31;
	}

}

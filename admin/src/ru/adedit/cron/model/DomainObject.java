package ru.adedit.cron.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Locale;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;


/**
 * Главный класс для всех сущностей, созраняемых в БД. Честно украден в сети)) 
 * @author доработан Ж.Ю.К.
 */
@MappedSuperclass
public abstract class DomainObject implements Serializable {
	/**
	 * Default serial version id 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Unique identifier.
	 */
	@Id
	@GeneratedValue
	private Integer id = null;
	
	/** Default locale to use */
	@Transient
	private Locale defLocale = new Locale("ru", "RU"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * Simple plain constructor
	 */
	public DomainObject() {
		id = null;
	}

	/**
	 * Constructor that sets the id parameter
	 * 
	 * @param id
	 *            Id of the object to set
	 */
	public DomainObject(Integer id) {
		this.id = id;
	}

	/**
	 * <p>
	 * Constructor that initialized <code>this</code> object with values of the
	 * passed object.
	 * </p>
	 * <p>
	 * The method {@link #copyFieldsValuesFrom(DomainObject)} is used.
	 * </p>
	 * <p>
	 * Objects should be of the same class!
	 * </p>
	 * 
	 * @param obj
	 *            Another object to get values from
	 */
	public DomainObject(DomainObject obj) {
		id = null;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * @return the defLocale
	 */
	public Locale getDefLocale() {
		return defLocale;
	}

	/**
	 * @param defLocale the defLocale to set
	 */
	public void setDefLocale(Locale defLocale) {
		this.defLocale = defLocale;
	}

	/**
	 * <p>
	 * Copying all properties of the passed <code>obj</code> object to
	 * <code>this</code> object.
	 * </p>
	 * <p>
	 * The property {@link #id} is not copied. Also all properties that extend
	 * {@link Collection} and {@link Class} are not copied either.
	 * </p>
	 * 
	 * @param obj
	 *            Object to get values from
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DomainObject other = (DomainObject) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DomainObject";
	}

}

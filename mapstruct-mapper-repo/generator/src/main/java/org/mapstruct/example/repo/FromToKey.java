/**
 * 
 */
package org.mapstruct.example.repo;

/**
 * @author jucheme
 *
 */
public class FromToKey {

	@SuppressWarnings("rawtypes")
	public final Class from;
	@SuppressWarnings("rawtypes")
	public final Class to;

	@SuppressWarnings("rawtypes")
	public FromToKey(Class from, Class to) {
		this.from = from;
		this.to = to;
	}

	public String toString() {
		return from.getSimpleName() + ":" + to.getSimpleName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((from == null) ? 0 : from.hashCode());
		result = prime * result + ((to == null) ? 0 : to.hashCode());
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
		FromToKey other = (FromToKey) obj;
		if (from == null) {
			if (other.from != null)
				return false;
		} else if (!from.equals(other.from))
			return false;
		if (to == null) {
			if (other.to != null)
				return false;
		} else if (!to.equals(other.to))
			return false;
		return true;
	}

}

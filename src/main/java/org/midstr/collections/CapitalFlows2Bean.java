package org.midstr.collections;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class CapitalFlows2Bean implements Serializable {
	/**
	 * 证券id
	 */
	private final String securitiesId;
	/**
	 * 交易日
	 */
	private Date transDate;

	/**
	 * 主力流入额
	 */
	private double mainIn;
	/**
	 * 主力流出额
	 */
	private double mainOut;
	/**
	 * 主力净流入
	 */
	private double mainNetIn;
	/**
	 * 散户流入额
	 */
	private double retailIn;
	/**
	 * 散户流出额
	 */
	private double retailOut;
	/**
	 * 散户净流入
	 */
	private double retailNetIn;
	/**
	 * 大单
	 */
	private String bigTrans;

	/**
	 * 分时资金数据，只有10条
	 */
	private List<CapitalFlows2Bean> mins;

	public CapitalFlows2Bean(String securitiesId) {
		this.securitiesId = securitiesId;
	}

	/**
	 * @return the transDate
	 */
	public Date getTransDate() {
		return transDate;
	}

	/**
	 * @param transDate
	 *            the transDate to set
	 */
	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}

	/**
	 * @return the mainIn
	 */
	public double getMainIn() {
		return mainIn;
	}

	/**
	 * @param mainIn
	 *            the mainIn to set
	 */
	public void setMainIn(double mainIn) {
		this.mainIn = mainIn;
	}

	/**
	 * @return the mainOut
	 */
	public double getMainOut() {
		return mainOut;
	}

	/**
	 * @param mainOut
	 *            the mainOut to set
	 */
	public void setMainOut(double mainOut) {
		this.mainOut = mainOut;
	}

	/**
	 * @return the retailIn
	 */
	public double getRetailIn() {
		return retailIn;
	}

	/**
	 * @param retailIn
	 *            the retailIn to set
	 */
	public void setRetailIn(double retailIn) {
		this.retailIn = retailIn;
	}

	/**
	 * @return the retailOut
	 */
	public double getRetailOut() {
		return retailOut;
	}

	/**
	 * @param retailOut
	 *            the retailOut to set
	 */
	public void setRetailOut(double retailOut) {
		this.retailOut = retailOut;
	}

	/**
	 * @return the mainNetIn
	 */
	public double getMainNetIn() {
		return mainNetIn;
	}

	/**
	 * @param mainNetIn
	 *            the mainNetIn to set
	 */
	public void setMainNetIn(double mainNetIn) {
		this.mainNetIn = mainNetIn;
	}

	/**
	 * @return the retailNetIn
	 */
	public double getRetailNetIn() {
		return retailNetIn;
	}

	/**
	 * @param retailNetIn
	 *            the retailNetIn to set
	 */
	public void setRetailNetIn(double retailNetIn) {
		this.retailNetIn = retailNetIn;
	}

	/**
	 * @return the bigTrans
	 */
	public String getBigTrans() {
		return bigTrans;
	}

	/**
	 * @param bigTrans
	 *            the bigTrans to set
	 */
	public void setBigTrans(String bigTrans) {
		this.bigTrans = bigTrans;
	}

	/**
	 * @return the securitiesId
	 */
	public String getSecuritiesId() {
		return securitiesId;
	}

	/**
	 * @return the mins
	 */
	public List<CapitalFlows2Bean> getMins() {
		return mins;
	}

	/**
	 * @param mins
	 *            the mins to set
	 */
	public void setMins(List<CapitalFlows2Bean> mins) {
		this.mins = mins;
	}

	/**
	 * check
	 * 
	 * @return
	 */
	public boolean isValidate() {
		if (securitiesId == null) {
			return false;
		}

		return true;
	}

	/* (non-Javadoc)
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
		CapitalFlows2Bean other = (CapitalFlows2Bean) obj;
		if (securitiesId == null) {
			if (other.securitiesId != null) {
				return false;
			}
		} else if (!securitiesId.equals(other.securitiesId)) {
			return false;
		}
		if (transDate == null) {
			if (other.transDate != null)
				return false;
		} else if (!transDate.equals(other.transDate))
			return false;
		if (Double.compare(mainIn, other.mainIn) != 0)
			return false;
		if (Double.compare(mainOut, other.mainOut) != 0)
			return false;
		if (Double.compare(retailIn, other.retailIn) != 0)
			return false;
		if (Double.compare(retailOut, other.retailOut) != 0)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((securitiesId == null) ? 0 : securitiesId.hashCode());
		result = prime * result + (transDate == null ? 0 : transDate.hashCode());
		result = prime * result + doubleHashCode(mainIn);
		result = prime * result + doubleHashCode(mainOut);
		result = prime * result + doubleHashCode(retailIn);
		result = prime * result + doubleHashCode(retailOut);
		return result;
	}

	private int doubleHashCode(double d) {
		long bits = Double.doubleToLongBits(d);
		return (int) (bits ^ (bits >>> 32));
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		//return ToStringBuilder.reflectionToString(this);
		return null;
	}
}

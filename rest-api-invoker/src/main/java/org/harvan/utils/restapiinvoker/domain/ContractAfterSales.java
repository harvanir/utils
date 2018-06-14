/*
 * Copyright 2018-2018 the original author or authors.
 */

package org.harvan.utils.restapiinvoker.domain;

import java.io.Serializable;

/**
 * 
 * @author Harvan Irsyadi
 * @version 1.0.0
 * @since 1.0.0 (12 Jun 2018)
 *
 */
public class ContractAfterSales implements Serializable {
	private static final long serialVersionUID = 7315620324024096249L;
	private String code;
	private Integer pkContract;
	private String contractNo;
	private Integer lookupPK;
	private String reasonDescr;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getPkContract() {
		return pkContract;
	}

	public void setPkContract(Integer pkContract) {
		this.pkContract = pkContract;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public Integer getLookupPK() {
		return lookupPK;
	}

	public void setLookupPK(Integer lookupPK) {
		this.lookupPK = lookupPK;
	}

	public String getReasonDescr() {
		return reasonDescr;
	}

	public void setReasonDescr(String reasonDescr) {
		this.reasonDescr = reasonDescr;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ContractAfterSales [code=");
		builder.append(code);
		builder.append(", pkContract=");
		builder.append(pkContract);
		builder.append(", contractNo=");
		builder.append(contractNo);
		builder.append(", lookupPK=");
		builder.append(lookupPK);
		builder.append(", reasonDescr=");
		builder.append(reasonDescr);
		builder.append("]");
		return builder.toString();
	}
}
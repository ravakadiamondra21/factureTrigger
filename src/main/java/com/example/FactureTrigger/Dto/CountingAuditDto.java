package com.example.FactureTrigger.Dto;

public class CountingAuditDto {
	private String action_type;
	private Long total;
	
	public CountingAuditDto(String action_type, Long total) {
		super();
		this.action_type = action_type;
		this.total = total;
	}

	public String getAction_type() {
		return action_type;
	}

	public void setAction_type(String action_type) {
		this.action_type = action_type;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}
	
	
	
}

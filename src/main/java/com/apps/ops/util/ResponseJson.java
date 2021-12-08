package com.apps.ops.util;

import org.springframework.stereotype.Component;

@Component
public class ResponseJson {
	
	private int status;
	private Object data;
	
	public ResponseJson() {
		super();
	}
	
	public ResponseJson(int status, Object data) {
		super();
		this.status = status;
		this.data = data;
	}
	
	public ResponseJson(Object data) {
		super();
		this.data = data;
	}
	
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}

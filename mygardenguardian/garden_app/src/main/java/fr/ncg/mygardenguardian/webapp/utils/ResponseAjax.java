package fr.ncg.mygardenguardian.webapp.utils;

public class ResponseAjax {

	private String status;
	private Object data;

	public ResponseAjax() {
	}

	public ResponseAjax(String status, Object data) {
		this.status = status;
		this.data = data;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getData() {
		return this.data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}

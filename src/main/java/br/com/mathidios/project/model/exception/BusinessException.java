package br.com.mathidios.project.model.exception;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String title;
	
	public BusinessException() {
		super();
	}
	
	public BusinessException(String title, Exception e) {
		super(e);
		this.title = title;
	}
	
	public String getTitle() {
		return this.title;
	}

}

package mail;

import java.io.InputStream;

import mail.exceptions.ParseException;

public abstract class Part {

	protected final String BOUNDARY = "boundary";
	
	//glownych siedem predefiniowanych Content-Typeow
	protected final String MULTIPART_TYPE = "multipart";
	protected final String TEXT_TYPE = "text";
	protected final String MESSAGE_TYPE = "message";
	protected final String IMAGE_TYPE = "image";
	protected final String AUDIO_TYPE = "audio";
	protected final String VIDEO_TYPE = "video";
	protected final String APPLICATION_TYPE = "application";
	
	/**
	 * content of the message got from input stream
	 * saved in memory as bytes
	 */
	protected byte[] content;
	
	/**
	 * simple content type 
	 */
	protected ContentType contentType;
	
	/**
	 * 
	 */
	protected InputStream inputStream;
	
	/**
	 * inside multipart can have some headers there are the same as 
	 * in main message
	 */
	protected MimeMessageHeaders headers;
		
	public MimeMessageHeaders getHeaders() {
		return headers;
	}

	public void setHeaders(MimeMessageHeaders headers) {
		this.headers = headers;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public ContentType getContentType() {
		return contentType;
	}

	public void setContentType(ContentType contentType) {
		this.contentType = contentType;
	}
	
	public abstract void parse () throws ParseException;
	
}

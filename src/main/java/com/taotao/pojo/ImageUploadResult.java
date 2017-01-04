package com.taotao.pojo;

import java.io.Serializable;

public class ImageUploadResult implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private int error;
    private String message;
    private String url;

    /**
     * @param error
     * @param message
     * @param url
     */
    public ImageUploadResult(int error, String message, String url) {
        super();
        this.error = error;
        this.message = message;
        this.url = url;
    }

    /**
     * @return the error
     */
    public int getError() {
        return error;
    }

    /**
     * @param error
     *            the error to set
     */
    public void setError(int error) {
        this.error = error;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message
     *            the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     *            the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    public static ImageUploadResult ok(String url){
        return new ImageUploadResult(0, null, url);
    }
    
    public static ImageUploadResult error(String message){
        return new ImageUploadResult(1, message, null);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ImageUploadResult [error=" + error + ", message=" + message
                + ", url=" + url + "]";
    }
    
    
}

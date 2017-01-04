package com.taotao.pojo;

public class TreeNode {
    private long id;
    private String text;
    private String state;

    /**
     * @param id
     * @param text
     * @param state
     */
    public TreeNode(long id, String text, String state) {
        super();
        this.id = id;
        this.text = text;
        this.state = state;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text
     *            the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state
     *            the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

}

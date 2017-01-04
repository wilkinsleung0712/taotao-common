package com.taotao.pojo;

import java.util.List;
/**
 * 给EASY-UI返回一个EUDataGridResult Object 
 * @author WEIQIANG LIANG
 *
 */
public class EUDataGridResult {
    private long total;
    private List<?> rows;
    /**
     * @return the total
     */
    public long getTotal() {
        return total;
    }
    /**
     * @param l the total to set
     */
    public void setTotal(long l) {
        this.total = l;
    }
    /**
     * @return the rows
     */
    public List<?> getRows() {
        return rows;
    }
    /**
     * @param rows the rows to set
     */
    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}

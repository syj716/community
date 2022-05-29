package com.nowcoder.community.entity;

import lombok.Data;

@Data
public class Page {
    private int current =1;
    private int limit=10;
    //显示总数
    private int rows;
    //显示路经
    private String path;

    public void setCurrent(int current) {
        if(current >=1)
        this.current = current;
    }

    public void setRows(int rows) {
        if(rows>=0)
        this.rows = rows;
    }

    public void setLimit(int limit) {
        if (limit >= 1 && limit <= 100) {
            this.limit = limit;
        }
    }

    /**
     * 获取起始行的行号
     */
    public int getOffset(){
        return (current -1)*limit+1;
    }
    /**
     * 获取总页数
     */
    public int getTotal() {
        // rows / limit [+1]
        if (rows % limit == 0) {
            return rows / limit;
        } else {
            return rows / limit + 1;
        }
    }
    /**
     * 获取起始页码
     */
    public int getFrom() {
        int from = current - 2;
        return from < 1 ? 1 : from;
    }

    /**
     * 获取结束页码
     *
     * @return
     */
    public int getTo() {
        int to = current + 2;
        int total = getTotal();
        return to > total ? total : to;
    }
}

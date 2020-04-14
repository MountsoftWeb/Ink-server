package com.ink.server.dao.entity;

import java.util.List;


public class pageBean<T> {
    private int pageNum;        // 当前页面
    private int pageSize;       // 每页数量
    private int totalRecord;    // 记录总数
    private int totalPage;      // 记录总页数
    private List<T> list;       // 结果集
    private int start;
    private int end;
    private int[] array = new int[5];
    private int fromIndex;
    private int toIndex;

    public pageBean(int pageNum, int pageSize, int totalRecord) {
        this.setPageNum(pageNum);
        this.setPageSize(pageSize);
        this.setTotalRecord(totalRecord);
        fromIndex = (pageNum - 1) * pageSize;
        toIndex = pageNum * pageSize > totalRecord ? totalRecord : pageNum * pageSize;

        if (totalRecord % pageSize == 0) {
            this.totalPage = totalRecord / pageSize;
        } else {
            this.totalPage = totalRecord / pageSize + 1;
        }
        start = 1;
        end = 5;
        if (totalPage <= 5) {
            end = this.totalPage;
            
        } else {
            start = pageNum - 2;
            end = pageNum + 2;

            if (start < 1) {
                start = 1;
                end = 5;
            }
            if (end > this.totalPage) {
                end = totalPage;
                start = end - 5;
            }
           
        }
        if (pageNum > 5){
            int temp = ++start;
            for (int i = 0;i < 5;i++){
                array[i] = temp;
                temp++;
            }
        }else {
            int temp = start;
            for (int i = 0;i < 5;i++){
                array[i] = temp;
                temp++;
            }
        }
        

    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public List<T> getList() {
        return list;
    }

    public int getToIndex() {
        return toIndex;
    }

    public void setToIndex(int toIndex) {
        this.toIndex = toIndex;
    }

    public int getFromIndex() {
        return fromIndex;
    }

    public void setFromIndex(int fromIndex) {
        this.fromIndex = fromIndex;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public void setList(List<T> list) {
        this.list = list.subList(fromIndex, toIndex);
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

//     public pageBean(Integer pageNo,Integer pageSize,List<T> list){
//         if(list==null){
//             return;
//         }
//         //总记录数
//         this.totalRecord = list.size();
//         //每页显示多小条数据
//         this.pageSize = pageSize;
//         //总页数
//         this.totalPage = this.totalRecord % this.pageSize == 0?this.totalRecord/this.pageSize:this.totalRecord/this.pageSize+1;
//         //当前第几页
//         if(this.totalPage < pageNo){
//             this.pageNum = this.totalPage;
//         }else{
//             this.pageNum = pageNo;
//         }
//         //起始索引
//         Integer fromIndex = this.pageSize * (this.pageNum - 1);
//         //结束索引
//         Integer endIndex = null;
//         if(this.pageSize * this.pageNum >this.totalRecord){
//             endIndex = this.totalRecord;
//         }else{
//             endIndex = this.pageSize * this.pageNum;
//         }
//         this.list = list.subList(fromIndex, endIndex);
//    }
}
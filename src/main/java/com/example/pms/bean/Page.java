package com.example.pms.bean;

public class Page {
    public enum Index {
        HOME, PROPERTY, PARKING, EQUIPMENT, FEE, COMPLAINT
    }

    private int pageIndex = Index.HOME.ordinal();

    public void setPageIndex(Index index) {
        this.pageIndex = index.ordinal();
    }

    public int getPageIndex() {
        return this.pageIndex;
    }
}

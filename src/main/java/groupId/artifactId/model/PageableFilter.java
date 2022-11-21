package by.it_academy.jd2.hw.example.crm.model;

public class PageableFilter {
    private int page;
    private int size;
    private ESortDirection sortDirection;

    public PageableFilter(int page, int size, ESortDirection sortDirection) {
        this.page = page;
        this.size = size;
        this.sortDirection = sortDirection;
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }

    public ESortDirection getSortDirection() {
        return sortDirection;
    }
}

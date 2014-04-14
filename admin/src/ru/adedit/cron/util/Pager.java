package ru.adedit.cron.util;

import java.util.ArrayList;

public class Pager {
    private int currentPage = 1;
    private int pageSize = 5;
    private int sidePages = 2;
    private int total;
    private String name; 
    private String baseUrl="";

    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSidePages() {
		return sidePages;
	}

	public Pager() {

    }

    public Pager(int currentPage) {
        this.currentPage = currentPage;
    }

    public Pager(int currentPage, int pageSize) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setSidePages(int sidePages) {
        this.sidePages = sidePages;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal() {
        return total;
    }

    public int getFrom() {
        return currentPage == 1 ? 1 : (currentPage - 1) * pageSize + 1;
    }

    public int getTo() {
        return (currentPage * pageSize) > total ? total : currentPage * pageSize;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public ArrayList<Link> getPageLinks() {
        ArrayList<Link> pageLinks;
        int pageCount ;
//         pageSize=(pageSize==0)?100000:pageSize;
            pageCount= (total % pageSize == 0) ? total / pageSize : total / pageSize + 1;

        if (pageCount > 12) {
            Link link;
            pageLinks = new ArrayList<Link>();

            int from = (currentPage-sidePages) <1 ? 1 : currentPage-sidePages;
            int to = (currentPage+sidePages) > pageCount ? pageCount : currentPage+sidePages;

            if(from!=1) {
                link = new Link(String.valueOf(1), getUrl(1));
                pageLinks.add(link);
                link = new Link("...", getUrl(2));
                pageLinks.add(link);
            }
            for(; from<=to; from++) {
                link = new Link(String.valueOf(from), getUrl(from));
                pageLinks.add(link);
            }
            if(to!=pageCount) {
                link = new Link("...", getUrl(pageCount-1));
                pageLinks.add(link);
                link = new Link(String.valueOf(pageCount), getUrl(pageCount));
                pageLinks.add(link);

            }

        } else {
            pageLinks = new ArrayList<Link>(pageCount);
            for (int i = 1; i <= pageCount; i++) {
                Link link = new Link(String.valueOf(i), getUrl(i));
                pageLinks.add(link);
            }
        }
        return pageLinks;
    }
    private String getUrl(int pageIndex) {
        String url = "page=" + pageIndex + "&size=" + pageSize+"&name="+name;
//        if (pageIndex == currentPage) {
//            url = baseUrl;
//        } else {
            url = baseUrl + ((baseUrl.contains("?") == true) ? "&" + url : "?" + url);
//        }
        
        return url;
    }
}

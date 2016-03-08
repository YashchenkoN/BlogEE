package com.blogger.common;

import org.hibernate.criterion.Order;

import javax.ejb.Stateless;

/**
 * @author Nikolay Yashchenko
 */
@Stateless
public class OrderHelper {
    public static final String DATE_ASC = "dateAsc";
    public static final String DATE_DESC = "dateDesc";
    public static final String NAME_ASC = "nameAsc";
    public static final String NAME_DESC = "nameDesc";

    public Order getOrder(String sort) {
        if(sort == null) return Order.asc("id");
        switch (sort) {
            case DATE_ASC:
                return Order.asc("creationDate");
            case DATE_DESC:
                return Order.desc("creationDate");
            case NAME_ASC:
                return Order.asc("title");
            case NAME_DESC:
                return Order.desc("title");
            default:
                return Order.asc("id");
        }
    }
}

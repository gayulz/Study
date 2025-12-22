package com.skt.mo.list.test.ex2;

import java.util.ArrayList;

/**
 * @author : gayul.kim
 * @date : 2025. 12. 22.
 * @fileName : ShoppingCart
 */
public class ShoppingCart {
    private ArrayList<Item> list = new ArrayList<>();
    public void addItem(Item item) {
        list.add(item);
    }

    public void displayItems() {
        int listTotal = 0;
        System.out.println("장바구니 상품 출력");
        for (int i = 0; i < list.size(); i++) {
            int total = list.get(i).getPrice() * list.get(i).getQuantity();
            System.out.println("상품명 : " + list.get(i).getName() + ", 합계 : " + total);
            listTotal += total;
        }
        System.out.println("전체 가격 합 : " + listTotal);
    }

}

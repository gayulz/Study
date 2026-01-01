package com.skt.mo.set.member;

import com.skt.mo.set.MyHashSetV2;

/**
 * @author : gayul.kim
 * @date : 2026. 1. 1.
 * @fileName : HashAndEqualsMain1
 */
public class HashAndEqualsMain1 {
    public static void main(String[] args) {
        MyHashSetV2 set = new MyHashSetV2(10);
        MemberNoHashNoEq m1 = new MemberNoHashNoEq("A");
        MemberNoHashNoEq m2 = new MemberNoHashNoEq("A");

        /*
        * equals와 hashCode를 재정의 하지 않았기 때문에
        * 참조 값을 가지고 검증한다.
        * 우리가 기존 자주쓰는 String.equals(String)의 비교는
        * String 내부안에 hashCode와 equals가 재정의 되어 있어
        * Object의 hashCode 와 equals의 물리적값(메모리의 위치/인스턴스의 참조값)
        * 비교가 아닌 논리적값(참조값의 실제 값)을 비교하게 되어있다.
        * */
        System.out.println("m1.hashCode() = " + m1.hashCode());
        System.out.println("m2.hashCode() = " + m2.hashCode());
        System.out.println("m1.equals(m2) = " + m1.equals(m2));

        set.add(m1);
        set.add(m2);
        System.out.println("set = " + set);

        // 검색 실패
        MemberNoHashNoEq searchValue = new MemberNoHashNoEq("A");
        System.out.println("searchValue.hashCode() = " + searchValue.hashCode());

        /*
        * 현재 상태에선 실행 할 때 마다 참조값이 달라지므로(메모리 할당되는 위치)
        * set의 기능인 중복 저장 불가가 무력화가 되고 배열에 위치가 매번 달라지게 된다.
        * */
    }
}

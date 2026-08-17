package io.member;

import io.member.impl.DataMemberRepository;
import io.member.impl.FileMemberRepository;
import io.member.impl.MemoryMemberRepository;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 5.
 * @fileName : MemberConsoleMain
 */
public class MemberConsoleMain {

//    private static final MemberRepository repository = new MemoryMemberRepository();
//    private static final MemberRepository repository = new FileMemberRepository();
    private static final MemberRepository repository = new DataMemberRepository();

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("1. 회원 등록 | 2. 회원 목록 조회 | 3. 종료");
            System.out.print("선택 : ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // new Line 제거

            switch(choice){
                case 1:
                    // 회원 등록
                    registerMember(scanner);
                    break;
                case 2:
                    // 회원 목록 조회
                    displayMembers();
                    break;
                case 3:
                    System.out.println("프로그램을 종료합니다");
                    return;
                default:
                    System.out.println("잘못된 선택입니다 다시 입력하세요.");
            }
        }
    }


    private static void registerMember(Scanner scanner) throws IOException {
        System.out.print("아이디 : ");
        String id = scanner.nextLine();
        System.out.print("이름 : ");
        String name = scanner.nextLine();
        System.out.print("나이 : ");
        Integer age = scanner.nextInt();
        scanner.nextLine(); // new Line 제거

        Member newMember = new Member(id, name, age);
        repository.add(newMember);
    }

    private static void displayMembers() {
        List<Member> members = repository.findAll();
        System.out.println("회원 목록 : " + members.size());
        for (Member member : members) {
            System.out.printf("아이디: %s, 이름: %s, 나이: %d\n", member.getId(), member.getName(), member.getAge());
        }
    }
}

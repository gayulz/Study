package io.member.impl;

import io.member.Member;
import io.member.MemberRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 5.
 * @fileName : DataMemberRepositry
 */
public class DataMemberRepository implements MemberRepository {

    private static final String FILE_PATH = "temp/members-data.dat";

    @Override
    public void add(Member member) {
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(FILE_PATH, true))) {
            dos.writeUTF(member.getId());
            dos.writeUTF(member.getName());
            dos.writeInt(member.getAge());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Member> findAll() {
//        return List.of();
        List<Member> members = new ArrayList<>();
        try (DataInputStream dis = new DataInputStream(new FileInputStream(FILE_PATH))){
            while(dis.available() > 0){
                members.add(new Member(dis.readUTF(), dis.readUTF(), dis.readInt()));
            }
            return members;

        } catch (FileNotFoundException e) {
            return List.of();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

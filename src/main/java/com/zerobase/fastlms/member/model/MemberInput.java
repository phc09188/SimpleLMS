package com.zerobase.fastlms.member.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MemberInput {

    private String user_Id;
    private String userName;
    private String password;
    private String phone;


}

package com.EMBAD.vo;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class EmergencyChart {
    private String ptntNumber;
    private String ptntGender;
    private String ptntAge;
    private String ptntCause;
    private String ptntNote;
    private String KTASlevel;
    private String ptntAid;
    private String staffNumber;
    private String hpid;
    private Date ptntDate;
    private String staffName;
    private String staffPhone;
}

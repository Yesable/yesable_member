package yesable.member.model.entity.mariadb.user;



import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import yesable.member.enums.user.Disabilitytype;
import yesable.member.enums.user.Educationlevel;
import yesable.member.enums.user.Interestfield;
import yesable.member.enums.user.Worktype;


import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Getter
public class PrivateUser extends CoreUser {

    private String username;

    private String location; // 상세하지 않고 적절한 지역단위로, 온보딩

    @ElementCollection
    private Set<Interestfield> interestField; //관심분야 : IT, 서비스, 제조업

    @ElementCollection
    private Set<Worktype> workType; //선호하는 업무 형태, 정규직, 파트타임..

    @ElementCollection
    private Set<String> skills; //자격증

    @Enumerated(EnumType.STRING)
    private Educationlevel education;

    private String personality; //개인 성격

    private String hobbies; // 취미

    private String supportneeds; //지원 요구사항

    @Enumerated(EnumType.STRING)
    private Disabilitytype disabilitytype;

    @OneToMany(mappedBy = "privateUser", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Experience> experiences;

}

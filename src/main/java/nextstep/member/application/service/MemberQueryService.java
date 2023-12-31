package nextstep.member.application.service;

import nextstep.member.application.dto.MemberResponse;
import nextstep.member.domain.Member;
import nextstep.member.domain.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class MemberQueryService {

    private final MemberRepository memberRepository;

    public MemberQueryService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public MemberResponse findMember(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(RuntimeException::new);

        return MemberResponse.of(member);
    }

    public MemberResponse findMember(String email) {
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(RuntimeException::new);

        return MemberResponse.of(member);
    }
}

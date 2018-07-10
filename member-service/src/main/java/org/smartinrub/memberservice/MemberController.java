package org.smartinrub.memberservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class MemberController {

    private final List<Member> members = Arrays.asList(
            new Member(1, "Sergio", 27),
            new Member(2, "Juan", 26),
            new Member(3, "Rosa", 58),
            new Member(4, "Jose", 59));

    @GetMapping("/member/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Member getMembers(@PathVariable long id) {
        return members.stream()
                .filter(member -> member.getId() == id)
                .findFirst()
                .orElseThrow(MemberNotFoundException::new);
    }
}

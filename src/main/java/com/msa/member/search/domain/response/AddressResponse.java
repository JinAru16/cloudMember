package com.msa.member.search.domain.response;

import com.msa.common.entity.Users;
import com.msa.member.exception.MemberException;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AddressResponse {
    private Long memberId;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String country;
    private String postalCode;

    public AddressResponse (Users users){
        if(users.getAddress() == null){
            throw new MemberException("해당 회원의 주소가 존재하지않습니다.");
        }
        this.memberId = users.getId();
        this.address1 = users.getAddress().getAddress1();
        this.address2 = users.getAddress().getAddress2();
        this.city = users.getAddress().getCity();
        this.state = users.getAddress().getState();
        this.country = users.getAddress().getCountry();
        this.postalCode = users.getAddress().getPostalCode();

    }

    @Builder
    public AddressResponse(Long memberId, String address1, String address2, String city, String state, String country, String postalCode) {
        this.memberId = memberId;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postalCode = postalCode;
    }

}

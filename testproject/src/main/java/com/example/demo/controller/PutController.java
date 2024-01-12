package com.example.demo.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.MemberDTO;

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {
	
    // http://localhost:8080/api/v1/put-api/default
    @PutMapping(value = "/default")
    public String putMethod() {
        return "Hello World!";
    }
    
    
    @PutMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> putData) {
    	StringBuilder sb = new StringBuilder();
    	
    	putData.entrySet().forEach(map -> {
    		sb.append(map.getKey() + " : " + map.getValue() + "\n");
    	});
    	
  
    	return sb.toString();
    }
    
    
    
    // member1, member2, member3 리턴형태의 차이, 비교해보기
     @PutMapping(value="/member1")
     public String postMemberDto1(@RequestBody MemberDTO memberDTO) {
    	 
    	 return memberDTO.toString();
    	 // return [name=이름, email=이메일@이메일.com, organization=기관]
    	 // return String => MemberDTO에서 선언한 toString()값과 동일하게 출력됨
     }
     
     @PutMapping(value="member2")
     public MemberDTO postMemberDto2(@RequestBody MemberDTO memberDTO) {
    	 return memberDTO;
    	 // return { "name": "이름", "email": "이메일@이메일.com", "organization": "기관" }
    	 // return DTO => JSON의 형태로 리턴됨
     }

     @PutMapping(value="member3")
     public ResponseEntity<MemberDTO> postMemberDto3(@RequestBody MemberDTO memberDTO) {
    	 // memberDTO를 받아서
    	 
    	 // ResponseEntity라는걸 씌워서, status를 HttpStatus.ACCEPTED로 받아가지고
    	 // body값에 memberDTO를 담아서 return하겠다.
    	 return ResponseEntity.status(HttpStatus.ACCEPTED).body(memberDTO);
    	 // return { "name": "이름", "email": "이메일@이메일.com", "organization": "기관" }
    	 // return값은 member2와 동일하나, 상태코드가 202로 전송됨(.ACCEPTED의 코드)
    	 // 필요에 따라 HttpStatus를 변경하여 전송하는 방식으로 사용
     }
}

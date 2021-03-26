package com.cos.baseball;

public class notepad {
	/*
	 * java프로젝트 jsp프로 블로그 프로(스프링) 리액트 crud 프로
	 * -최총프로
	 * 시간정보 
	 * 둘다 OneToOne일때, 부모를 정해야됨(아무나. 왜?원자성을 안해쳐서)
	 * 경기장 삭제 = 팀도 삭제, 팀 삭제 != 경기장 삭제cascade.remove/detach 
	 * ㅡㅡㅡㅡㅡㅡㅡㅡㅡ 
	 * form태그 안에 그림그리기
	 * 컨트롤러에서 이동(나중에 db에 담는거) 
	 * 서비스에서등록 
	 * jsp만들기 
	 * 데이터 받아오기(model)
	 * 선수가 어느 팀인지(teamId) 팀이 어느 구장인지(fieldId)
	 * selectbox를 써주고 select로 데이터 받아오기(model)
	 * 
	 * db에 teamId, fieldId 넣기 teamId, fieldId못받음 = 키값으로 받았는데 오브젝트로 주고잇음. (dto필요)
	 * 컬렉션으로 바꿔서 넣어줘야함 or 네이티브쿼리 redirect:/filed/list mvnrepository =>qlrm = dto 받기
	 * 위해서 mysql-pivot
	 * 
	 * stringbuffer-동시접근불가 별칭이해불가 = 인라인서브쿼리사용(도 안됨) =>maven clean/update 재시작
	 */
}

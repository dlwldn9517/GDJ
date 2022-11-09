package com.gdu.app11.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.gdu.app11.domain.EmpDTO;
import com.gdu.app11.mapper.EmpMapper;
import com.gdu.app11.util.PageUtil;

@Service
public class EmpServiceImpl implements EmpService {
	
	@Autowired
	private EmpMapper empMapper;
	
	@Autowired
	private PageUtil pageUtil;	// 타입이 일치하면 @Autowired는 가져온다.

	@Override																	// request는 페이지라는 파라미터가 있어서 받아온다.
	public void findAllEmployees(HttpServletRequest request, Model model) {		// model은 결과 명단 저장하려고 받아온다.

		// request에서 page 파라미터 꺼내기
		// page 파라미터가 전달되지 않는 경우 page = 1로 처리한다.
		Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
		int page = Integer.parseInt(opt.orElse("1"));

		// 전체 레코드(직원) 개수 구하기
		int totalRecord = empMapper.selectAllEmployeesCount();
		
		// PageUtil 계산하기
		pageUtil.setPageUtil(page, totalRecord);
		
		// Map 만들기 (begin, end)
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", pageUtil.getBegin());
		map.put("end", pageUtil.getEnd());
		
		// begin ~ end 목록 가져오기
		List<EmpDTO> employees = empMapper.selectEmployeesByPage(map);	// map으로 begin과 end를 가져온다.
		
		// 뷰로 보낼 데이터
		model.addAttribute("employees", employees);
		model.addAttribute("paging", pageUtil.getPaging(request.getContextPath() + "/emp/list"));
		model.addAttribute("beginNo", totalRecord - (page - 1) * pageUtil.getRecordPerPage());
	}
	
	@Override
	public void findEmployees(HttpServletRequest request, Model model) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("column", request.getParameter("column"));
		map.put("query", request.getParameter("query"));
		map.put("begin", request.getParameter("begin"));
		map.put("end", request.getParameter("end"));
		
		System.out.println("검색 결과 개수 : " + empMapper.selectFindEmployeesCount(map));
		
	}

}

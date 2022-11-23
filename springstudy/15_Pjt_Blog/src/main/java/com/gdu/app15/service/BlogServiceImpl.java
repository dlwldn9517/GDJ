package com.gdu.app15.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.gdu.app15.mapper.BlogMapper;
import com.gdu.app15.util.PageUtil;

@Service
public class BlogServiceImpl implements BlogService {

	private BlogMapper blogMapper;
	private PageUtil pageUtil;	// @Component 스프링이 뉴 페이지유틸 해서 갖고 있는걸 @Autowired로 가져와서 사용하겠다. 스프링이 페이지유틸 객체를 가지고 있다
	
	@Autowired	// @Autowired를 여러개를 사용할 때 아래 코드처럼 복잡하게 구현
	// 매개변수 2개로 주입된다. (컨트롤러에서 많이 보이는 코드)
	public void set(BlogMapper blogMapper, PageUtil pageUtil) {
		this.blogMapper = blogMapper;
		this.pageUtil = pageUtil;
	}
	
	@Override
	public void getBlogList(Model model) {	
		
		// Model에 저장된 request 꺼내기
		Map<String, Object> modelMap = model.asMap();	// model을 map으로 변신
		HttpServletRequest request = (HttpServletRequest)modelMap.get("request");

		// 페이징 처리할 때 꼭 필요한 것 : 페이지 수(page)
		// 파라미터
		Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
		int page = Integer.parseInt(opt.orElse("1"));	// 페이지가 안넘어오면 무조건 1페이지 보여준다.
		
		// 전체 블로그 개수	
		int totalRecord = blogMapper.selectBlogListCount();	// 전체 블로그 갯수는 db에서 구해온다.
		
		// 페이징 처리에 필요한 변수 계산
		pageUtil.setPageUtil(page, totalRecord);
		
		// 조회 조건으로 사용할 Map 만들기
		Map<String, Object> map = new HashMap<String, Object>();	// 값 2개가 int라고 해서 Integer라고 안해도 된다. 그냥 Object로 하자
		map.put("begin", pageUtil.getBegin());	// pageUtil에 begin값이 계산되서 담겨 있다. 계산하고 꺼내올 것 (순서만 지키자)
		map.put("end", pageUtil.getEnd());
		
		// 뷰에 전달할 데이터를 model에 저장하기
		model.addAttribute("totalRecord", totalRecord);
		model.addAttribute("blogList", blogMapper.selectBlogListByMap(map));
		model.addAttribute("beginNo", totalRecord - (page - 1) * pageUtil.getRecordPerPage());	// 순번 만들때 필요한 정보 모델에 싣는다.
		model.addAttribute("paging", pageUtil.getPaging(request.getContextPath() + "/blog/list"));	// 완성된 번호 텍스트로 받아서 넘기깅(getPaging()에 경로path만 넘겨주면 다 작성되게 String으로 넘겨줌)
		 																							// 뭘 누르든 어차피 blogList. 그래서 "/blog/list" 경로로 이동
		
		
		
	}
	
	
	
}

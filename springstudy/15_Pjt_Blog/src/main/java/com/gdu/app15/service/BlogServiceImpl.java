package com.gdu.app15.service;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.gdu.app15.domain.BlogDTO;
import com.gdu.app15.mapper.BlogMapper;
import com.gdu.app15.util.MyFileUtil;
import com.gdu.app15.util.PageUtil;

@Service
public class BlogServiceImpl implements BlogService {

	private BlogMapper blogMapper;
	private PageUtil pageUtil;	// @Component 스프링이 뉴 페이지유틸 해서 갖고 있는걸 @Autowired로 가져와서 사용하겠다. 스프링이 페이지유틸 객체를 가지고 있다
	private MyFileUtil myFileUtil;
	
	@Autowired	// @Autowired를 여러개를 사용할 때 아래 코드처럼 복잡하게 구현
	// 매개변수 2개로 주입된다. (컨트롤러에서 많이 보이는 코드)
	public void set(BlogMapper blogMapper, PageUtil pageUtil, MyFileUtil myFileUtil) {
		this.blogMapper = blogMapper;
		this.pageUtil = pageUtil;
		this.myFileUtil = myFileUtil;
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
	
	@Override
	public void saveBlog(HttpServletRequest request, HttpServletResponse response) {
		
		// 파라미터 title, content
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		// 작성자의 ip
		// 작성된 내용이 어딘가를 경유해서 도착하면 원래 ip가 X-Forwarded-For라는 요청헤더에 저장된다.
		
		// 출발			  			도착
		// 1.1.1.1					1.1.1.1 : request.getRemoteAddr()
		//							null	: request.getHeader("X-Forwarded-For")
		
		// 출발			경유		도착
		// 1.1.1.1		2.2.2.2		2.2.2.2 : request.getRemoteAddr()
		//							1.1.1.1 : request.getHeader("X-Forwarded-For")
		Optional<String> opt = Optional.ofNullable(request.getHeader("X-Forwarded-For"));	
		String ip = opt.orElse(request.getRemoteAddr());	// 만약에 null이 나오면 request.getRemoteAddr()를 사용해라
		
		// DB로 보낼 BlogDTO
		BlogDTO blog = BlogDTO.builder()
				.title(title)
				.content(content)
				.ip(ip)
				.build();
		
		// DB에 저장
		int result = blogMapper.insertBlog(blog);
		
		// 응답
		try {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			if(result > 0) {
				out.println("alert('삽입 성공')");
				out.println("location.href='" + request.getContextPath() + "/blog/list';");
			} else {
				out.println("alert('삽입 실패')");
				out.println("history.back();");
			}
			out.println("</script>");
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Map<String, Object> saveSummernoteImage(MultipartHttpServletRequest multipartRequest) {

		// 파라미터 file
		// getParameter()는 String일 떄만 꺼내서 사용가능
		MultipartFile multipartFile = multipartRequest.getFile("file");
		
		// 저장할 파일명
		String filesystem = myFileUtil.getFilename(multipartFile.getOriginalFilename());	// 원본 파일명에서 확장자만 가져다쓰고 나머지는 랜덤값으로 변경해줌
		
		// 저장 경로
		String path = "C:\\upload";
		
		// 저장 경로가 없으면 만들기
		File dir = new File(path);
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		
		// 저장할 File 객체
		File file = new File(path, filesystem);	// new File(dir, filesystem)도 가능
		
		// HDD에 File 객체 저장하기
		try {
			multipartFile.transferTo(file);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 저장된 파일을 확인할 수 있는 매핑을 반환
		Map<String, Object> map = new HashMap<String, Object>();	// 잭슨을 넣어놨기 떄문에 json으로 잘 바꿔줌
		map.put("src", multipartRequest.getContextPath() + "/load/image/" + filesystem);
		return map;
		
		// 저장된 파일이 aaa.jpg라고 가정하면
		// src=${contextPath}/load/image/aaa.jpg 이다
	}
	
	@Override
	public int increseBlogHit(int blogNo) {
		return blogMapper.updateHit(blogNo);
	}
	
	@Override
	public void getBlogByNo(int blogNo, Model model) {
		// TODO Auto-generated method stub
		
	}
	
}

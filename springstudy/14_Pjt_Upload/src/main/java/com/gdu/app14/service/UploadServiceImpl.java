package com.gdu.app14.service;

import java.io.File;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.gdu.app14.domain.AttachDTO;
import com.gdu.app14.domain.UploadDTO;
import com.gdu.app14.mapper.UploadMapper;
import com.gdu.app14.util.MyFileUtil;

@Service
public class UploadServiceImpl implements UploadService {

	@Autowired
	private UploadMapper uploadMapper;
	
	@Autowired
	private MyFileUtil myFileUtil;
	
	@Override
	public List<UploadDTO> getUploadList() {	// 페이징 처리해야 함 - 11장 참고
		return uploadMapper.selectUploadList();
	}
	
	@Transactional	// insert가 두번 (attach(사진)랑 upload(글) 둘다 insert)
	@Override
	public void save(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) {

		/*  UPLOAD 테이블에 저장하기 */
		
		// 파라미터
		String title = multipartRequest.getParameter("title");
		String content = multipartRequest.getParameter("content");
		
		// DB로 보낼 UploadDTO
		UploadDTO upload = UploadDTO.builder()
				.title(title)
				.content(content)
				.build();
		
		// System.out.println(upload);	// uploadNo 없다.
		
		// DB에 UploadDTO 저장
		int uploadResult = uploadMapper.insertUpload(upload);	// <selectkey>에 의해서 인수 upload에 uploadNo 값이 저장된다.
		
		// System.out.println(upload);	// insert 하고 나면 uploadNo 있다.
		
		
		/* 
			1번 게시글에 첨부 3개
			1/제목/내용/1121/1121
											// 시퀀스는 디비에서 만든다. 근데 서비스에서는 시퀀스 몇 번을 썼는지 알 수 없다.
			1/STORAGE/사과/APPLE/0/1		// 0은 다운로드 횟수, 1은 시퀀스 번호
			2/STORAGE/바나나/BANANA/0/1
			3/STORAGE/체리/CHERRY/0/1
		*/
		
		/* ATTACH 테이블에 저장하기 */
		

		
		// 첨부된 파일 목록
		List<MultipartFile> files = multipartRequest.getFiles("files");	// <input type="file" name="files">

		// 첨부 결과
		int attachResult = 0;
		// files[0] (x) → files.get(0).getSize() == 0 : 첫번째 요소 사이즈 가져오기
		//				  files.get(0).getOriginalFilename().isEmpty()도 가능한데 너무 길다.
		if(files.get(0).getSize() == 0) {	// 첨부가 없는 경우 (files 리스트에 [MultipartFile[field="files", filename=, contentType=application/octet-stream, size=0]] 이렇게 저장되어 있어서 files.size()가 1이다.
			attachResult = 1;
		} else {
			attachResult = 0;
		}
		
		// 첨부된 파일 목록 순회(하나씩 저장) (첨부파일 개수만큼 for문 돈다)
		for(MultipartFile multipartFile : files) {
			
			try {
				
				// 첨부가 있는지 점검
				if(multipartFile != null && multipartFile.isEmpty() == false) {	// 둘 다 필요함
					
					// 원래 이름
					String origin = multipartFile.getOriginalFilename();
					origin = origin.substring(origin.lastIndexOf("\\") + 1);	// IE는 origin에 전체 경로가 붙어서 파일명만 사용해야 함
				
					// 저장할 이름
					String filesystem = myFileUtil.getFilename(origin);
					
					// 저장할 경로
					String path = myFileUtil.getTodayPath();
					
					// 저장할 경로 만들기
					File dir = new File(path);
					if(dir.exists() == false) {
						dir.mkdirs();	// mkdirs에서 s 안들어가면 오류남
					}
					
					// 첨부할 File 객체
					File file = new File(dir, filesystem);
					
					// 첨부파일 서버에 저장 (업로드 진행)
					multipartFile.transferTo(file);		// 필요한 복사 작업을 해줌
					
					// AttachDTO 생성
					AttachDTO attach = AttachDTO.builder()
							.path(path)
							.origin(origin)
							.filesystem(filesystem)
							.uploadNo(upload.getUploadNo())
							.build();
						
					// DB에 AttachDTO 저장
					// 첨부된 개수랑 attachResult와 같은지 비교
					attachResult += uploadMapper.insertAttach(attach);	// 받기만 하면 세개 모두 성공했는지 알 수 었다. 누적을 시켜줘야 함
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	// for
		
		
		// 응답
		try {
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			if(uploadResult > 0 && attachResult == files.size()) {
				out.println("<script>");
				out.println("alert('업로드 되었습니다.');");
				out.println("location.href='" + multipartRequest.getContextPath() + "/upload/list'");
				out.println("</script>");
			} else {
				out.println("<script>");
				out.println("alert('업로드 실패했습니다.');");
				out.println("history.back();");
				out.println("</script>");
			}
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 첨부가 없이 글 작성 시 attachResult = 0이고, files.size() = 1 이라서 업로드 실패했습니다. 라는 메세지가 떴었다.
	}
	
	// select는 @Transactional 대상이 아니다.	
	@Override
	public void getUploadByNo(int uploadNo, Model model) {
		// 2가지 종류를 싣어야 하니까 model에 편하게 싣어서 이동
		model.addAttribute("upload", uploadMapper.selectUploadByNo(uploadNo));
		model.addAttribute("attachList", uploadMapper.selectAttachList(uploadNo));
	}
	
	@Override
	// ResponseEntity는 페이지 변화 없이 값만 반환. (ajax 같은 상황)
	// 다운로드할 때 페이지가 변경되지 않으니까
	public ResponseEntity<Resource> download(String userAgent, int attachNo) {
		
		// 다운로드 할 첨부 파일의 정보(경로, 이름)
		AttachDTO attach = uploadMapper.selectAttachByNo(attachNo);
		File file = new File(attach.getPath(), attach.getFilesystem());		// (경로, 파일명) 원본 이름은 DB에만 있는거야  Filesystem : 영문+숫자로 파일명 변경 해놓은것
		
		// 반환할 Resource
		Resource resource = new FileSystemResource(file);	// file 전달
		
		// Resource가 없으면 종료 (다운로드할 파일이 없음)
		if(resource.exists() == false) {
			return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);	
		}
		
		// 다운로드 횟수 증가
		uploadMapper.updateDownloadCnt(attachNo);
		
		// 다운로드 되는 파일명(브라우저 마다 다르게 세팅)
		String origin = attach.getOrigin();
		try {
			
			// IE (userAgent에 "Trident"가 포함되어 있음)
			if(userAgent.contains("Trident")) {
				origin = URLEncoder.encode(origin, "UTF-8").replaceAll("\\+", " ");	// replaceAll("+", " ")는 안된다 왜냐 +가 따로 하는 일이 있어서
			}
			// Edge (userAgent에 "Edg"가 포함되어 있음)
			else if(userAgent.contains("Edg")) {
				origin = URLEncoder.encode(origin, "UTF-8");
			}
			// 나머지
			else {
				origin = new String(origin.getBytes("UTF-8"), "ISO-8859-1");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 다운로드 헤더 만들기
		// 실제로 반환할 리소스, 헤더, 상태값
		HttpHeaders header = new org.springframework.http.HttpHeaders();
		header.add("Content-Disposition", "attachment; filename=" + origin);
		header.add("Content-Length", file.length() + "");
		
		return new ResponseEntity<Resource>(resource, header, HttpStatus.OK);
	}
	
	@Override
	public void removeAttachByAttachNo(int attachNo) {
		
		// 삭제할 Attach 정보 가져오기
		// 삭제하면 되돌릴 수 없으니까
		AttachDTO attach = uploadMapper.selectAttachByNo(attachNo);
		
		// DB에서 Attach 정보 삭제
		int result = uploadMapper.deleteAttachByAttachNo(attachNo);
		
		// 첨부 파일 삭제
		if(result > 0) {
			
			// 첨부 파일을 File 객체로 만듬
			File file = new File(attach.getPath(), attach.getFilesystem());	// 경로, 파일명
			
			// 삭제
			if(file.exists()) {	// 파일이 존재하면
				file.delete();	// 파일 삭제해라
			}
		}
	}
	
}

package service;

import java.util.List;
import java.util.Map;

import domain.Notice;

public interface NoticeService {
	
	public int getAllNoticesCnt();
	public List<Notice> findAllNotices(Map<String, Object> map);
	

}

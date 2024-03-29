package com.example.spring01.controller.board;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring01.model.board.dto.ReplyDTO;
import com.example.spring01.service.board.Pager;
import com.example.spring01.service.board.ReplyService;

@RestController
@RequestMapping("/reply/*")
public class ReplyController {
	
	@Inject
	ReplyService replyService;
	
	@RequestMapping("insert.do")
	public void insert(@ModelAttribute ReplyDTO dto, HttpSession session) {
		String userid=(String)session.getAttribute("userid");
		dto.setReplyer(userid);
		replyService.create(dto);
	}
	
	@RequestMapping(value="/delete/{rno}", method=RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable("rno") int rno){
		ResponseEntity<String> entity=null;
		try {
			replyService.delete(rno);
			entity=new ResponseEntity<>("success", HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			entity=new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	@RequestMapping(value="insert_rest.do",
			method=RequestMethod.POST)
	public ResponseEntity<String> insert_rest(
			@RequestBody ReplyDTO dto, HttpSession session){
		ResponseEntity<String> entity=null;
		try {
			String userid=(String)session.getAttribute("userid");
			dto.setReplyer(userid);
			replyService.create(dto);
			entity=new ResponseEntity<String>(
					"success",HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity=new ResponseEntity<String>(
					e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	@RequestMapping(value="/detail/{rno}", method=RequestMethod.GET)
	public ModelAndView reply_detail(@PathVariable("rno") int rno, ModelAndView mav) {
		ReplyDTO dto=replyService.detail(rno);
		mav.setViewName("board/reply_detail");
		mav.addObject("dto",dto);
		return mav;
	}
	@RequestMapping(value="/list/{bno}/{curPage}", method=RequestMethod.GET)
	public ModelAndView reply_list(
			@PathVariable("bno") int bno,
			@PathVariable int curPage,
			ModelAndView mav,
			HttpSession session) {
		int count=replyService.count(bno);
		Pager pager=new Pager(count,curPage);
		int start=pager.getPageBegin();
		int end=pager.getPageEnd();
		List<ReplyDTO> list=replyService.list(bno, start, end, session);
		mav.setViewName("board/reply_list");
		mav.addObject("list",list);
		mav.addObject("pager",pager);
		return mav;
	}
	@RequestMapping("list.do")
	public ModelAndView list(@RequestParam int bno,
			@RequestParam(defaultValue="1") int curPage, ModelAndView mav, HttpSession session) {
		int count=replyService.count(bno);
		Pager pager=new Pager(count,curPage);
		int start=pager.getPageBegin();
		int end=pager.getPageEnd();
		List<ReplyDTO> list=replyService.list(bno, start, end, session);
		mav.setViewName("board/reply_list");
		mav.addObject("list", list);
		mav.addObject("pager", pager);
		return mav;
	}
	@RequestMapping(value="/update/{rno}", method= {RequestMethod.PUT, RequestMethod.PATCH})
	public ResponseEntity<String> update(
			@PathVariable("rno") int rno,@RequestBody ReplyDTO dto){
		ResponseEntity<String> entity=null;
		try {
			dto.setRno(rno);
			replyService.update(dto);
			entity=new ResponseEntity<String>("success",HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity=new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	@RequestMapping("list_json.do")
	public @ResponseBody List<ReplyDTO> list_json(
			@RequestParam(defaultValue="1") int curPage, @RequestParam int bno,
			HttpSession session) {
		int count=10; //댓글 갯수
		Pager pager=new Pager(count,curPage);
		int start=pager.getPageBegin();
		int end=pager.getPageEnd();
		List<ReplyDTO> list
		=replyService.list(bno,start,end,session);
		return list;
	}
}

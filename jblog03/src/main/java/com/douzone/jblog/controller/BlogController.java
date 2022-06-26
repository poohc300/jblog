package com.douzone.jblog.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.douzone.jblog.exception.FileUploadException;
import com.douzone.jblog.security.Auth;
import com.douzone.jblog.security.AuthUser;
import com.douzone.jblog.service.BlogService;
import com.douzone.jblog.service.FileUploadService;
import com.douzone.jblog.vo.BlogVo;
import com.douzone.jblog.vo.UserVo;

@Controller
@RequestMapping("/{id:(?!assets).*}")
public class BlogController {

	@Autowired
	private BlogService blogService;
	@Autowired
	private FileUploadService fileUploadService;
	
	@ResponseBody
	@RequestMapping({"", "/{pathNo1}", "/{pathNo1}/{pathNo2}"})
	public String index(
		@PathVariable("id") String id,
		@PathVariable("pathNo1") Optional<Long> pathNo1,
		@PathVariable("pathNo2") Optional<Long> pathNo2, Model model) {
		
		Long categoryNo = 0L;
		Long postNo = 0L;
		
		if(pathNo2.isPresent()) {
			categoryNo = pathNo1.get();
			postNo = pathNo2.get();
		} else if(pathNo1.isPresent()) {
			categoryNo = pathNo1.get();
		}
		BlogVo blogVo = blogService.getAll(id);
		
		model.addAttribute("blogVo", blogVo);
		model.addAttribute("blog", blogVo.getTitle());
		
		return "/blog/main";
	}
	
	
	@RequestMapping("/admin/basic")
	public String adminBasic(@PathVariable("id") String id, @AuthUser UserVo authUser, Model model) {
		if(!authUser.getId().equals(id)) {
			return "redirect:/";
		}
		BlogVo blogVo = blogService.getAll(id);
		
		model.addAttribute("blogVo", blogVo);
		model.addAttribute("blog", blogService.getBlog(id));
		
		return "/blog/admin/basic";
	}
	@RequestMapping(value = "/admin/basic", method = RequestMethod.POST)
	public String adminBasic(@PathVariable("id") String id, @AuthUser UserVo authUser,
			@RequestParam("logo-file") MultipartFile multipartFile, BlogVo vo) throws FileUploadException {

		if (!authUser.getId().equals(id)) {
			return "redirect:/";
		}

		String url = fileUploadService.restoreImage(multipartFile);
		vo.setLogo(url);
		vo.setId(authUser.getId());
		blogService.updateBlog(vo);

		return "redirect:/" + id;
	}
}
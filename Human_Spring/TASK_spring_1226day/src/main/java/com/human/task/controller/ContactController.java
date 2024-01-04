package com.human.task.controller;

import com.human.task.dto.ContactDTO;
import com.human.task.dto.PageVO;
import com.human.task.service.ContactServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@Controller
public class ContactController {
    @Inject
    private ContactServiceImpl contactService;

    // 모든 게시글 보기
    @RequestMapping(value = "ContactUS", method = RequestMethod.GET)
    public String contactView(Model model, @ModelAttribute PageVO pageVO){
        if(pageVO.getPage()==null){pageVO.setPage(1);}
        pageVO.setTotalCount(contactService.totalPostCont());
        pageVO.prt();
        model.addAttribute("list", contactService.selectAll(pageVO));
        model.addAttribute("pagevo", pageVO);
        return "ContactUsView";
    }

    // 게시글 추가 클릭 -> 게시글 추가form으로 이동
    @RequestMapping(value = "/addWrite", method = RequestMethod.GET)
    public String wr(Model model) {
        return "AddPost";
    }

    // 게시글 저장
    @RequestMapping(value = "/addCommit", method = RequestMethod.POST)
    public String save(ContactDTO contactDTO){
        contactService.insertPost(contactDTO);
        return "redirect:/ContactUS";
    }

    // 게시글 단건 찾아오는 메서드
    @RequestMapping(value="/selectPost", method = RequestMethod.POST)
    public String selectPost(Model model, @RequestParam("contactNum") int contactNum){
        model.addAttribute("post", contactService.selectPost(contactNum));
        return "editPost";
    }

    // 게시글 수정 업데이트
    @RequestMapping(value="/editPost", method = RequestMethod.POST)
    public String editPost(ContactDTO contactDTO){
        contactService.editPost(contactDTO);
        return "redirect:/ContactUS";
    }

    // 게시글 삭제 메서드
    @RequestMapping(value="/deletePost", method = RequestMethod.POST)
    public String delete(@RequestParam("contactNum") int contactNum){
        contactService.deletePost(contactNum);
        return "redirect:/ContactUS";
    }

    // 게시글 내용보기 메서드
    @RequestMapping(value = "/showPost", method = RequestMethod.GET)
    public String postSelect(Model model, @RequestParam("contactNum") int contactNum){
        model.addAttribute("post", contactService.selectPost(contactNum));
        return "showPost";
    }
}

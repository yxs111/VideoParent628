package com.qfedu.controller;

import com.github.pagehelper.PageInfo;
import com.qfedu.pojo.Speaker;
import com.qfedu.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/speaker")
public class SpeakerController {

    @Autowired
    private SpeakerService speakerService;

    @RequestMapping(value="/list")
    public String list(Model model, @RequestParam(name = "page",required = false,defaultValue="1") int page, @RequestParam(name="pageSize",required = false,defaultValue="5")int pageSize){
        List<Speaker> speakerList = speakerService.selectAllSpeaker(page,pageSize);


        PageInfo<Speaker> pageInfo =new PageInfo<Speaker>(speakerList);

        model.addAttribute("pageInfo",pageInfo);
        return "behind/speakerList";
    }
    @RequestMapping("/deleteSpeakerById")
    @ResponseBody
    public String deleteSpeakerById(Integer id){
     boolean result=   speakerService.deleteSpeakerById(id);
        if (result){
            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            return "success";
        }else {
            return "fail";
        }

    }
@RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Speaker speaker){
    System.out.println(speaker);
    System.out.println("保存前："+ speaker.getId());
    speakerService .saveOrUpdate(speaker);
    System.out.println("保存之后："+speaker.getId());
    return "redirect:/speaker/list";
}
    @RequestMapping("/insertSpeaker")
    public String insertSpeaker(){
        return "behind/addSpeaker";
//        model.addAttribute();
    }
    @RequestMapping("/updateSpeaker")
    public String updateSpeaker(Model model ,int id){
         Speaker speaker = speakerService.findSpeakerById(id);
         model.addAttribute("speaker",speaker);
        return "behind/addSpeaker";
    }
}

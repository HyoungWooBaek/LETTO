package com.letto.www.Controller;

import com.letto.www.dto.BoardDto;
import com.letto.www.dto.JungsanDto;
import com.letto.www.service.JungsanService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class JungsanController {
    private JungsanService jungsanService;

    @GetMapping("admin/inputjungsan")
    public String list(Model model, @RequestParam(value="page", defaultValue = "1") Integer pageNum) {
        List<JungsanDto> jungsanList = jungsanService.getJungsanlist(pageNum);
        Integer[] pageList = jungsanService.getPageList(pageNum);

        model.addAttribute("jungsanList", jungsanList);
        model.addAttribute("pageList", pageList);
        return "admin/inputjungsan.html";
    }

    @PostMapping("admin/add")
    public String write(JungsanDto jungsanDto) {
        jungsanService.savePost(jungsanDto);
        return "redirect:/admin/inputjungsan";
    }

    @GetMapping("/jungsan/edit/{no}")
    public String edit(@PathVariable("no") Long no, Model model) {
        JungsanDto jungsanDto = jungsanService.getPost(no);

        model.addAttribute("jungsanDto", jungsanDto);
        return "admin/jungsanupdate.html";
    }

    @PutMapping("/jungsan/edit/{no}")
    public String update(JungsanDto jungsanDto) {
        jungsanService.savePost(jungsanDto);

        return "redirect:/admin/inputjungsan";
    }

    @DeleteMapping("admin/delete/{no}")
    public String delete(@PathVariable("no") Long no) {
        jungsanService.deletePost(no);
        return "redirect:/admin/inputjungsan";
    }

    @GetMapping("/junsan/search")
    public String search(@RequestParam(value="keyword") String keyword, Model model){
        List<JungsanDto> jungsanDtoList = jungsanService.searchPosts(keyword);
        model.addAttribute("jungsanList", jungsanDtoList);

        return "admin/inputjungsan.html";
    }
}

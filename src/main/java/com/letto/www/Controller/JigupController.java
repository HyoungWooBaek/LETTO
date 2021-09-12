package com.letto.www.Controller;

import com.letto.www.dto.JigupDto;
import com.letto.www.dto.JungsanDto;
import com.letto.www.service.JigupService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class JigupController {
    private JigupService jigupService;

    @GetMapping("admin/inputjigup")
    public String list(Model model) {
        List<JigupDto> jungsanSumList = jigupService.getJungsanSumList();
        model.addAttribute("jungsanSumList", jungsanSumList);

        return "admin/inputjigup.html";
    }
}

package com.letto.www.Controller;

import com.letto.www.dto.BoardDto;
import com.letto.www.dto.JungsanDto;
import com.letto.www.service.BoardService;
import com.letto.www.service.JungsanService;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class HomeController {
    private BoardService boardService;
    private JungsanService jungsanService;

    @GetMapping("/member")
    public String user(Model model, @RequestParam(value="page", defaultValue = "1") Integer pageNum) {
        List<BoardDto> boardList = boardService.getMainBoardlist(pageNum);
        model.addAttribute("boardList", boardList);
        return "main_m.html";
    }

    @GetMapping("/admin")
    public String admin(Model model, @RequestParam(value="page", defaultValue = "1") Integer pageNum) {
        List<BoardDto> boardList = boardService.getMainBoardlist(pageNum);
        model.addAttribute("boardList", boardList);
        return "admin/main.html";
    }
}

package com.example.demo20210724.jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/jpa")
@RequiredArgsConstructor
public class JpaTodoController {

    private final JpaTodoService jpaTodoService;

    @GetMapping("todoList")
    public String select (Model model) {
        model.addAttribute("todoList", jpaTodoService.findAll());
        return "todoList";
    }

    @PostMapping("todoList")
    public @ResponseBody
    String insert (@RequestBody List<String> stringList) {
        jpaTodoService.insert(stringList);
        return "ok";
    }

    @PutMapping("todoList")
    public @ResponseBody String update (@RequestBody List<Integer> idxList) {
        jpaTodoService.changeDone(idxList);
        return "ok";
    }

    @DeleteMapping("todoList")
    public @ResponseBody String delete (@RequestBody List<Integer> idxList) {
        jpaTodoService.delete(idxList);
        return "ok";
    }
}

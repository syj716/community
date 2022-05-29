package com.nowcoder.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import org.springframework.ui.Model;

@Controller
@RequestMapping("alpha")
public class AlphaController {
    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response){
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String key = headerNames.nextElement();
            String value = request.getHeader(key);
            System.out.println(key + " " + value);
        }
        System.out.println(request.getParameter("code"));
    }
    //get:student?name="jz"
    @RequestMapping(path="/student",method = RequestMethod.GET)
    @ResponseBody
    //@RequestParam获取参数
    //@ResponseBody注解都会处理返回的数据格式，使用了该类型注解后返回的不再是视图，不会进行转跳，而是返回json或xml数据格式，输出在页面上。
    public String student(@RequestParam(name="name",required = false,defaultValue = "syj") String name){
        System.out.println(name);
        return "student success";
    }
    //get:student/3
    @RequestMapping(path="/student/{id}",method = RequestMethod.GET)
    @ResponseBody
    //PathVariable获取路径参数
    public String studentid(@PathVariable(name="id") int id){
        System.out.println(id);
        return "id success";
    }
    //post:student
    @RequestMapping(path="/student",method = RequestMethod.POST)
    @ResponseBody
    public String submit(@RequestParam(name="name")String name,@RequestParam(name="age")String age){
        System.out.println(name);
        System.out.println(age);
        return "submit success";
    }
    //相应请求
    /*
    @RequestMapping(path="/teacher",method = RequestMethod.GET)
    public ModelAndView GetTeacher(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("name","蒋哲");
        modelAndView.addObject("age","22");
        modelAndView.setViewName("/demo/view");
        return modelAndView;
    }

     */
    //不加ResponseBody会跳转，这个是动态html
    @RequestMapping(path = "/teacher", method = RequestMethod.GET)
    public ModelAndView getTeacher() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("name", "张三");
        mav.addObject("age", 30);
        mav.setViewName("/demo/view");
        return mav;
    }
    @RequestMapping(path="/school",method = RequestMethod.GET)
    public String GetSchool(Model model){
        model.addAttribute("name","蒋哲");
        model.addAttribute("age","22");
        return "/demo/view";
    }
    //转为json对象
    @RequestMapping(path = "/emp",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> GetEmp(){
        Map<String,Object> map=new HashMap<>();
        map.put("蒋哲","孙燕杰");
        map.put("孙燕杰","蒋哲");
        map.put("师兄爱","宝宝");
        map.put("宝宝爱","师兄");
        return map;
    }
}

package com.mkyong.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/welcome")
public class HelloController {

 /**
 * printWelcome.
 * @param  model
 * @return      hello
 */
  @RequestMapping(method = RequestMethod.GET)
  public String printWelcome(@RequestParam final ModelMap model) {
    model.addAttribute("message", "Spring Security Hello World");
    return "hello";
  }
}

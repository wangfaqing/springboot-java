package org.wfq.odo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Api(value = "/hello")
public class HelloController {

    @ApiOperation(value="hello", notes="hello")
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    @ResponseBody
    public String hello(String word){
        return "hello " + word;
    }

}

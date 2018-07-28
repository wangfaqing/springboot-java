package org.wfq.odo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wfq.odo.dao.firstly.CustomerMapper;
import org.wfq.odo.dao.secondary.StudentMapper;
import org.wfq.odo.entity.firstly.Customer;
import org.wfq.odo.entity.secondary.Student;

@Controller
@Api(value = "/hello")
public class HelloController {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @ApiOperation(value="hello", notes="hello")
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    @ResponseBody
    public String hello(String id){
        Student student = studentMapper.getStuNameById(Integer.valueOf(id));
        Customer customer = customerMapper.getCusNameBuyId(Integer.valueOf(id));
        return "hello " + customer.getUserName() + "<br/>" + "hello " + student.getStuName();
    }

}

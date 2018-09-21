package org.wfq.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wfq.demo.common.util.ResponseBean;
import org.wfq.demo.common.util.ResultEnum;
import org.wfq.demo.dao.firstly.CustomerMapper;
import org.wfq.demo.dao.secondary.StudentMapper;
import org.wfq.demo.entity.firstly.Customer;
import org.wfq.demo.entity.secondary.Student;

@Controller
@Api(value = "/hello")
public class HelloController {
    public static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @ApiOperation(value="hello", notes="hello")
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    @ResponseBody
    public ResponseBean<Object> hello(String id){
        Customer customer = customerMapper.getCusNameBuyId(Integer.valueOf(id));
        LOGGER.info("第一个数据源数据[{}]",customer.getUserName());
        Student student = studentMapper.getStuNameById(Integer.valueOf(id));
        LOGGER.info("第二个数据源数据[{}]",student.getStuName());
        return new ResponseBean<>(ResultEnum.Success);
    }

}

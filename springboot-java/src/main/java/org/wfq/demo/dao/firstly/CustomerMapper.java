package org.wfq.demo.dao.firstly;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.wfq.demo.common.util.MyMapper;
import org.wfq.demo.entity.firstly.Customer;

@Repository
public interface CustomerMapper extends MyMapper<Customer, Integer> {

    Customer getCusNameBuyId(@Param("id")Integer id);

}
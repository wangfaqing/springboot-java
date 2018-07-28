package org.wfq.odo.dao.firstly;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.wfq.odo.common.util.MyMapper;
import org.wfq.odo.entity.firstly.Customer;

@Repository
public interface CustomerMapper extends MyMapper<Customer, Integer> {

    Customer getCusNameBuyId(@Param("id")Integer id);

}
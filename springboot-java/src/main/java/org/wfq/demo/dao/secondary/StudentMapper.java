package org.wfq.demo.dao.secondary;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.wfq.demo.common.annotation.Ds;
import org.wfq.demo.common.constants.DataSourceType;
import org.wfq.demo.common.util.MyMapper;
import org.wfq.demo.entity.secondary.Student;

@Repository
@Ds(DataSourceType.SLAVE_DATASOURCE)
public interface StudentMapper extends MyMapper<Student, Integer> {

    Student getStuNameById(@Param("id")Integer id);

}
package org.wfq.odo.dao.secondary;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.wfq.odo.common.util.MyMapper;
import org.wfq.odo.entity.secondary.Student;

@Repository
public interface StudentMapper extends MyMapper<Student, Integer> {

    Student getStuNameById(@Param("id")Integer id);

}
package org.wfq.demo.common.util;

import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

/**
 * 
 * @Description: 公共的mapper接口
 * @author zhouxi
 * @date 2017年8月26日 上午11:09:02
 * @param <T>
 */
public interface MyMapper<T, ID> extends Mapper<T>, MySqlMapper<T> {

    /**
     * @Title: selectListHandler
     * @Description: 根据条件查询出数据(单表)
     * @param: @param s
     * @param: @return
     * @return: List
     * @throws
     */
    List<T> selectListHandler(T s);

    /**
     * @Title: changeStatus
     * @Description: 修改状态
     * @param: @param status
     * @param: @param ids
     * @param: @return
     * @return: int
     * @throws
     */
    int changeStatus(@Param("status") Integer status, @Param("ids") List<ID> ids);

    /**
	 * @ClassName: MyMapper
	 * @Description: 删除数据信息
	 * @Params:
	 * @Date 2018/1/11 19:49
	 */
	int deleteByIds(@Param("ids") List<ID> ids);

    /**
    * @ClassName: MyMapper
    * @Description: 批量插入
    * @Params: 
    * @Date 2018/1/14 17:58
    */
    
    int batchInsertT(@Param("batchList") List<T> list);
    
    /**
     * @ClassName: MyMapper
     * @Description: 根据日期来删除数据
     * @Params: 
     * @Date 2018/1/17 16:38
     */
    int deleteByDateStr(String dateStr);
}

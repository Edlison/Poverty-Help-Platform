package com.edlison.marketing.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * CronMapper
 *
 * @Author Edlison
 * @Date 1/22/21 10:37
 */
@Mapper
public interface CronMapper {

    @Select("select cron_detail from cron where cron_id = #{cron_id}")
    String selectCron(@Param("cron_id") int id);
}

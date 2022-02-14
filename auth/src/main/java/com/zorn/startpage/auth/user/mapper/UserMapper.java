package com.zorn.startpage.auth.user.mapper;

import com.zorn.startpage.auth.user.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wzh
 * @since 2022-02-14 04:26:42
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}

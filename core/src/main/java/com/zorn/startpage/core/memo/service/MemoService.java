package com.zorn.startpage.core.memo.service;

import com.zorn.startpage.auth.user.entity.User;
import com.zorn.startpage.base.dto.PageinateDto;
import com.zorn.startpage.core.memo.entity.Memo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wzh
 * @since 2022-02-17 12:42:26
 */
public interface MemoService extends IService<Memo> {
    Object findAll(User user, PageinateDto pageinateDto);
}

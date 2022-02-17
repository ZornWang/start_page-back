package com.zorn.startpage.core.memo.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zorn.startpage.auth.user.entity.User;
import com.zorn.startpage.base.dto.PageinateDto;
import com.zorn.startpage.base.utils.WrapperUtils;
import com.zorn.startpage.core.memo.entity.Memo;
import com.zorn.startpage.core.memo.mapper.MemoMapper;
import com.zorn.startpage.core.memo.service.MemoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zorn.startpage.core.memo.vo.MemoPageVO;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wzh
 * @since 2022-02-17 12:42:26
 */
@Service
public class MemoServiceImpl extends ServiceImpl<MemoMapper, Memo> implements MemoService {
    @Override
    public Object findAll(User user, PageinateDto pageinateDto) {
        if (pageinateDto.getCurrent() == null || pageinateDto.getSize() == null) {
            return list(WrapperUtils.getQueryWrapper("user_id", user.getId()));
        } else {
            Page<Memo> memoPage = page(new Page<>(pageinateDto.getCurrent(), pageinateDto.getSize()), WrapperUtils.getQueryWrapper("user_id", user.getId()));
            return MemoPageVO.pageResult(memoPage);
        }
    }
}

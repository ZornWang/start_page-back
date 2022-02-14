package com.zorn.startpage.core.background.service.impl;

import com.zorn.startpage.base.enums.COSUrl;
import com.zorn.startpage.base.enums.ResultStatus;
import com.zorn.startpage.base.utils.TXUtil;
import com.zorn.startpage.core.background.entity.Background;
import com.zorn.startpage.core.background.mapper.BackgroundMapper;
import com.zorn.startpage.core.background.service.BackgroundService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wzh
 * @since 2022-02-14 09:18:50
 */
@Service
public class BackgroundServiceImpl extends ServiceImpl<BackgroundMapper, Background> implements BackgroundService {

    @Autowired
    private TXUtil txUtil;

    @Override
    public String uploadBackground(String username, MultipartFile file) {
        String fileName = username + "_background_" + System.currentTimeMillis();
        return txUtil.uploadfile(Objects.requireNonNull(file, ResultStatus.FILE_IS_NULL.getMessage()), COSUrl.USERBACKGROUND.getUrl(), fileName);
    }
}

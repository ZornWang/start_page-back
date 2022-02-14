package com.zorn.startpage.core.background.service;

import com.zorn.startpage.core.background.entity.Background;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wzh
 * @since 2022-02-14 09:18:50
 */
public interface BackgroundService extends IService<Background> {
    String uploadBackground(String username, MultipartFile file);
}

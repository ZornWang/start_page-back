package com.zorn.startpage;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zorn.startpage.core.memo.entity.Memo;
import com.zorn.startpage.core.memo.service.MemoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MainApplicationTest {
    @Autowired
    private MemoService memoService;

    @Test
    void testPage() {
        Page<Memo> memoPage = new Page<>(1,10);
        Page<Memo> page = memoService.page(memoPage);
        System.out.println(page);
    }
}

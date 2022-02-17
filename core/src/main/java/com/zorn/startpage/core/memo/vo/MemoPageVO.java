package com.zorn.startpage.core.memo.vo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zorn.startpage.core.memo.entity.Memo;
import lombok.Data;

import java.util.List;

@Data
public class MemoPageVO {
    private List<Memo> records;
    private Long total;
    private Long size;
    private Long current;

    public static MemoPageVO pageResult(Page<Memo> page) {
        MemoPageVO memoPageVO = new MemoPageVO();
        memoPageVO.setCurrent(page.getCurrent());
        memoPageVO.setSize(page.getSize());
        memoPageVO.setTotal(page.getTotal());
        memoPageVO.setRecords(page.getRecords());
        return memoPageVO;
    }
}

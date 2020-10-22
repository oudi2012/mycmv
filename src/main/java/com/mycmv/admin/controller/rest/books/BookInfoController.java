package com.mycmv.admin.controller.rest.books;

import com.alibaba.fastjson.JSON;
import com.mycmv.server.constants.LogConstants;
import com.mycmv.server.model.AbstractUser;
import com.mycmv.server.model.ResponseObject;
import com.mycmv.server.model.base.vo.LongIdListVo;
import com.mycmv.server.model.books.entry.BookInfo;
import com.mycmv.server.model.books.vo.BookListVo;
import com.mycmv.server.service.book.BookInfoService;
import com.mycmv.server.utils.CommonUtils;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/***
 * 书籍管理
 * @author a
 */
@RestController
@RequestMapping("book")
public class BookInfoController{

    private static final Logger logger = LoggerFactory.getLogger(LogConstants.ADM_LOG);

    @Resource
    private BookInfoService bookInfoService;

    @ResponseBody
    @GetMapping("pageList")
    public ResponseObject pageList(AbstractUser user, BookInfo bookItem, int pageIndex, int pageSize) {
        String url = "book/pageList";
        logger.info("用户 {} ，访问 {} , 参数：{}，{}，{}", user.getUserName(), url, JSON.toJSON(bookItem), pageIndex, pageSize);
        ResponseObject responseObject = new ResponseObject();
        PageInfo<BookInfo> pageInfo = bookInfoService.pageList(bookItem, pageIndex, pageSize);
        logger.info("返回结果 list 条数：{}", pageInfo.getSize());
        CommonUtils.executeSuccess(responseObject, pageInfo);
        return responseObject;
    }


    @ResponseBody
    @GetMapping("list")
    public ResponseObject list(AbstractUser user, BookInfo bookItem) {
        String url = "book/list";
        logger.info("用户 {} ，访问 {} , 参数：{}", user.getUserName(), url, JSON.toJSON(bookItem));
        ResponseObject responseObject = new ResponseObject();
        List<BookInfo> list = bookInfoService.list(bookItem);
        if (CollectionUtils.isEmpty(list)) {
            logger.info("返回结果 list 条数：0");
        } else {
            logger.info("返回结果 list 条数：{}", list.size());
        }
        CommonUtils.executeSuccess(responseObject, list);
        return responseObject;
    }


    @ResponseBody
    @GetMapping("findById")
    public ResponseObject findById(AbstractUser user, int bookId) {
        String url = "book/findById";
        logger.info("用户 {} ，访问 {} , 参数：{}", user.getUserName(), url, bookId);
        ResponseObject responseObject = new ResponseObject();
        BookInfo tmp = bookInfoService.findById(bookId);
        if (ObjectUtils.isEmpty(tmp)) {
            logger.info("返回结果 null");
        } else {
            logger.info("返回结果 {}", JSON.toJSONString(tmp));
        }
        CommonUtils.executeSuccess(responseObject, tmp);
        return responseObject;
    }


    @ResponseBody
    @PostMapping("create")
    public ResponseObject create(AbstractUser user, @RequestBody BookInfo item) {
        String url = "book/create";
        logger.info("用户 {} ，访问 {} , 参数：{}", user.getUserName(), url, JSON.toJSON(item));
        ResponseObject responseObject = new ResponseObject();
        bookInfoService.insert(item);
        CommonUtils.executeSuccess(responseObject);
        return responseObject;
    }


    @ResponseBody
    @PostMapping("edit")
    public ResponseObject edit(AbstractUser user, @RequestBody  BookInfo item) {
        String url = "book/create";
        logger.info("用户 {} ，访问 {} , 参数：{}", user.getUserName(), url, JSON.toJSON(item));
        ResponseObject responseObject = new ResponseObject();
        bookInfoService.insert(item);
        CommonUtils.executeSuccess(responseObject);
        return responseObject;
    }


    @ResponseBody
    @PostMapping("batchCreate")
    public ResponseObject batchCreate(AbstractUser user, @RequestBody BookListVo bookListVo) {
        String url = "book/batchCreate";
        logger.info("用户 {} ，访问 {} , 数量：{}", user.getUserName(), url, bookListVo.getBookInfoList().size());
        ResponseObject responseObject = new ResponseObject();
        bookInfoService.batchInsert(bookListVo.getBookInfoList());
        CommonUtils.executeSuccess(responseObject);
        return responseObject;
    }


    @ResponseBody
    @PostMapping("remove")
    public ResponseObject delete(AbstractUser user, @RequestBody LongIdListVo longIdListVo) {
        logger.info("用户 {} ，访问 {} , 数量：{}", user.getUserName(), "book/remove", JSON.toJSON(longIdListVo));
        ResponseObject resObj = new ResponseObject();
        if (CollectionUtils.isEmpty(longIdListVo.getIds())) {
            longIdListVo.setIds(Collections.singletonList(longIdListVo.getId()));
        }
        CommonUtils.executeSuccess(resObj, bookInfoService.delete(longIdListVo.getIds()));
        return resObj;
    }
}

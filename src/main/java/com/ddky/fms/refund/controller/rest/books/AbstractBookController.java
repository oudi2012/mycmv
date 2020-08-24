package com.ddky.fms.refund.controller.rest.books;

import com.alibaba.fastjson.JSON;
import com.ddky.fms.refund.configuration.CurrentUser;
import com.ddky.fms.refund.configuration.UserLoginToken;
import com.ddky.fms.refund.constants.LogConstants;
import com.ddky.fms.refund.model.AbstractUser;
import com.ddky.fms.refund.model.ResponseObject;
import com.ddky.fms.refund.model.books.BookInfo;
import com.ddky.fms.refund.service.book.BookService;
import com.ddky.fms.refund.utils.CommonUtils;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/***
 * 书籍管理
 * @author a
 */
public abstract class AbstractBookController<T extends BookInfo> implements BookInfoApiFunc<T>{

    private static final Logger logger = LoggerFactory.getLogger(LogConstants.ADM_LOG);

    /***
     * 获取服务接口
     * @return  BookService
     */
    public abstract BookService<T> getBookService();

    /***
     * 获取访问根目录
     * @return String
     */
    public String getRootPath() {
        return this.getClass().getAnnotation(RequestMapping.class).value()[0];
    }

    @Override
    @UserLoginToken
    @ResponseBody
    @GetMapping("pageList")
    public ResponseObject pageList(@CurrentUser AbstractUser user, T t, int pageIndex, int pageSize) {
        String url = getRootPath() + "/pageList";
        logger.info("用户 {} ，访问 {} , 参数：{}，{}，{}", user.getUserName(), url, JSON.toJSON(t), pageIndex, pageSize);
        ResponseObject responseObject = new ResponseObject();
        PageInfo<T> pageInfo = getBookService().pageList(t, pageIndex, pageSize);
        logger.info("返回结果 list 条数：{}", pageInfo.getSize());
        CommonUtils.executeSuccess(responseObject, pageInfo);
        return responseObject;
    }

    @Override
    @UserLoginToken
    @ResponseBody
    @GetMapping("list")
    public ResponseObject list(@CurrentUser AbstractUser user, T t) {
        String url = getRootPath() + "/list";
        logger.info("用户 {} ，访问 {} , 参数：{}", user.getUserName(), url, JSON.toJSON(t));
        ResponseObject responseObject = new ResponseObject();
        List<T> list = getBookService().list(t);
        if (CollectionUtils.isEmpty(list)) {
            logger.info("返回结果 list 条数：0");
        } else {
            logger.info("返回结果 list 条数：{}", list.size());
        }
        CommonUtils.executeSuccess(responseObject, list);
        return responseObject;
    }

    @Override
    @UserLoginToken
    @ResponseBody
    @GetMapping("findById")
    public ResponseObject findById(@CurrentUser AbstractUser user, int bookId) {
        String url = getRootPath() + "/findById";
        logger.info("用户 {} ，访问 {} , 参数：{}", user.getUserName(), url, bookId);
        ResponseObject responseObject = new ResponseObject();
        T tmp = getBookService().findById(bookId);
        if (ObjectUtils.isEmpty(tmp)) {
            logger.info("返回结果 null");
        } else {
            logger.info("返回结果 {}", JSON.toJSONString(tmp));
        }
        CommonUtils.executeSuccess(responseObject, tmp);
        return responseObject;
    }

    @Override
    @UserLoginToken
    @ResponseBody
    @GetMapping("create")
    public ResponseObject create(@CurrentUser AbstractUser user, T item) {
        String url = getRootPath() + "/create";
        logger.info("用户 {} ，访问 {} , 参数：{}", user.getUserName(), url, JSON.toJSON(item));
        ResponseObject responseObject = new ResponseObject();
        getBookService().insert(item);
        CommonUtils.executeSuccess(responseObject);
        return responseObject;
    }

    @Override
    @UserLoginToken
    @ResponseBody
    @GetMapping("batchCreate")
    public ResponseObject batchCreate(@CurrentUser AbstractUser user, List<T> list) {
        String url = getRootPath() + "/create";
        logger.info("用户 {} ，访问 {} , 数量：{}", user.getUserName(), url, list.size());
        ResponseObject responseObject = new ResponseObject();
        getBookService().batchInsert(list);
        CommonUtils.executeSuccess(responseObject);
        return responseObject;
    }
}

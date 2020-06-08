package com.ddky.fms.refund.controller.stream;

import com.ddky.fms.refund.model.stream.entry.Order;
import com.ddky.fms.refund.service.ListStreamService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/***
 * wyw
 * @author a
 */
@Controller
@RequestMapping("stream/list")
public class ListStreamController {

    @Autowired
    private ListStreamService listStreamService;

    @GetMapping("listIds")
    @ResponseBody
    public String listId()  {
        List<Integer> pageIndexList = new ArrayList<>();
        int pageIndex = 1;
        while (pageIndex <= 1000) {
            pageIndexList.add(pageIndex);
            pageIndex++;
        }
        pageIndexList.parallelStream().forEach(item ->{
            PageInfo<Order> orderPageInfo = listStreamService.list(item, 100);
            try {
                listStreamService.listIds(orderPageInfo.getList());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        return "success";
    }
}

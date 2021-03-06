package com.qfedu.newhorizon.controller.user;

import com.alibaba.fastjson.JSON;
import com.qfedu.newhorizon.common.redis.RedisUtil;
import com.qfedu.newhorizon.common.tools.TokenTool;
import com.qfedu.newhorizon.domain.user.User;
import com.qfedu.newhorizon.domain.user.UserAddr;
import com.qfedu.newhorizon.domain.user.UserMain;
import com.qfedu.newhorizon.service.user.UserAddrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserAddrController {
    @Autowired
    private UserAddrService userAddrService;
    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("useraddrsave.do")
    public int save(UserAddr userAddr) {
        return userAddrService.save(userAddr);
    }

    @RequestMapping("useraddrupdate.do")
    public int update(HttpServletRequest request) {
        String tokren = TokenTool.getToken(request);
        String json = (String) redisUtil.get(tokren);
        User user = JSON.parseObject(json, UserMain.class);
        UserAddr userAddr = userAddrService.select(user.getUid());
        return userAddrService.query(userAddr);
    }
}

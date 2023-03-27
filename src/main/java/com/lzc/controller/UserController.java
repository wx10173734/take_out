package com.lzc.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lzc.common.R;
import com.lzc.entity.User;
import com.lzc.service.UserService;
import com.lzc.util.EmailUtil;
import com.lzc.util.ValidateCodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @title: UserController
 * @Author luozouchen
 * @Date: 2023/3/25 21:27
 */
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 发送qq邮箱验证码短信
     *
     * @param user
     * @return
     */
    @PostMapping("/sendMsg")
    public R<String> sendMsg(@RequestBody User user, HttpSession session) {
        //获取邮箱
        String phone = user.getPhone();
        //生成随机的4位验证码
        if (StringUtils.isNotEmpty(phone)) {
            String code = ValidateCodeUtils.generateValidateCode(4).toString();
            log.info("code:{}", code);
            //调用自己封装的qq邮箱发送其发送邮箱
            EmailUtil.sendAuthCodeEmail(phone, code);
            //需要将验证码保存到session中
            session.setAttribute(phone, code);
            //session.setMaxInactiveInterval(60); //设置session有效期 60秒,这里以后可能会用redis,所以先不设置
            return R.success("邮箱验证码发送成功");
        }
        return R.error("邮箱发送失败");
    }

    /**
     * 移动端用户登录
     * 这里的接收参数是phone和code,一般肯定单独创建一个dto来接收,这里直接其实使用map也可以
     *
     * @param map
     * @param session
     * @return
     */
    @PostMapping("/login")
    public R<User> login(@RequestBody Map map, HttpSession session) {
//        log.info(map.toString());
//        //获取邮箱
//        String phone = map.get("phone").toString();
//        //获取验证码
//        String code = map.get("code").toString();
//        //从Session中获取保存的验证码
//        Object codeInSession = session.getAttribute(phone);
//        //进行验证码的比对(页面提交的验证码和Session中保存的验证码比对)
//        if (codeInSession != null && codeInSession.equals(code)) {
//            //如果能够比对成功,说明登录成功
//            //判断当前手机号对应的用户是否为新用户,如果是新用户就自动完成注册
//            LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
//            queryWrapper.eq(User::getPhone, phone);
//            User user = userService.getOne(queryWrapper);
//            if (user == null) {//说明是新用户
//                //直接注册
//                user = new User();
//                user.setPhone(phone);
//                user.setStatus(1);
//                userService.save(user);
//            }
//            //登录成功,放入对应的用户session数据并返回对应用户的信息
//            session.setAttribute("user", user.getId());
//            log.info("user:::{}", user.getId());
//            return R.success(user);
//        }
//        return R.error("登录失败");
        log.info(map.toString());
        //获取邮箱
        String phone = map.get("phone").toString();
        //获取验证码
        String code = map.get("code").toString();
        //从Session中获取保存的验证码
        Object codeInSession = session.getAttribute(phone);
        //进行验证码比对(页面中验证码和session中保存的验证码比对)
        if (codeInSession != null && codeInSession.equals(code)) {
            //如果能够比对成功，说明登录成功
            LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(User::getPhone, phone);
            User user = userService.getOne(queryWrapper);
            if (user == null) {
                //判断当前手机号对应的用户是否为新用户，如果是新用户就自动完成注册
                user = new User();
                user.setPhone(phone);
                user.setStatus(1);
                userService.save(user);
            }
            session.setAttribute("user", user.getId());
            log.info("user:::{}", user.getId());
            return R.success(user);
        }

        return R.error("登录失败");
    }


}

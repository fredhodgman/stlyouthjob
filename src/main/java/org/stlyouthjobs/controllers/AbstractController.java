package org.stlyouthjobs.controllers;

import org.stlyouthjobs.models.User;
import org.stlyouthjobs.models.data.CategoryDao;
import org.stlyouthjobs.models.data.CheeseDao;
import org.stlyouthjobs.models.data.MenuDao;
import org.stlyouthjobs.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by LaunchCode
 */
public abstract class AbstractController {

    @Autowired
    protected UserDao userDao;

    @Autowired
    protected CheeseDao cheeseDao;

    @Autowired
    protected CategoryDao categoryDao;

    @Autowired
    protected MenuDao menuDao;

    public static final String userSessionKey = "user_id";

    protected User getUserFromSession(HttpSession session) {
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        return userId == null ? null : userDao.findOne(userId);
    }

    protected void setUserInSession(HttpSession session, User user) {
        session.setAttribute(userSessionKey, user.getUid());
    }

    @ModelAttribute("userId")
    public Integer getUserIdFromSession(HttpServletRequest request) {
        return (Integer) request.getSession().getAttribute(userSessionKey);
    }

}
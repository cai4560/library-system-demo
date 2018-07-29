package com.thoughtworks.library.constant;

public interface Constant {
    class SUCCESS_MESSAGE {
        public static String UPLOAD_BOOKS_SUCCESS = "上传图书成功";
        public static String CREATE_ORDER_SUCCESS = "借阅图书成功";
        public static String DELETE_ORDER_SUCCESS = "删除订单成功";
    }

    class ERROR_MESSAGE {
        public static String LOGIN_FAIL = "用户名或者密码不正确";
        public static String NO_PERMISSION = "您没有权限使用当前服务";
        public static String UPLOAD_BOOKS_FAIL = "上传图书失败";
        public static String BOOK_NOT_FOUND = "未找到该图书";
        public static String BOOK_NOT_AVAILABLE = "该图书在借阅中";
        public static String CREATE_ORDER_FAIL = "借阅图书失败";
        public static String ORDER_NOT_FOUND = "未找到该订单";
        public static String DELETE_ORDER_FAIL = "删除订单失败";
    }
}

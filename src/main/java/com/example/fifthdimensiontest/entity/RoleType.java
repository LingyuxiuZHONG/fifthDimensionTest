package com.example.fifthdimensiontest.entity;

public enum RoleType {
    ADMIN("Admin"),// 枚举常量 USER，调用构造方法并传入参数 "user"
    USER("User");// 枚举常量 ADMIN，调用构造方法并传入参数 "admin"

    private String roleName;

    RoleType(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName(){
        return roleName;
    }
}

# Springboot1

這是一個 Java web 專案，使用Spring boot框架、引入Spring Security模組保護網站。 

專案內容包括：

- 符合MVC架構的簡單網站
- 劃分三種安全區域:公用區(/)、一般使用者區(/user)、管理員區(/admin)
- 兩種角色權限:USER, ADMIN
- 自訂登入頁面
- Postgre 資料庫介接設定(依自己需求改寫)
- 帳號資料表DDL(PostgreSQL)

便於快速開發網站雛形，適用於敏捷式(agile)開發流程。

## 相容性
- JDK 版本：1.8
- Spring boot 版本: 2.7.15
- Spring security 版本: 2.7.15
- 模板引擎: Thymeleaf 3.0.15


## 使用方式

可下載專案改寫，也可參考推送紀錄(push history)照著實做一遍。

## 了解更多

- 開始使用 Spring Security
- 開始使用 Spring Security 2.0
- 基於角色的權限控管
- 自訂登入頁面
- 資料庫設計

## References

[Spring Security 中文手冊](https://idontwannarock.github.io/spring-security-reference/docs/i_pref/)

[新手工程師的程式教室](https://chikuwa-tech-study.blogspot.com/2021/06/spring-boot-security-authentication-and-authorization.html)

[深入淺出 Spring Boot 多重設定檔管理 (Spring Profiles)](https://blog.miniasp.com/post/2022/09/21/Mastering-Spring-Boot-Profiles)

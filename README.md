新闻发布网站

20171110 -增加在线人数统计功能； 涉及技术application
20171110 -增加登陆页面的验证码和记住我功能； 涉及技术 session，cookie
20171115 -增加登陆页面的自动登录，（成功访问管理员界面后，关闭浏览器后，下次访问时自动登录。）  涉及技术filter
20171118 -增强自动登录功能，自动登录只能一次，并且需要排除和登录、注册相关的资源
20171120 -使用servlet3.0实现文件上传
20171122 -servlet路径配置改为注解模式
20171125 -增加BaseServlet基类。所有servlet改写 ，由之前的每个动作写一个servlet，改为目前的通用Userservlet
            添加用户的时候
            以前: /store/addUser
            现在: /store/user?method=add
         -所有jsp页面中加入自定义标签 fns  /WEB-INF/tlds/fns.tld
         -用户注册成功后，发送激活邮件。
20171126 -dao层全部改用c3p0数据库连接池的方式链接，利用dbutils工具包来操作数据库
         -模仿spring写一个工厂BeanFactory,进行控制层（Servlet层）与service层、service层与dao层的简单解耦
         -添加缓存技术；

20171129 -做简单的过滤器的权限控制
         -文件上传工厂
         -分页封装
-增强所有的添加操作：动态代理



# BBS论坛系统API说明文档

# remain
1. 热帖有个nickname = null的问题
2. put post 函数userId 没有必要
---

<!--*  [1.AdminController(管理员API)](#1.AdminController(管理员API))-->
<!--*  [2.BlockController (版块API)](#2)-->
<!--	* [2.1 findAllBlockInfos()  (查找所有版块的基本信息)](#2.1)-->
<!--	* [2.2 getBlock() (通过版块id查找版块的基本信息，得问阿豪为什么名字不要ById)](#2.2)-->

[toc]



## AdminController(管理员API)
### login (登录)
```
请求方式： POST
url: /admin/login
input: 
username: 用户名
password：用户密码

eg: http://localhost:8080/admin/login

{
    "message": "",
    "status": true,
    "data": {
        "id": 1,                          //管理员id
        "userName": "tuanzi",            //管理员名称
        "password": "123456",            //管理员密码
        "nickname": "飞舞的团子",       // 管理员昵称
        "gender": "male",              //管理员性别
        "avatar": ""                    //管理员头像路径
    }
}
 
```
### changePostStatus(改变帖子的状态)
```
请求方式：PUT
url:/admin/post/id/{id}/status/{status}
input:
    id: 帖子的ID
    status: 帖子将要改变的状态 0删除，1正常，2加精，3置顶
    
eg:http://localhost:8080/admin/post/id/1/status/2
{
    "message": "",
    "status": true,
    "data": null                            //返回值
}
```
### getIndexStatus(获取主页基本信息)
```
请求方式：GET
url:/admin/status
input: null
eg:http://localhost:8080/admin/status
{
    "message": "",
    "status": true,
    "data": {
        "postInc": 45,                      //帖子最近一周增长数量
        "postSum": 46,                      //帖子总数量
        "todayUser": 0,                     //今日登录用户数量
        "userInc": 4,                       //用户最近一周增长数量
        "userSum": 4,                       //用户总数量
        "weeklyUser": 4                     //最近一周用户登录数量
    }
}
```

### delUser（根据用户id删除用户)
```
请求方式:DELETE
url:/admin/user/delUser/id/{id}
input: 
id: 用户id
eg: http://localhost:8080/admin/user/id/19
{
    "message": "",
    "status": true,                       //状态为true，说明删除成功，false说明失败
    "data": null
}
```
### recUser（根据用户id恢复用户)
```
请求方式:PUT
url:/admin/user/id/{id}
input: 
id: 用户id

eg: http://localhost:8080/admin/user/id/19
{
    "message": "",
    "status": true,                       //状态为true，说明恢复成功，false说明失败
    "data": null
}
```

### findAllPost（查询用户列表）
```
请求方式：GET
url:/admin/post/page/{page}
input:
page:分页的页数，每页的大小在后台自定义了，默认为15

eg:http://localhost:8080//admin/post/page/1
数据输出有点长，这里只保留两条记录,时间格式还有点问题，待解决
{
    "message": "",
    "status": true,
    "data": [
        {
            "update_time": "2018-06-10T08:31:23.000+0000",         //帖子的更新时间
            "category_id": 5,                                      // 帖子所在的分类id
            "create_time": "2018-06-01T11:55:26.000+0000",         // 帖子的创建时间
            "user_id": 15,                                         //发帖人的ID
            "id": 6,                                               // 帖子ID
            "title": "我是一个属于javaweb类的帖子",               // 帖子标题
            "content": "如何用三周时间用Javaweb写一个bbs系统",    // 帖子的内容
            "status": 1         //帖子的状态 0删除，1正常，2加精，3置顶
        },
              {
            "update_time": "2018-06-10T08:32:02.000+0000",
            "category_id": 1,
            "create_time": "2018-06-10T07:42:55.000+0000",
            "user_id": 1,
            "id": 32,
            "title": "Test Post8",
            "content": "Test Post Content8",
            "status": 1
        }
    ]
}

```
### findAllUser(查询用户列表)
```
请求方式：GET
url:/admin/user/page/{page}
input: 分页的页数，每页的大小在后台自定义了，默认为15

eg:http://localhost:8080//admin/user/page/1
数据输出有点长，这里只保留两条记录,时间格式还有点问题，待解决
{
    "message": "",
    "status": true,
    "data": [
        {
            "password": "111",                               //用户密码
            "update_time": "2018-06-10T14:24:51.000+0000",   //用户的信息更新时间
            "gender": "男",                                  //用户性别
            "create_time": "2018-06-10T14:23:57.000+0000",   //用户创建时间
            "last_login_time": "2018-06-10T06:23:51.000+0000",//用户上次登录时间
            "nickname": "阿豪",                               //用户的昵称
            "id": 15,                                         //用户的id
            "avatar": "localhost:8080/avatar/default.jpg",    //用户头像存储路径
            "exp": 1,                                         //用户的经验值
            "username": "Tuanzi@qq.com",                      //用户名（邮箱）
            "status": "1"                     //用户状态（0拉黑 1 普通 2版主）
        }, 
           {
            "password": "111",
            "update_time": "2018-06-11T14:21:09.000+0000",
            "gender": "男",
            "create_time": "2018-06-11T14:11:00.000+0000",
            "last_login_time": "2018-06-11T06:10:50.000+0000",
            "nickname": "test",
            "id": 19,
            "avatar": "localhost:8080/avatar/default.jpg",
            "exp": 1,
            "username": "test@qq.com",
            "status": "1"
        }
    ]
}
```
### getUserPageNum（获取user列表页数),用在显示用户时判断多少页
```
请求方式：GET
url:/admin/page/user
input:无

eg:http://localhost:8080//admin/page/user
{
    "message": "",
    "status": true,                 
    "data": 1                                             //返回应该显示的页数
}
```
### getPostPageNum（获取Post列表页数),用在显示列表时判断多少页
```
请求方式：GET
url:/admin/page/post
input:无

eg:http://localhost:8080//admin/page/post
{
    "message": "",
    "status": true,                 
    "data": 3                                              //返回应该显示的页数
}
```
### getWeekStatus(得到最近七天的发帖数量)
```
请求方式：GET
url:/admin/status/week
input: 无

eg: http://localhost:8080//admin/status/week
由于是用Map映射的，返回的结果是乱序的，要自己对应好
{
    "message": "",
    "status": true,
    "data": {
        "Wen": 0,                                       //3天前用户登录数量
        "Thur": 1,                                      //4天前用户登录数量
        "Sat": 0,                                       //6天前用户登录数量
        "Tues": 0,                                      //2天前用户登录数量
        "Fri": 3,                                       //5天前用户登录数量
        "Mon": 41,                                      //1天前用户登录数量
        "Sun": 0                                        //7天前用户登录数量
    }
}
```

### searchUserByNickname（根据用户昵称模糊查询用户列表）
```
请求方式：GET
url: /admin/user/nickname?nickname=...
input:
nickname: 用户昵称

eg:http://localhost:8080/admin/user/nickname?nickname=阿
{
    "message": "",
    "status": true,
    "data": [
        {
            "password": "111",
            "update_time": "2018-06-11T14:47:29.000+0000",
            "gender": "男",
            "create_time": "2018-06-10T14:23:57.000+0000",
            "last_login_time": "2018-06-10T06:23:51.000+0000",
            "nickname": "阿豪",
            "id": 15,
            "avatar": "localhost:8080/avatar/default.jpg",
            "exp": 1,
            "username": "Tuanzi@qq.com",
            "status": "1"
        }
    ]
}
```
## BlockController(版块控制API)
### findAllBlockInfos()  (查找所有版块的基本信息)
```
请求方式： GET
url: /block
input: 无

eg:http://localhost:8080/block
{
    "message": "",
    "status": true,
    "data": [
        { 
            "id": 1,                                                 //版块id
            "name": "JavaWeb",                                       //版块名称
            "icon": "localhost:8080/img/block/default.jpg",          //版块图标存储路径
            "categorySum": 2,                                        //版块下的分类数量
            "postSum": 3,                                            //版块下面的帖子数量
            "updateTime": "2018-06-10 16:31:24"                      //版块的最近更新时间
        },
        {
            "id": 2,
            "name": "Python",
            "icon": "localhost:8080/img/block/default.jpg",
            "categorySum": 2,
            "postSum": 3,
            "updateTime": "2018-06-10 16:31:24"
        }
    ]
}
```
### getBlock(通过版块id查找版块的基本信息，得问阿豪为什么名字不要ById）

```
请求方式： GET
url: /block/id/{id}
input: id(版块的id）
eg:http://localhost:8080/block/id/1
{
    "message": "",
    "status": true,
    "data": {
        "id": 1,                                                  //版块Id                            
        "name": "JavaWeb",                                        //版块名称
        "icon": "localhost:8080/img/block/default.jpg",           //版块图标路径
        "description": "JavaWeb版块",                             //版块的描述信息
        "status": 0,                                              //版块的状态，0为删除，1为正常
        "categories": [                                           //版块下面的所有的分类信息
            { 
                "id": 4,                                          //分类的Id
                "name": "三天精通java",                            //分类的名称
                "description": "我属于java版块",                   //分类的描述信息
                "status": 0                                       //版块的状态，0为删除，1为正常
            },
            {
                "id": 5,
                "name": "javaweb",
                "description": "我也属于java版块",
                "status": 0
            }
        ]
    }
}
```
## CategoryController(分类API)
### getCategoryInfo（查看category的详细信息，右侧信息）
```
请求方式：GET
url:/category/id/{id}
input: 
id: 分类的id

eg：http://localhost:8080/category/id/1
```
## CommentController(评论API)

### addComment（添加评论）
```
请求方式：POST
url:/comment/add
input:
userId: 用户id（Integer）
postId: 帖子id（Integer）
content: 评论内容（String）

eg:
http://localhost:8080/comment/add
{
    "message": "",
    "status": true,
    "data": 6                      //返回的结果为生成的主键id
}
```
### delComment（删除评论，假删除）
```
请求方式：DELETE
url:/comment/del/id/{id}
input:
id: 评论id

eg：http://localhost:8080/comment/del/id/6
{
    "message": "",
    "status": true,               //成功返回true
    "data": null
}
```
## FavoriteController(收藏夹API)
## ImgController(图片API)
## MessageController(私信API)
## PostController(帖子API)
### addPost(增加帖子记录)
```
请求方式：POST
url:/post
input:
userId: 用户id
categoryId: 分类id
title：标题
content:内容

eg:http://localhost:8080/post
{
    "message": "",
    "status": true,
    "data": 64            //返回帖子的主键值
}
```

### addPost(更新帖子记录)
```
请求方式：PUT
url:/post
input: {
    id: 帖子id  
    userId: 用户id
    categoryId: 分类id
    title：标题
    content:内容
}
eg:http://localhost:8080/post
{
    "message": "",
    "status": true,           //返回true则为真
    "data": null            
}
```
### findAllPostByCategoryId（获取某个分类下的所有帖子）
```
请求方式：GET
url: /post/category/{id}/page/{page}/{sort}
input:
id: 该分类的id号
page: 当前所在的页号（默认从1开始,默认每页大小为10）
sort: 排序方式 id（id号）title（标题）nickname（昵称 ）commentSum（评论量） favoriteSum(收藏量) updateTime（更新时间）

eg:http://localhost:8080/post/category/7/page/1/id

{
    "message": "",
    "status": true,
    "data": [
        {
            "id": 7,                                          //帖子的ID
            "title": "我是一个Python大数据类别的帖子",        //帖子标题
            "nickname": "阿豪",                               //帖子主人的昵称
            "status": 1,                     //帖子的状态 0删除，1正常，2加精，3置顶
            "commentSum": 0,                 //帖子的评论量
            "favoriteSum": 0,                // 帖子的收藏量
            "updateTime": "2018-06-10"      //帖子的更新时间
        },
        {
            "id": 10,
            "title": "修改后的帖子标题是这个,分类分到了人工智能那一块",
            "nickname": "阿豪",
            "status": 1,
            "commentSum": 0,
            "favoriteSum": 0,
            "updateTime": "2018-06-10"
        }
    ]
}
```
### findAllPostInfoByUserId(获取某个用户的所有的帖子)
```
请求方式:GET
url：/post/user/{id}/page/{page}/{sort}
input:
id: 用户的id号
page: 当前所在的页号（默认从1开始,默认每页大小为10）
sort: 排序方式 id title commentSum favoriteSum updateTime
    
eg: http://localhost:8080/post/user/15/page/1/id
{
    "message": "",
    "status": true,
    "data": [
        {
            "id": 6,                                            //帖子的id号
            "title": "我是一个属于javaweb类的帖子",             //帖子标题
            "nickname": "阿豪",           //帖子主人的昵称      
            "status": 2,                 //帖子状态 0删除，1正常，2加精，3置顶
            "commentSum": 2,               //帖子的评论量
            "favoriteSum": 0,               // 帖子的收藏量
            "updateTime": "2018-06-12"        //帖子的更新时间
        },
        {
            "id": 7,
            "title": "我是一个Python大数据类别的帖子",
            "nickname": "阿豪",
            "status": 1,
            "commentSum": 0,
            "favoriteSum": 0,
            "updateTime": "2018-06-10"
        },
        {
            "id": 10,
            "title": "修改后的帖子标题是这个,分类分到了人工智能那一块",
            "nickname": "阿豪",
            "status": 1,
            "commentSum": 0,
            "favoriteSum": 0,
            "updateTime": "2018-06-10"
        },
        {
            "id": 23,
            "title": "新增帖子",
            "nickname": "阿豪",
            "status": 1,
            "commentSum": 0,
            "favoriteSum": 0,
            "updateTime": "2018-06-10"
        }
    ]
}

```
### findQuestionByUserId（获取某个用户所有的提问的帖子）
```
请求方式：GET
url:/post/user/{id}/page/{page}/question
input:
id: 用户的id号
page: 当前所在的页号（默认从1开始,默认每页大小为10）

eg:http://localhost:8080/post/user/15/page/1/question
{
    "message": "",
    "status": true,
    "data": [
        {
            "id": 24,                       //帖子id
            "title": "Test Post0",          //帖子的标题
            "nickname": "阿豪",             // 发帖人昵称
            "status": 1,                    
            "commentSum": 0,                //回答量
            "favoriteSum": 0,               //收藏量
            "updateTime": "2018-06-12"      //更新时间
        },
        {
            "id": 25,
            "title": "Test Post1",
            "nickname": "阿豪",
            "status": 1,
            "commentSum": 0,
            "favoriteSum": 0,
            "updateTime": "2018-06-12"
        }
    ]
}

```
### findPostById(获取对应ID 的post的详细信息)
```
请求方式:GET
url：/post/id/{id}
input:
id: 帖子的id号

eg: http://localhost:8080/post/id/6
{
    "message": "",
    "status": true,
    "data": {
        "id": 6,                                            //帖子的id号
        "categoryId": 5,                                    //帖子对应的分类id号
        "title": "我是一个属于javaweb类的帖子",             //帖子标题
        "content": "如何用三周时间用Javaweb写一个bbs系统",  // 帖子内容
        "status": 2,                       //帖子状态 0删除，1正常，2加精，3置顶
        "updateTime": "2018-06-12 07:07:43", //更新时间
        "userInfo": {                        //发帖人的基本信息
            "id": 15,                       //发帖人id 
            "nickname": "阿豪",              //发帖人昵称
            "avatar": "localhost:8080/avatar/default.jpg",  //发帖人头像路径
            "exp": 1,                       //发帖人经验值
            "status": 1                    //发帖人状态 0拉黑 1正常 2 版主
        },
        "comments": [                     //帖子的评论列表
            { 
                "id": 1,                  //评论id号
                "userInfo": {             //1号评论者的基本信息
                    "id": 16,             //评论者的id
                    "nickname": "哈希琛",  // 评论者的昵称
                    "avatar": "localhost:8080/avatar/default.jpg", //评论者头像路径
                    "exp": 1,               //评论者经验值
                    "status": 1             //评论者状态 0拉黑 1正常 2 版主
                },
                "content": "我是阿琛，我对阿豪的javaweb帖子进行评论",//评论内容
                "status": 1,                            //内容的状态 0删除 1拉黑
                "updateTime": "2018-06-07 10:34:28",    //内容的更新时间
                "replies": [               //1号评论的回复信息
                    { 
                        "id": 2,            //回复id
                        "content": "我是晓莉宝宝，我在回复阿琛对阿豪帖子的评论", //回复内容
                        "createTime": "2018-06-06 08:25:20", //回复的创建时间
                        "updateTime": "2018-06-06 08:25:20", //回复的更新时间（一般没有）
                        "userInfo": {    // 回复者的基本信息
                            "id": 18,    //回复者ID
                            "nickname": "晓莉宝宝",//回复者的昵称
                            "avatar":"localhost:8080/avatar/default.jpg",//回复者头像路径
                            "exp": 1,           //回复者的经验值
                            "status": 1         //回复者状态 0拉黑 1正常 2 版主
                        }
                    },
                    {
                        "id": 3,
                        "content": "我是鸡王，我也在给阿琛对阿豪的评论回复",
                        "createTime": "2018-06-07 09:02:06",
                        "updateTime": "2018-06-07 09:02:06",
                        "userInfo": {
                            "id": 17,
                            "nickname": "鸡王",
                            "avatar": "localhost:8080/avatar/default.jpg",
                            "exp": 1,
                            "status": 1
                        }
                    }
                ]
            },
            {
                "id": 3,
                "userInfo": {
                    "id": 17,
                    "nickname": "鸡王",
                    "avatar": "localhost:8080/avatar/default.jpg",
                    "exp": 1,
                    "status": 1
                },
                "content": "我是鸡王，我对阿豪的Javaweb进行回复",
                "status": 1,
                "updateTime": "2018-06-07 09:58:41",
                "replies": []           //空代表没有
            }
        ]
    }
}
```
### getHotPost得到热门帖子
```
请求方式:GET
url:/post/hot
input: 无

eg:http://localhost:8080/post/hot
{
    "message": "",
    "status": true,
    "data": [
        {
            "id": 6,                                     //帖子id
            "title": "我是一个属于javaweb类的帖子",      //标题
            "nickname": null,                            //无
            "status": 2,                                 //状态。。。
            "commentSum": 0,                             //评论量
            "favoriteSum": 0,                             //收藏量
            "updateTime": null                            //无。。
        },
        {
            "id": 7,
            "title": "我是一个Python大数据类别的帖子",
            "nickname": null,
            "status": 2,
            "commentSum": 0,
            "favoriteSum": 0,
            "updateTime": null
        },
        {
            "id": 8,
            "title": "我属于Python人工智能的铁则",
            "nickname": null,
            "status": 2,
            "commentSum": 0,
            "favoriteSum": 0,
            "updateTime": null
        }
    ]
}

```
## ReplyController(回复API)
### addReply（添加回复）
```
请求方式：POST
url:/reply/add
input:
userId 回复者id
commentId  回复的评论id
content 回复内容

eg: http://localhost:8080/reply/add
{
    "message": "",
    "status": true,
    "data": 6           //返回reply自增id
}
```
### delReply(删除回复)
```
请求方式：GET
url:/reply/del
input:
id: 回复的id

eg:http://localhost:8080/reply/del/id/6
{
    "message": "",
    "status": true,
    "data": 1              //返回值为1则成功
}
```
## StarController(收藏API)
## UserController(用户API)
### getUserInfo（根据用户id查询用户信息）
```
请求方式:GET
url:/user/id/{id}
input:
id: 用户的id

eg: http://localhost:8080/user/id/15
{
    "message": "",
    "status": true,
    "data": {
        "id": 15,                     //用户id
        "nickname": "阿豪",           //用户昵称
        "exp": 1,                     //用户经验值
        "rank": "Lucky",              //用户等级
        "status": 1,                  //用户的状态 0拉黑 1正常 2 版主
        "lastLoginTime": "2018-06-10 02:23:51"  //用户的上次登录时间
    }
}
```
### login（用户登录）
```
请求方式:POST
url: /user/login
input:
username: 用户名（邮箱）
password: 密码

eg:http://localhost:8080/user/login
{
    "message": "",
    "status": true,
    "data": {
        "id": 16,                  //用户的id值
        "nickname": "哈希琛",      //用户名称
        "exp": 1,                  //用户经验值
        "rank": "Lucky",           //用户等级
        "token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxNiJ9.3wMIoQaAPMxXSj-VxnDZptr8Ql7FeM8Ueq4S3pp-UCA", //token
        "status": 0,                //用户的状态 0拉黑 1正常 2 版主
        "lastLoginTime": "2018-06-10 02:22:41"  //用户的上次登录时间
    }
}
```

### register(用户注册)
```
请求方式:POST
url:/user/register
input:
nickname: 用户昵称
username: 用户名（邮箱）
password: 密码

eg:http://localhost:8080/user/register

{
    "message": "昵称已经存在",
    "status": false,
    "data": null
}

或者
{
    "message": "邮箱已被注册",
    "status": false,
    "data": null
}
或者
{
    "message": "",
    "status": true,
    "data": {
        "id": 21,                             //返回的自增主键值
        "nickname": "test222fddf",            //用户昵称
        "exp": 1,                             //用户默认经验值
        "rank": "Lucky",                      //用户等级
        "token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyMSJ9.HrOqnEa7Q7LJOZDtZjyG0exWEzysug2sH6ZYgY-gz0I",           //用户的token
        "status": 0,                           //在映射时没有选择这项属性，默认值为0                  
        "lastLoginTime": "2018-06-12 08:14:20"  //用户的上次登录时间
    }
}

```
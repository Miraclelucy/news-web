 var _menus = {"menus":[
						{"menuid":"1","icon":"icon-sys","menuname":"新闻类型管理",
							"menus":[
									{"menuid":"10","menuname":"类型编辑","icon":"icon-nav","url":"typeDetails.jsp"}
														
								]
						},{"menuid":"2","icon":"icon-sys","menuname":"新闻管理",
							"menus":[{"menuid":"11","menuname":"新闻编辑","icon":"icon-nav","url":"newsDetails.jsp"},
									{"menuid":"12","menuname":"新闻采集","icon":"icon-role","url":"newsAdd.jsp"}							
									
								]
						},{"menuid":"3","icon":"icon-sys","menuname":"用户管理",
							"menus":[{"menuid":"13","menuname":"用户查询","icon":"icon-nav","url":"userDetails.jsp"},
									{"menuid":"14","menuname":"封号管理","icon":"icon-role","url":"userManager.jsp"}
								]
						},{"menuid":"4","icon":"icon-sys","menuname":"留言管理",
							"menus":[{"menuid":"15","menuname":"留言查询","icon":"icon-nav","url":"bbsManager.jsp"},
										{"menuid":"16","menuname":"留言编辑","icon":"icon-role","url":"bbsManager.jsp"}
									]
							},{"menuid":"5","icon":"icon-sys","menuname":"系统管理",
							"menus":[{"menuid":"17","menuname":"管理员设置","icon":"icon-nav","url":"adminDetails.jsp"},
									{"menuid":"18","menuname":"网站参数设置","icon":"icon-nav","url":"websiteSet.jsp"},
									{"menuid":"19","menuname":"系统日志","icon":"icon-nav","url":"systemLog.jsp"},
								]
						}
				]};
        //设置登录窗口
        function openPwd() {
            $('#w').window({
                title: '修改密码',
                width: 300,
                modal: true,
                shadow: true,
                closed: true,
                height: 160,
                resizable:false
            });
        }
        //关闭登录窗口
        function closePwd() {
            $('#w').window('close');
        }

        

        //修改密码
        function serverLogin() {
            var $newpass = $('#txtNewPass');
            var $rePass = $('#txtRePass');

            if ($newpass.val() == '') {
                msgShow('系统提示', '请输入密码！', 'warning');
                return false;
            }
            if ($rePass.val() == '') {
                msgShow('系统提示', '请在一次输入密码！', 'warning');
                return false;
            }

            if ($newpass.val() != $rePass.val()) {
                msgShow('系统提示', '两次密码不一至！请重新输入', 'warning');
                return false;
            }

            $.post('/ajax/editpassword.ashx?newpass=' + $newpass.val(), function(msg) {
                msgShow('系统提示', '恭喜，密码修改成功！<br>您的新密码为：' + msg, 'info');
                $newpass.val('');
                $rePass.val('');
                close();
            })
            
        }

        $(function() {

            openPwd();

            $('#editpass').click(function() {
                $('#w').window('open');
            });

            $('#btnEp').click(function() {
                serverLogin();
            })

			$('#btnCancel').click(function(){closePwd();})

            $('#loginOut').click(function() {
                $.messager.confirm('系统提示', '您确定要退出本次登录吗?', function(r) {

                    if (r) {
                        location.href = '/ajax/loginout.ashx';
                    }
                });
            })
        });
		
		
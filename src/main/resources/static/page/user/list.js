layui.use(['form','layer','laydate','table','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        table = layui.table;


    // 渲染数据表格
    var tableIns = table.render({
        elem: '#userList'
        ,id:'userListTable'
        ,url: ctx+'sys/user/list.json' //数据接口
        ,method: 'post'
        ,page: true //开启分页
        ,limit: 5 // 每页显示数据
        ,limits: [5,10,15,20,25] // 可选每页大小下拉框
        ,loading: true // 切换分页时显示加载条，url方式有效
        ,text: '暂无数据' // 空数据时异常提示
        // ,initSort: { // 初始化排序
        //     field: 'beginDate' //排序字段，对应 cols 设定的各字段名
        //     ,type: 'desc' //排序方式  asc: 升序、desc: 降序、null: 默认排序
        // }
        // ,toolbar: 'default' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
        ,cellMinWidth : 95
        ,height : "full-125"
        ,skin: 'line' //行边框风格
        ,even: true //开启隔行背景
        ,size: 'lg' //大/小尺寸的表格
        ,cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: 'id', title: 'ID', width:60, align:"center"},
            {field: 'username', title: '用户名', width:350},
            {field: 'email', title: '邮箱', align:'center'},
            {field: 'sex', title: '性别',  align:'center',templet:"#sexS"},
            {field: 'state', title: '用户状态', align:'center',templet:function (u) {
                    if(u.state == 1){
                        return "正常";
                    }else if(u.state == 2){
                        return "锁定";
                    }else{
                        return "~";
                    }
                }},
            {field: 'joindate', title: '创建时间', align:'center', minWidth:110, templet:function(d){
                    return Format(d.joindate,'yyyy-MM-dd')
            }},
            {title: '操作', width:170, templet:'#userListBar',fixed:"right",align:"center"}
        ]]
        ,request: {
            pageName: 'pageNum' //页码的参数名称，默认：page
            ,limitName: 'pageSize' //每页数据量的参数名，默认：limit
        }
        ,response: {
            statusName: 'code' //数据状态的字段名称，默认：code
            ,statusCode: 200 //成功的状态码，默认：0
            ,msgName: 'msg' //状态信息的字段名称，默认：msg
            ,countName: 'count' //数据总数的字段名称，默认：count
            ,dataName: 'data' //数据列表的字段名称，默认：data
        },done: function(res, curr, count){
            //如果是异步请求数据方式，res即为你接口返回的信息。
            //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
        }
    });

    loadSelectData();
    //加载下拉框数据
    function loadSelectData(){
        $.post(ctx+"sys/role/selectData",{},function(re){
            $('.roleVal').empty();
            var result = eval(re);
            $('.roleVal').append(new Option('全部',''));
            $.each(result,function(i,n){
                $('.roleVal').append(new Option(n.name,n.id));//往下拉菜单里添加元素
            });
            form.render();//菜单渲染 把内容加载进去
        });
    }

    //搜索
    $(".search_btn").on("click",function(){
        table.reload("userListTable",{
            page: {
                curr: 1 //重新从第 1 页开始
            },
            method:'post',
            where: {
                username: $(".usernameVal").val(),  //搜索的关键字
                rid: $(".roleVal").val()
            }
        })
    });

    //添加用户
    function addUser(edit){
        console.log(edit);
        var title = edit == undefined ? "添加用户" : "修改用户";
        var url = edit == undefined ? ctx+"sys/user/add.html" : ctx+"sys/user/edit.html/"+edit.id;
        var index = layui.layer.open({
            title : title,
            type : 2,
            content : url,
            success : function(layero, index){
                var body = layui.layer.getChildFrame('body', index);
                setTimeout(function(){
                    layui.layer.tips('点击此处返回用户列表', '.layui-layer-setwin .layui-layer-close', {
                        tips: 3
                    });
                },500)
            }
        })
        layui.layer.full(index);
        window.sessionStorage.setItem("index",index);
        //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
        $(window).on("resize",function(){
            layui.layer.full(window.sessionStorage.getItem("index"));
        })
    }
    $(".addNews_btn").click(function(){
        addUser();
    })

    //批量删除
    $(".delAll_btn").click(function(){
        var checkStatus = table.checkStatus('userListTable'),
            data = checkStatus.data,
            ids = new Array();
        if(data.length > 0) {
            $.each(data,function(i,n){
                ids.push(n.id);
                if(n.id === 1){
                    layer.msg("不能删除超级管理员");
                    return false;
                }
            });
            console.log(ids);
            layer.confirm('确定删除选中的用户？', {icon: 3, title: '提示信息'}, function (index) {
                var deleteindex = layer.msg('删除中，请稍候',{icon: 16,time:false,shade:0.8});
                $.ajax({
                    type:"POST",
                    url: ctx+"sys/user/dels",
                    data:{"ids":ids},
                    dataType:"json",
                    success:function(r){
                        layer.close(deleteindex);
                        layer.msg(r.msg);
                        if(r.code == 0){
                            // 删除成功，重新渲染表格
                            tableIns.reload();
                        }
                    }
                });
            })
        }else{
            layer.msg("请选择需要删除的用户");
        }
    })

    //列表操作
    table.on('tool(userList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;
        if(layEvent === 'edit'){ //编辑
            addUser(data);
        } else if(layEvent === 'del'){ //删除
            layer.confirm('确定删除【'+data.username+'】吗？',{icon:3, title:'提示信息'},function(index){
                $.post(ctx+"sys/user/del",{id:data.id},function(r){
                    layer.msg(r.msg);
                    layer.close(index);
                    if(r.code == 0){
                        // 删除成功，重新渲染表格
                        tableIns.reload();
                    }
                })
            });
        } else if(layEvent == 'look'){
            layer.alert("查看："+data.id);
        }
    });
})